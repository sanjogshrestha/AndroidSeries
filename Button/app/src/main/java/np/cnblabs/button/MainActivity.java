package np.cnblabs.button;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button1,button3,button4,button5,button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);

        button1.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
    }

    public void clickMe(View view) {
        //do your action here
        Toast.makeText(this, "With an icon, using the ImageButton class:", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        String text = null;
        switch (view.getId()){
            case R.id.button1:
                text = button1.getTag().toString();
                break;
            case R.id.button3:
                text = button3.getTag().toString();
                break;
            case R.id.button4:
                text = button4.getTag().toString();
                break;
            case R.id.button5:
                text = button5.getTag().toString();
                break;
            case R.id.button6:
                text = button6.getTag().toString();
                break;
        }
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
