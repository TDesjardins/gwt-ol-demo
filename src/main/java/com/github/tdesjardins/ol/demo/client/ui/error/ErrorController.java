package com.github.tdesjardins.ol.demo.client.ui.error;

import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import com.github.tdesjardins.ol.demo.client.GwtOlDemoContext;
import elemental2.dom.HTMLElement;
import java.lang.Override;

@Controller(route = "/error/error", selector = "content", componentInterface = IErrorComponent.class, component = ErrorComponent.class)
public class ErrorController extends AbstractComponentController<GwtOlDemoContext, IErrorComponent, HTMLElement> implements IErrorComponent.Controller {

    public ErrorController() {
    }

    @Override
    public void start() {
        // Get the error message from the router and set it.
        this.component.setErrorMessage(this.router.getNaluErrorMessage().getErrorMessage());
    }

    @Override
    public void doRouteHome() {
        this.router.route("/application/screen01");
    }
}
