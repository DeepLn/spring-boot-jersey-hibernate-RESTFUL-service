package com.xdao.service;

import com.xdao.dto.UserDto;

import java.util.List;

/**
 * The interface User service.
 */
public interface IUserService {

  boolean auth(final String apiKey, final String apiSecret);

  UserDto findByMobile(final String mobile);

  UserDto findByApiKeySecret(final String apiKey, final String apiSecret);

  /**
   * Save user.
   *
   * @param userDto the user dto
   * @return the user dto
   */
  UserDto saveUser(UserDto userDto);

  /**
   * Remove user by id.
   *
   * @param userId the user id
   */
  void removeUserById(String userId);

  /**
   * Find user by id.
   *
   * @param id the id
   * @return the user dto
   */
  UserDto findUserById(String id);

  /**
   * Find all users.
   *
   * @return the list of users.
   */
  List<UserDto> findAllUsers();

}
