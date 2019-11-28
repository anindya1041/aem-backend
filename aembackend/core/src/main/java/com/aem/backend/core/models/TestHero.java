/**
 * 
 */
package com.aem.backend.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.widgets.TextField;


/**
 * @author ANINDYA
 *
 */
@Model(adaptables = Resource.class)
@Component(value="testhero")
public class TestHero {

	@DialogField(fieldLabel="test")
	@TextField
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
