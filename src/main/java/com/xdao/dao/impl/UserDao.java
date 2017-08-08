package com.xdao.dao.impl;

import com.xdao.dto.UserDto;

/**
 * The interface User dao.
 *
 * @param <T> the type parameter
 */
public interface UserDao<T> extends SqlDao<T> {
  /**
   * Find object by mobile.
   *
   * @param mobile the mobile 
   * @return the found object
   */
  T findByMobile(final String mobile);

  T findByApiKeySecret(final String apiKey, final String apiSecret);

}
