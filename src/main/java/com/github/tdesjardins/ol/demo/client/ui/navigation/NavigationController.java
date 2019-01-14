package com.github.tdesjardins.ol.demo.client.ui.navigation;

import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import com.github.tdesjardins.ol.demo.client.GwtOlDemoContext;
import elemental2.dom.HTMLElement;
import java.lang.Override;
import java.lang.String;

@Controller(route = "/application/", selector = "navigation", componentInterface = INavigationComponent.class, component = NavigationComponent.class)
public class NavigationController extends AbstractComponentController<GwtOlDemoContext, INavigationComponent, HTMLElement>
implements INavigationComponent.Controller {

    public NavigationController() {
    }

    @Override
    public void doNavigateTo(String target) {

        switch(target) {
            case "map":
                router.route("/application/map");
                break;
            case "mapCard":
                router.route("/application/mapCard");
                break;
        }

    }

}
