package com.prodapt.m2m.da;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.prodapt.m2m.da.core.CommandInfo;
import com.prodapt.m2m.da.core.DeviceSimulator;
import com.prodapt.m2m.da.events.Publisher;
import com.prodapt.m2m.rest.domain.Command;
import com.prodapt.m2m.rest.domain.Container;
import com.prodapt.m2m.rest.domain.ContentInstance;

@Controller
public class DeviceController {
	
	@Autowired
	private Publisher publisher;

	private DeviceSimulator deviceSimulator;

	@RequestMapping(value = {"/pronet-da-starter/applications/{appId}/containers/{deviceId}/commands"},
		method = RequestMethod.POST)
	public ResponseEntity<String> receiveCommand(
		@PathVariable String appId,
		@PathVariable String deviceId,
		@RequestBody Command command) {

		try {
			CommandInfo commandInfo = new CommandInfo(appId, deviceId, command);
			
			publisher.commandReceivedEvent(commandInfo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Success Guaranteed", HttpStatus.OK);

	}

	@RequestMapping(value = "/pronet-da-starter/configure", 
		method = RequestMethod.GET)
	public ResponseEntity<String> configure(
		@RequestParam(value = "m2mPoC", required=true) String m2mPoC,
		@RequestParam(value = "appId", required=true) String appId ) {

		if(null == deviceSimulator) {
			deviceSimulator = new DeviceSimulator(appId, m2mPoC);
			return new ResponseEntity<String> (
				"Device Application Configured Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String> (
				"NA Reconfiguration Forbidden, App Id:" + deviceSimulator.getAppId(), 
				HttpStatus.FORBIDDEN);
		}

	}

	@RequestMapping(value = "/pronet-da-starter/create-device", 
		method = RequestMethod.GET)
	public ResponseEntity<String> createDevice() {

		if(deviceSimulator != null && deviceSimulator.getDeviceId() == null) {

			Container device = deviceSimulator.createDevice();
			String deviceId = device.getContainerId();

			System.out.println("Device Id: " + deviceId);

			return new ResponseEntity<String>(
				"Device Created Successfully, Device Id :" + deviceId,
					HttpStatus.OK);

		} else {

			if(deviceSimulator == null) {

				return new ResponseEntity<String> (
					"Add Device Forbidden, Configure NA Simulator", HttpStatus.FORBIDDEN);
			} else {
				return new ResponseEntity<String> (
					"Device Exists , Device Id: " + deviceSimulator.getDeviceId(), 
						HttpStatus.FORBIDDEN);
			}
		}
	}

	@RequestMapping(value = "/pronet-da-starter/send-device-params", 
		method = RequestMethod.GET)
	public ResponseEntity<String> sendDeviceParams() {

		if(deviceSimulator != null && deviceSimulator.getDeviceId() != null) {

			ContentInstance deviceParam = deviceSimulator.sendDeviceParams();

			System.out.println("Device Id: " + deviceSimulator.getDeviceId() + 
				" Reading Reference: " + deviceParam.getContentInstanceId());
			
			return new ResponseEntity<String>(HttpStatus.OK);

		} else {

			if(deviceSimulator == null) {

				return new ResponseEntity<String> (
					"Add Device Forbidden, Configure NA Simulator", 
						HttpStatus.FORBIDDEN);
			} else {
				return new ResponseEntity<String> (
					"Device Exists , Device Id: " + deviceSimulator.getDeviceId(), 
						HttpStatus.FORBIDDEN);
			}
		}
	}
}

