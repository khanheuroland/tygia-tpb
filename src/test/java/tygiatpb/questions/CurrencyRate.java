package tygiatpb.questions;

import net.serenitybdd.screenplay.Question;

import java.util.List;

public class CurrencyRate {
    public static Question<List<tygiatpb.models.CurrencyRate>> displayOnWebPage()
    {
        return new CurrencyRateDisplay();
    }

    public static Question<List<tygiatpb.models.CurrencyRate>> fromAPI()
    {
        return new CurrencyRateFromAPI();
    }
}
