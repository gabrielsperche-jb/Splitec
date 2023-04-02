package com.splitec.zarka.domain;

import com.splitec.zarka.repository.WorkflowRepository;
import org.json.JSONObject;

import java.lang.reflect.InvocationTargetException;

public class WorkflowExecutor {
  WorkflowRepository repository = new WorkflowRepository();

  public String executeFlow(JSONObject config) throws ClassNotFoundException, InvocationTargetException,
      InstantiationException, IllegalAccessException, NoSuchMethodException {
    return repository.callConnector(config.getString("connectorName"),
        config).toString();
  }
}
