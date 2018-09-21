package com.rsm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rsm.bean.Cooker;
import com.rsm.common.HttpClientUtil;
import com.rsm.common.JsonUtils;

@Controller
@RequestMapping("/sms")
public class SmsController {
	//@Value("${HTTPCLIENT_SMS_URL}")
	private String HTTPCLIENT_SMS_URL="http://localhost:8088/sendMap";
	@RequestMapping("/send")
	public String sendSms(String mobile,String name) throws Exception{
		System.out.println("正在开始");
		System.out.println(HTTPCLIENT_SMS_URL);
		name=new String(name.getBytes("iso8859-1"),"utf-8");
		Map map = new HashMap();	
		map.put("mobile", mobile);
		map.put("name", name);
		String responseResult = HttpClientUtil.doGet(HTTPCLIENT_SMS_URL, map);
		return responseResult;
	}
	/**
	 * 测试方法
	 * @return
	 */
	@RequestMapping("/findCookerList")
	@ResponseBody	//只是转化成json格式，在页面层次就是一个string类型  //使用了转化器的话在页面就是一个json格式的数据
	public List<Cooker> getCooker(){
		List list = new ArrayList();
		list.add(new Cooker(1,"小刘"));
		list.add(new Cooker(2,"小刘"));
		list.add(new Cooker(3,"小刘"));
		String json = JsonUtils.objectToJson(list);
		System.out.println(json);
		return list;
	}
}
