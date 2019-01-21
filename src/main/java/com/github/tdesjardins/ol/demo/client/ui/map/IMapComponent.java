package com.github.tdesjardins.ol.demo.client.ui.map;

import com.github.nalukit.nalu.client.component.IsComponent;
import elemental2.dom.HTMLElement;

public interface IMapComponent extends IsComponent<IMapComponent.Controller, HTMLElement> {

    interface Controller extends IsComponent.Controller {

        String getMapId();

    }

}
