package com.scp.retoback.stepdefinitions;

import static com.scp.retoback.utils.ExceptionsConstants.NO_TOKEN_INFORMATION_IS_DISPLAYED;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import com.scp.retoback.conf.SessionVariables;
import com.scp.retoback.exceptions.ConsumptionServicesException;
import com.scp.retoback.tasks.ConsumptionServiceGet;
import com.scp.retoback.tasks.ConsumptionServicePost;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;

public class LoginFromApiStepDefinition {

  @Given("que ingresó la información del id: (.*), el Id de la mascota: (.*)$")
  public void userToEnterTheCoordinateInformation(int var1, int var2) {
    OnStage.theActorInTheSpotlight().remember(SessionVariables.ID.getKey(), var1);
    OnStage.theActorInTheSpotlight().remember(SessionVariables.PET_ID.getKey(), var2);
  }

  @Given("que ingreso la cantidad: (.*), la fecha de envío: (.*), el estado: (.*)$")
  public void userToEnterTheCoordinateInformation(int var1, String var2, String var3) {
    OnStage.theActorInTheSpotlight().remember(SessionVariables.QUANTITY.getKey(), var1);
    OnStage.theActorInTheSpotlight().remember(SessionVariables.SHIP_DATE.getKey(), var2);
    OnStage.theActorInTheSpotlight().remember(SessionVariables.STATUS.getKey(), var3);

  }

  @Given("que ingreso el estado actual del registro: (.*)$")
  public void userToEnterTheCoordinateInformation(Boolean var1) {
    OnStage.theActorInTheSpotlight().remember(SessionVariables.COMPLETE.getKey(), var1);
  }

  @Given("que ingresó la información de la ordenen que desea buscar: (.*)$")
  public void userToEnterOrderNumber(int var1) {
    OnStage.theActorInTheSpotlight().remember(SessionVariables.ORDEN_NUMBER.getKey(), var1);
  }

  @When("ejecuta el servicio con los párametros ingresados")
  public void heConsultsTheInformationPresentedAt() {
    OnStage.theActorInTheSpotlight().attemptsTo(ConsumptionServicePost.apiRest());
  }

  @When("ejecuta el servicio con los párametros ingresados para la búsqueda")
  public void heConsultsTheInformationOrder() {
    OnStage.theActorInTheSpotlight().attemptsTo(ConsumptionServiceGet.apiRest());
  }

  @Then("se muestra la información del pedido de compra de la mascota")
  public void locationInformationAndResponseCodeAreDisplayed() {
    theActorInTheSpotlight()
        .should(
            seeThatResponse(
                    "Se muestra la información de la orden de compra: "
                        + SerenityRest.lastResponse().getBody().jsonPath().getJsonObject(""),
                    response -> response.body("id", Matchers.notNullValue()))
                .orComplainWith(
                    ConsumptionServicesException.class, NO_TOKEN_INFORMATION_IS_DISPLAYED));
    SerenityRest.lastResponse().body().print();
  }

  @Then("se muestra la información de las órdenes ingresadas")
  public void showInformationAndResponseCodeOrders() {
    theActorInTheSpotlight()
            .should(
                    seeThatResponse("all the expected users should be returned",
                            response -> response.statusCode(200)
                                    .body("id", equalTo(7))
                    )
            );
  }
}
