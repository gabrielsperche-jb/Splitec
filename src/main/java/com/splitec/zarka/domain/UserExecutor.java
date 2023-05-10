package com.splitec.zarka.domain;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.json.JSONObject;

public class UserExecutor {
  MongoClient mongoClient = new MongoClient("localhost", 27017);
  MongoDatabase database = mongoClient.getDatabase("zarka");
  MongoCollection<Document> collection = database.getCollection("users");

  public String buildUserDocument(JSONObject userInfo) {
    String responseMessage;
    try {
      Document userDoc = new Document();
      userDoc.append("usuario", userInfo.getString("username"));
      userDoc.append("senha", userInfo.getString("password"));
      collection.insertOne(userDoc);
      responseMessage = "Cadastrado com sucesso";
    } catch (Exception e) {
      responseMessage = e.getLocalizedMessage();
    }
    return responseMessage;
  }

}
