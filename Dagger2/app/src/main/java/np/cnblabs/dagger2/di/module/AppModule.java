package np.cnblabs.dagger2.di.module;

import android.app.Application;
import android.content.res.Resources;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import np.cnblabs.dagger2.MyApplication;

/**
 * Created by sanjogstha on 11/24/17.
 * Innovisto LLC
 * sanjogshrestha.nepal@gmail.com
 */

@Module
public class AppModule {
    Application appModule;

    public AppModule(MyApplication myApplication) {
        this.appModule = myApplication;
    }

    @Provides @Singleton
    Resources getResources(){
        return appModule.getResources();
    }

    @Provides
    @Singleton
    Application getAppModule() {
        return appModule;
    }
}
