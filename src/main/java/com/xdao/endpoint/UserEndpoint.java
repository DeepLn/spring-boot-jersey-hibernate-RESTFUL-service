package com.xdao.endpoint;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.xdao.dto.UserDto;
import com.xdao.filter.auth.AuthGeneral;
import com.xdao.service.IUserService;

@Component
@Path("/user")
public class UserEndpoint {

  private static final Logger logger = LoggerFactory.getLogger(UserEndpoint.class);  

  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  private IUserService userService;

  @POST
  @Path("/register")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response userRegister(UserDto userDto) {
    final String mobile = userDto.getMobile();

    if (userService.findByMobile(mobile) == null) {
      userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));

      String verifyCode = userDto.getVerifyCode();
      if (verifyCode == null || !userDto.getVerifyCode().equals("123456")) {
        return Response.ok(ResponseJson.warning("invalid verify code!").toString()).build();
      }

      String apiKey;
      String apiSecret;

      while (true) {
        apiKey = RandomStringUtils.randomAlphanumeric(8);
        apiSecret = RandomStringUtils.randomAlphanumeric(24);

        if (userService.findByApiKeySecret(apiKey, apiSecret) == null) {
          userDto.setApiKey(apiKey);
          userDto.setApiSecret(apiSecret);
          userDto.setCreatedTime(System.currentTimeMillis());
          break;
        }
      }

      userDto = userService.saveUser(userDto);
      return Response.ok(ResponseJson.registerOk(userDto)).build();
    } else {
      return Response.ok(ResponseJson.warning("regested!").toString()).build();
    }
  }  

  @POST
  @Path("/login")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response userLogin(UserDto userDto) {

    final String mobile = userDto.getMobile();
    final String password = userDto.getPassword();

    UserDto dto = userService.findByMobile(mobile);
    if (dto == null || !passwordEncoder.matches(password, dto.getPassword())) {
      JSONObject obj = new JSONObject();
      obj.put("message", "wrong mobile or password!");
      return Response.ok(obj.toString()).build();
    }
    
    return Response.ok(ResponseJson.loginOk(dto)).build();
  }

  @POST
  @Path("/passwordReset")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response userPasswordReset(UserDto userDto) {
    final String mobile = userDto.getMobile();

    String verifyCode = userDto.getVerifyCode();
    if (verifyCode == null || !userDto.getVerifyCode().equals("123456")) {
      return Response.ok(ResponseJson.warning("invalid verify code!").toString()).build();
    }

    UserDto user = userService.findByMobile(mobile);
    if (user != null) {
      user.setPassword(passwordEncoder.encode(userDto.getPassword()));
      userDto = userService.saveUser(user);
      return Response.ok(ResponseJson.registerOk(userDto)).build();
    } else {
      return Response.ok(ResponseJson.warning("user not exist!").toString()).build();
    }
  }  


  @GET
  @Path("/sample")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response userSample() {
    return Response.ok("ok, you'are requesting a RESTFUL service").build();
  }

}
