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
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import automotive.tum.de.routem.models.Comment;
import automotive.tum.de.routem.models.ImageModel;
import automotive.tum.de.routem.models.Route;

/**
 * Created by Ch0PPeR on 20.01.2015.
 */
public class Images extends ListFragment {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Intent intent = getActivity().getIntent();

        Route route = new Gson().fromJson(intent.getStringExtra("route"), Route.class);

        ArrayList<Comment> comments = route.getComments();

        List<ImageModel> list = new ArrayList<>();

        for (int i = 0; i < comments.size(); i++) {
            ImageModel image = new ImageModel();
            image.setComment(comments.get(i));
            list.add(image);
        }

        setListAdapter(new ImageItemsAdapter(getActivity(), list));
    }

    private class ImageItemsAdapter extends ArrayAdapter {
        List<ImageModel> list;
        Activity mContext;

        TextView text;
        ImageView image;

        public ImageItemsAdapter(Activity context, List<ImageModel> list) {
            super(context, R.layout.image_item, list);


            this.list = list;
            mContext = context;

            getListView().setDividerHeight(0);
            getListView().setDivider(new ColorDrawable(Color.TRANSPARENT));
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = mContext.getLayoutInflater();
            View rowView = inflater.inflate(R.layout.image_item, null);
            String string = list.get(position).getComment().getText();
            text = (TextView) rowView.findViewById(R.id.textView11);
            image = (ImageView) rowView.findViewById(R.id.imageView4);

            text.setText(string);

            if (string.startsWith("Mighty"))
                image.setImageResource(R.drawable.mighty);
            if (string.startsWith("Wow"))
                image.setImageResource(R.drawable.wow);
            if (string.startsWith("Very"))
                image.setImageResource(R.drawable.very);
            if (string.startsWith("Delicious"))
                image.setImageResource(R.drawable.delicious);
            if (string.startsWith("Nice"))
                image.setImageResource(R.drawable.nice);
            if (string.startsWith("Great"))
                image.setImageResource(R.drawable.great);
            return rowView;
        }
    }
}
