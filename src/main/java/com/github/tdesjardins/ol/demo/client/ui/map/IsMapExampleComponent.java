package com.github.tdesjardins.ol.demo.client.ui.map;

import com.github.nalukit.nalu.client.component.IsComponent;
import elemental2.dom.HTMLElement;

public interface IsMapExampleComponent extends IsComponent<IsMapExampleComponent.Controller, HTMLElement> {

    void setMapId(String mapId);

    interface Controller extends IsComponent.Controller {}

}
