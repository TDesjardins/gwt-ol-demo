package com.github.tdesjardins.ol.demo.client.ui.screen02;

import com.github.nalukit.nalu.client.component.IsComponent;
import com.github.tdesjardins.ol.demo.client.model.MyModel;
import elemental2.dom.HTMLElement;

public interface IScreen02Component extends IsComponent<IScreen02Component.Controller, HTMLElement> {

    void edit(MyModel model);

    interface Controller extends IsComponent.Controller {}

}
