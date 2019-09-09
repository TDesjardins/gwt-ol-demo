package com.github.tdesjardins.ol.demo.client.ui.map;

import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.AcceptParameter;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import com.github.nalukit.nalu.client.exception.RoutingInterceptionException;
import com.github.tdesjardins.ol.demo.client.GwtOlDemoContext;
import com.github.tdesjardins.ol.demo.client.event.UnFitLayoutEvent;
import com.github.tdesjardins.ol.demo.client.example.Example;
import com.github.tdesjardins.ol.demo.client.example.OLExampleType;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.dialogs.MessageDialog;

import java.lang.Override;

@Controller(route = "/application/map/:example", selector = "content", componentInterface = IsMapExampleComponent.class, component = MapExampleComponent.class)
public class MapExampleController extends AbstractComponentController<GwtOlDemoContext, IsMapExampleComponent, HTMLElement>
implements IsMapExampleComponent.Controller {

    private String mapId;

    public MapExampleController() {
    }

    @Override
    public void activate() {

        this.showMap();

    }

    @Override
    public void start() {
        this.eventBus.fireEvent(new UnFitLayoutEvent());
        this.router.storeInCache(this);
        this.showMap();

    }

    private void showMap() {

        if (this.mapId == null || this.mapId.isEmpty()) {
            this.mapId = OLExampleType.AnimationExample.name();
        }

        boolean containsMap = this.component.containsMap(this.mapId);
        Example currentExample = OLExampleType.valueOf(this.mapId).getExample();
        this.component.setMapExample(this.mapId, currentExample);

        if (!containsMap) {
            Scheduler.get().scheduleDeferred(() -> currentExample.show(this.mapId));
        }

    }


    @AcceptParameter("example")
    public void setId(String example) throws RoutingInterceptionException {
        this.mapId = example;
    }

}
