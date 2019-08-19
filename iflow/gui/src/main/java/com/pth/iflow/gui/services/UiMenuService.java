package com.pth.iflow.gui.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pth.iflow.gui.models.ui.UiMenuItem;

/**
 * A class to manage and load menu items and sub items
 *
 * @author rezasei
 *
 */
@Service
public class UiMenuService {
  
  private final Logger logger = LoggerFactory.getLogger(UiMenuService.class);
  
  private List<UiMenuItem> menus;
  
  @Autowired
  private ObjectMapper objectMapper;
  
  @Autowired
  private ResourceLoader resourceLoader;
  
  @Autowired
  private IMessagesHelper messages;
  
  public UiMenuService() {
    this.menus = new ArrayList<>();
  }
  
  @PostConstruct
  public void reload() throws JsonParseException, JsonMappingException, IOException {
    
    this.logger.debug("Reading menu access.");
    
    final List<UiMenuItem> menulist;
    
    final Resource resource = this.resourceLoader.getResource("classpath:config/menulist.json");
    try (final InputStream is = resource.getInputStream()) {
      menulist = this.objectMapper.readValue(is, new TypeReference<List<UiMenuItem>>() {
      });
      
      for (final UiMenuItem item : menulist) {
        item.setLabelsFromMessage(this.messages);
      }
      
      this.menus.clear();
      this.menus.addAll(menulist);
      
      this.logger.debug("Found {} menu item(s).", this.menus.size());
      
    }
    
  }
  
  public List<UiMenuItem> getAllMenus() {
    return this.menus;
  }
  
  public List<UiMenuItem> getMenus(final List<String> idList) {
    final List<UiMenuItem> list = new ArrayList<>();
    for (final UiMenuItem menu : this.menus) {
      if (idList.contains(menu.getId())) {
        list.add(menu);
      }
    }
    return list;
  }
  
  public void setMenus(final List<UiMenuItem> menus) {
    this.menus = menus;
  }
  
  public UiMenuItem getMenuItemByUrl(final String url) {
    for (final UiMenuItem item : this.menus) {
      final UiMenuItem f = item.getMenuItemByUrl(url);
      if (f != null) {
        return f;
      }
    }
    
    return null;
  }
  
}
