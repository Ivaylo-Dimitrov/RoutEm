package automotive.tum.de.routem;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import automotive.tum.de.routem.models.Review;
import automotive.tum.de.routem.models.Route;

/**
 * Created by Ch0PPeR on 19.01.2015.
 */
public class SearchItemsAdapter extends ArrayAdapter {
    List<Route> list;
    Activity mContext;
    Route route;

    TextView title;
    TextView length;
    TextView duration;
    TextView difficulty;
    TextView rating;
    String ratingAverage;
    int ratingz;
    ArrayList<Review> reviews;


    public SearchItemsAdapter(Activity context, List<Route> list) {
        super(context, R.layout.search_item, list);
        this.list = list;
        mContext = context;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = mContext.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.search_item, null);

        title = (TextView) rowView.findViewById(R.id.titlez);
        length = (TextView) rowView.findViewById(R.id.lengthz);
        duration = (TextView) rowView.findViewById(R.id.durationz);
        difficulty = (TextView) rowView.findViewById(R.id.difficultyz);
        rating = (TextView) rowView.findViewById(R.id.ratingz);

        route = list.get(position);
        title.setText(route.getName());
        length.setText(String.valueOf(route.getDistance()) + "km");
        duration.setText(String.valueOf(route.getDuration()) + "h");
        difficulty.setText(String.valueOf(route.getDifficulty()));

        reviews = route.getReviews();

        ratingz = 0;
        int gesamt = 0;

        for (int i = 0; i < reviews.size(); i++) {
            ratingz += reviews.get(i).getRating();
            gesamt++;
        }

        ratingAverage = String.valueOf(ratingz / gesamt);

        rating.setText(ratingAverage + "/5.0");

        return rowView;
    }
}
