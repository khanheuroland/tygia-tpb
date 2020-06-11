package tygiatpb.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.ScrollTo;
import net.serenitybdd.screenplay.actions.ScrollToTarget;
import net.thucydides.core.annotations.Step;
import tygiatpb.ui.CurrencyRatePage;

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
                Scroll.to(CurrencyRatePage.RATE_ITEMS)
        );
    }

    public static Search forTheDay(LocalDate day) {
        return instrumented(Search.class, day);
    }

}
