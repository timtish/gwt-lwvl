package com.dtornkaew.gwt.validation.client;


/**
 * Validation result collector.
 */
public interface ValidationHandler
{
	/**
	 * On valid or invalid result.
	 *
	 * @param result
	 */
    public void invoke(ValidationResult result);

	/**
	 * On remove validation status.
	 */
    public void reset();
}
