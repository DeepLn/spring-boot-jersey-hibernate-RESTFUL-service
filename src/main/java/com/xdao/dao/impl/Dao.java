package com.xdao.dao.impl;

import java.util.List;

/**
 * The generic Dao interface.
 *
 * @param <T> the type parameter
 */
public interface Dao<T, K> {

  /**
   * Save object. Will be returned object with id
   *
   * @param object the domain object
   * @return the saved object
   */
  T save(T object);

  /**
   * Find all objects.
   *
   * @return the list of objects
   */
  List<T> find();

  /**
   * Find object by id.
   *
   * @param id the id
   * @return the found object
   */
  T findById(K id);

  /**
   * Remove all objects from collection/table.
   */
  void removeAll();

  /**
   * Remove object by id.
   *
   * @param id the object id
   */
  void removeById(K id);

}
