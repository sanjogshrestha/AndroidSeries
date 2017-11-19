package np.cnblabs.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import np.cnblabs.listview.adapter.ListViewCustomAdapterActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fromXML(View view) {
        startActivity(new Intent(this, ListViewXMLActivity.class));
    }

    public void fromArrayAdapter(View view) {
        startActivity(new Intent(this, ListViewArrayAdapter.class));
    }

    public void fromCustomAdapter(View view) {
        startActivity(new Intent(this, ListViewCustomAdapterActivity.class));
    }
}
