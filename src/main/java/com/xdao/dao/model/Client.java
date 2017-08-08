package com.xdao.dao.model;

import static com.xdao.dao.DaoConstants.CLIENT_TABLE_NAME;
import static com.xdao.dao.DaoConstants.CLIENT_CLIENTID;
import static com.xdao.dao.DaoConstants.CLIENT_TOPIC;
import static com.xdao.dao.DaoConstants.CLIENT_SDK_NAME;
import static com.xdao.dao.DaoConstants.CLIENT_SDK_VERSION;
import static com.xdao.dao.DaoConstants.CLIENT_CREATED_TIME;
import static com.xdao.dao.model.ModelUtils.getLongId;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.xdao.dto.ClientDto;

@Entity
@Table(name = CLIENT_TABLE_NAME,
    uniqueConstraints = @UniqueConstraint(columnNames = {CLIENT_CLIENTID}))
public class Client extends GenericModel<ClientDto> implements Serializable {

  private static final long serialVersionUID = -6651349022301623429L;

  @Column(name = CLIENT_CLIENTID, unique = true, length = 21)
  private String clientId;

  @Column(name = CLIENT_TOPIC, length = 32)
  private String topic;

  @Column(name = CLIENT_SDK_NAME, length = 32)
  protected String sdkName;

  @Column(name = CLIENT_SDK_VERSION, length = 16)
  protected String sdkVersion;

  @Column(name = CLIENT_CREATED_TIME)
  protected long createdTime;

  public Client() {
  }

  public Client(Long id) {
    this.id = id;
  }

  /**
   * Instantiates new user.
   */
  public Client(ClientDto dto) {
    if (dto != null) {
      this.id = getLongId(dto);
      this.clientId = dto.getClientId();
      this.topic = dto.getTopic();
      this.sdkName = dto.getSdkName();
      this.sdkVersion = dto.getSdkVersion();
      this.createdTime = dto.getCreatedTime();
    }
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

  @Override
  public String toString() {
    return "Client [clientId=" + clientId + ", id=" + id + "]";
  }

  @Override
  protected ClientDto createDto() {
    return new ClientDto();
  }

  @Override
  protected GenericModel<ClientDto> newInstance(Long id) {
    return new Client(id);
  }

  @Override
  public ClientDto toDto() {
    ClientDto dto = createDto();
    dto.setId(getStringId());
    dto.setClientId(clientId);
    dto.setTopic(topic);
    dto.setSdkName(sdkName);
    dto.setSdkVersion(sdkVersion);
    dto.setCreatedTime(createdTime);
    return dto;
  }

  @Override
  public int hashCode() {
    final int prime = 45;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
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
    Client other = (Client) obj;
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

}
