package com.github.tdesjardins.ol.demo.client.ui.statusbar;

import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import com.github.tdesjardins.ol.demo.client.GwtOlDemoContext;
import com.github.tdesjardins.ol.demo.client.event.StatusChangeEvent;
import elemental2.dom.HTMLElement;
import java.lang.Override;
import org.gwtproject.event.shared.HandlerRegistration;

@Controller(route = "/application/", selector = "footer", componentInterface = IStatusbarComponent.class, component = StatusbarComponent.class)
public class StatusbarController extends AbstractComponentController<GwtOlDemoContext, IStatusbarComponent, HTMLElement>
implements IStatusbarComponent.Controller {

    private HandlerRegistration registration;

    public StatusbarController() {
    }

    @Override
    public void start() {
        this.registration = this.eventBus.addHandler(StatusChangeEvent.TYPE, e -> component.edit(e.getStatus()));
    }

    @Override
    public void stop() {
        this.registration.removeHandler();
    }

}
