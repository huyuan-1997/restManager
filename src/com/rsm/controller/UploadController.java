package com.rsm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rsm.common.FastDFSClient;
import com.rsm.common.Result;

@RestController
public class UploadController {
	private String FILE_SERVER_URL = "http://192.168.25.133/";// �ļ���������ַ

	@RequestMapping("/upload")
	public Result upload(MultipartFile file) {
		// 1��ȡ�ļ�����չ��
		String originalFilename = file.getOriginalFilename();
		String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
		try {
			// 2������һ�� FastDFS �Ŀͻ���
			FastDFSClient fastDFSClient = new FastDFSClient("classpath:fdfs_client.conf");
			// 3��ִ���ϴ�����
			String path = fastDFSClient.uploadFile(file.getBytes(), extName);
			// 4��ƴ�ӷ��ص� url �� ip ��ַ��ƴװ�������� url
			String url = FILE_SERVER_URL + path;
			return new Result(true, url);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "�ϴ�ʧ��");
		}
	}
	
	
}
