package np.cnblabs.edittext;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/*
* sanjogshrestha.nepal@gmail.com
*/
public class MainActivity extends AppCompatActivity {
    TextInputLayout email_text_input_layout;
    EditText etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email_text_input_layout = findViewById(R.id.email_text_input_layout);
        etEmail = findViewById(R.id.etEmail);

        etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence text, int start, int count, int after) {
                if (text.length() == 0) {
                    email_text_input_layout.setError(getString(R.string.required_field));
                    email_text_input_layout.setErrorEnabled(true);
                } else if(!isValidEmail(text)){
                    email_text_input_layout.setError(getString(R.string.invalid_email));
                    email_text_input_layout.setErrorEnabled(true);
                }else {
                    email_text_input_layout.setErrorEnabled(false);
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {}

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    public static boolean isValidEmail(CharSequence email) {
        return email != null && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
