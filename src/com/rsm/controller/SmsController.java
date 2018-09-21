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
		System.out.println("���ڿ�ʼ");
		System.out.println(HTTPCLIENT_SMS_URL);
		name=new String(name.getBytes("iso8859-1"),"utf-8");
		Map map = new HashMap();	
		map.put("mobile", mobile);
		map.put("name", name);
		String responseResult = HttpClientUtil.doGet(HTTPCLIENT_SMS_URL, map);
		return responseResult;
	}
	/**
	 * ���Է���
	 * @return
	 */
	@RequestMapping("/findCookerList")
	@ResponseBody	//ֻ��ת����json��ʽ����ҳ���ξ���һ��string����  //ʹ����ת�����Ļ���ҳ�����һ��json��ʽ������
	public List<Cooker> getCooker(){
		List list = new ArrayList();
		list.add(new Cooker(1,"С��"));
		list.add(new Cooker(2,"С��"));
		list.add(new Cooker(3,"С��"));
		String json = JsonUtils.objectToJson(list);
		System.out.println(json);
		return list;
	}
}
