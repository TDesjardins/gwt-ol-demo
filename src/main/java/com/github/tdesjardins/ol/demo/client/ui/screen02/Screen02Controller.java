package com.github.tdesjardins.ol.demo.client.ui.screen02;

import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import com.github.tdesjardins.ol.demo.client.GwtOlDemoContext;
import com.github.tdesjardins.ol.demo.client.event.StatusChangeEvent;
import com.github.tdesjardins.ol.demo.client.event.UnFitLayoutEvent;

import elemental2.dom.HTMLElement;
import java.lang.Override;

@Controller(route = "/application/mapCard", selector = "content", componentInterface = IScreen02Component.class, component = Screen02Component.class)
public class Screen02Controller extends AbstractComponentController<GwtOlDemoContext, IScreen02Component, HTMLElement>
implements IScreen02Component.Controller {

    public Screen02Controller() {
    }

    @Override
    public void start() {

        this.eventBus.fireEvent(new UnFitLayoutEvent());
        this.router.storeInCache(this);
        this.component.edit();
        this.eventBus.fireEvent(new StatusChangeEvent("Map in a card"));

    }

}
