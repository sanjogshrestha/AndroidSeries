package np.cnblabs.dagger2.di.component;

import javax.inject.Singleton;

import dagger.Component;
import np.cnblabs.dagger2.MainActivity;
import np.cnblabs.dagger2.di.module.AppModule;
import np.cnblabs.dagger2.di.module.NetModule;

/**
 * Created by sanjogstha on 11/24/17.
 * Innovisto LLC
 * sanjogshrestha.nepal@gmail.com
 */

@Singleton @Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(MainActivity mainActivity);
}
