package com.xdao.endpoint;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xdao.dto.ClientDto;
import com.xdao.dto.UserDto;
import com.xdao.filter.auth.AuthGeneral;
import com.xdao.filter.auth.AuthManager;
import com.xdao.service.IClientService;

@Component
@Path("/client")
public class ClientEndpoint {

  private static final Logger logger = LoggerFactory.getLogger(ClientEndpoint.class);  

  @Autowired
  private IClientService clientService;

  @POST
  @AuthManager
  @Path("/add")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response clientAdd(ClientDto clientDto) {
    clientDto.setCreatedTime(System.currentTimeMillis());
    try {
      clientService.saveClient(clientDto);
      return Response.ok(ResponseJson.ok().toString()).build();
    } catch (Exception ex) {
      return Response.status(Status.CONFLICT).build();
    }
  }  

  @POST
  @AuthGeneral
  @Path("/property")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response clientProperty(@Context SecurityContext sc, ClientDto clientDto) {
    /*System.out.println("mobile:" + ((UserDto)sc.getUserPrincipal()).getMobile());*/

    ClientDto dto = clientService.findByClientId(clientDto.getClientId());
    if (dto != null) {
      JSONObject obj = ResponseJson.ok().put("topic", dto.getTopic());
      obj.put("sdkName", dto.getSdkName()).put("sdkVersion", dto.getSdkVersion());
      return Response.ok(obj.toString()).build();
    }
    return Response.status(Status.NO_CONTENT).build();
  }  

}
