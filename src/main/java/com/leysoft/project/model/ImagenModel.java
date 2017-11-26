package com.leysoft.project.model;

import org.springframework.web.multipart.MultipartFile;

public class ImagenModel {
	
	private MultipartFile file;

	public ImagenModel() {}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
}