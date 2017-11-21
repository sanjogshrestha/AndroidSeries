package np.cnblabs.aynctask.asyncTask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import np.cnblabs.aynctask.DAO.Model;
import np.cnblabs.aynctask.DAO.Post;
import np.cnblabs.aynctask.R;

/**
 * Created by sanjogstha on 11/21/17.
 * Innovisto LLC
 * sanjogshrestha.nepal@gmail.com
 */

public class AsyncAPICallActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);

        listView = findViewById(R.id.listView);

        new FetchData().execute("http://blog.teamtreehouse.com/api/get_recent_summary/");
    }

    public class FetchData extends AsyncTask<String, Void, String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL mUrl = new URL(strings[0]);
                HttpURLConnection httpConnection = (HttpURLConnection) mUrl.openConnection();
                httpConnection.setRequestMethod("GET");
                httpConnection.setUseCaches(false);
                httpConnection.setAllowUserInteraction(false);
                httpConnection.connect();

                int responseCode = httpConnection.getResponseCode();

                if(responseCode == HttpURLConnection.HTTP_OK){
                    BufferedReader br = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line).append("\n");
                    }
                    br.close();
                    return sb.toString();
                }else
                    return null;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Gson gson = new Gson();
            Model model = gson.fromJson(s, Model.class);
            List<String> stringList = new ArrayList<>();
            for (Post post : model.getPosts()) {
                stringList.add(post.getTitle());
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<>(AsyncAPICallActivity.this,
                    android.R.layout.simple_list_item_1,
                    stringList);
            listView.setAdapter(adapter);

        }
    }
}
