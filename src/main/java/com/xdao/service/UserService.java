package com.xdao.service;

import static com.xdao.util.DaoUtil.convertDtoList;
import static com.xdao.util.DaoUtil.getDto;
import static com.xdao.util.Validator.isValidSqlId;
import static com.xdao.util.Validator.isValidSqlObject;

import org.apache.commons.lang3.StringUtils;

import com.xdao.dto.UserDto;
import com.xdao.dao.impl.UserDao;
import com.xdao.dao.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class UserService implements IUserService {

  private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

  @Autowired
  private UserDao<User> userDao;

  @Override
  public UserDto auth(final String apiKey, final String apiSecret) {
    return findByApiKeySecret(apiKey, apiSecret);
  }

  @Override
  public UserDto findByMobile(final String mobile) {
    return getDto(userDao.findByMobile(mobile));
  }

  @Override
  public UserDto findByApiKeySecret(final String apiKey, final String apiSecret) {
    return getDto(userDao.findByApiKeySecret(apiKey, apiSecret));
  }

  @Override
  public UserDto saveUser(UserDto userDto) {
    UserDto user = null;
    if (isValidSqlObject(userDto)) {
      user = getDto(userDao.save(new User(userDto)));
    }
    return user;
  }

  @Override
  public void removeUserById(String id) {
    if (isValidSqlId(id)) {
      userDao.removeById(id);
    }
  }

  @Override
  public UserDto findUserById(String id) {
    UserDto userDto = null;
    if (isValidSqlId(id)) {
      userDto = getDto(userDao.findById(id));
    }
    return userDto;
  }

  @Override
  public List<UserDto> findAllUsers() {
    return convertDtoList(userDao.find());
  }

}
