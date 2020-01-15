package com.github.tdesjardins.ol.demo.client.ui.navigation;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import elemental2.dom.HTMLElement;
import java.lang.Override;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.tree.Tree;
import org.dominokit.domino.ui.tree.TreeItem;

public class NavigationComponent extends AbstractComponent<INavigationComponent.Controller, HTMLElement> implements INavigationComponent {

    private Tree<String> tree;

    public NavigationComponent() {
        super();
        this.tree = Tree.create("Navigation");
        this.tree.autoHeight();
    }

    @Override
    public void render() {

        initElement(tree.element());

    }

    @Override
    public void addTreeItem(String title, String key) {

        TreeItem<String> currentItem = TreeItem.create(title, Icons.ALL.map());
        currentItem.addClickListener(e -> getController().doNavigateTo(key));
        this.tree.appendChild(currentItem);
    }

}
