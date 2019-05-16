package com.example.internal_storage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Second extends AppCompatActivity {
    Button load, prev;
    EditText etname, etpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        load = findViewById(R.id.loadbtn);
        prev = findViewById(R.id.prevbtn);
        etname = findViewById(R.id.etonee);
        etpass = findViewById(R.id.ettwoo);
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fileInputStream = openFileInput("my.txt");
                    int read = -1;
                    StringBuffer s = new StringBuffer();
                    while ((read = fileInputStream.read()) != -1) {
                        s.append((char) read);
                    }
                    etname.setText(s.substring(0, s.indexOf(" ")));
                    etpass.setText(s.substring(s.indexOf(" "), s.length() - 1));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Second.this, MainActivity.class));
            }
        });
    }
}
