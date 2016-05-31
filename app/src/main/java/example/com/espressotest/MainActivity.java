package example.com.espressotest;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private EditText eText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        eText = (EditText) findViewById(R.id.textToSave);
    }

    public void save(View v) {
        SharedPreferences sharedPreferences = getSharedPreferences("abc", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("editText", eText.getText().toString());
        editor.apply();
    }

    public void display(View v) {
        SharedPreferences sharedPreferences = getSharedPreferences("abc", 0);
        String text = sharedPreferences.getString("editText", "Couldn't fetch value");
        String reverseText = "";
        for(int i = text.length()-1; i >= 0; i--) {
            reverseText += text.substring(i,i+1);
        }
        textView.setText(reverseText);

    }
}
