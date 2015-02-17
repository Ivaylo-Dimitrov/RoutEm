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
    String difficultyString;


    public SearchItemsAdapter(Activity context, List<Route> list) {
        super(context, R.layout.search_item, list);
        this.list = list;
        mContext = context;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = mContext.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.search_item, null);

        route = list.get(position);

        title = (TextView) rowView.findViewById(R.id.titlez);
        length = (TextView) rowView.findViewById(R.id.lengthz);
        duration = (TextView) rowView.findViewById(R.id.durationz);
        difficulty = (TextView) rowView.findViewById(R.id.difficultyz);
        rating = (TextView) rowView.findViewById(R.id.ratingz);

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

        title.setText(route.getName());
        length.setText(String.valueOf(route.getDistance()) + "km");
        duration.setText(String.valueOf(route.getDuration()) + "h");
        difficulty.setText(String.valueOf(difficultyString));

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
