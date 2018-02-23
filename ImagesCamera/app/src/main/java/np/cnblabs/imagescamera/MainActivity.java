package np.cnblabs.imagescamera;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    public static final int CAMERA = 777;
    private static final int GALLERY = 888;
    public final String APP_TAG = "CameraApp";
    File photoFile = null;
    String photoName = "LFA.jpg";
    ImageView imageIV;
    private Uri cameraImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageIV = findViewById(R.id.imageIV);
    }

    public void takePicture(View view) {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, CAMERA);
            return;
        }

        takePicture();
    }

    private void takePicture() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        String imageFileName = "Test" + System.currentTimeMillis() + "_";

        File photo = new File(Environment.
                getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM),
                UUID.randomUUID().toString() + imageFileName);

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            cameraImageUri = FileProvider.getUriForFile(this,
                    getApplicationContext().getPackageName() + ".provider", photo);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, cameraImageUri);
        } else {
            cameraImageUri = Uri.fromFile(photo);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photo));
        }
        startActivityForResult(intent, CAMERA);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case CAMERA:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                        grantResults[1] == PackageManager.PERMISSION_GRANTED){
                    takePicture();
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case CAMERA:
                if(resultCode == RESULT_OK) {
                    imageIV.setImageURI(cameraImageUri);
                }
                break;

            case GALLERY:
                if(resultCode == RESULT_OK){
                    cameraImageUri = data.getData();
                    imageIV.setImageURI(cameraImageUri);
                }
                break;
        }
    }

    public void fetchGallery(View view) {
        Intent attachIntent = new Intent();
        attachIntent.setType("image/*");
        attachIntent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(attachIntent, getResources().getString(R.string.select_picture)), GALLERY);
    }
}
