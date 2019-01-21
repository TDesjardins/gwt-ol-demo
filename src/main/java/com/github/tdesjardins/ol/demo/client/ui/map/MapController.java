package com.github.tdesjardins.ol.demo.client.ui.map;

import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import com.github.tdesjardins.ol.demo.client.GwtOlDemoContext;
import com.github.tdesjardins.ol.demo.client.event.FitLayoutEvent;
import com.github.tdesjardins.ol.demo.client.event.StatusChangeEvent;
import com.github.tdesjardins.ol.demo.client.event.UnFitLayoutEvent;

import elemental2.dom.HTMLElement;
import java.lang.Override;

@Controller(route = "/application/map", selector = "content", componentInterface = IMapComponent.class, component = MapComponent.class)
public class MapController extends AbstractComponentController<GwtOlDemoContext, IMapComponent, HTMLElement> implements IMapComponent.Controller {

    public MapController() {
    }

    @Override
    public void start() {
        this.eventBus.fireEvent(new FitLayoutEvent());
        this.router.storeInCache(this);
        this.component.edit();
        this.eventBus.fireEvent(new StatusChangeEvent("Map"));
    }

    @Override
    public void activate() {
        this.eventBus.fireEvent(new FitLayoutEvent());
        super.activate();
    }

    @Override
    public void deactivate() {
        this.eventBus.fireEvent(new UnFitLayoutEvent());
        super.deactivate();
    }

}
