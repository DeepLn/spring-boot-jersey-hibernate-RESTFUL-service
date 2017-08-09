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
import org.springframework.stereotype.Component;

import com.xdao.dto.UserDto;
import com.xdao.service.IUserService;

@Component
@Path("/sms")
public class SmsEndpoint {

  private static final Logger logger = LoggerFactory.getLogger(SmsEndpoint.class);  

  @POST
  @Path("/launch")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response smsLaunch(UserDto userDto) {
    final String mobile = userDto.getMobile();
    return Response.ok(ResponseJson.ok().toString()).build();
  }

  @POST
  @Path("/verify")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response smsVerify(UserDto userDto) {
    final String mobile = userDto.getMobile();
    final String verifyCode = userDto.getVerifyCode();
    if (verifyCode == null || !verifyCode.equals("123456")) {
      return Response.ok(ResponseJson.warning("invalid verify code!").toString()).build();
    }
    return Response.ok(ResponseJson.ok().toString()).build();
  }

}
