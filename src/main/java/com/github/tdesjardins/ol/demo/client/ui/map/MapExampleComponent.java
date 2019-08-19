package com.github.tdesjardins.ol.demo.client.ui.map;

import com.github.nalukit.nalu.client.component.AbstractComponent;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;

import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.jboss.gwt.elemento.core.Elements;

public class MapExampleComponent extends AbstractComponent<IsMapExampleComponent.Controller, HTMLElement> implements IsMapExampleComponent {

    private HTMLDivElement element = Elements.div().asElement();

    private Card exampleCard;

    public MapExampleComponent() {
        super();
    }

    @Override
    public void render() {

        initElement(element);
        exampleCard = new Card();
        exampleCard.fitContent();

        element.appendChild(Row.create()
        .addColumn(Column.span12()
                .appendChild(exampleCard)).asElement());

    }

    @Override
    public void setMapId(String mapId) {
        exampleCard.getBody().setId(mapId);
        exampleCard.setTitle(mapId);
        exampleCard.setDescription(mapId);
    }

}
