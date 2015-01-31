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

import automotive.tum.de.routem.models.ImageModel;

/**
 * Created by Ch0PPeR on 20.01.2015.
 */
public class Images extends ListFragment {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        List<ImageModel> list = new ArrayList<>();
        list.add(new ImageModel());
        list.add(new ImageModel());
        list.add(new ImageModel());
        list.add(new ImageModel());
        list.add(new ImageModel());
        list.add(new ImageModel());
        setListAdapter(new ImageItemsAdapter(getActivity(), list));
    }

    private class ImageItemsAdapter extends ArrayAdapter {
        List<ImageModel> list;
        Activity mContext;

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


            return rowView;
        }
    }
}
