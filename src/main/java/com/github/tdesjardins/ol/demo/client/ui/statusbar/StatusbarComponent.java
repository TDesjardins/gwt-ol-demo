package com.github.tdesjardins.ol.demo.client.ui.statusbar;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import java.lang.Override;
import java.lang.String;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.style.Style;
import org.jboss.elemento.Elements;

public class StatusbarComponent extends AbstractComponent<IStatusbarComponent.Controller, HTMLElement> implements IStatusbarComponent {

    private HTMLDivElement messageInfo;

    public StatusbarComponent() {
        super();
    }

    @Override
    public void edit(String message) {
        messageInfo.textContent = message;
    }

    @Override
    public void render() {
        messageInfo = Elements.div().element();
        initElement(Row.create()
        .style()
        .setMargin("0px")
        .add("demo-footer")
        .get()
        .addColumn(Style.of(Column.span6())
        .get()
        .appendChild(Elements.h(4).textContent("Map demos using Domino-UI and Nalu")))
        .addColumn(Style.of(Column.span6())
        .setTextAlign("right")
        .get()
        .appendChild(this.messageInfo))
        .element());
    }
}
