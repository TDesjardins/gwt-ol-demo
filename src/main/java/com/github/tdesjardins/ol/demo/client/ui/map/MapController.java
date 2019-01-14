package com.github.tdesjardins.ol.demo.client.ui.map;

import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import com.github.tdesjardins.ol.demo.client.GwtOlDemoContext;
import com.github.tdesjardins.ol.demo.client.event.StatusChangeEvent;
import com.github.tdesjardins.ol.demo.client.model.MyModel;
import com.github.tdesjardins.ol.demo.client.utils.DemoUtils;

import elemental2.dom.HTMLElement;
import java.lang.Override;

@Controller(route = "/application/map", selector = "content", componentInterface = IMapComponent.class, component = MapComponent.class)
public class MapController extends AbstractComponentController<GwtOlDemoContext, IMapComponent, HTMLElement> implements IMapComponent.Controller {

    private static final String MAP_ID = "map";

    private MyModel model;

    public MapController() {
    }

    @Override
    public void start() {
        context.fitLayout();

        model = new MyModel("This is a map based on OpenLayers.");

        component.asElement().setAttribute("id", MAP_ID);

        // now, move the data out of the model into the widgets - that's what we do next
        component.edit(model);
        // update the statusbar at the buttom of the screen
        eventBus.fireEvent(new StatusChangeEvent("Map"));

        DemoUtils.createDefaultMap(MAP_ID);

    }

}
