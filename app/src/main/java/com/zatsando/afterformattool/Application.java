package com.zatsando.afterformattool;

public class Application {
    private String appName;
    private String command;
    private int imageOfApp;
    private boolean isChecked;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public int getImageOfApp() {
        return imageOfApp;
    }

    public void setImageOfApp(int imageOfApp) {
        this.imageOfApp = imageOfApp;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public Application() {
    }

    public Application(String appName, String command, int imageOfApp, boolean isChecked) {
        this.appName = appName;
        this.command = command;
        this.imageOfApp = imageOfApp;
        this.isChecked = isChecked;
    }
}
