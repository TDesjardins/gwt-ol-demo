package com.github.tdesjardins.ol.demo.client.event;

import org.gwtproject.event.shared.Event;

public class FitLayoutEvent
    extends Event<FitLayoutEvent.FitLayoutEventHandler> {

    public static Type<FitLayoutEvent.FitLayoutEventHandler> TYPE = new Type<>();

    public FitLayoutEvent() {
        super();
    }

    @Override
    public Type<FitLayoutEvent.FitLayoutEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    public void dispatch(FitLayoutEvent.FitLayoutEventHandler handler) {
        handler.onFitLayout(this);
    }

    public interface FitLayoutEventHandler {

        void onFitLayout(FitLayoutEvent event);
    }

}
