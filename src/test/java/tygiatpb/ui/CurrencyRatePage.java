package tygiatpb.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;


@DefaultUrl("https://tpb.vn/cong-cu-tinh-toan/ty-gia-ngoai-te")
public class CurrencyRatePage extends PageObject {
    public static final Target INPUT_DATE = Target.the("day of value")
            .located(By.cssSelector("input#datepicker"));
    public static final Target SEARCH = Target.the("Xem Ti Gia button")
            .located(By.cssSelector("a#xem-ty-gia"));
    public static final Target RATE_ITEMS = Target.the("rate items")
            .located(By.cssSelector("div#forex-rate-table-container tbody tr"));
}
