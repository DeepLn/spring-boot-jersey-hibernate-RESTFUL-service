package com.xdao.dao.impl.sql;

import static com.xdao.dao.DaoConstants.USER_MOBILE;
import static com.xdao.dao.DaoConstants.USER_APIKEY;
import static com.xdao.dao.DaoConstants.USER_APISECRET;

import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import com.xdao.dao.impl.UserDao;
import com.xdao.dao.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class HibernateUserDao extends HibernateAbstractDao<User> implements UserDao<User> {

  private static final Logger LOG = LoggerFactory.getLogger(HibernateUserDao.class);

  @Override
  protected Class<User> getEntityClass() {
    return User.class;
  }

  @Override
  public User findByMobile(final String mobile) {
    LOG.debug("Searching user by mobile [{}]", mobile);
    User user = findOneByCriterion(Restrictions.eq(USER_MOBILE, mobile));
    if (LOG.isTraceEnabled()) {
      LOG.trace("[{}] Search result: {}.", mobile, user);
    } else {
      LOG.debug("[{}] Search result: {}.", mobile, user != null);
    }
    return user;
  }

  @Override
  public User findByApiKeySecret(final String apiKey, final String apiSecret) {
    LOG.debug("Searching user by apiKey [{}] and apiSecret [{}]", apiKey, apiSecret);
    User user = findOneByCriterion(Restrictions.and(
                                     Restrictions.eq(USER_APIKEY, apiKey),
                                     Restrictions.eq(USER_APISECRET, apiSecret)));
    if (LOG.isTraceEnabled()) {
      LOG.trace("[{}][{}] Search result: {}.", apiKey, apiSecret, user);
    } else {
      LOG.debug("[{}][{}] Search result: {}.", apiKey, apiSecret, user != null);
    }
    return user;
  }

}
