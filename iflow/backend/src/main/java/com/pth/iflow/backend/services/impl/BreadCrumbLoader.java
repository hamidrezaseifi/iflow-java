package com.pth.iflow.backend.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pth.iflow.backend.models.ui.BreadCrumb;
import com.pth.iflow.backend.models.ui.UiMenuItem;
import com.pth.iflow.backend.services.IBreadCrumbLoader;
import com.pth.iflow.backend.services.UiMenuService;

/**
 * a class to manage BreadCrumb items for each page
 *
 * @author rezasei
 *
 */
@Component
public class BreadCrumbLoader implements IBreadCrumbLoader {

  @Autowired
  private UiMenuService menuService;

  /*
   * (non-Javadoc)
   * @see de.tui.cssi.mdm.ui.helpers.IBreadCrumbLoader#getBreadCrumbList(java.lang.String)
   */
  @Override
  public List<BreadCrumb> getBreadCrumbList(final String url) {

    final ArrayList<BreadCrumb> list = new ArrayList<>();

    UiMenuItem home = this.menuService.getMenuItemByUrl("/");
    final UiMenuItem item = this.menuService.getMenuItemByUrl(url);
    UiMenuItem temp = item;

    while (temp != null) {
      list.add(0, new BreadCrumb(temp.getLabel(), temp.getUrl(), temp.getId() == item.getId()));

      if (temp.getId() == home.getId()) {
        home = null;
      }
      temp = temp.getParent();
    }

    if (home != null) {
      if ((temp == null) || (home.getId() != item.getId())) {

        list.add(0, new BreadCrumb(home.getLabel(), home.getUrl()));
      }
    }

    return list;
  }
}
