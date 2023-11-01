package com.scp.retoback.tasks;

import static com.scp.retoback.utils.Constans.CHARACTER_QUOTATION_MARKS;
import static com.scp.retoback.utils.Constans.URL_RESOURCE;

import com.scp.retoback.conf.SessionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;

public class ConsumptionServicePost implements Task {
  public static ConsumptionServicePost apiRest() {
    return Tasks.instrumented(ConsumptionServicePost.class);
  }

  @Step("{0} enters consume api rest service")
  @Override
  public <T extends Actor> void performAs(T actor) {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            Post.to(URL_RESOURCE)
                .with(
                    request ->
                        request
                            .header("Content-Type", "application/json")
                            .body(
                                "{\"id\":"
                                    + (OnStage.theActorInTheSpotlight()
                                        .recall(SessionVariables.ID.getKey())
                                        .toString())
                                    + ",\"petid\":"
                                    + (OnStage.theActorInTheSpotlight()
                                        .recall(SessionVariables.PET_ID.getKey())
                                        .toString())
                                        + ",\"quantity\":"
                                        + (OnStage.theActorInTheSpotlight()
                                        .recall(SessionVariables.QUANTITY.getKey())
                                        .toString())
                                        + ",\"shipDate\":"
                                        + CHARACTER_QUOTATION_MARKS
                                        + (OnStage.theActorInTheSpotlight()
                                        .recall(SessionVariables.SHIP_DATE.getKey())
                                        .toString())
                                        + "\",\"status\":"
                                        + CHARACTER_QUOTATION_MARKS
                                        + (OnStage.theActorInTheSpotlight()
                                        .recall(SessionVariables.STATUS.getKey())
                                        .toString())
                                        + "\",\"complete\":"
                                        + CHARACTER_QUOTATION_MARKS
                                        + (OnStage.theActorInTheSpotlight()
                                        .recall(SessionVariables.COMPLETE.getKey())
                                        .toString())
                                    + CHARACTER_QUOTATION_MARKS
                                    + "}")));
  }
}
