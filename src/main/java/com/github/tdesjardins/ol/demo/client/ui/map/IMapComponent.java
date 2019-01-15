package com.github.tdesjardins.ol.demo.client.ui.map;

import com.github.nalukit.nalu.client.component.IsComponent;
import com.github.tdesjardins.ol.demo.client.model.MyModel;
import elemental2.dom.HTMLElement;

public interface IMapComponent extends IsComponent<IMapComponent.Controller, HTMLElement> {
  void edit();

  interface Controller extends IsComponent.Controller {
  }
}
