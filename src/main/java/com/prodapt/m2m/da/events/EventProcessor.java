/* 
* @Author: Gowri Gary Shankar
* @Date:   2014-04-19 09:04:42
* @Last Modified by:   Gowri Gary Shankar
* @Last Modified time: 2014-04-24 12:15:40
*/

package com.prodapt.m2m.da.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import reactor.core.Reactor;
import reactor.event.Event;

@Service
public class EventProcessor {
    
	@Autowired
	Reactor reactor;

	public void commandReceivedEvent(int command) throws InterruptedException {

		reactor.notify("commands", Event.wrap(command));
	}
}