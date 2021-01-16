package com.zatsando.afterformattool;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AlertDialogLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private CheckBox brave_check;
    private CheckBox discord_check;
    private CheckBox mozila_check;
    private CheckBox telegram_check;
    private CheckBox intellij_check;
    private CheckBox vsc_check;
    private CheckBox eclipse_check;
    private CheckBox steam_check;
    private CheckBox geforcenow_check;
    private CheckBox epic_check;
    private CheckBox torrent_check;
    private CheckBox vlc_check;
    private CheckBox anydesk_check;
    ArrayList<String> commands = new ArrayList<>();
    private static final String FILE_NAME = "scriptinstaller.ps1";


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
        steam_check = findViewById(R.id.steam_check);
        geforcenow_check = findViewById(R.id.geforcenow_check);
        epic_check = findViewById(R.id.epic_check);
        torrent_check = findViewById(R.id.torrent_check);
        vlc_check = findViewById(R.id.vlc_check);
        anydesk_check = findViewById(R.id.anydesk_check);
    }

    //read button to send
    public void ready_button(View view) {

        if (commands.isEmpty()) {
            Toast.makeText(getApplicationContext(), "You have to check something, you know...", Toast.LENGTH_SHORT).show();
        }
        else {
            String chocoInstaller = "Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'));";
            String textCommand = commands.toString().replace(",", "").replace("[" , "").replace("]", "");
            String finalCommandFile = chocoInstaller + textCommand;

            //create the ps1 file into the root folder
            FileOutputStream fos = null;
            try {
                fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
                fos.write(finalCommandFile.getBytes());

                Toast.makeText(this, "Saved to " + getFilesDir() + "/" + FILE_NAME,
                        Toast.LENGTH_LONG).show();
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, finalCommandFile);
                sendIntent.setType("application/ps1");
                Intent shareIntent = Intent.createChooser(sendIntent, "scriptinstaller.ps1");
                startActivity(shareIntent);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //clear button
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
        if (steam_check.isChecked()) {
            steam_check.setChecked(false);
        }
        if (geforcenow_check.isChecked()) {
            geforcenow_check.setChecked(false);
        }
        if (epic_check.isChecked()) {
            epic_check.setChecked(false);
        }
        if (torrent_check.isChecked()){
            torrent_check.setChecked(false);
        }
        if (vlc_check.isChecked()){
            vlc_check.setChecked(false);
        }
        if (anydesk_check.isChecked()){
            anydesk_check.setChecked(false);
        }

        Toast.makeText(getApplicationContext(), "Cleared!", Toast.LENGTH_SHORT).show();
    }

    //check buttons functionality
    public void brave_check(View view) {
        if (brave_check.isChecked()) {
            Toast.makeText(getApplicationContext(), "Checked!", Toast.LENGTH_SHORT).show();
            commands.add("choco install brave -a;");
        } else {
            commands.remove("choco install brave -a;");
            Toast.makeText(getApplicationContext(), "Unchecked!", Toast.LENGTH_SHORT).show();
        }
    }

    public void mozila_check(View view) {
        if (mozila_check.isChecked()) {
            Toast.makeText(getApplicationContext(), "Checked!", Toast.LENGTH_SHORT).show();
            commands.add("choco install firefox -a;");
        } else {
            commands.remove("choco install firefox -a;");
            Toast.makeText(getApplicationContext(), "Unchecked!", Toast.LENGTH_SHORT).show();
        }
    }

    public void discord_check(View view) {
        if (discord_check.isChecked()) {
            Toast.makeText(getApplicationContext(), "Checked!", Toast.LENGTH_SHORT).show();
            commands.add("choco install discord -a;");
        } else {
            commands.remove("choco install discord -a;");
            Toast.makeText(getApplicationContext(), "Unchecked!", Toast.LENGTH_SHORT).show();
        }
    }

    public void telegram_check(View view) {
        if (telegram_check.isChecked()) {
            Toast.makeText(getApplicationContext(), "Checked!", Toast.LENGTH_SHORT).show();
            commands.add("choco install telegram -a;");
        } else {
            commands.remove("choco install telegram -a;");
            Toast.makeText(getApplicationContext(), "Unchecked!", Toast.LENGTH_SHORT).show();
        }
    }

    public void intellij_check(View view) {
        if (intellij_check.isChecked()) {
            Toast.makeText(getApplicationContext(), "Checked!", Toast.LENGTH_SHORT).show();
            commands.add("choco install intellij -a;");
        } else {
            commands.remove("choco install intellij -a;");
            Toast.makeText(getApplicationContext(), "Unchecked!", Toast.LENGTH_SHORT).show();
        }
    }

    public void vsc_check(View view) {
        if (vsc_check.isChecked()) {
            Toast.makeText(getApplicationContext(), "Checked!", Toast.LENGTH_SHORT).show();
            commands.add("choco install vsc -a;");
        } else {
            commands.remove("choco install vsc -a;");
            Toast.makeText(getApplicationContext(), "Unchecked!", Toast.LENGTH_SHORT).show();
        }
    }

    public void eclipse_check(View view) {
        if (eclipse_check.isChecked()) {
            Toast.makeText(getApplicationContext(), "Checked!", Toast.LENGTH_SHORT).show();
            commands.add("choco install eclipse -a;");
        } else {
            commands.remove("choco install eclipse -a;");
            Toast.makeText(getApplicationContext(), "Unchecked!", Toast.LENGTH_SHORT).show();
        }
    }

    public void steam_check(View view) {
        if (steam_check.isChecked()) {
            Toast.makeText(getApplicationContext(), "Checked!", Toast.LENGTH_SHORT).show();
            commands.add("choco install steam -a;");
        } else {
            commands.remove("choco install steam -a;");
            Toast.makeText(getApplicationContext(), "Unchecked!", Toast.LENGTH_SHORT).show();
        }
    }

    public void geforcenow_check(View view) {
        if (geforcenow_check.isChecked()) {
            Toast.makeText(getApplicationContext(), "Checked!", Toast.LENGTH_SHORT).show();
            commands.add("choco install nvidia-geforce-now -a;");
        } else {
            commands.remove("choco install nvidia-geforce-now -a;");
            Toast.makeText(getApplicationContext(), "Unchecked!", Toast.LENGTH_SHORT).show();
        }
    }

    public void epic_check(View view) {
        if (epic_check.isChecked()) {
            Toast.makeText(getApplicationContext(), "Checked!", Toast.LENGTH_SHORT).show();
            commands.add("choco install epicgameslauncher -a;");
        } else {
            commands.remove("choco install epicgameslauncher -a;");
            Toast.makeText(getApplicationContext(), "Unchecked!", Toast.LENGTH_SHORT).show();
        }
    }

    public void torrent_check(View view) {
        if (torrent_check.isChecked()) {
            Toast.makeText(getApplicationContext(), "Checked!", Toast.LENGTH_SHORT).show();
            commands.add("choco install qbittorrent -a;");
        } else {
            commands.remove("choco install qbittorrent -a;");
            Toast.makeText(getApplicationContext(), "Unchecked!", Toast.LENGTH_SHORT).show();
        }
    }

    public void vlc_check(View view) {
        if (vlc_check.isChecked()) {
            Toast.makeText(getApplicationContext(), "Checked!", Toast.LENGTH_SHORT).show();
            commands.add("choco install vlc -a;");
        } else {
            commands.remove("choco install vlc -a;");
            Toast.makeText(getApplicationContext(), "Unchecked!", Toast.LENGTH_SHORT).show();
        }
    }

    public void anydesk_check(View view) {
        if (anydesk_check.isChecked()) {
            Toast.makeText(getApplicationContext(), "Checked!", Toast.LENGTH_SHORT).show();
            commands.add("choco install anydesk -a;");
        } else {
            commands.remove("choco install anydesk -a;");
            Toast.makeText(getApplicationContext(), "Unchecked!", Toast.LENGTH_SHORT).show();
        }
    }

}