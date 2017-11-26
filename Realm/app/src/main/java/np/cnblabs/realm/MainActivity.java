package np.cnblabs.realm;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmResults;
import np.cnblabs.realm.adapter.CustomAdapter;
import np.cnblabs.realm.model.Detail;
import np.cnblabs.realm.realm.DetailData;
import np.cnblabs.realm.realm.RealmMapper;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.name_textInputLayout) TextInputLayout name_textInputLayout;
    @BindView(R.id.email_textInputLayout) TextInputLayout email_textInputLayout;
    @BindView(R.id.name_editText)  EditText name_editText;
    @BindView(R.id.email_editText)  EditText email_editText;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;

    String email, name;
    Realm realm;
    CustomAdapter customAdapter;

    private RealmResults<DetailData> detailDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        realm = RealmApplication.getRealmInstance();
        addItemInRecyclerView();

        customAdapter.setOnClick(new CustomAdapter.onClickListener() {
            @Override
            public void onItemLongClick(String email) {
                final DetailData detailData = realm.where(DetailData.class)
                        .equalTo(DetailData.EMAIL_ID, email)
                        .findFirst();
                if(detailData == null) return;
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(@NonNull Realm realm) {
                        detailData.deleteFromRealm();
                        detailDataList = realm.where(DetailData.class).findAll();
                        customAdapter.notifyDataSetChanged();
                    }
                });
            }

            @Override
            public void onItemClick(String name) {
                Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void addDetail(View view) {
        name = name_editText.getText().toString();
        email = email_editText.getText().toString();

        if(!validateName()) return;
        if(!validateEmail()) return;

        Detail detail = new Detail(name, email);

        saveInRealm(detail);
    }

    private void addItemInRecyclerView() {
        detailDataList = realm.where(DetailData.class).findAll();

        customAdapter = new CustomAdapter(this, detailDataList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        recyclerView.setAdapter(customAdapter);
    }

    private void saveInRealm(final Detail detail) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(@NonNull Realm realm) {
                RealmMapper.toRealm(detail, realm);
                detailDataList = realm.where(DetailData.class).findAll();
                customAdapter.notifyDataSetChanged();
            }
        });
    }

    private boolean validateEmail() {
        if(email.isEmpty()){
            email_textInputLayout.setErrorEnabled(true);
            email_textInputLayout.setError(getString(R.string.empty_field));
            return false;
        }else {
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                email_textInputLayout.setErrorEnabled(true);
                email_textInputLayout.setError(getString(R.string.invalid_email));
                return false;
            }
            email_textInputLayout.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validateName() {
        if(name.isEmpty()){
            name_textInputLayout.setError(getString(R.string.empty_field));
            name_textInputLayout.setErrorEnabled(true);
            return false;
        }else{
            name_textInputLayout.setErrorEnabled(false);
        }
        return true;
    }
}
