package com.prodapt.m2m.rest.domain;

import java.util.ArrayList;
import java.util.Date;

public class ContentInstance {
	
	private String contentInstanceId;	
	private Date creationTime;
	private Date lastModifiedTime;
	private ArrayList<String> contentTypes;
	private ArrayList<String> mimeType;
	private int contentSize;
	private String content;
	
	public String getContentInstanceId() {
		return contentInstanceId;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}
	public ArrayList<String> getContentTypes() {
		return contentTypes;
	}
	public ArrayList<String> getMimeType() {
		return mimeType;
	}
	public int getContentSize() {
		return contentSize;
	}
	public String getContent() {
		return content;
	}
	
	public void setContentInstanceId(String contentInstanceId) {
		this.contentInstanceId = contentInstanceId;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
	public void setContentTypes(ArrayList<String> contentTypes) {
		this.contentTypes = contentTypes;
	}
	public void setMimeType(ArrayList<String> mimeType) {
		this.mimeType = mimeType;
	}
	public void setContentSize(int contentSize) {
		this.contentSize = contentSize;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public ContentInstance() {
		
	}
}