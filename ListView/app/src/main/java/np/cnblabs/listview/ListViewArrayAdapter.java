package np.cnblabs.listview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by sanjogstha on 11/19/17.
 * Innovisto LLC
 * sanjogshrestha.nepal@gmail.com
 */

public class ListViewArrayAdapter extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrayadapter);

        listView = findViewById(R.id.listView);
        String[] sports = {"Football", "Cricket", "TT", "Hockey", "Basketball", "Baseball" , "Karate"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sports);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListViewArrayAdapter.this, ((TextView)view).getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
