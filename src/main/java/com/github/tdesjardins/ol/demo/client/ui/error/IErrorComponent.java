package com.github.tdesjardins.ol.demo.client.ui.error;

import com.github.nalukit.nalu.client.component.IsComponent;
import elemental2.dom.HTMLElement;
import java.lang.String;

public interface IErrorComponent extends IsComponent<IErrorComponent.Controller, HTMLElement> {

    void setErrorMessage(String errorMessage);

    interface Controller extends IsComponent.Controller {

        void doRouteHome();
    }

}
