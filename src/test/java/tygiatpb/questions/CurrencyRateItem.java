package tygiatpb.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.By;
import tygiatpb.models.CurrencyRate;
import tygiatpb.ui.CurrencyRatePage;

import java.util.List;

public class CurrencyRateItem implements Question<String> {
    int atIndex=0;
    public CurrencyRateItem(int index)
    {
        this.atIndex = index;
    }
    @Override
    public String answeredBy(Actor actor) {
        List<WebElementFacade> lstRows = CurrencyRatePage.RATE_ITEMS.resolveAllFor(actor);
        WebElementFacade row = lstRows.get(this.atIndex);
        return CurrencyRate.withCode(row.findElements(By.cssSelector("td")).get(0).getText())
                .andName(row.findElements(By.cssSelector("td")).get(1).getText())
                .andBuyPrice(row.findElements(By.cssSelector("td")).get(2).getText())
                .andExchangePrice(row.findElements(By.cssSelector("td")).get(3).getText())
                .andSellPrice(row.findElements(By.cssSelector("td")).get(4).getText())
            .build().toString();
    }
}
