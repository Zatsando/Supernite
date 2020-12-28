package com.zatsando.afterformattool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private CheckBox brave_check;
    private CheckBox discord_check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        brave_check = findViewById(R.id.brave_check);
        discord_check = findViewById(R.id.discord_check);

    }

    ArrayList<String> commands = new ArrayList<>();

    public void brave_check(View view) {
        if(brave_check.isChecked()){
            Toast.makeText(getApplicationContext(), "Checked!", Toast.LENGTH_SHORT).show();
            commands.add("choco install brave;");
        }else {
            Toast.makeText(getApplicationContext(), "Unchecked!", Toast.LENGTH_SHORT).show();
        }
    }

    public void discord_check(View view) {
        if(discord_check.isChecked()){
            Toast.makeText(getApplicationContext(), "Checked!", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(), "Unchecked!", Toast.LENGTH_SHORT).show();
        }
    }

    public void ready_button(View view) {

    }
}