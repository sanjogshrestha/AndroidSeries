package np.cnblabs.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/*
* Shared Preferences allows activities and applications to keep preferences,
* in the form of key-value pairs similar to a Map that will persist even when the user closes the application.
*
* SharedPreferences is application specific, i.e. the data is lost on performing one of the following options:
    1. on uninstalling the application
    2. on clearing the application data (through Settings)
* */
public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    TextView name, email;
    public static final String myPreference = "mypref";
    public static final String Name = "nameKey";
    public static final String Email = "emailKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedpreferences = getSharedPreferences(myPreference, Context.MODE_PRIVATE);

        email = findViewById(R.id.etEmail);
        name = findViewById(R.id.etName);
    }

    public void Save(View view) {
        String n = name.getText().toString();
        String e = email.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Name, n);
        editor.putString(Email, e);
        editor.apply();

        /*
        editor.putBoolean("key_name", true); // Storing boolean - true/false
        editor.putString("key_name", "string value"); // Storing string
        editor.putInt("key_name", "int value"); // Storing integer
        editor.putFloat("key_name", "float value"); // Storing float
        editor.putLong("key_name", "long value"); // Storing long
        */
    }

    public void clear(View view) {
        name.setText("");
        email.setText("");
    }

    public void Get(View view) {
        /*
        pref.getString("key_name", null); // getting String
        pref.getInt("key_name", null); // getting Integer
        pref.getFloat("key_name", null); // getting Float
        pref.getLong("key_name", null); // getting Long
        pref.getBoolean("key_name", null); // getting boolean
        */
        if (sharedpreferences.contains(Name)) {
            name.setText(sharedpreferences.getString(Name, ""));
        }
        if (sharedpreferences.contains(Email)) {
            email.setText(sharedpreferences.getString(Email, ""));

        }
    }
}

