package np.cnblabs.aynctask.asyncTask;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

import np.cnblabs.aynctask.R;

/**
 * Created by sanjogstha on 11/21/17.
 * Innovisto LLC
 * sanjogshrestha.nepal@gmail.com
 */

public class ImageDownloaderActivity extends AppCompatActivity {
    ImageView imageView;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_image);
        imageView = findViewById(R.id.imageView);
    }

    public void downloadImage(View view) {
        new DownloadImage().execute("http://sanjogshrestha.github.io/img/portfolio/nimbus.png");
    }

    public class DownloadImage extends AsyncTask<String, Void, Bitmap>{
        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap bitmap = null;
            InputStream inputStream;
            try {
                // Download Image from URL
                inputStream = new URL(strings[0]).openStream();
                // Decode Bitmap
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progress dialog
            mProgressDialog = new ProgressDialog(ImageDownloaderActivity.this);
            // Set progress dialog title
            mProgressDialog.setTitle("Downloading Image");
            // Set progress dialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progress dialog
            mProgressDialog.show();
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            imageView.setImageBitmap(bitmap);
            // Close progress dialog
            mProgressDialog.dismiss();
        }
    }
}
