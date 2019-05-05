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
@Component(name = "Asset Import Service")
public class AssetImport implements CourseImport {

	private static final Logger LOGGER = LoggerFactory.getLogger(AssetImport.class);

	@Override
	public void importContent() {

		LOGGER.debug("Importing The Asset::");

	}

	@Override
	public boolean canProcess(String fileName) {
		if (StringUtils.equals("sample.jpg", fileName)) {
			LOGGER.debug("Called for the ASSet Import match found");
			return true;
		} else {
			LOGGER.debug("AssetImporter Match did not found");
			return false;
		}

	}

}
