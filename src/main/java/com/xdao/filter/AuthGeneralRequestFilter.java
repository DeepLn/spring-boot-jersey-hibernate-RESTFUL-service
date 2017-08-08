package com.xdao.filter;

import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import com.xdao.filter.auth.AuthGeneral;
import com.xdao.service.UserService;

@AuthGeneral
@Provider
public class AuthGeneralRequestFilter implements ContainerRequestFilter {

  static final String apiKey = "apiKey";
  static final String apiSecret = "apiSecret";

  @Autowired
  UserService userService;

  @Override
  public void filter(ContainerRequestContext containerRequest)
      throws WebApplicationException {

    if (!userService.auth(containerRequest.getHeaderString(apiKey),
                          containerRequest.getHeaderString(apiSecret))) {
      throw new WebApplicationException(Status.UNAUTHORIZED);
    }
  }

}
