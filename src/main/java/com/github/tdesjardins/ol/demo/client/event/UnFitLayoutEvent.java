package com.github.tdesjardins.ol.demo.client.event;

import org.gwtproject.event.shared.Event;

public class UnFitLayoutEvent
    extends Event<UnFitLayoutEvent.UnFitLayoutEventHandler> {

    public static Type<UnFitLayoutEvent.UnFitLayoutEventHandler> TYPE = new Type<>();

    public UnFitLayoutEvent() {
        super();
    }

    @Override
    public Type<UnFitLayoutEvent.UnFitLayoutEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    public void dispatch(UnFitLayoutEvent.UnFitLayoutEventHandler handler) {
        handler.onUnFitLayout(this);
    }

    public interface UnFitLayoutEventHandler {

        void onUnFitLayout(UnFitLayoutEvent event);
    }

}
