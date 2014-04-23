/* 
* @Author: Gowri Gary Shankar
* @Date:   2014-04-19 12:45:13
* @Last Modified by:   Gowri Gary Shankar
* @Last Modified time: 2014-04-19 12:51:20
*/
package com.prodapt.m2m.da.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.prodapt.m2m.rest.domain.Application;
import com.prodapt.m2m.rest.domain.Container;
import com.prodapt.m2m.rest.domain.ContentInstance;

@Component
public class DeviceSimulator {

	@Autowired
    RestTemplate restTemplate;

	private String appId;
	private String deviceId;
	private String m2mPoC;

	public DeviceSimulator(String appId, String m2mPoC) {
		this.appId = appId;
		this.m2mPoC = m2mPoC;
	}
	
	public DeviceSimulator() {
		
	}

	public Application createApplication() {
		Application newApp = new Application();
		return newApp;
	}
	
	public String getAppId() {
		return appId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public Container createDevice() {

		Container device = new Container();
			
		HttpEntity<Container> deviceEntity = new HttpEntity<Container>(device);
			
		String deviceLocationAtm2mPoC = m2mPoC + "/pronet/applications/" + 
			appId + "/containers";
			
		ResponseEntity<Container> newDeviceEntity = restTemplate.postForEntity(
			deviceLocationAtm2mPoC, deviceEntity, Container.class);
			
		Container newDevice = newDeviceEntity.getBody();
		String deviceId = newDevice.getContainerId();

		this.deviceId = deviceId;

		
		return newDevice;

	}

	public ContentInstance sendDeviceParams() {

		ContentInstance deviceParams = new ContentInstance("SIMULATOR CONTENT");

		HttpEntity<ContentInstance> deviceParamsEntity
			= new HttpEntity<ContentInstance> (deviceParams);

		String deviceParamsAtm2mPoC = m2mPoC + "/pronet/applications/" + 
			appId + "/containers/" + deviceId + "/contentinstances";
	
		ResponseEntity<ContentInstance> newDeviceParamsEntity = 
			restTemplate.postForEntity(deviceParamsAtm2mPoC, deviceParamsEntity, 
				ContentInstance.class);
	
		ContentInstance newDeviceParams = newDeviceParamsEntity.getBody();

		return newDeviceParams;
	}
}