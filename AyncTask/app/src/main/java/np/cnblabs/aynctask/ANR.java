package np.cnblabs.aynctask;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by sanjogstha on 11/21/17.
 * Innovisto LLC
 * sanjogshrestha.nepal@gmail.com
 */

public class ANR extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anr);

        //get the references to on screen items
        tv= findViewById(R.id.textView);
    }

    public void doButtonClick(View view) {
        tv.setText("Processing, please wait.");
        thisTakesAWhile();
        tv.setText("Finished.");
    }

    private void thisTakesAWhile() {
        //mimic long running code
        int count = 0;
        do{
            SystemClock.sleep(1000);
            count++;
            tv.setText("Processed " + count + " of 10.");
        } while(count<10);
    }
}
