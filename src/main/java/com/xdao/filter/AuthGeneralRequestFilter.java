package com.xdao.filter;

import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import com.xdao.dto.UserDto;
import com.xdao.filter.auth.AuthGeneral;
import com.xdao.security.AuthSecurityContext;
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

    UserDto userDto = userService.auth(containerRequest.getHeaderString(apiKey),
                                       containerRequest.getHeaderString(apiSecret));
    if (userDto != null) {
      containerRequest.setSecurityContext(new AuthSecurityContext(userDto));
      return;
    }

    /*String path = requestContext.getUriInfo().getPath(); 
    if (path.equals("/user/login") || path.equals("/user/signup") || path.equals("/user/testRest")) { 
        return; 
    }*/

    containerRequest.abortWith(Response.ok("abort!").build());
  }

}
