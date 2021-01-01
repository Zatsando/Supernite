package com.zatsando.afterformattool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<Application> applicationsList = new ArrayList<>();
    Button clearBtn, downloadBtn;
    ListView listView;
    MyListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clearBtn = (Button) findViewById(R.id.clearBtn);
        downloadBtn = (Button) findViewById(R.id.downloadBtn);

        listView = (ListView) findViewById(R.id.listView);
        fillListWithItems();


        adapter = new MyListViewAdapter(this, applicationsList);
        listView.setAdapter(adapter);

        downloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ready_button();
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Application app : applicationsList) {
                    app.setChecked(false);
                }
                adapter = new MyListViewAdapter(MainActivity.this, applicationsList);
                listView.setAdapter(adapter);
                clearBtn.setVisibility(View.GONE);
                downloadBtn.setVisibility(View.GONE);
            }
        });

    }


    //read and clear buttons
    public void ready_button() {
        String chocoInstaller = "Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'));";
        String textCommand = applicationsList.toString().replace(",", "").replace("[", "").replace("]", "");

        //intend method to create the text file
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, chocoInstaller + textCommand);
        sendIntent.setType("text/plain");
        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);

        Toast.makeText(getApplicationContext(), "You are indeed, ready!", Toast.LENGTH_SHORT).show();
    }


    private void fillListWithItems() {

        clearBtn.setVisibility(View.GONE);
        downloadBtn.setVisibility(View.GONE);

        Application firefox = new Application("Firefox", "choco install firefox -a;", R.drawable.firefox, false);
        applicationsList.add(firefox);
        Application brave = new Application("Brave", "choco install brave -a;", R.drawable.brave, false);
        applicationsList.add(brave);
        Application telegram = new Application("telegram", "choco install telegram -a;", R.drawable.telegram, false);
        applicationsList.add(telegram);
        Application discord = new Application("discord", "choco install discord -a;", R.drawable.discord, false);
        applicationsList.add(discord);
        Application intellij = new Application("intellij", "choco install intellij -a;", R.drawable.intellij, false);
        applicationsList.add(intellij);
        Application vsc = new Application("vsc", "choco install vsc -a;", R.drawable.vsc, false);
        applicationsList.add(vsc);
    }

}