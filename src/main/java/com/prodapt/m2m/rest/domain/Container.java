package com.prodapt.m2m.rest.domain;

import java.util.ArrayList;
import java.util.Date;

public class Container {

	private String containerId;
	private String accessRightID;
	private ArrayList<String> searchStrings;
	private Date creationTime;
	private Date lastModifiedTime;
	private int maxNrOfInstances;
	private String contentInstancesReference;
	private String subscriptionReference;
	
	public String getContainerId() {
		return containerId;
	}
	public String getAccessRightID() {
		return accessRightID;
	}
	public ArrayList<String> getSearchStrings() {
		return searchStrings;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}
	public int getMaxNrOfInstances() {
		return maxNrOfInstances;
	}
	public String getContentInstancesReference() {
		return contentInstancesReference;
	}
	public String getSubscriptionReference() {
		return subscriptionReference;
	}

	public Container() {
		
	}

	public void setContainerId(String containerId) {
		this.containerId = containerId;
	}

	public void setAccessRightID(String accessRightID) {
		this.accessRightID = accessRightID;
	}

	public void setSearchStrings(ArrayList<String> searchStrings) {
		this.searchStrings = searchStrings;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public void setMaxNrOfInstances(int maxNrOfInstances) {
		this.maxNrOfInstances = maxNrOfInstances;
	}

	public void setContentInstancesReference(String contentInstancesReference) {
		this.contentInstancesReference = contentInstancesReference;
	}

	public void setSubscriptionReference(String subscriptionReference) {
		this.subscriptionReference = subscriptionReference;
	}
}