package automotive.tum.de.routem;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gc.materialdesign.views.ButtonFloat;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

/**
 * Created by Ch0PPeR on 20.01.2015.
 */
public class RouteFragment extends Fragment implements OnMapReadyCallback {
    GoogleMap googleMap;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  =inflater.inflate(R.layout.route_fragment, container, false);

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
                View view  =inflater.inflate(R.layout.navigation_options, null, false);
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
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
    }
}
