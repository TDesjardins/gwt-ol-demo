package com.github.tdesjardins.ol.demo.client.ui.screen02;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import com.github.tdesjardins.ol.demo.client.model.MyModel;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.utils.DominoElement;

public class Screen02Component extends AbstractComponent<IScreen02Component.Controller, HTMLElement> implements IScreen02Component {


    public Screen02Component() {
        super();
    }

    @Override
    public void render() {

        initElement(DominoElement.div()
                .appendChild(Row.create()
                        .addColumn(Column.span8()
                                .offset2()
                                .appendChild(Card.create("Map in a card")
                                        .fitContent()
                                        .apply(element -> element.getBody().setId("mapCard")))
                        )).asElement());

    }

    @Override
    public void edit(MyModel model) {
    }

}
