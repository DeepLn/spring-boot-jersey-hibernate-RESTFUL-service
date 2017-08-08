package com.xdao.endpoint;

import org.json.JSONObject;

import com.xdao.dto.ClientDto;
import com.xdao.dto.UserDto;

public class ResponseJson {

  static public JSONObject ok() {
    JSONObject obj = new JSONObject();
    obj.put("code", "200");
    obj.put("message", "OK");
    return obj;
  }

  static public JSONObject warning(final String warn) {
    JSONObject obj = new JSONObject();
    obj.put("code", "701");
    obj.put("message", warn);
    return obj;
  }

  static public String registerOk(UserDto userDto) {
    return ok().put("apiKey", userDto.getApiKey()).put("apiSecret", userDto.getApiSecret()).toString();
  }

  static public String loginOk(UserDto userDto) {
    return ok().put("apiKey", userDto.getApiKey()).put("apiSecret", userDto.getApiSecret()).toString();
  }

  static public String clientProperty(ClientDto clientDto) {
    return ok().put("clientId", clientDto.getClientId()).toString();
  }

}
