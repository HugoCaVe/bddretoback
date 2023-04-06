package com.scp.retoback.conf;

public enum SessionVariables {
  USER_NAME("username"),
  PASSWORD("password");

  private String key;
  private String value;

  SessionVariables(String key, String value) {
    this.key = key;
    this.value = value;
  }

  SessionVariables(String key) {
    this.key = key;
  }

  public String getKey() {
    return key;
  }

  public String getValue() {
    return value;
  }
}
