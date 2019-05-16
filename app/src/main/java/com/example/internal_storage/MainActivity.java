package com.example.internal_storage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button save, activityB;
    EditText etname, etpass;
File file=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        save = findViewById(R.id.savebtn);
        activityB = findViewById(R.id.bbtn);
        etname = findViewById(R.id.etone);
        etpass = findViewById(R.id.ettwo);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream fileOutputStream = null;
                file=getFilesDir();
                try {

                    fileOutputStream = openFileOutput("my.txt", Context.MODE_PRIVATE);
                    byte[] bytes = (etname.getText().toString() + " " + etpass.getText().toString()).getBytes();
                    fileOutputStream.write(bytes);
                    etname.setText("");
                    etpass.setText("");
                    Toast.makeText(MainActivity.this, "Data saved "+file.toString(), Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            }
        });
        activityB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Second.class));
            }
        });
    }
}
