package com.xdao.service;

import com.xdao.dto.ClientDto;

import java.util.List;

/**
 * The interface Client service.
 */
public interface IClientService {

  ClientDto findByClientId(final String clientId);

  /**
   * Save client.
   *
   * @param clientDto the client dto
   * @return the client dto
   */
  ClientDto saveClient(ClientDto clientDto);

  /**
   * Remove client by id.
   *
   * @param clientId the client id
   */
  void removeClientById(String clientId);

  /**
   * Find client by id.
   *
   * @param id the id
   * @return the client dto
   */
  ClientDto findClientById(String id);

  /**
   * Find all clients.
   *
   * @return the list of clients.
   */
  List<ClientDto> findAllClients();

}
