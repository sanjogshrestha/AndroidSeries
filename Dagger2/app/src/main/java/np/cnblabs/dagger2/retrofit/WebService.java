package np.cnblabs.dagger2.retrofit;

import np.cnblabs.dagger2.model.TreeHouseModel;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sanjogstha on 11/24/17.
 * Innovisto LLC
 * sanjogshrestha.nepal@gmail.com
 */

public interface WebService {
    @GET("api/get_recent_summary/")
    Call<TreeHouseModel> listPosts();
}
