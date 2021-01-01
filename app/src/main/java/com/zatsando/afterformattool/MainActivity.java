package com.zatsando.afterformattool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<String> applicationsList = new ArrayList<>();
    Button clearBtn, downloadBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clearBtn = (Button) findViewById(R.id.clearBtn);
        downloadBtn = (Button) findViewById(R.id.downloadBtn);

    }


    //read and clear buttons
    public void ready_button(View view) {
        String chocoInstaller = "Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'));";
        String textCommand = commands.toString().replace(",", "").replace("[", "").replace("]", "");

        //intend method to create the text file
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, chocoInstaller + textCommand);
        sendIntent.setType("text/plain");
        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);

        Toast.makeText(getApplicationContext(), "You are indeed, ready!", Toast.LENGTH_SHORT).show();
    }


            commands.add("choco install brave -a;");
            commands.add("choco install firefox -a;");
                        commands.add("choco install telegram -a;");
                                    commands.add("choco install discord -a;");
                                                commands.add("choco install intellij -a;");
                                                            commands.add("choco install vsc -a;");
            commands.add("choco install vsc -a;");


}