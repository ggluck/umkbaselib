package com.umk.base.exception;

/**
 * 抛出该子类的异常，会自动被UErrorHandler 处理
 *
 */
public  class UException extends RuntimeException {
	private static final long serialVersionUID = -1096970905084026855L;

	public UException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
