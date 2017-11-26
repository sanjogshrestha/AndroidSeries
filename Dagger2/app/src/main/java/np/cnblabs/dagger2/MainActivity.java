package np.cnblabs.dagger2;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import np.cnblabs.dagger2.model.Post;
import np.cnblabs.dagger2.model.TreeHouseModel;
import np.cnblabs.dagger2.retrofit.WebService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static np.cnblabs.dagger2.MyApplication.getMyApplication;

public class MainActivity extends AppCompatActivity {
    @Inject WebService webService;
    @Inject Resources resources;

    TextView textView;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        textView = findViewById(R.id.text);

        textView.setTextColor(resources.getColor(R.color.colorAccent));
        getMyApplication(this).getNetComponent().inject(this);

        webService.listPosts().enqueue(new Callback<TreeHouseModel>() {
            @Override
            public void onResponse(@NonNull Call<TreeHouseModel> call, @NonNull Response<TreeHouseModel> response) {
                TreeHouseModel treeHouseModel = response.body();
                List<String> stringList = new ArrayList<>();
                if(treeHouseModel != null){
                    for (Post post : treeHouseModel.getPosts()) {
                        stringList.add(post.getAuthor());
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, stringList);
                    listView.setAdapter(arrayAdapter);
                }
            }

            @Override
            public void onFailure(@NonNull Call<TreeHouseModel> call, @NonNull Throwable t) {

            }
        });
    }
}
