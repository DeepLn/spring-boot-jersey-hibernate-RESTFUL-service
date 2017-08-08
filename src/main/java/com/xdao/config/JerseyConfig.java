package com.xdao.config;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.xdao.endpoint.ClientEndpoint;
import com.xdao.endpoint.UserEndpoint;
import com.xdao.filter.AuthGeneralRequestFilter;
import com.xdao.filter.AuthManagerRequestFilter;

@Component
@ApplicationPath("")
public class JerseyConfig extends ResourceConfig {
  public JerseyConfig() {
    register(AuthGeneralRequestFilter.class);
    register(AuthManagerRequestFilter.class);
    register(ClientEndpoint.class);
    register(UserEndpoint.class);
  }

  @Autowired
  private EntityManagerFactory entityManagerFactory;
  
  @Bean
  public PasswordEncoder getPasswordEncoder(){
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SessionFactory getSessionFactory() {
    if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
      throw new NullPointerException("factory is not a hibernate factory");
    }
    return entityManagerFactory.unwrap(SessionFactory.class);
  }

}
