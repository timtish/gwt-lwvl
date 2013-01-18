package com.dtornkaew.gwt.validation.client.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import com.dtornkaew.gwt.validation.client.Validator;
import com.dtornkaew.gwt.validation.client.ValidatorController;
import com.dtornkaew.gwt.validation.client.validators.AsyncValidator;
import com.dtornkaew.gwt.validation.client.validators.ClientValidator;
import com.google.gwt.user.client.ui.*;

/**
 * @author Timofey Tishin (timtish@gmail.com)
 */
public class AbstractForm extends FormPanel {

	public static final String STYLE_ERROR = "error";

	private ComplexPanel container;
	private Label errorMsg;

	private Collection<Validator> validators = new ArrayList<Validator>();

	public AbstractForm() {
		container = new FlowPanel();
		setWidget(container);

		errorMsg = new Label();
		errorMsg.setStyleName("form-error-msg");
		add(errorMsg);

		addSubmitHandler(new SubmitHandler() {
			public void onSubmit(SubmitEvent event) {
				event.cancel();
				boolean isValid = true;
				for (Validator validator : validators) {
					if (validator instanceof ClientValidator && validator.isEnabled()
							&& !((ClientValidator) validator).validate().isValid()) {
						isValid = false;
					}
				}
				if (isValid) {
					clearErrorMsg();
					processSubmit();
				} else {
					setErrorMsg("Дозаполните форму");
				}
			}
		});
	}

	protected void processSubmit() {
		// fireEvent(new FormSubmitEvent<AbstractForm>(AbstractForm.this));
	}

	public void setErrorMsg(String errorMessage) {
		errorMsg.setVisible(true);
		errorMsg.setText(errorMessage);
		addStyleDependentName(STYLE_ERROR);
	}

	public void clearErrorMsg() {
		errorMsg.setVisible(false);
		removeStyleDependentName(STYLE_ERROR);
	}

	@Override
	public void reset() {
		clearErrorMsg();
		super.reset();
	}

	public void addValidator(ValueBoxBase widget, ClientValidator... validators) {
		this.validators.addAll(Arrays.asList(validators));
		ValidatorController validatorController = new ValidatorController(validators);
		validatorController.addValidationHandler(new TextBoxValidationHandler(widget));
		widget.addChangeHandler(validatorController);
	}

	/**
	 * Add validator to form fields.
	 *
	 * addValidator(name, new LoginNotExists(name), new RequiredValidator<String>(name));
	 * addValidator(password, new RequiredValidator<String>(password));
	 *
	 * @param widget
	 * @param asyncValidator
	 * @param validators
	 */
	public void addValidator(ValueBoxBase widget, AsyncValidator asyncValidator, ClientValidator... validators) {
		this.validators.addAll(Arrays.asList(validators));
		ValidatorController validatorController = new ValidatorController(asyncValidator, validators);
		validatorController.addValidationHandler(new TextBoxValidationHandler(widget));
		widget.addChangeHandler(validatorController);
	}

	@Override
	public void add(Widget w) {
		container.add(w);
	}

	@Override
	public void add(IsWidget child) {
		container.add(child);
	}

	@Override
	public boolean remove(Widget w) {
		return container.remove(w);
	}

	@Override
	public Iterator<Widget> iterator() {
		return container.iterator();
	}

}
