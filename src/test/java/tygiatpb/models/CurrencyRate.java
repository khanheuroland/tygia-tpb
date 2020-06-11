package tygiatpb.models;

public class CurrencyRate {
    public String ban;
    public String ten;
    public String chuyen;
    public String mua;
    public String kieu;
    @Override
    public String toString() {
        return "{"
                +"ten:"+ this.ten +","
                +"ban:"+ this.ban +","
                +"mua:"+ this.mua +","
                +"chuyen:"+this.chuyen +","
                +"kieu:"+ this.kieu
                +"}";
    }

    public CurrencyRate(String code, String name, String buy, String sell, String exchange)
    {
        this.kieu = code;
        this.ten = name;
        this.mua = buy;
        this.ban = sell;
        this.chuyen = exchange;
    }

    public static CurrencyRateBuilder withCode(String name) {
        return new CurrencyRateBuilder(name);
    }

    public static class CurrencyRateBuilder
    {
        private String ban;
        private String ten;
        private String chuyen;
        private String mua;
        private String kieu;

        public CurrencyRateBuilder(String code)
        {
            this.kieu = code;
        }

        public CurrencyRateBuilder andName(String name)
        {
            this.ten = name;
            return this;
        }

        public CurrencyRateBuilder andBuyPrice(String price)
        {
            this.mua = price;
            return this;
        }
        public CurrencyRateBuilder andSellPrice(String price)
        {
            this.ban = price;
            return this;
        }
        public CurrencyRateBuilder andExchangePrice(String price)
        {
            this.chuyen = price;
            return this;
        }

        public CurrencyRate build()
        {
            return new CurrencyRate(this.kieu, this.ten, this.mua, this.ban, this.chuyen);
        }
    }
}
