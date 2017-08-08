package com.xdao.dao.impl.sql;

import static com.xdao.dao.DaoConstants.CLIENT_CLIENTID;

import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import com.xdao.dao.impl.ClientDao;
import com.xdao.dao.model.Client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class HibernateClientDao extends HibernateAbstractDao<Client> implements ClientDao<Client> {

  private static final Logger LOG = LoggerFactory.getLogger(HibernateClientDao.class);

  @Override
  protected Class<Client> getEntityClass() {
    return Client.class;
  }

  @Override
  public Client findByClientId(final String clientId) {
    LOG.debug("Searching client by clientId [{}]", clientId);
    Client client = findOneByCriterion(Restrictions.eq(CLIENT_CLIENTID, clientId));
    if (LOG.isTraceEnabled()) {
      LOG.trace("[{}] Search result: {}.", clientId, client);
    } else {
      LOG.debug("[{}] Search result: {}.", clientId, client != null);
    }
    return client;
  }

}
