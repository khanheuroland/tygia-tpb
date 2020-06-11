package tygiatpb.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.By;
import tygiatpb.models.CurrencyRate;
import tygiatpb.ui.CurrencyRatePage;

import java.util.ArrayList;
import java.util.List;

public class CurrencyRateDisplay implements Question<List<CurrencyRate>> {
    @Override
    public List<CurrencyRate> answeredBy(Actor actor) {
        List<WebElementFacade> lstRows = CurrencyRatePage.RATE_ITEMS.resolveAllFor(actor);
        List<CurrencyRate> lstRateFound = new ArrayList<>();
        for(WebElementFacade row: lstRows)
        {
            lstRateFound.add(
                    CurrencyRate.withCode(row.findElements(By.cssSelector("td")).get(0).getText())
                            .andName(row.findElements(By.cssSelector("td")).get(1).getText())
                            .andBuyPrice(row.findElements(By.cssSelector("td")).get(2).getText())
                            .andExchangePrice(row.findElements(By.cssSelector("td")).get(3).getText())
                            .andSellPrice(row.findElements(By.cssSelector("td")).get(4).getText())
                            .build()
            );
        }
        return lstRateFound;
    }
}
