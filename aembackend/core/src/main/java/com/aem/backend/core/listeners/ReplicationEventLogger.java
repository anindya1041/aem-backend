/**
 * 
 */
package com.aem.backend.core.listeners;

import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ANINDYA
 *
 */
@Component(service = EventHandler.class, immediate = true, property = {
		Constants.SERVICE_DESCRIPTION + "=Replication EventListner",
		EventConstants.EVENT_TOPIC + "=Replication Activate" })
public class ReplicationEventLogger implements EventHandler {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public void handleEvent(Event event) {
		
		logger.debug("Event Handling :: {}");

	}
}
