package com.github.tdesjardins.ol.demo.client.event;

import java.lang.Override;
import java.lang.String;
import org.gwtproject.event.shared.Event;

public class StatusChangeEvent extends Event<StatusChangeEvent.StatusChangeEventHandler> {

    public static Event.Type<StatusChangeEvent.StatusChangeEventHandler> TYPE = new Event.Type<>();

    private String status;

    public StatusChangeEvent(String status) {
        super();
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    @Override
    public Event.Type<StatusChangeEvent.StatusChangeEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    public void dispatch(StatusChangeEvent.StatusChangeEventHandler handler) {
        handler.onStatusChange(this);
    }

    public interface StatusChangeEventHandler {

        void onStatusChange(StatusChangeEvent event);
    }

}
