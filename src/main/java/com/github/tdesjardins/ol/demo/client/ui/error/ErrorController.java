package com.github.tdesjardins.ol.demo.client.ui.error;

import com.github.nalukit.nalu.client.component.AbstractErrorPopUpComponentController;
import com.github.nalukit.nalu.client.component.annotation.ErrorPopUpController;
import com.github.tdesjardins.ol.demo.client.GwtOlDemoContext;

@ErrorPopUpController(component = ErrorComponent.class,
                      componentInterface = IErrorComponent.class)
public class ErrorController
    extends AbstractErrorPopUpComponentController<GwtOlDemoContext, IErrorComponent>
    implements IErrorComponent.Controller {

  public ErrorController() {
  }

  @Override
  public void onBeforeShow() {
    this.component.clear();
  }

  @Override
  protected void show() {
    // this only works, cause the get method is not asynchron!
    this.component.edit(this.errorEventType,
                        this.route,
                        this.message,
                        this.dataStore);
    this.component.show();
  }

  //  @Override
  //  public void doRouteHome() {
  //    // clear the error message to avoid showing it again!
  //    this.router.clearNaluErrorMessage();
  //    // route to the search screen
  //    this.router.route("/application/person/search");
  //  }

}
