package com.xdao.service;

import static com.xdao.util.DaoUtil.convertDtoList;
import static com.xdao.util.DaoUtil.getDto;
import static com.xdao.util.Validator.isValidSqlId;
import static com.xdao.util.Validator.isValidSqlObject;

import org.apache.commons.lang3.StringUtils;

import com.xdao.dto.ClientDto;
import com.xdao.dao.impl.ClientDao;
import com.xdao.dao.model.Client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class ClientService implements IClientService {

  private static final Logger LOG = LoggerFactory.getLogger(ClientService.class);

  @Autowired
  private ClientDao<Client> clientDao;

  @Override
  public ClientDto findByClientId(final String clientId) {
    return getDto(clientDao.findByClientId(clientId));
  }

  @Override
  public ClientDto saveClient(ClientDto clientDto) {
    ClientDto client = null;
    if (isValidSqlObject(clientDto)) {
      client = getDto(clientDao.save(new Client(clientDto)));
    }
    return client;
  }

  @Override
  public void removeClientById(String id) {
    if (isValidSqlId(id)) {
      clientDao.removeById(id);
    }
  }

  @Override
  public ClientDto findClientById(String id) {
    ClientDto clientDto = null;
    if (isValidSqlId(id)) {
      clientDto = getDto(clientDao.findById(id));
    }
    return clientDto;
  }

  @Override
  public List<ClientDto> findAllClients() {
    return convertDtoList(clientDao.find());
  }

}
