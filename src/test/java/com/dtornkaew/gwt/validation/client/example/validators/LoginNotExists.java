package com.dtornkaew.gwt.validation.client.example.validators;

import com.dtornkaew.gwt.validation.client.ValidationHandler;
import com.dtornkaew.gwt.validation.client.validators.AsyncValidator;
import com.google.gwt.user.client.TakesValue;

/**
 * @author Timofey Tishin (timtish@gmail.com)
 */
public class LoginNotExists extends AsyncValidator<String> {

	private final TakesValue<String> target;

	//private UserServiceAsync userService = UserServiceAsync.Util.getInstance();

	public LoginNotExists(TakesValue<String> target) {
		this("LoginNotExists", target);
	}

	public LoginNotExists(String key, TakesValue<String> target) {
		super(key);
		this.target = target;
	}

	@Override
	public void validate(final ValidationHandler callback) {
		/*userService.checkNewLogin(target.getValue(), new AsyncCallback<String>() {
			public void onFailure(Throwable caught) {
				callback.reset();
			}

			public void onSuccess(String errorCode) {
				ValidationResult validationResult = new ValidationResult();
				if (errorCode != null) {
					validationResult.addError(new ValidationError<Object>(LoginNotExists.this, errorCode, target));
				}
				callback.invoke(validationResult);
			}
		});*/
	}
}
