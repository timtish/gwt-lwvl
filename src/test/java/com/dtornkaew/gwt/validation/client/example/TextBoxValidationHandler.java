package com.dtornkaew.gwt.validation.client.example;

import com.dtornkaew.gwt.validation.client.ValidationError;
import com.dtornkaew.gwt.validation.client.ValidationHandler;
import com.dtornkaew.gwt.validation.client.ValidationResult;
import com.google.gwt.user.client.ui.Widget;

/**
* @author Timofey Tishin (timtish@gmail.com)
*/
public class TextBoxValidationHandler implements ValidationHandler {

	private Widget widget;

	public TextBoxValidationHandler(Widget widget) {
		this.widget = widget;
	}

	public void invoke(ValidationResult result) {
		if (!result.isValid()) {
			ValidationError err = result.getErrors().get(0);
			widget.addStyleDependentName(AbstractForm.STYLE_ERROR);
			widget.setTitle(MessagesHelper.errorAsString(err));
		} else {
			reset();
		}
	}

	public void reset() {
		widget.removeStyleDependentName(AbstractForm.STYLE_ERROR);
		widget.setTitle("");
	}
}
