package com.github.tdesjardins.ol.demo.client.ui.navigation;

import com.github.nalukit.nalu.client.component.IsComponent;
import elemental2.dom.HTMLElement;
import java.lang.String;

public interface INavigationComponent extends IsComponent<INavigationComponent.Controller, HTMLElement> {

    interface Controller extends IsComponent.Controller {

        void doNavigateTo(String target);
    }
}
