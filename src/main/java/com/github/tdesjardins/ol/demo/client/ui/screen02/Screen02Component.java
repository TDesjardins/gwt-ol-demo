package com.github.tdesjardins.ol.demo.client.ui.screen02;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import com.github.tdesjardins.ol.demo.client.utils.DemoUtils;

import elemental2.dom.HTMLElement;

import org.dominokit.addons.ol.ui.MapCard;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.utils.DominoElement;

public class Screen02Component extends AbstractComponent<IScreen02Component.Controller, HTMLElement> implements IScreen02Component {

    private static final String MAP_ID = "mapCard";

    public Screen02Component() {
        super();
    }

    @Override
    public void render() {

        MapCard mapCard = new MapCard(Screen02Component.MAP_ID, "Map in a card");

        initElement(DominoElement.div()
                .appendChild(Row.create()
                        .addColumn(Column.span8()
                                .offset2()
                                .appendChild(mapCard)
                        )).asElement());

    }

    @Override
    public void edit() {
        DemoUtils.createDefaultMap(Screen02Component.MAP_ID);
    }

}
