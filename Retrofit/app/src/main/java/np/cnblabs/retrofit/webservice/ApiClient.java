package np.cnblabs.retrofit.webservice;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sanjogstha on 11/23/17.
 * Innovisto LLC
 * sanjogshrestha.nepal@gmail.com
 */

public class ApiClient {
    public static Retrofit getClient(){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .connectTimeout(3, TimeUnit.MINUTES)
                .readTimeout(3, TimeUnit.MINUTES)
                .writeTimeout(3, TimeUnit.MINUTES);

        OkHttpClient client = httpClient.build();

        return new Retrofit.Builder()
                .baseUrl(UrlConstant.MAIN_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
