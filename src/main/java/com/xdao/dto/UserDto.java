package com.xdao.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDto implements HasId, Serializable {

  private static final long serialVersionUID = 2052580632293959408L;

  private String id;

  @Size(min = 11)
  @NotNull(message = "invalid mobile")
  private String mobile;

  @Size(min = 32)
  @NotNull(message = "invalid password hash")
  private String password;

  private String apiKey;

  private String apiSecret;

  private long createdTime;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getApiKey() {
    return apiKey;
  }

  public void setApiKey(String apiKey) {
    this.apiKey = apiKey;
  }

  public String getApiSecret() {
    return apiSecret;
  }

  public void setApiSecret(String apiSecret) {
    this.apiSecret = apiSecret;
  }

  public long getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(long createdTime) {
    this.createdTime = createdTime;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result += prime * result + ((mobile == null) ? 0 : mobile.hashCode());
    result += prime * result + ((apiKey == null) ? 0 : apiKey.hashCode());
    result += prime * result + ((apiSecret == null) ? 0 : apiSecret.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    UserDto other = (UserDto) obj;
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    if (mobile == null) {
      if (other.mobile != null) {
        return false;
      }
    } else if (!mobile.equals(other.id)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "UserDto [id=" + id + ", mobile=" + mobile + ", password=" + password + "]";
  }

}
