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

/*	public ContentInstanceDetails toContentInstanceDetails(String contentInstanceId) {
		
		ContentInstanceDetails details = new ContentInstanceDetails();

		details.setContentInstanceId(contentInstanceId);
		details.setCreationTime(creationTime);
		details.setLastModifiedTime(lastModifiedTime);
		details.setContentTypes(contentTypes);
		details.setMimeType(mimeType);
		details.setContentSize(contentSize);
		details.setContent(content);

		return details;

	}

	public static ContentInstance fromContentInstanceDetails(
		ContentInstanceDetails contentInstanceDetails) {
		
		ContentInstance contentInstance = new ContentInstance();

		contentInstance.contentInstanceId = contentInstanceDetails.getContentInstanceId();
		contentInstance.creationTime = contentInstanceDetails.getCreationTime();
		contentInstance.lastModifiedTime = contentInstanceDetails.getLastModifiedTime();
		contentInstance.contentTypes = contentInstanceDetails.getContentTypes();
		contentInstance.mimeType = contentInstanceDetails.getMimeType();
		contentInstance.contentSize = contentInstanceDetails.getContentSize();
		contentInstance.content = contentInstanceDetails.getContent();

		return contentInstance;
	}*/
	
	public ContentInstance(String content) {
		this.content = content;
	}
}