package com.github.tdesjardins.ol.demo.client;

import com.github.nalukit.nalu.client.application.AbstractApplicationLoader;
import com.github.nalukit.nalu.client.application.IsApplicationLoader;
import java.lang.Override;

public class GwtOlDemoLoader extends AbstractApplicationLoader<GwtOlDemoContext> {

    @Override
    public void load(IsApplicationLoader.FinishLoadCommand finishLoadCommand) {
        // enter your code here ...
        finishLoadCommand.finishLoading();
    }

}
