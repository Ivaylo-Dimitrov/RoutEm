package automotive.tum.de.routem.rest;

/**
 * Created by H1GHWAvE on 2/8/15.
 */
import com.squareup.okhttp.OkHttpClient;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

public class RestClient {

    private static RestInterface REST_CLIENT;
    private static String ROOT = "http://routeem-automotive1415.rhcloud.com/RouteEm-0.1";

    static {
        setupRestClient();
    }

    private RestClient() {
    }

    public static RestInterface get() {
        return REST_CLIENT;
    }

    private static void setupRestClient() {
        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(ROOT)
                .setClient(new OkClient(new OkHttpClient()));//setLogLevel(RestAdapter.LogLevel.FULL);

        RestAdapter restAdapter = builder.build();
        REST_CLIENT = restAdapter.create(RestInterface.class);
    }
}