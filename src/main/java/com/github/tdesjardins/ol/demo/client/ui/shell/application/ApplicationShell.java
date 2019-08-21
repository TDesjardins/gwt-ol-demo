package com.github.tdesjardins.ol.demo.client.ui.shell.application;

import com.github.nalukit.nalu.client.component.AbstractShell;
import com.github.nalukit.nalu.client.component.annotation.Shell;
import com.github.nalukit.nalu.client.exception.RoutingInterceptionException;
import com.github.tdesjardins.ol.demo.client.GwtOlDemoContext;
import com.github.tdesjardins.ol.demo.client.event.FitLayoutEvent;
import com.github.tdesjardins.ol.demo.client.event.UnFitLayoutEvent;
import org.dominokit.domino.ui.layout.Layout;
import org.dominokit.domino.ui.style.ColorScheme;

@Shell("application")
public class ApplicationShell
        extends AbstractShell<GwtOlDemoContext> {

    private Layout layout;

    public ApplicationShell() {
        super();
    }

    @Override
    public void attachShell() {

        layout = Layout.create("GWT-OL Demo")
                .show(ColorScheme.INDIGO)
                .hideFooter()
                .fitWidth()
                .fitHeight();

        layout.getLeftPanel().setId("navigation");
        layout.getContentPanel().setId("content");
    }

    @Override
    public void detachShell() {
        this.layout.remove();
    }

    @Override
    public void bind(ShellLoader loader) throws RoutingInterceptionException {

        this.eventBus.addHandler(FitLayoutEvent.TYPE,
                event -> {
                    layout.fitWidth();
                    layout.fitHeight();
                });

        this.eventBus.addHandler(UnFitLayoutEvent.TYPE,
                event -> {
                    layout.unfitWidth();
                    layout.unfitHeight();
                });

        loader.continueLoading();

    }

}
