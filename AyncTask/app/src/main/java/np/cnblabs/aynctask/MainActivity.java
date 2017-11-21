package np.cnblabs.aynctask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import np.cnblabs.aynctask.asyncTask.AsyncAPICallActivity;
import np.cnblabs.aynctask.asyncTask.AsyncActivity;
import np.cnblabs.aynctask.asyncTask.ImageDownloaderActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createANR(View view) {
        startActivity(new Intent(this, ANR.class));
    }

    public void asyncTask(View view) {
        startActivity(new Intent(this, AsyncActivity.class));
    }

    public void downloadImage(View view) {
        startActivity(new Intent(this, ImageDownloaderActivity.class));
    }

    public void apiCall(View view) {
        startActivity(new Intent(this, AsyncAPICallActivity.class));
    }
}
