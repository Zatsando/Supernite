package com.zatsando.afterformattool;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.FileUtils;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.net.URI;
import java.nio.file.Files;
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

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                alertDialogBuilder.setTitle("DELETE ALL?");
                alertDialogBuilder.setMessage("You are going to delete all. Do you want to delete it?");
                alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (Application app : applicationsList) {
                            app.setChecked(false);
                        }
                        adapter = new MyListViewAdapter(MainActivity.this, applicationsList);
                        listView.setAdapter(adapter);
                        clearBtn.setVisibility(View.GONE);
                        downloadBtn.setVisibility(View.GONE);
                    }
                });
                alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Nothing deleted", Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialogBuilder.show();
            }

        });
    }


    //read and clear buttons
    public void ready_button() {
        String chocoInstaller = "Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'));";

        StringBuilder sb = new StringBuilder();
        for (Application app : applicationsList) {
            if (app.isChecked()) {
                sb.append(app.getCommand());
            }
        }

        String textCommand = chocoInstaller + sb.toString();
//        File file = new File(Uri.encode(textCommand));

        //intend method to create the text file
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);

        sendIntent.setType("text/*");
        sendIntent.putExtra(Intent.EXTRA_TEXT, textCommand);

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
        Application telegram = new Application("Telegram", "choco install telegram -a;", R.drawable.telegram, false);
        applicationsList.add(telegram);
        Application discord = new Application("Discord", "choco install discord -a;", R.drawable.discord, false);
        applicationsList.add(discord);
        Application intellij = new Application("Intellij", "choco install intellij -a;", R.drawable.intellij, false);
        applicationsList.add(intellij);
        Application vsc = new Application("Vsc", "choco install vsc -a;", R.drawable.vsc, false);
        applicationsList.add(vsc);
    }

}