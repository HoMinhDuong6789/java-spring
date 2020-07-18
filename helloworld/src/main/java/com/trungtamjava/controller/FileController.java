package com.trungtamjava.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {

	@GetMapping("/upload-file")
	public String upload() {
		return "uploadFile";
	}

	@PostMapping("/upload-file")
	public String upload(@RequestParam(name = "files") MultipartFile[] files) {
		for (MultipartFile file : files) {
			System.out.println("############file:" + file.getOriginalFilename());
		}
		return "uploadFile";
	}
}
