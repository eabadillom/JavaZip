package com.eabm.model;

import java.util.Arrays;

public class JZFile {
	private String fileName = null;
	private byte[] content = null;
	
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public byte[] getContent() {
		return content;
	}
	public void setContent(byte[] content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "{\"fileName\":\"" + fileName + "\", \"content\":\"" + Arrays.toString(content) + "\"}";
	}
}
