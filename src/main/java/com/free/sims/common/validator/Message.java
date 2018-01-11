package com.free.sims.common.validator;

/**
 * @author liuzeke
 * @version 1.0
 */
public class Message {

	private boolean invalid;
	private String message;

	public Message() {
	}

	public Message(boolean invalid, String message) {
		this.invalid = invalid;
		this.message = message;
	}

	public boolean isInvalid() {
		return invalid;
	}

	public void setInvalid(boolean invalid) {
		this.invalid = invalid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
