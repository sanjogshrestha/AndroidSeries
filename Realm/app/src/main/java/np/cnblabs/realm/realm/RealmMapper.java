package np.cnblabs.realm.realm;

import android.support.annotation.NonNull;

import io.realm.Realm;
import np.cnblabs.realm.model.Detail;

/**
 * Created by sanjogstha on 11/26/17.
 * Innovisto LLC
 * sanjogshrestha.nepal@gmail.com
 */

public class RealmMapper {
    public static Detail fromRealm(DetailData detailData){
        if(detailData == null) return null;
        return new Detail(detailData.getName(), detailData.getEmail());
    }

    public static DetailData toRealm(@NonNull Detail detail, @NonNull  Realm realm){
        DetailData detailData = realm.where(DetailData.class)
                .equalTo(DetailData.EMAIL_ID, detail.getEmail())
                .findFirst();

        if(detailData == null){
            detailData = realm.createObject(DetailData.class, detail.getEmail());
        }

        detailData.setName(detail.getName());
        return detailData;
    }
}
