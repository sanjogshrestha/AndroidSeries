package np.cnblabs.listview.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import np.cnblabs.listview.R;

/**
 * Created by sanjogstha on 11/19/17.
 * Innovisto LLC
 * sanjogshrestha.nepal@gmail.com
 */

public class ListViewCustomAdapterActivity extends AppCompatActivity {
    ListView listView;
    String[] sports = {"Football", "Cricket", "TT", "Hockey", "Baseball" , "Karate"};
    int[] drawables = {R.drawable.soccer, R.drawable.cricket, R.drawable.tt, R.drawable.hockey, R.drawable.baseball, R.drawable.karate};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter);
        listView = findViewById(R.id.listView);
        listView.setAdapter(new CustomAdapter(this, sports, drawables));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListViewCustomAdapterActivity.this,
                        adapterView.getItemAtPosition(i).toString(),
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}
