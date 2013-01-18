package com.dtornkaew.gwt.validation.client.example;

import com.dtornkaew.gwt.validation.client.ValidationHandler;
import com.dtornkaew.gwt.validation.client.ValidationResult;

/**
 * @author Timofey Tishin (ttishin@luxoft.com)
 */
public class FormValidationHandler implements ValidationHandler {

	private final AbstractForm form;

	public FormValidationHandler(AbstractForm form) {
		this.form = form;
	}

	public void invoke(ValidationResult result) {
		if (result.isValid()) {
			form.clearErrorMsg();
		} else {
			form.setErrorMsg(MessagesHelper.errorAsString(result));
		}
	}

	public void reset() {
		form.clearErrorMsg();
	}
}
