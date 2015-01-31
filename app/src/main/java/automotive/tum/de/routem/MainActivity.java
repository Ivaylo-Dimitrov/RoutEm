package automotive.tum.de.routem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton btRun = (ImageButton) findViewById(R.id.bt_run);
        ImageButton btClimb = (ImageButton) findViewById(R.id.bt_climb);
        ImageButton btWalk = (ImageButton) findViewById(R.id.bt_walk);
        ImageButton btBike = (ImageButton) findViewById(R.id.bt_bike);
        ImageButton btSkiTour = (ImageButton) findViewById(R.id.bt_ski_tour);
        ImageButton btSki = (ImageButton) findViewById(R.id.bt_skiing);

        btRun.setOnClickListener(this);
        btClimb.setOnClickListener(this);
        btWalk.setOnClickListener(this);
        btBike.setOnClickListener(this);
        btSkiTour.setOnClickListener(this);
        btSki.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        }else if(id == R.id.action_record){
            startActivity( new Intent(this, RecordActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this,SearchActivity.class ));
    }
}
