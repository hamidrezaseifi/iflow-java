package com.pth.iflow.gui.services;

import java.util.List;

import com.pth.iflow.gui.models.ui.BreadCrumb;

public interface IBreadCrumbLoader {
  
  /**
   * this code create BreadCrumb list from the url string. the urls are in menu items and each url must have a identical menu item. if there
   * is a menu item it will be iterate until first parent. that code make sure that first element in list must be the home link. current
   * menu item and without link menu items are not allowed to have link but just label
   *
   * @param url
   * @return
   */
  List<BreadCrumb> getBreadCrumbList(String url);
  
}
