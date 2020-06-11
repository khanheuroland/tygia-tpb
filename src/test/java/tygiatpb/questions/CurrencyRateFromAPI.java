package tygiatpb.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import tygiatpb.models.CurrencyRate;
import tygiatpb.models.CurrencyResponse;

import java.util.List;

import static net.serenitybdd.rest.RestRequests.given;

public class CurrencyRateFromAPI implements Question<List<CurrencyRate>> {
    @Override
    public List<CurrencyRate> answeredBy(Actor actor) {
        String api = "https://tpb.vn/CMCWPCoreAPI/api/public-service/get-currency-rate?filename=20200611";
        given().with().header("Authorization", "Basic d3BzdHBiMjAxODpXUFN0cGIyMDE4MTIxMg==")
                .when().get(api);

        CurrencyResponse response = SerenityRest.lastResponse().as(CurrencyResponse.class);
        return response.rate_currency;
    }
}
