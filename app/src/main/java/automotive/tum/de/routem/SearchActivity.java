package automotive.tum.de.routem;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.marvinlabs.widget.floatinglabel.edittext.FloatingLabelEditText;

import java.util.ArrayList;
import java.util.List;

import automotive.tum.de.routem.models.Activities;
import automotive.tum.de.routem.models.Route;
import automotive.tum.de.routem.rest.RestClient;

/**
 * Created by Ch0PPeR on 18.01.2015.
 */
public class SearchActivity extends ActionBarActivity{
    Intent intent;
    int activity;
    String activityString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        intent = getIntent();
        activity = intent.getIntExtra("class", 1);

        switch (activity) {
            case 1:
                getSupportActionBar().setTitle(Activities.runningLabel);
                break;
            case 2:
                getSupportActionBar().setTitle(Activities.climbingLabel);
                break;
            case 3:
                getSupportActionBar().setTitle(Activities.walkingLabel);
                break;
            case 4:
                getSupportActionBar().setTitle(Activities.bikingLabel);
                break;
            case 5:
                getSupportActionBar().setTitle(Activities.skiingLabel);
                break;
            case 6:
                getSupportActionBar().setTitle(Activities.skitourLabel);
                break;
            default:
                getSupportActionBar().setTitle(Activities.runningLabel);
                break;
        }

        setContentView(R.layout.choose);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        ArrayList<Route> routesList = RestClient.get().getRoutes((float) 48.122957, (float) 11.574097, 15, "running");

        Log.e("ASD", String.valueOf(routesList.size()));
        List<Route> routeList = new ArrayList<>();
        for (int i = 0; i < routesList.size(); i++) {
            routeList.add(routesList.get(i));
        }

        ListView lv = (ListView) findViewById(R.id.listView);
        SearchItemsAdapter sia = new SearchItemsAdapter(this, routeList);
        lv.setAdapter(sia);
        FloatingLabelEditText tvWhere = (FloatingLabelEditText) findViewById(R.id.editText);
        tvWhere.clearFocus();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3)
            {
                Route route = (Route)adapter.getItemAtPosition(position);
                // assuming string and if you want to get the value on click of list item
                // do what you intend to do on click of listview row
                Log.e("ASD", new Gson().toJson(route, Route.class));
                intent = new Intent(SearchActivity.this, DetailActivity.class);
                intent.putExtra("route", new Gson().toJson(route, Route.class));
                startActivity(intent);

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
