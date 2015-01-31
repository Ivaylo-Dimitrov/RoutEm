package automotive.tum.de.routem;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import automotive.tum.de.routem.models.Comment;

/**
 * Created by Ch0PPeR on 20.01.2015.
 */
public class Ratings extends ListFragment {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        List<Comment> list = new ArrayList<>();
        list.add(new Comment());
        list.add(new Comment());
        list.add(new Comment());
        list.add(new Comment());
        list.add(new Comment());
        list.add(new Comment());
        setListAdapter(new CommentItemsAdapter(getActivity(), list));
    }

    private class CommentItemsAdapter extends ArrayAdapter {
        List<Comment> list;
        Activity mContext;

        public CommentItemsAdapter(Activity context, List<Comment> list) {
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


            return rowView;
        }
    }
}
