package com.xdao.dao.model;

import com.xdao.dao.model.ToDto;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class GenericModel<T> implements Serializable, ToDto<T> {

  private static final long serialVersionUID = 8371621337499494435L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getStringId() {
    return id != null ? id.toString() : null;
  }

  public GenericModel<T> newInstance(String id) {
    return newInstance(ModelUtils.getLongId(id));
  }

  protected abstract GenericModel<T> newInstance(Long id);

  protected abstract T createDto();

}
