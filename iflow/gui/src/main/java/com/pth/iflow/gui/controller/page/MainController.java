package com.pth.iflow.gui.controller.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pth.iflow.gui.configurations.IGuiConfiguration;
import com.pth.iflow.gui.helper.BuildInfoProperties;

@Controller
@RequestMapping(value = "/")
public class MainController extends GuiPageControllerBase {

  @Autowired
  private IGuiConfiguration backendConfigurations;

  @Autowired
  BuildInfoProperties buildInfoProperties;

  /*
   * @ResponseStatus(HttpStatus.OK)
   * 
   * @GetMapping(path = "/") public String index() {
   * 
   * return "ang/index"; }
   * 
   * @ResponseStatus(HttpStatus.OK)
   * 
   * @GetMapping(path = "/about", produces = MediaType.APPLICATION_XML_VALUE)
   * 
   * @ResponseBody public BuildInfoProperties about() {
   * 
   * return this.buildInfoProperties; }
   * 
   * @ResponseStatus(HttpStatus.OK)
   * 
   * @GetMapping(path = "/test", produces = MediaType.APPLICATION_XML_VALUE)
   * 
   * @ResponseBody public Map<String, String> test() { final Map<String, String> map = new HashMap<>(); map.put("valid-email",
   * this.backendConfigurations.getBackendValidEMail());
   * 
   * return map; }
   */
}
