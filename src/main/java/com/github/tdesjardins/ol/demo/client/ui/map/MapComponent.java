package com.github.tdesjardins.ol.demo.client.ui.map;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.HTMLElement;

public class MapComponent
        extends AbstractComponent<IMapComponent.Controller, HTMLElement>
        implements IMapComponent {

    public MapComponent() {
        super();
    }

    @Override
    public void render() {
        Element container = DomGlobal.document.createElement("div");
        container.setAttribute("id", getController().getMapId());
        initElement((HTMLElement)container);
    }

}
