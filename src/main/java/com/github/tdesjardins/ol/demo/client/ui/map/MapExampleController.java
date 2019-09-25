package com.github.tdesjardins.ol.demo.client.ui.map;

import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.AcceptParameter;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import com.github.nalukit.nalu.client.exception.RoutingInterceptionException;
import com.github.tdesjardins.ol.demo.client.GwtOlDemoContext;
import com.github.tdesjardins.ol.demo.client.event.UnFitLayoutEvent;
import com.github.tdesjardins.ol.demo.client.example.OLExampleType;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.dialogs.MessageDialog;

import java.lang.Override;

@Controller(route = "/application/map/:example", selector = "content", componentInterface = IsMapExampleComponent.class, component = MapExampleComponent.class)
public class MapExampleController extends AbstractComponentController<GwtOlDemoContext, IsMapExampleComponent, HTMLElement>
implements IsMapExampleComponent.Controller {

    private String example;

    public MapExampleController() {
    }

    @Override
    public void start() {
        this.eventBus.fireEvent(new UnFitLayoutEvent());
        //this.router.storeInCache(this);
        
        if (example == null || example.isEmpty()) {
            example = "AnimationExample";
        }

        if (example != null) {
            for (OLExampleType currentExample : OLExampleType.values()) {

                if (currentExample.name().equals(example)) {
                    component.setMapId(example);
                    Scheduler.get().scheduleDeferred(() -> currentExample.getExample().show(currentExample.name()));
                }

            }
        }

    }


    @AcceptParameter("example")
    public void setId(String example) throws RoutingInterceptionException {
        this.example = example;
    }

}
