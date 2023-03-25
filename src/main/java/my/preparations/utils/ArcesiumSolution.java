package my.preparations.utils;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;

import java.net.*;

import com.google.gson.*;


class Result {

    /*
     * Complete the 'calculateNAV' function below.
     *
     * The function is expected to return a DOUBLE.
     * The function accepts STRING date as parameter.
     */

    public static double calculateNAV(String date) {
        HoldingService holdingService = new HoldingService();
        PricingService pricingService = new PricingService();

        List<HoldingDto> holdingsForDate = holdingService.getHoldingsForDate(date);
        if (holdingsForDate.size() == 0) {
            return 0.0;
        }

        double nav = 0.0;

        for (HoldingDto holding : holdingsForDate) {
            Double price = 0.0;
            try {
                price = pricingService.getPriceForSecurityOnDate(holding.getSecurity(), date);
            } catch (PriceNotExistsException pne) {
                price = 0.0;
            }
            nav += price;
        }

        return nav;
    }

}

/**
 * Service to fetch holdings from API.
 */
class HoldingService {
    public final String HOLDING_NON_PAGINATED_URL = "https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/api/holding";
    private Map<String, List<HoldingDto>> dateWiseHoldings;
    private Gson gson;

    public HoldingService() {
        gson = new Gson();
        dateWiseHoldings = new HashMap<>();
        List<HoldingDto> allHoldings = getAllHoldings();
        dateWiseHoldings = allHoldings
                .stream()
                .collect(Collectors.groupingBy(HoldingDto::getDate));
    }

    public List<HoldingDto> getAllHoldings() {
        String jsonResponse = HttpRequestUtil.performGetRequest(HOLDING_NON_PAGINATED_URL, Collections.emptyMap());
        HoldingDto[] holdings = gson.fromJson(jsonResponse, HoldingDto[].class);
        return Arrays.asList(holdings);
    }

    public List<HoldingDto> getHoldingsForDate(String date) {
        return dateWiseHoldings.getOrDefault(date, Collections.emptyList());
    }
}

//{"date" : "20190101", "security" : "ABC Corporation", "quantity" : 980, "portfolio" : "Growth"}
class HoldingDto {
    private String date;
    private String security;
    private Long quantity;
    private Portfolio portfolio;

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return this.date;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public String getSecurity() {
        return this.security;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getQuantity() {
        return this.quantity;
    }

    public void setPortfolio(Portfolio p) {
        this.portfolio = p;
    }

    public Portfolio getPortfolio() {
        return this.portfolio;
    }
}

enum Portfolio {
    Growth,
    Balanced,
    Equity,
    Technology
}

class PricingService {
    public final String PRICING_NON_PAGINATED_URL = "https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/api/pricing";
    private Map<String, Map<String, Double>> securityAndDateWisePrice;
    private Gson gson;

    public PricingService() {
        gson = new Gson();
        securityAndDateWisePrice = new HashMap<>();
        List<PriceDto> prices = getAllPrices();
        for (PriceDto ele : prices) {
            Map<String, Double> securityMap = securityAndDateWisePrice.getOrDefault(ele.getSecurity(), new HashMap<>());
            securityMap.put(ele.getDate(), ele.getPrice());
            securityAndDateWisePrice.put(ele.getSecurity(), securityMap);
        }
    }

    public List<PriceDto> getAllPrices() {
        String jsonResponse = HttpRequestUtil.performGetRequest(PRICING_NON_PAGINATED_URL, Collections.emptyMap());
        PriceDto[] prices = gson.fromJson(jsonResponse, PriceDto[].class);
        return Arrays.asList(prices);
    }

    public Double getPriceForSecurityOnDate(String security, String date) throws PriceNotExistsException {
        return Optional.ofNullable(securityAndDateWisePrice.get(security))
                .map(dateWisePrice -> dateWisePrice.get(date))
                .orElseThrow(() -> new PriceNotExistsException(security, date));
    }
}

class PriceNotExistsException extends Exception {
    private String security;
    private String date;

    public PriceNotExistsException(String security, String date) {
        super("Price for " + security + " not defined for " + date);
        this.date = date;
        this.security = security;
    }
}

class PriceDto {
    private String date;
    private String security;
    private Double price;

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return this.date;
    }

    public void setSecurity(String s) {
        this.security = s;
    }

    public String getSecurity() {
        return this.security;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return this.price;
    }
}

class HttpRequestUtil {
    // Some Compilation error due to missing library or something

    /**
     * private final HttpClient client = HttpClient.newHttpClient();
     * <p>
     * public static String performGetRequest(String url, Map<String, String> queryParams) {
     * String queryParamStr = queryParams.entries.map((k,v) -> k.trim()+"="+v.trim()).join("&");
     * final String endpoint = Optional.ofNullable(queryParamStr).map(p -> url + "?" + p).orElse(url);
     * <p>
     * HttpRequest request = HttpRequest.newBuilder(URI.create(endpoint))
     * .header("accept", "application/json")
     * .GET()
     * .build();
     * <p>
     * HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
     * return response.body();
     * }
     */

    public static String performGetRequest(String url, Map<String, String> queryParams) {
        String queryParamStr = queryParams.entrySet()
                .stream()
                .map(entry -> entry.getKey().trim() + "=" + entry.getValue().trim())
                .collect(Collectors.joining("&"));
        final String endpoint = Optional.ofNullable(queryParamStr).map(p -> url + "?" + p).orElse(url);
        StringBuffer sb = new StringBuffer();
        HttpURLConnection con = null;
        try {
            URL targetUrl = new URL(endpoint);
            con = (HttpURLConnection) targetUrl.openConnection();
            con.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
        } catch (Exception e) {

        } finally {
            con.disconnect();
        }

        return sb.toString();
    }
}


public class ArcesiumSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String date = bufferedReader.readLine();

        double result = Result.calculateNAV(date);

        System.out.println(String.valueOf(result));

        bufferedReader.close();
    }
}
