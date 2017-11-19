package com.security.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.security.vo.FileInfo;

@RestController
@RequestMapping("/file")
public class FileController {

	private static final Logger logger = LoggerFactory.getLogger(FileController.class);
	
	private String folder = "F://";
	
	@PostMapping
	public FileInfo upload(MultipartFile file) throws IllegalStateException, IOException{
		logger.info(file.getName());
		logger.info(file.getOriginalFilename());
		System.out.println(file.getSize());
		
		File localFile = new File(folder, new Date().getTime() + ".txt");
		file.transferTo(localFile);
		
		return new FileInfo(localFile.getAbsolutePath());
	}
}
