package com.company.model;

import java.util.List;

// TODO: 4/20/22 add toString
public class MainComputer extends Computer {

    public MainComputer(String id) {
        super(id, null);
    }

    // TODO: 4/20/22 handle case if showError has id from MainComputer
    @Override
    public void showNotification(String message, Computer from) {
        System.out.println(getPrefix() + " retrieved a message from " + from.getPrefix() + ": " + message);
    }

    // TODO: 4/20/22 handle case if List<Computer> secondaryComputers contain object instance of MainComputer
    @Override
    public void turnOnForAll(List<Computer> secondaryComputers) {
        String ids = getIds(secondaryComputers);
        System.out.println(getPrefix() + " turned secondary computers " + ids + " to status " + Status.ON);
    }

    // TODO: 4/20/22 handle case if List<Computer> secondaryComputers contain object instance of MainComputer
    @Override
    public void turnOffForAll(List<Computer> secondaryComputers) {
        String ids = getIds(secondaryComputers);
        System.out.println(getPrefix() + " turned secondary computers " + ids + " to status " + Status.OFF);
    }

    @Override
    public void reboot(List<Computer> secondaryComputers) {
        turnOffForAll(secondaryComputers);
        turnOnForAll(secondaryComputers);
    }

    @Override
    public String toString() {
        return "MainComputer{" +
                "id='" + id + '\'' +
                ", status=" + status +
                '}';
    }
}
