package automotive.tum.de.routem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import automotive.tum.de.routem.models.Activities;


public class MainActivity extends ActionBarActivity {
    Intent intent;

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

        btRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, SearchActivity.class);
                intent.putExtra("class", Activities.running);
                startActivity(intent);
            }
        });
        btClimb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, SearchActivity.class);
                intent.putExtra("class", Activities.climbing);
                startActivity(intent);
            }
        });
        btWalk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, SearchActivity.class);
                intent.putExtra("class", Activities.walking);
                startActivity(intent);
            }
        });
        btBike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, SearchActivity.class);
                intent.putExtra("class", Activities.biking);
                startActivity(intent);
            }
        });
        btSkiTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, SearchActivity.class);
                intent.putExtra("class", Activities.skitour);
                startActivity(intent);
            }
        });
        btSki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, SearchActivity.class);
                intent.putExtra("class", Activities.skiing);
                startActivity(intent);
            }
        });

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
}
