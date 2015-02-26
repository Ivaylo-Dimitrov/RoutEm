package automotive.tum.de.routem;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.gc.materialdesign.views.ButtonFloat;
import com.google.gson.Gson;
import com.marvinlabs.widget.floatinglabel.edittext.FloatingLabelEditText;

import java.util.ArrayList;
import java.util.List;

import automotive.tum.de.routem.models.Activities;
import automotive.tum.de.routem.models.Comment;
import automotive.tum.de.routem.models.Comments;
import automotive.tum.de.routem.models.Route;
import automotive.tum.de.routem.rest.RestClient;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Ch0PPeR on 18.01.2015.
 */
public class SearchActivity extends ActionBarActivity implements View.OnClickListener{
    Intent intent;
    int activity;
    String activityString;
    ArrayList<Route> routesList = new ArrayList<>();
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        intent = getIntent();
        activity = intent.getIntExtra("class", 1);

        ButtonFloat b = (ButtonFloat) findViewById(R.id.buttonFloat);
        b.setOnClickListener(this);

        FloatingLabelEditText tvWhere = (FloatingLabelEditText) findViewById(R.id.editText);
        tvWhere.clearFocus();

        lv = (ListView) findViewById(R.id.listView);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3) {
                Route route = (Route) adapter.getItemAtPosition(position);
                // assuming string and if you want to get the value on click of list item
                // do what you intend to do on click of listview row
                Log.e("ASD", new Gson().toJson(route, Route.class));
                intent = new Intent(SearchActivity.this, DetailActivity.class);
                for(Comment c : route.getComments()){
                    c.setPic(null);
                }

                String data = new Gson().toJson(route, Route.class);
                intent.putExtra("route", data);
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

    private void parseList(List <Route> routesList){
        Log.e("ASD", String.valueOf(routesList.size()));
        List<Route> routeList = new ArrayList<>();
        for (int i = 0; i < routesList.size(); i++) {
            routeList.add(routesList.get(i));
        }


        SearchItemsAdapter sia = new SearchItemsAdapter(this, routeList);
        lv.setAdapter(sia);



    }

    @Override
    public void onClick(View v) {

        String type = new String();
        switch (activity) {
            case 1:
                type=  "running";
                break;
            case 2:
                type=  "climbing";
                break;
            case 3:
                type=  "walking";
                break;
            case 4:
                type=  "bicycling";
                break;
            case 5:
                type=  "skiing";
                break;
            case 6:
                type=  "touring";
                break;
            default:
                getSupportActionBar().setTitle(Activities.runningLabel);
                break;
        }

        getSupportActionBar().setTitle(type.toUpperCase());
        RestClient.get().getRoutesAsync((float) 48.122957, (float) 11.574097, 15,type, new Callback<ArrayList<Route>>() {
            @Override
            public void success(ArrayList<Route> routes, Response response) {
                parseList(routes);
            }

            @Override
            public void failure(RetrofitError retrofitError) {

            }
        });


    }
}
