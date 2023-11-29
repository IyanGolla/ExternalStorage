package com.example.externalstorage;

import static android.os.Environment.getExternalStorageDirectory;

import androidx.appcompat.app.AppCompatActivity;

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

    private static final String FILENAME = "demo.txt";

    Button write;
    EditText txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        write = findViewById(R.id.button);
        txt = findViewById(R.id.editTextTextPersonName);
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createFileTE();
                txt.setText("");

            }
        });
    }
    private void createFileTE() {
        File file = new File(getExternalStorageDirectory(),FILENAME);
        save(file);


    }
    public void save(File file) {
        String text = txt.getText().toString();


        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
            out.write(text.getBytes());
            txt.getText().clear();
            Toast.makeText(this, "Saved File" + file.getPath() + "/" + FILENAME, Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
//close output stream
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

