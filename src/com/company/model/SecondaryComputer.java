package com.company.model;

import java.util.List;

// TODO: 4/20/22 add toString
public class SecondaryComputer extends Computer {

    public SecondaryComputer(String id) {
        super(id, null);
    }

    @Override
    public void showNotification(String message, Computer from) {
        throw new UnsupportedOperationException(getPrefix() + " is unable to retrieve a message from " + from.getPrefix());
    }

    @Override
    public void turnOnForAll(List<Computer> secondaryComputers) {
        throw new UnsupportedOperationException(getPrefix() + " is unable to show turn on computers: " + getIds(secondaryComputers));
    }

    @Override
    public void turnOffForAll(List<Computer> secondaryComputers) {
        throw new UnsupportedOperationException(getPrefix() + " is unable to show turn off computers: " + getIds(secondaryComputers));
    }

    @Override
    public void reboot(List<Computer> secondaryComputers) {
        throw new UnsupportedOperationException(getPrefix() + " is unable to show turn off computers: " + getIds(secondaryComputers));
    }

    @Override
    public String toString() {
        return "SecondaryComputer{" +
                "id='" + id + '\'' +
                ", status=" + status +
                '}';
    }
}
