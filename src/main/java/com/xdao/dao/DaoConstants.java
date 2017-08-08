package com.xdao.dao;

public class DaoConstants {

  /**
   * User constants.
   */
  public static final String USER_TABLE_NAME = "user";
  public static final String USER_MOBILE = "mobile";
  public static final String USER_PASSWORD = "password";
  public static final String USER_APIKEY = "apiKey";
  public static final String USER_APISECRET = "apiSecret";
  public static final String USER_CREATED_TIME = "createdTime";

  /**
   * Client constants.
   */
  public static final String CLIENT_TABLE_NAME = "client";
  public static final String CLIENT_CLIENTID = "clientId";
  public static final String CLIENT_TOPIC = "topic";
  public static final String CLIENT_SDK_NAME = "sdkName";
  public static final String CLIENT_SDK_VERSION = "sdkVersion";
  public static final String CLIENT_CREATED_TIME = "createdTime";

  private DaoConstants() {
    throw new UnsupportedOperationException("Not supported");
  }
}
