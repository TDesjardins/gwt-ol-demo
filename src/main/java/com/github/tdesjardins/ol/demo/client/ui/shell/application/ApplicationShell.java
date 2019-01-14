package com.github.tdesjardins.ol.demo.client.ui.shell.application;

import com.github.nalukit.nalu.client.component.AbstractShell;
import com.github.nalukit.nalu.client.component.annotation.Shell;
import com.github.tdesjardins.ol.demo.client.GwtOlDemoContext;
import java.lang.Override;
import org.dominokit.domino.ui.layout.Layout;
import org.dominokit.domino.ui.style.ColorScheme;

import elemental2.dom.CSSProperties;

@Shell("application")
public class ApplicationShell extends AbstractShell<GwtOlDemoContext> {

    private Layout layout;

    public ApplicationShell() {
        super();
    }

    @Override
    public void attachShell() {
        layout = Layout.create("Simple Map Application using Domino-UI, Nalu and GWT-OL")
        .show(ColorScheme.INDIGO);
        layout.showFooter().fixFooter().getFooter().asElement().style.minHeight = CSSProperties.MinHeightUnionType.of("42px");
        layout.getFooter().setId("footer");
        layout.getLeftPanel().setId("navigation");
        layout.getContentPanel().setId("content");
    }

    @Override
    public void detachShell() {
        this.layout.remove();
    }
}
