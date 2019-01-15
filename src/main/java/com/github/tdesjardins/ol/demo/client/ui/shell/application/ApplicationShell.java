package com.github.tdesjardins.ol.demo.client.ui.shell.application;

import com.github.nalukit.nalu.client.component.AbstractShell;
import com.github.nalukit.nalu.client.component.annotation.Shell;
import com.github.tdesjardins.ol.demo.client.GwtOlDemoContext;
import com.github.tdesjardins.ol.demo.client.event.FitLayoutEvent;
import com.github.tdesjardins.ol.demo.client.event.UnFitLayoutEvent;
import org.dominokit.domino.ui.layout.Layout;
import org.dominokit.domino.ui.style.ColorScheme;

import static org.dominokit.domino.ui.style.Unit.px;

@Shell("application")
public class ApplicationShell
    extends AbstractShell<GwtOlDemoContext> {

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
          .apply(l -> l.getFooter()
                       .style()
                       .setMinHeight(px.of(42)))
          .fixFooter();
    layout.getFooter()
          .setId("footer");
    layout.getLeftPanel()
          .setId("navigation");
    layout.getContentPanel()
          .setId("content");
  }

  @Override
  public void detachShell() {
    this.layout.remove();
  }

  @Override
  public void bind() {
    this.eventBus.addHandler(FitLayoutEvent.TYPE,
                             e -> {
                               layout.fitWidth();
                               layout.fitHeight();
                             });
    this.eventBus.addHandler(UnFitLayoutEvent.TYPE,
                             e -> {
                               layout.unfitWidth();
                               layout.unfitHeight();
                             });
  }

}
