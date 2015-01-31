package automotive.tum.de.routem;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import automotive.tum.de.routem.models.Route;

/**
 * Created by Ch0PPeR on 19.01.2015.
 */
public class SearchItemsAdapter  extends ArrayAdapter{
    List<Route> list;
    Activity mContext;
    public SearchItemsAdapter (Activity context, List<Route> list) {
        super(context,R.layout.search_item,list);
        this.list = list;
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = mContext.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.search_item, null);


        return rowView;
    }
}
