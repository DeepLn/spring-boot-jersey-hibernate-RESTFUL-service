package com.xdao.dao.model;

import static com.xdao.dao.DaoConstants.USER_TABLE_NAME;
import static com.xdao.dao.DaoConstants.USER_MOBILE;
import static com.xdao.dao.DaoConstants.USER_PASSWORD;
import static com.xdao.dao.DaoConstants.USER_APIKEY;
import static com.xdao.dao.DaoConstants.USER_APISECRET;
import static com.xdao.dao.DaoConstants.USER_CREATED_TIME;
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

import com.xdao.dto.UserDto;

@Entity
@Table(name = USER_TABLE_NAME,
    uniqueConstraints = @UniqueConstraint(columnNames = {USER_MOBILE}))
public class User extends GenericModel<UserDto> implements Serializable {

  private static final long serialVersionUID = -6651349022301623429L;

  @Column(name = USER_MOBILE, unique = true, length = 16)
  private String mobile;

  @Column(name = USER_PASSWORD, length = 60)
  private String password;

  @Column(name = USER_APIKEY, unique = true, length = 8)
  private String apiKey;

  @Column(name = USER_APISECRET, length = 24)
  private String apiSecret;

  @Column(name = USER_CREATED_TIME)
  protected long createdTime;

  public User() {
  }

  public User(Long id) {
    this.id = id;
  }

  /**
   * Instantiates new user.
   */
  public User(UserDto dto) {
    if (dto != null) {
      this.id = getLongId(dto);
      this.mobile = dto.getMobile();
      this.password = dto.getPassword();
      this.apiKey = dto.getApiKey();
      this.apiSecret = dto.getApiSecret();
      this.createdTime = dto.getCreatedTime();
    }
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  @Override
  public String toString() {
    return "User [mobile=" + mobile + ", id=" + id + "]";
  }

  @Override
  protected UserDto createDto() {
    return new UserDto();
  }

  @Override
  protected GenericModel<UserDto> newInstance(Long id) {
    return new User(id);
  }

  @Override
  public UserDto toDto() {
    UserDto dto = createDto();
    dto.setId(getStringId());
    dto.setPassword(password);
    dto.setMobile(mobile);
    dto.setApiKey(apiKey);
    dto.setApiSecret(apiSecret);
    dto.setCreatedTime(createdTime);
    return dto;
  }

  @Override
  public int hashCode() {
    final int prime = 45;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
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
    User other = (User) obj;
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
    } else if (!mobile.equals(other.mobile)) {
      return false;
    }
    return true;
  }
}
