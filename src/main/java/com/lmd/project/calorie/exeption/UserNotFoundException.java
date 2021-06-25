package com.lmd.project.calorie.exeption;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8012170119091171142L;

	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public UserNotFoundException(final String message) {
		super(message);
	}

	public UserNotFoundException(final Throwable cause) {
		super(cause);
	}
}
