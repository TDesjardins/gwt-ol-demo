package com.github.tdesjardins.ol.demo.client;

import com.github.nalukit.nalu.client.application.IsContext;
import org.dominokit.domino.ui.layout.Layout;

public class GwtOlDemoContext implements IsContext {


    private Layout layout;

    public GwtOlDemoContext() {
        // enter your constructor code here ...
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }

    public void fitLayout(){
        layout.fitWidth();
        layout.fitHeight();
    }

    public void unfitLayout(){
        layout.unfitWidth();
        layout.unfitHeight();
    }

}
