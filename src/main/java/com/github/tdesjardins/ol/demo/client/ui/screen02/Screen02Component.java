package com.github.tdesjardins.ol.demo.client.ui.screen02;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import com.github.tdesjardins.ol.demo.client.model.MyModel;
import elemental2.dom.HTMLElement;
import java.lang.Override;
import org.dominokit.domino.ui.cards.Card;

public class Screen02Component extends AbstractComponent<IScreen02Component.Controller, HTMLElement> implements IScreen02Component {

    private Card card;

    public Screen02Component() {
        super();
    }

    @Override
    public void render() {

        card = Card.create("Map in a card");
        card.setWidth("600px");
        card.getBody().setAttribute("id", "mapCard");
        //card.getBody().style().remove("body");
        card.getBody().style().setMarginTop("0px");
        initElement(card.asElement());

    }

    @Override
    public void edit(MyModel model) {
        // TODO Auto-generated method stub

    }

}
