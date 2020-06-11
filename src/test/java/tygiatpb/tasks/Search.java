package tygiatpb.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import java.time.LocalDate;
import java.util.Date;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Search implements Task {

    private final LocalDate day;

    protected Search(LocalDate day) {
        this.day = day;
    }

    @Step("Search currency rate for day #searchTerm")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

        );
    }

    public static Search forTheDay(LocalDate day) {
        return instrumented(Search.class, day);
    }

}
