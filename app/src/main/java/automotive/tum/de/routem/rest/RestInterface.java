package automotive.tum.de.routem.rest;

import java.util.ArrayList;

import automotive.tum.de.routem.models.Route;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by H1GHWAvE on 2/8/15.
 */
public interface RestInterface {
    @GET("/RouteManager/getRoutes?{param}")
    ArrayList getRouteFiltered(@Path("param") String param);

    @GET("/RouteManager/getRoutes")
    ArrayList<Route> getRoutes(@Query("lat") float lat, @Query("lon") float lon, @Query("radius") int radius, @Query("type") String type);
}
