package automotive.tum.de.routem;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import automotive.tum.de.routem.models.Comment;
import automotive.tum.de.routem.models.Review;
import automotive.tum.de.routem.models.Route;

/**
 * Created by Ch0PPeR on 20.01.2015.
 */
public class Ratings extends ListFragment {
    Intent intent;
    Route route;
    TextView title;
    TextView description;
    Review comment;
    RatingBar rating;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        intent = getActivity().getIntent();

        route = new Gson().fromJson(intent.getStringExtra("route"), Route.class);


        ArrayList<Review> comments = route.getReviews();

        List<Review> list = new ArrayList<>();

        for (int i = 0; i < comments.size(); i++) {
            list.add(comments.get(i));
        }
        setListAdapter(new CommentItemsAdapter(getActivity(), list));
    }

    private class CommentItemsAdapter extends ArrayAdapter {
        List<Review> list;
        Activity mContext;

        public CommentItemsAdapter(Activity context, List<Review> list) {
            super(context, R.layout.comment_item, list);
            this.list = list;
            mContext = context;

            getListView().setDividerHeight(0);
            getListView().setDivider(new ColorDrawable(Color.TRANSPARENT));
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = mContext.getLayoutInflater();
            View rowView = inflater.inflate(R.layout.comment_item, null);


            title = (TextView) rowView.findViewById(R.id.titley);
            description = (TextView) rowView.findViewById(R.id.description);
            rating = (RatingBar) rowView.findViewById(R.id.ratingBar);

            comment = list.get(position);

            title.setText(comment.getTitle());
            description.setText(comment.getText());
            rating.setRating(comment.getRating());

            return rowView;
        }
    }
}
