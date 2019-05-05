/**
 * 
 */
package com.aem.backend.core.serviceImpl;

import org.apache.commons.lang3.StringUtils;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.backend.core.service.CourseImport;

/**
 * @author ANINDYA
 *
 */
@Component(name = "Page Import Service", service = CourseImport.class, property = { "type=page" })
public class PageImport implements CourseImport {

	private static final Logger LOGGER = LoggerFactory.getLogger(PageImport.class);

	public void importContent() {
		LOGGER.debug("PageImport Has been called");
	}

	public boolean canProcess(String fileName) {
		if (StringUtils.equals("page", fileName)) {
			LOGGER.debug("Page Import Called");
			return true;
		} else {
			LOGGER.debug("Page Import Not Matched");
			return false;
		}
	}
}
