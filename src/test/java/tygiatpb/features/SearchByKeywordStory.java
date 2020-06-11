package tygiatpb.features;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.Ensure;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;
import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import tygiatpb.models.CurrencyResponse;
import tygiatpb.questions.CurrencyRate;
import tygiatpb.tasks.OpenTheApplication;
import tygiatpb.tasks.Search;

import java.time.LocalDateTime;
import java.util.Date;

import static net.serenitybdd.rest.RestRequests.given;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
public class SearchByKeywordStory {

    Actor anna = Actor.named("Anna");

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Steps
    OpenTheApplication openTheApplication;

    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void the_number_of_row_display_is_the_same_with_return_values_from_rest_api() {
        givenThat(anna).wasAbleTo(openTheApplication);

        when(anna).attemptsTo(
                Search.forTheDay(LocalDateTime.now().toLocalDate())
        );

        then(anna).should(
                seeThat(CurrencyRate.displayOnWebPage(), hasSize(CurrencyRate.fromAPI().answeredBy(anna).size()))
        );
    }
}