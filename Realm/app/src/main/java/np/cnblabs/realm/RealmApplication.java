package np.cnblabs.realm;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by sanjogstha on 11/26/17.
 * Innovisto LLC
 * sanjogshrestha.nepal@gmail.com
 */

public class RealmApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        Realm.setDefaultConfiguration(createRealmConfiguration());
    }

    private RealmConfiguration createRealmConfiguration() {
        // The RealmConfiguration is created using the builder pattern.
        return new RealmConfiguration.Builder()
                .name("default1")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();
    }

    /**
     * Get Realm Instance
     *
     * @return Realm Configuration
     */
    public static Realm getRealmInstance() {
        return Realm.getDefaultInstance();
    }
}
