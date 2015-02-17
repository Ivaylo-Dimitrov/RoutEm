package automotive.tum.de.routem;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gc.materialdesign.views.ButtonFloat;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.gson.Gson;

import java.util.ArrayList;

import automotive.tum.de.routem.models.Comment;
import automotive.tum.de.routem.models.Coordinate;
import automotive.tum.de.routem.models.Route;


/**
 * Created by Ch0PPeR on 20.01.2015.
 */
public class RouteFragment extends Fragment implements OnMapReadyCallback {
    GoogleMap googleMap;
    Intent intent;
    int activity;
    Route route;
    TextView distance;
    TextView duration;
    TextView difficulty;
    OnMapReadyCallback listener;
    String difficultyString;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.route_fragment, container, false);

        intent = getActivity().getIntent();

        route = new Gson().fromJson(intent.getStringExtra("route"), Route.class);

        distance = (TextView) view.findViewById(R.id.distancex);
        duration = (TextView) view.findViewById(R.id.durationx);
        difficulty = (TextView) view.findViewById(R.id.difficultyx);

        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager()
                .findFragmentById(R.id.mapview_fragment);
        mapFragment.getMapAsync(this);


        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ButtonFloat buttonFloat = (ButtonFloat) getActivity().findViewById(R.id.buttonFloat);
        buttonFloat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater = getActivity().getLayoutInflater();
                View view = inflater.inflate(R.layout.navigation_options, null, false);
                builder.setView(view);
                builder.setPositiveButton("Route ME", null);
                builder.setNegativeButton("Cancel", null);
                builder.show();
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();

        switch (route.getDifficulty()) {
            case 0:
                difficultyString = "any";
                break;
            case 1:
                difficultyString = Route.novice;
                break;
            case 2:
                difficultyString = Route.expirienced;
                break;
            case 3:
                difficultyString = Route.professional;
                break;
            case 4:
                difficultyString = Route.godlike;
                break;
        }

        distance.setText(String.valueOf(route.getDistance()) + "km");
        duration.setText(String.valueOf(route.getDuration()) + "h");
        difficulty.setText(String.valueOf(difficultyString));


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        googleMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(route.getStartLatitude(), route.getStartLongitude())));
        googleMap.setMyLocationEnabled(true);

        ArrayList<Coordinate> coordiantes = route.getCoordinates();

        Polyline line;
        line = googleMap.addPolyline(new PolylineOptions()
                .add(new LatLng(route.getStartLatitude(), route.getStartLongitude()), new LatLng(coordiantes.get(0).getLatitude(), coordiantes.get(0).getLongitude()))
                .width(5)
                .color(Color.RED));
        for (int i = 0; i < coordiantes.size() - 1; i++) {
            line = googleMap.addPolyline(new PolylineOptions()
                    .add(new LatLng(coordiantes.get(i).getLatitude(), coordiantes.get(i).getLongitude()), new LatLng(coordiantes.get(i + 1).getLatitude(), coordiantes.get(i + 1).getLongitude()))
                    .width(5)
                    .color(Color.RED));
        }

        googleMap.addMarker(new MarkerOptions().position(new LatLng(coordiantes.get(coordiantes.size()-1).getLatitude(), coordiantes.get(coordiantes.size()-1).getLongitude())).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(route.getStartLatitude(), route.getStartLongitude())).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));


        ArrayList<Comment> comments = route.getComments();

        for(int i = 0; i <comments.size(); i ++) {
            googleMap.addMarker(new MarkerOptions().position(new LatLng(comments.get(i).getCoordinate().getLatitude(), comments.get(i).getCoordinate().getLongitude())).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        }



    }
}
