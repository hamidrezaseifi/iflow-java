package com.pth.iflow.gui.services;

public interface IMessagesHelper {

  String get(String code);

  String get(String code, Object... args);

}
