package com.xdao.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ClientDto implements HasId, Serializable {

  private static final long serialVersionUID = 2052580632293959408L;

  private String id;

  @Size(min = 16)
  @NotNull(message = "clientId can't be null")
  private String clientId;

  @Size(min = 1)
  @NotNull(message = "topic can't be null")
  private String topic;

  @Size(min = 1)
  @NotNull(message = "sdk name can't be null")
  private String sdkName;

  @Size(min = 1)
  @NotNull(message = "sdk version can't be null")
  private String sdkVersion;

  private long createdTime;

  public String getId() {
    return id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public String getClientId() {
    return clientId;
  }

  public void setClientId(final String clientId) {
    this.clientId = clientId;
  }

  public String getTopic() {
    return topic;
  }

  public void setTopic(final String topic) {
    this.topic = topic;
  }

  public String getSdkName() {
    return sdkName;
  }

  public void setSdkName(final String sdkName) {
    this.sdkName = sdkName;
  }

  public String getSdkVersion() {
    return sdkVersion;
  }

  public void setSdkVersion(final String sdkVersion) {
    this.sdkVersion = sdkVersion;
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
    result += prime * result + ((clientId == null) ? 0 : clientId.hashCode());
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
    ClientDto other = (ClientDto) obj;
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    if (clientId == null) {
      if (other.clientId != null) {
        return false;
      }
    } else if (!clientId.equals(other.clientId)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ClientDto [id=" + id + ", clientId=" + clientId + "]";
  }

}
