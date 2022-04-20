package com.company.model;

import java.util.List;

public abstract class Computer {

    protected String id;
    protected Status status;
    protected boolean isMain;

    public Computer(String id, Status status, boolean isMain) {
        this.id = id;
        this.status = status;
        this.isMain = isMain;
    }

    public void notifyMainComputer(Computer computer, String message) {
        computer.showError(message, this.id);
    }

    public abstract void showError(String error, String from);

    public abstract void turnOnForAll(List<Computer> secondaryComputers);

    public abstract void turnOffForAll(List<Computer> secondaryComputers);

    public abstract void reboot(List<Computer> secondaryComputers);

    protected String getPrefix() {
        return "Main-" + this.id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isMain() {
        return isMain;
    }

    public void setMain(boolean main) {
        isMain = main;
    }

}
