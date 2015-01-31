package automotive.tum.de.routem;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

import com.gc.materialdesign.views.ButtonRectangle;
import com.gc.materialdesign.views.ProgressBarCircularIndeterminate;

/**
 * Created by Ch0PPeR on 20.01.2015.
 */
public class RecordActivity extends ActionBarActivity {
    ProgressBarCircularIndeterminate progress;
    TextView tvRecording;
    ButtonRectangle recordButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record_activity);
         recordButton =  (ButtonRectangle) findViewById(R.id.button);
        recordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(progress.getVisibility() == View.VISIBLE){
                    progress.setVisibility(View.INVISIBLE);
                    tvRecording.setVisibility(View.INVISIBLE);
                    recordButton.setText("RECORD");
                }else{
                    progress.setVisibility(View.VISIBLE);
                    tvRecording.setVisibility(View.VISIBLE);
                    recordButton.setText("STOP RECORDING");
                }
            }
        });

        progress = (ProgressBarCircularIndeterminate) findViewById(R.id.progressBarCircularIndeterminate);
        tvRecording = (TextView) findViewById(R.id.tvRecording);


    }
}
