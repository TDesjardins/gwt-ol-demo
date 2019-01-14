package com.github.tdesjardins.ol.demo.client.ui.error;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import elemental2.dom.HTMLElement;
import elemental2.dom.Text;
import java.lang.Override;
import java.lang.String;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Color;

public class ErrorComponent extends AbstractComponent<IErrorComponent.Controller, HTMLElement> implements IErrorComponent {

    private Text errorText;

    public ErrorComponent() {
        super();
    }

    @Override
    public void render() {
        this.errorText = new Text();
        initElement(Card.create("An Error occurred!")
        .setHeaderBackground(Color.RED_DARKEN_2)
        .addHeaderAction(Icons.ALL.home(),
        e -> getController().doRouteHome())
        .appendChild(this.errorText)
        .asElement());
    }

    @Override
    public void setErrorMessage(String errorMessage) {
        this.errorText.textContent = errorMessage;
    }
}
