package com.scp.retoback.stepdefinitions;

import static com.scp.retoback.utils.ExceptionsConstants.NO_TOKEN_INFORMATION_IS_DISPLAYED;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

import com.scp.retoback.conf.SessionVariables;
import com.scp.retoback.exceptions.ConsumptionServicesException;
import com.scp.retoback.tasks.ConsumptionServicePost;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;

public class LoginFromApiStepDefinition {

  @Given("que ingresó la información del nombre de usuario: (.*) y la contraseña: (.*)$")
  public void userToEnterTheCoordinateInformation(String var1, String var2) {
    OnStage.theActorInTheSpotlight().remember(SessionVariables.USER_NAME.getKey(), var1);
    OnStage.theActorInTheSpotlight().remember(SessionVariables.PASSWORD.getKey(), var2);
  }

  @When("ejecuta el servicio con los párametros ingresados")
  public void heConsultsTheInformationPresentedAt() {
    OnStage.theActorInTheSpotlight().attemptsTo(ConsumptionServicePost.apiRest());
  }

  @Then("se muestra la información del token")
  public void locationInformationAndResponseCodeAreDisplayed() {
    theActorInTheSpotlight()
        .should(
            seeThatResponse(
                    "Se muestra la información del token: "
                        + SerenityRest.lastResponse().getBody().jsonPath().getJsonObject(""),
                    response -> response.body("token", Matchers.notNullValue()))
                .orComplainWith(
                    ConsumptionServicesException.class, NO_TOKEN_INFORMATION_IS_DISPLAYED));
    SerenityRest.lastResponse().body().print();
  }
}
