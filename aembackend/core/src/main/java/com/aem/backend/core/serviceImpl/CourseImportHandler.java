/**
 * 
 */
package com.aem.backend.core.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.backend.core.service.CourseImport;

import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

/**
 * @author ANINDYA
 *
 */
@Component(service = CourseImportHandler.class, name = "Course Import Handler Service", immediate = true)
public class CourseImportHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(CourseImportHandler.class);
	private List<CourseImport> courseImportImplList;

	@Reference(cardinality = ReferenceCardinality.MULTIPLE , policy = ReferencePolicy.DYNAMIC)
    protected void bind(CourseImport courseImport) {
    	if(courseImportImplList == null) {
    		courseImportImplList = new ArrayList<>();
    	}
    	courseImportImplList.add(courseImport);
    }
	protected void unbind(CourseImport courseImport) {
		courseImportImplList.remove(courseImport);
	}
	
	public void importContent() {
		for(CourseImport courseImportImpl : courseImportImplList) {
			if(courseImportImpl.canProcess("page")) {
				courseImportImpl.importContent();
			}
		}
	}
}
