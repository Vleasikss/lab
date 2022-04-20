package com.company.model;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Computer {

    protected String id;
    protected Status status;
    protected boolean isMain;

    public Computer(String id, Status status, boolean isMain) {
        this.id = id;
        this.status = status;
        this.isMain = isMain;
    }

    public void notifyMainComputer(Computer mainComputer, String message) {
        try {
            mainComputer.showNotification(message, this);
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
    }

    public abstract void showNotification(String message, Computer from);

    public abstract void turnOnForAll(List<Computer> secondaryComputers);

    public abstract void turnOffForAll(List<Computer> secondaryComputers);

    public abstract void reboot(List<Computer> secondaryComputers);

    protected abstract String getPrefix();

    protected static String getIds(List<Computer> computers) {
        return computers.stream().map(c -> c.id).collect(Collectors.joining(", "));
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
