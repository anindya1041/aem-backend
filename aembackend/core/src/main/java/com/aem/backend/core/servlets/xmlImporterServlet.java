/**
 * 
 */
package com.aem.backend.core.servlets;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.day.cq.dam.api.Rendition;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.aem.backend.core.bean.xmlBean;
import com.day.cq.dam.api.Asset;

/**
 * @author ANINDYA
 *
 */
@Component(service = Servlet.class, property = { Constants.SERVICE_DESCRIPTION + "=Simple Demo Servlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_GET,
		"sling.servlet.paths=" + "/bin/test", "sling.servlet.extensions=" + "txt" })
public class xmlImporterServlet extends SlingSafeMethodsServlet {

    private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	protected void doGet(final SlingHttpServletRequest req, final SlingHttpServletResponse resp)
			throws ServletException, IOException {

		ResourceResolver  resolver = req.getResourceResolver();
		Resource resource = resolver.resolve("/content/dam/wknd/custom-fragment/sample.csv");
        Asset rawAsset = resource.adaptTo(Asset.class);
		logger.debug("Asset Tracking :: {}",rawAsset);
		Rendition rend = rawAsset.getRendition("original");
		logger.debug("Rendition Tracking :: {}",rend);
		InputStream  stream = rend.getStream();
		logger.debug("Stream Checking :: {}",stream);
		Reader inputStreamReader = new InputStreamReader(stream);
		BufferedReader reader = new BufferedReader(inputStreamReader);
		List<xmlBean> beanList = new ArrayList<>();
		while(reader.readLine() != null) {
			String test = reader.readLine();
			logger.debug("Reading Sentence :: {}",test);
			xmlBean tempOb = new xmlBean();
			//tempOb.setIndustries_Code(industries_Code);
		}
		
	}
}
