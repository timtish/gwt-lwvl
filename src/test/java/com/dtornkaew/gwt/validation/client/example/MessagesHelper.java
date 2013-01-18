package com.dtornkaew.gwt.validation.client.example;

import java.util.MissingResourceException;

import com.dtornkaew.gwt.validation.client.ValidationError;
import com.dtornkaew.gwt.validation.client.ValidationResult;
import com.google.gwt.core.client.GWT;

/**
 * @author Timofey Tishin (ttishin@luxoft.com)
 */
public class MessagesHelper {

	private static final Validators msg = GWT.create(Validators.class);

	// hide constructor of helper class
	private MessagesHelper() {
	}

	public static String errorAsString(String code) {
		try {
			return msg.getString(code);
		} catch (MissingResourceException e) {
			GWT.log("Can't find validator message by code: " + code);
			return "???" + code + "???";
		}
	}

	public static String errorAsString(ValidationError err) {
		String code = err.getKey() + "" + err.getCode();

		try {
			return msg.getString(code);
		} catch (MissingResourceException e) {
			GWT.log("Can't find validator message by code: " + code);
		}

		try {
			return msg.getString(err.getCode().toString());
		}
		catch (MissingResourceException e) {
			GWT.log("Can't find validator message by code: " + code);
		}

		return "???" + code + "???";
	}

	public static String errorAsString(ValidationResult errors) {
		String result = "";
		for (ValidationError err : errors.getErrors()) {
			if (!result.isEmpty()) result += "; ";
			result += errorAsString(err);
		}
		return result;
	}
}
