package com.github.tdesjardins.ol.demo.client.ui.map;

import com.github.nalukit.nalu.client.component.AbstractComponent;

import org.dominokit.addons.ol.ui.MapView;

import elemental2.dom.HTMLElement;

public class MapComponent
        extends AbstractComponent<IMapComponent.Controller, HTMLElement>
        implements IMapComponent {

    public MapComponent() {
        super();
    }

    @Override
    public void render() {
        MapView mapView = new MapView(getController().getMapId());
        initElement(mapView.asElement());
    }

}
