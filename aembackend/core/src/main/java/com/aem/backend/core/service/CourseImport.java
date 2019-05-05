/**
 * 
 */
package com.aem.backend.core.service;

/**
 * @author ANINDYA
 *
 */
public interface CourseImport {

	public abstract void importContent();
	public abstract boolean canProcess(String fileName);
}
