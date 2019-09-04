package com.github.tdesjardins.ol.demo.client.ui.map;

import com.github.nalukit.nalu.client.component.AbstractComponent;

import java.util.HashMap;
import java.util.Map;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;

import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.jboss.gwt.elemento.core.Elements;

public class MapExampleComponent extends AbstractComponent<IsMapExampleComponent.Controller, HTMLElement> implements IsMapExampleComponent {

    private HTMLDivElement element = Elements.div().asElement();

    private Column container;

    private Map<String, Card> mapContainers = new HashMap<>();

    public MapExampleComponent() {

        super();

        this.container = Column.span12();

        this.element.appendChild(Row.create()
                .addColumn(this.container).asElement());
    }

    @Override
    public void render() {

        initElement(element);

    }

    @Override
    public boolean containsMap(String mapId) {
        return mapContainers.containsKey(mapId);
    }

    @Override
    public void setMapId(String mapId) {

        this.container.setInnerHtml("");

        Card card = this.mapContainers.get(mapId);

        if (card == null) {
            card = new Card();
            card.fitContent();
            card.getBody().setId(mapId);
            card.setTitle(mapId);
            card.setDescription(mapId);

            this.mapContainers.put(mapId, card);
        }

        this.container.appendChild(card);

    }

}