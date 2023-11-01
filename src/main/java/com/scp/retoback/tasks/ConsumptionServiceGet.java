package com.scp.retoback.tasks;

import com.scp.retoback.conf.SessionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

import static com.scp.retoback.utils.Constans.*;


public class ConsumptionServiceGet implements Task {
    public static ConsumptionServiceGet apiRest() {
        return Tasks.instrumented(ConsumptionServiceGet.class);
    }
    @Step("{0} enters consume api rest service")
    @Override
    public <T extends Actor> void performAs(T actor) {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                        Get.resource(URL_RESOURCE_GET));
    }
}
