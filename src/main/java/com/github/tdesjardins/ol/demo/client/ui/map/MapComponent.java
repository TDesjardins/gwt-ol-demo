package com.github.tdesjardins.ol.demo.client.ui.map;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import com.github.tdesjardins.ol.demo.client.utils.DemoUtils;
import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.HTMLElement;

public class MapComponent
        extends AbstractComponent<IMapComponent.Controller, HTMLElement>
        implements IMapComponent {

    private static final String MAP_ID = "map";

    public MapComponent() {
        super();
    }

    @Override
    public void edit() {
        DemoUtils.createDefaultMap(MapComponent.MAP_ID);
    }

    @Override
    public void render() {
        Element container = DomGlobal.document.createElement("div");
        container.setAttribute("id", MapComponent.MAP_ID);
        initElement((HTMLElement)container);
    }

}
