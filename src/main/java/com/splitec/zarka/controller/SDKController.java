package com.splitec.zarka.controller;

import com.splitec.zarka.Constants;
import com.splitec.zarka.domain.WorkflowExecutor;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sdk")
public class SDKController implements Constants {

  WorkflowExecutor executor = new WorkflowExecutor();

  @PostMapping(value = "/workflow/run")
  public ResponseEntity<Object> runWorkflow(@RequestBody String body) {
    try {
      JSONObject workflowConfig = new JSONObject(body);
      String result = executor.executeFlow(workflowConfig);
      return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
    } catch (Exception e) {
      return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
    }
  }
}