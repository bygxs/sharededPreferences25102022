package com.biniyam.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button loadButton;
    Button saveButton;
    TextView displayText;
    EditText inputField;
    SharedPreferences sharedPrefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // the first global way of declaring
         //sharedPref = getSharedPreferences("com.biniyam.sharedpreferences",MODE_PRIVATE);

        displayText = findViewById(R.id.text_view);
        inputField = findViewById(R.id.input_field);
        saveButton = findViewById(R.id.button_save);
        loadButton = findViewById(R.id.button_load);

        sharedPrefs = getSharedPreferences("com.biniyam.sharedpreferences",MODE_PRIVATE);




//       editor.putString("name", "Bill");
//       editor.putInt("age", 41);
//       editor.putString("password", "1234Secretpassword");


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor= sharedPrefs.edit();

                String savedData = inputField.getText().toString();

                editor.putString("saved String" ,savedData);
                editor.apply();

                Toast.makeText(MainActivity.this,"saved data to prefs", Toast.LENGTH_SHORT).show();


            }
        });

        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String s = sharedPrefs.getString("saved String","");
               displayText.setText(s);


            }
        });


    }
}