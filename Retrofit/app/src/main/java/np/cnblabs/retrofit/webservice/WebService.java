package np.cnblabs.retrofit.webservice;

import np.cnblabs.retrofit.model.TreeHouseModel;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sanjogstha on 11/23/17.
 * Innovisto LLC
 * sanjogshrestha.nepal@gmail.com
 */

public interface WebService {
    @GET("api/get_recent_summary/")
    Call<TreeHouseModel> listPosts();
}
