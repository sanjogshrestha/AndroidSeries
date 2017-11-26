package np.cnblabs.dagger2;

import android.app.Application;
import android.content.Context;

import np.cnblabs.dagger2.di.component.DaggerNetComponent;
import np.cnblabs.dagger2.di.component.NetComponent;
import np.cnblabs.dagger2.di.module.AppModule;
import np.cnblabs.dagger2.di.module.NetModule;

/**
 * Created by sanjogstha on 11/24/17.
 * Innovisto LLC
 * sanjogshrestha.nepal@gmail.com
 */

public class MyApplication extends Application {
    NetComponent netComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://blog.teamtreehouse.com/"))
                .build();
    }

    public static MyApplication getMyApplication(Context context){
        return (MyApplication) context.getApplicationContext();
    }

    public NetComponent getNetComponent(){
        return netComponent;
    }
}
