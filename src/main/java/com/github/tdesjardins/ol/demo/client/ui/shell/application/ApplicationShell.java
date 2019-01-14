package com.github.tdesjardins.ol.demo.client.ui.shell.application;

import com.github.nalukit.nalu.client.component.AbstractShell;
import com.github.nalukit.nalu.client.component.annotation.Shell;
import com.github.tdesjardins.ol.demo.client.GwtOlDemoContext;
import java.lang.Override;
import org.dominokit.domino.ui.layout.Layout;
import org.dominokit.domino.ui.style.ColorScheme;

import elemental2.dom.CSSProperties;
import org.dominokit.domino.ui.style.Unit;

import static org.dominokit.domino.ui.style.Unit.*;

@Shell("application")
public class ApplicationShell extends AbstractShell<GwtOlDemoContext> {

    private Layout layout;

    public ApplicationShell() {
        super();
    }

    @Override
    public void attachShell() {
        layout = Layout.create("Simple Map Application using Domino-UI, Nalu and GWT-OL")
        .show(ColorScheme.INDIGO)
        .fitWidth()
        .fitHeight();

        layout.showFooter()
                .apply(l -> l.getFooter().style().setMinHeight(px.of(42)))
                .fixFooter();
        layout.getFooter().setId("footer");
        layout.getLeftPanel().setId("navigation");
        layout.getContentPanel().setId("content");
        context.setLayout(layout);
    }

    @Override
    public void detachShell() {
        this.layout.remove();
    }
}
