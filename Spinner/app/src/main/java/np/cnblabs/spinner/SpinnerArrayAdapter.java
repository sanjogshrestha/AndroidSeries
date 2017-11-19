package np.cnblabs.spinner;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanjogstha on 11/19/17.
 * Innovisto LLC
 * sanjogshrestha.nepal@gmail.com
 */

public class SpinnerArrayAdapter extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter);
        Spinner spinner = findViewById(R.id.spinner);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Automobile");
        categories.add("Business Services");
        categories.add("Computers");
        categories.add("Education");
        categories.add("Personal");
        categories.add("Travel");

        /*Play with android.R.layout.simple_spinner_item*/
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.custom_view, categories);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SpinnerArrayAdapter.this, adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
    }
}
