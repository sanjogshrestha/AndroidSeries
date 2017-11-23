package np.cnblabs.retrofit;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;

import np.cnblabs.retrofit.webservice.ApiClient;
import np.cnblabs.retrofit.webservice.WebService;

/**
 * Created by sanjogstha on 11/23/17.
 * Innovisto LLC
 * sanjogshrestha.nepal@gmail.com
 */

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {

    protected WebService getAPIService(){
        return ApiClient.getClient().create(WebService.class);
    }
}
