/* 
* @Author: Gowri Gary Shankar
* @Date:   2014-04-15 19:27:23
* @Last Modified by:   Gowri Gary Shankar
* @Last Modified time: 2014-04-24 12:37:06
*/

package com.prodapt.m2m.rest.domain;

import java.util.Date;

public class Command {
	
	private String commandId;	
	private Date creationTime;
	private Date lastModifiedTime;
	private String commandType;
	private boolean execEnable;
	private String description;
	private String execInstancesReference;
	private String subscriptionsReference;
	private int command;
	
	public String getCommandId() {
		return commandId;
	}

	public void setCommandId(String commandId) {
		this.commandId = commandId;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public String getCommandType() {
		return commandType;
	}

	public void setCommandType(String commandType) {
		this.commandType = commandType;
	}

	public boolean isExecEnable() {
		return execEnable;
	}

	public void setExecEnable(boolean execEnable) {
		this.execEnable = execEnable;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExecInstancesReference() {
		return execInstancesReference;
	}

	public void setExecInstancesReference(String execInstancesReference) {
		this.execInstancesReference = execInstancesReference;
	}

	public String getSubscriptionsReference() {
		return subscriptionsReference;
	}

	public void setSubscriptionsReference(String subscriptionsReference) {
		this.subscriptionsReference = subscriptionsReference;
	}

	public int getCommand() {
		return command;
	}

	public void setCommand(int command) {
		this.command = command;
	}

	public Command() {
		
	}
}