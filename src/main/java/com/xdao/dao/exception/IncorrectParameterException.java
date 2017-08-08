package com.xdao.dao.exception;

public class IncorrectParameterException extends RuntimeException {

  private static final long serialVersionUID = 1446867056117761527L;

  public IncorrectParameterException(String message) {
    super(message);
  }

  public IncorrectParameterException(String message, Throwable cause) {
    super(message, cause);
  }

}
