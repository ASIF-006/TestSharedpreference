package com.example.mobileappdevelop.testsharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText dataEditText;
    TextView displayDataTextView;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataEditText = (EditText) findViewById(R.id.putDataEditText);
        displayDataTextView = (TextView) findViewById(R.id.displayText);
        editor = sharedPreferences.edit();
        sharedPreferences = getSharedPreferences("batch_16", MODE_PRIVATE);
    }

    public void save(View view) {
        String dataToBeSaved = dataEditText.getText().toString();
        editor.putString("message", dataToBeSaved);
        editor.commit();
    }

    public void retrieve(View view) {
        String dataToBeShown = sharedPreferences.getString("message", "data not found");
        displayDataTextView.setText(dataToBeShown);
    }
}
