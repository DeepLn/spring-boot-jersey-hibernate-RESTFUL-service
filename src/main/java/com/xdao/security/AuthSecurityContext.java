package com.xdao.security;
 
import com.xdao.dto.UserDto; 

import javax.ws.rs.core.SecurityContext; 
import java.security.Principal; 
 
public class AuthSecurityContext implements SecurityContext { 
 
    private UserDto userDto; 
 
    public AuthSecurityContext(UserDto userDto) { 
      this.userDto = userDto; 
    } 
 
    /**
     * UserDto entity implements Principal 
     * @return userDto 
     */ 
    @Override 
    public Principal getUserPrincipal() { 
      return this.userDto; 
    } 
 
    @Override 
    public boolean isUserInRole(String role) { 
      return false; 
    } 
 
    @Override 
    public boolean isSecure() { 
      return false; 
    } 
 
    @Override 
    public String getAuthenticationScheme() { 
      return SecurityContext.BASIC_AUTH; 
    } 

}
