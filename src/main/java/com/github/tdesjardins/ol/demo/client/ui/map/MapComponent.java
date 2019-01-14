package com.github.tdesjardins.ol.demo.client.ui.map;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import com.github.tdesjardins.ol.demo.client.model.MyModel;

import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.HTMLElement;
import java.lang.Override;

public class MapComponent extends AbstractComponent<IMapComponent.Controller, HTMLElement> implements IMapComponent {

    public MapComponent() {
        super();
    }

    @Override
    public void edit(MyModel model) {
    }

    @Override
    public void render() {
        Element container = DomGlobal.document.createElement("div");
        initElement((HTMLElement)container);
    }

}
