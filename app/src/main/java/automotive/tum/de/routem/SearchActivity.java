package automotive.tum.de.routem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.marvinlabs.widget.floatinglabel.edittext.FloatingLabelEditText;

import java.util.ArrayList;
import java.util.List;

import automotive.tum.de.routem.models.Route;

/**
 * Created by Ch0PPeR on 18.01.2015.
 */
public class SearchActivity extends ActionBarActivity implements AdapterView.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose);


        List<Route> list = new ArrayList<>();
        list.add(new Route());
        list.add(new Route());
        list.add(new Route());
        list.add(new Route());
        list.add(new Route());
        list.add(new Route());
        list.add(new Route());

        ListView lv = (ListView) findViewById(R.id.listView);
        SearchItemsAdapter sia = new SearchItemsAdapter(this,list);
        lv.setAdapter(sia);
        lv.setOnItemClickListener(this);
       FloatingLabelEditText tvWhere = (FloatingLabelEditText)findViewById(R.id.editText);
       tvWhere.clearFocus();
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startActivity(new Intent(this, DetailActivity.class));
    }
}
