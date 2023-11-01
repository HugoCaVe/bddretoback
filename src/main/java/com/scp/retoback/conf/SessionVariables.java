package com.scp.retoback.conf;

public enum SessionVariables {
  ID("id"),
  PET_ID("petId"),

  QUANTITY("quantity"),

  SHIP_DATE("shipDate"),

  STATUS("status"),

  COMPLETE("complete"),

  ORDEN_NUMBER("orden number");

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
