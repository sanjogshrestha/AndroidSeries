package np.cnblabs.retrofit;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import np.cnblabs.retrofit.model.Post;
import np.cnblabs.retrofit.model.TreeHouseModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    List<String> titleList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titleList);
    }

    public void fetchAPI(View view) {
        getAPIService().listPosts().enqueue(new Callback<TreeHouseModel>() {
            @Override
            public void onResponse(@NonNull Call<TreeHouseModel> call, @NonNull Response<TreeHouseModel> response) {
                TreeHouseModel treeHouseModel = response.body();
                if(treeHouseModel != null){
                    for (Post post : treeHouseModel.getPosts()) {
                        titleList.add(post.getTitle());
                    }
                    listView.setAdapter(arrayAdapter);
                }
            }

            @Override
            public void onFailure(@NonNull Call<TreeHouseModel> call, @NonNull Throwable t) {}
        });
    }
}
