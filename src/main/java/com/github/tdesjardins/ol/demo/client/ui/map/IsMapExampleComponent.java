package com.github.tdesjardins.ol.demo.client.ui.map;

import com.github.nalukit.nalu.client.component.IsComponent;
import com.github.tdesjardins.ol.demo.client.example.Example;

import elemental2.dom.HTMLElement;

public interface IsMapExampleComponent extends IsComponent<IsMapExampleComponent.Controller, HTMLElement> {

    boolean containsMap(String mapId);

    void setMapExample(String mapId, Example mapExample);

    interface Controller extends IsComponent.Controller {}

}
