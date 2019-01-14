package com.github.tdesjardins.ol.demo.client.ui.navigation;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import elemental2.dom.HTMLElement;
import java.lang.Override;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.tree.Tree;
import org.dominokit.domino.ui.tree.TreeItem;

public class NavigationComponent extends AbstractComponent<INavigationComponent.Controller, HTMLElement> implements INavigationComponent {

    private TreeItem mapItem;

    private TreeItem mapCardItem;

    public NavigationComponent() {
        super();
    }

    @Override
    public void render() {

        this.mapItem = TreeItem.create("OSM Map", Icons.ALL.map())
        .addClickListener(e -> getController().doNavigateTo("map"));

        this.mapCardItem = TreeItem.create("Card with map", Icons.ALL.map())
        .addClickListener(e -> getController().doNavigateTo("mapCard"));

        Tree tree = Tree.create("Navigation");
        tree.appendChild(mapItem);
        tree.appendChild(mapCardItem);

        initElement(tree.asElement());

    }

}
