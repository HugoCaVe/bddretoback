package com.scp.retoback.stepdefinitions;

import static com.scp.retoback.utils.Constans.URL_BASE;
import static com.scp.retoback.utils.Constans.USER_NAME;

import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class CommonStepDefinition {

  @Dado("que el usuario cargó la información de la URL")
  public void userLoadsTheUrlInformation() {
    OnStage.setTheStage(new OnlineCast());
    OnStage.theActorCalled(USER_NAME);
    OnStage.theActorInTheSpotlight().whoCan(CallAnApi.at(URL_BASE));
  }
}
