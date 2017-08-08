package com.xdao.dao.impl;

import com.xdao.dto.ClientDto;

/**
 * The interface Client dao.
 *
 * @param <T> the type parameter
 */
public interface ClientDao<T> extends SqlDao<T> {

  T findByClientId(final String clientId);

}
