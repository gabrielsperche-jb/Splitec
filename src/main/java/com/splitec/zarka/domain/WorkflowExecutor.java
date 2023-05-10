package com.splitec.zarka.domain;

import com.splitec.zarka.repository.WorkflowRepository;
import com.splitec.zarka.utils.JWTUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.InvocationTargetException;

public class WorkflowExecutor {
  WorkflowRepository repository = new WorkflowRepository();

  public String executeFlow(JSONArray config) throws ClassNotFoundException, InvocationTargetException,
      InstantiationException, IllegalAccessException, NoSuchMethodException {
    for (Object obj : config) {
      JSONObject connectorConfig = new JSONObject(obj);
      Object connectorResponse = repository.callConnector(connectorConfig.getString("connectorName"), connectorConfig);
    }
    return "";
  }

  public String createToken(JSONObject config) {
    return JWTUtils.createToken(config.getString("userId"));
  }
}
