package com.zatsando.afterformattool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private CheckBox brave_check;
    private CheckBox discord_check;
    private CheckBox mozila_check;
    private CheckBox telegram_check;
    private CheckBox intellij_check;
    private CheckBox vsc_check;
    private CheckBox eclipse_check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        brave_check = findViewById(R.id.brave_check);
        discord_check = findViewById(R.id.discord_check);
        mozila_check = findViewById(R.id.mozila_check);
        telegram_check = findViewById(R.id.telegram_check);
        intellij_check = findViewById(R.id.intellij_check);
        vsc_check = findViewById(R.id.vsc_check);
        eclipse_check = findViewById(R.id.eclipse_check);

    }

    ArrayList<String> commands = new ArrayList<>();

    //read and clear buttons
    public void ready_button(View view) {
        String textCommand = commands.toString().replace(",", "").replace("[" , "").replace("]", "");

        //intend method to create the text file
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, textCommand);
        sendIntent.setType("text/.ps1");
        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);

        Toast.makeText(getApplicationContext(), "You are indeed, ready!", Toast.LENGTH_SHORT).show();
    }

    public void clear_button(View view) {
        commands.clear();
        if (discord_check.isChecked()) {
            discord_check.setChecked(false);
        }
        if (brave_check.isChecked()) {
            brave_check.setChecked(false);
        }
        if (mozila_check.isChecked()) {
            mozila_check.setChecked(false);
        }
        if (telegram_check.isChecked()) {
            telegram_check.setChecked(false);
        }
        if (intellij_check.isChecked()) {
            intellij_check.setChecked(false);
        }
        if (vsc_check.isChecked()) {
            vsc_check.setChecked(false);
        }
        if (eclipse_check.isChecked()) {
            eclipse_check.setChecked(false);
        }

        Toast.makeText(getApplicationContext(), "Cleared!", Toast.LENGTH_SHORT).show();
    }

    //app buttons functionality
    public void brave_check(View view) {
        if (brave_check.isChecked()) {
            Toast.makeText(getApplicationContext(), "Checked!", Toast.LENGTH_SHORT).show();
            commands.add("choco install brave -a;");
        } else {
            Toast.makeText(getApplicationContext(), "Unchecked!", Toast.LENGTH_SHORT).show();
        }
    }

    public void mozila_check(View view) {
        if (mozila_check.isChecked()) {
            Toast.makeText(getApplicationContext(), "Checked!", Toast.LENGTH_SHORT).show();
            commands.add("choco install firefox -a;");
        } else {
            Toast.makeText(getApplicationContext(), "Unchecked!", Toast.LENGTH_SHORT).show();
        }
    }

    public void discord_check(View view) {
        if (discord_check.isChecked()) {
            Toast.makeText(getApplicationContext(), "Checked!", Toast.LENGTH_SHORT).show();
            commands.add("choco install discord -a;");
        } else {
            Toast.makeText(getApplicationContext(), "Unchecked!", Toast.LENGTH_SHORT).show();
        }
    }

    public void telegram_check(View view) {
        if (telegram_check.isChecked()) {
            Toast.makeText(getApplicationContext(), "Checked!", Toast.LENGTH_SHORT).show();
            commands.add("choco install telegram -a;");
        } else {
            Toast.makeText(getApplicationContext(), "Unchecked!", Toast.LENGTH_SHORT).show();
        }
    }

    public void intellij_check(View view) {
        if (intellij_check.isChecked()) {
            Toast.makeText(getApplicationContext(), "Checked!", Toast.LENGTH_SHORT).show();
            commands.add("choco install intellij -a;");
        } else {
            Toast.makeText(getApplicationContext(), "Unchecked!", Toast.LENGTH_SHORT).show();
        }
    }

    public void vsc_check(View view) {
        if (vsc_check.isChecked()) {
            Toast.makeText(getApplicationContext(), "Checked!", Toast.LENGTH_SHORT).show();
            commands.add("choco install vsc -a;");
        } else {
            Toast.makeText(getApplicationContext(), "Unchecked!", Toast.LENGTH_SHORT).show();
        }
    }

    public void eclipse_check(View view) {
        if (eclipse_check.isChecked()) {
            Toast.makeText(getApplicationContext(), "Checked!", Toast.LENGTH_SHORT).show();
            commands.add("choco install vsc -a;");
        } else {
            Toast.makeText(getApplicationContext(), "Unchecked!", Toast.LENGTH_SHORT).show();
        }
    }
}