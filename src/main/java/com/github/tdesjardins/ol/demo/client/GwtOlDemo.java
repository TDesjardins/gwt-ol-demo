package com.github.tdesjardins.ol.demo.client;

import com.github.nalukit.nalu.plugin.elemental2.client.NaluPluginElemental2;
import com.google.gwt.core.client.EntryPoint;

public class GwtOlDemo implements EntryPoint {

    public void onModuleLoad() {

        GwtOlDemoApplication application = new GwtOlDemoApplicationImpl();
        application.run(new NaluPluginElemental2());

    }
}
