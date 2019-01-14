package com.github.tdesjardins.ol.demo.client.ui.shell.error;

import com.github.nalukit.nalu.client.component.AbstractShell;
import com.github.nalukit.nalu.client.component.annotation.Shell;
import com.github.tdesjardins.ol.demo.client.GwtOlDemoContext;
import elemental2.dom.CSSProperties;
import java.lang.Override;
import org.dominokit.domino.ui.layout.Layout;
import org.dominokit.domino.ui.style.ColorScheme;

@Shell("error")
public class ErrorShell extends AbstractShell<GwtOlDemoContext> {

    private Layout layout;

    public ErrorShell() {
        super();
    }

    @Override
    public void attachShell() {
        layout = Layout.create("Error Message")
        .show(ColorScheme.INDIGO);
        layout.showFooter()
        .fixFooter()
        .getFooter()
        .asElement().style.minHeight = CSSProperties.MinHeightUnionType.of("42px");
        layout.getFooter().setId("footer");
        layout.disableLeftPanel();
        layout.getContentPanel().setId("content");
    }

    @Override
    public void detachShell() {
        this.layout.remove();
    }
}
