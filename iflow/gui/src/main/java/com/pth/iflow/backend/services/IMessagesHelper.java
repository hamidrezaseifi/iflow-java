package com.pth.iflow.backend.services;

public interface IMessagesHelper {

  String get(String code);

  String get(String code, Object... args);

}
