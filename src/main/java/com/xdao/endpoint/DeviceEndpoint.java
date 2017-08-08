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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xdao.dto.UserDto;
import com.xdao.filter.auth.AuthGeneral;

@Component
@Path("/api/device")
public class DeviceEndpoint {

  private static final Logger logger = LoggerFactory.getLogger(DeviceEndpoint.class);  

  @GET
  @Path("/getBind")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response userRegister(/*UserDto userDto*/) {
    final String re = "{\"data\":[{\"id\":0,\"name\":\"嘀嘀嘀\",\"bindTime\":\"2017-3-3\",\"IMEI\":\"123desafasdf344\"," +
                      "\"isDefault\":true},{\"id\":1,\"name\":\"嘀嘀嘀\",\"bindTime\":\"2017-3-3\",\"IMEI\":\"123dsdgf34df344\"," +
                      "\"isDefault\":false}],\"resultMsg\":\"成功\",\"resultCode\":\"000\"}";
    return Response.ok(re).build();
  }  

  @POST
  @AuthGeneral
  @Path("/property")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response clientProperty(UserDto userDto) {
    return Response.ok("client").build();
  }  

}
