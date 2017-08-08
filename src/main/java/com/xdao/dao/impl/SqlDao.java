package com.xdao.dao.impl;

import org.hibernate.FlushMode;
import org.hibernate.LockOptions;
import org.hibernate.Session;

public interface SqlDao<T> extends Dao<T, String> {

  /**
   * Re-read object from database.
   *
   * @param object The object to refresh
   */
  void refresh(Object object);

  /**
   * Get hibernate session with the given flush mode option.
   *
   * @param flushMode the {@link org.hibernate.FlushMode} object.
   * @return the {@link org.hibernate.Session} object.
   */
  Session getSession(FlushMode flushMode);

  /**
   * Get hibernate session.
   *
   * @return the {@link org.hibernate.Session} object.
   */
  Session getSession();

  /**
   * Save object. Will be returned object with id.
   *
   * @param object the domain object
   * @param flush  specify if session flush needed.
   * @return the saved object
   */
  T save(T object, boolean flush);

  /**
   * @param object the o
   * @param clazz  the clazz
   * @param <V>    the V
   * @return the saved object
   */
  <V> V save(V object, Class<?> clazz);

  /**
   * Build lock request with the given {@link org.hibernate.LockOptions} object
   *
   * @param lockOptions The lock options to use
   * @return the {@link org.hibernate.Session.LockRequest} object.
   */
  Session.LockRequest lockRequest(LockOptions lockOptions);

  /**
   * Find object by id.
   *
   * @param id   the id
   * @param lazy specifies whether return initialized object (if false is set) or proxy (if true is
   *             set)
   * @return the found object or null if object not found
   */
  T findById(String id, boolean lazy);

  /**
   * Persist model object.
   *
   * @param object the model object
   * @return the persisted object
   */
  T persist(T object);

}
