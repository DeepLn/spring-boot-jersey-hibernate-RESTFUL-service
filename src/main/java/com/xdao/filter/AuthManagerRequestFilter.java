package com.xdao.filter;

import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import org.springframework.beans.factory.annotation.Value;

import com.xdao.filter.auth.AuthManager;
import com.xdao.service.UserService;

@AuthManager
@Provider
public class AuthManagerRequestFilter implements ContainerRequestFilter {

  private String apiKey;

  private String apiSecret;

  @Autowired
  UserService userService;

  @Autowired
  public void getAdminApiKey(@Value("${admin.api.key}") String apiKey) {
    this.apiKey = apiKey;
  }

  @Autowired
  public void getAdminApiSecret(@Value("${admin.api.secret}") String apiSecret) {
    this.apiSecret = apiSecret;
  }

  @Override
  public void filter(ContainerRequestContext containerRequest)
      throws WebApplicationException {

    if (!apiKey.equals(containerRequest.getHeaderString("apiKey")) ||
                          !apiSecret.equals(containerRequest.getHeaderString("apiSecret"))) {
      throw new WebApplicationException(Status.UNAUTHORIZED);
    }
  }

}
