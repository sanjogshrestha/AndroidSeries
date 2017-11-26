package np.cnblabs.dagger2.di.module;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import np.cnblabs.dagger2.retrofit.WebService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sanjogstha on 11/24/17.
 * Innovisto LLC
 * sanjogshrestha.nepal@gmail.com
 */

@Module
public class NetModule {
    private String baseUrl;

    public NetModule(String url) {
        this.baseUrl = url;
    }

    @Provides @Singleton
    OkHttpClient getOkHttpClient(){
        return new OkHttpClient.Builder()
                .writeTimeout(10000, TimeUnit.MILLISECONDS)
                .readTimeout(10000, TimeUnit.MILLISECONDS)
                .connectTimeout(10000, TimeUnit.MILLISECONDS)
                .build();
    }

    @Provides @Singleton
    Retrofit getRetrofit(OkHttpClient httpClient){
        return new Retrofit.Builder()
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build();
    }

    @Provides @Singleton
    WebService getWebService(Retrofit retrofit){
        return retrofit.create(WebService.class);
    }

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }
}
