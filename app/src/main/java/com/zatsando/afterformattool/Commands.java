package com.zatsando.afterformattool;

public class Commands {
    String name;
    int id;
    String command;

    public Commands(String name, int id, String command) {
        this.name = name;
        this.id = id;
        this.command = command;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
