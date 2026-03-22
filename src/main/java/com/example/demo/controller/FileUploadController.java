package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.helper.FileUploadHelper;


@RestController
public class FileUploadController {
	
	@Autowired
	private FileUploadHelper fileUploadHelper;

	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
//		System.out.println(file.getOriginalFilename());
		
		if(file.isEmpty()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
		}
		
		if(!file.getContentType().equals("image/png")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain change file formate");

		}
		
		boolean f = fileUploadHelper.uploadFile(file);
		if(f) {
			return ResponseEntity.ok("file uploaded sucessfully");
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("somthing went wrong ! Please try again");
		
	}
}
