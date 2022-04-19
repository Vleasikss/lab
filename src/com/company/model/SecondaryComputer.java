package com.company.model;

import java.util.List;

// TODO: 4/20/22 add toString
public class SecondaryComputer extends Computer {

    public SecondaryComputer(String id) {
        super(id, null, false);
    }

    @Override
    public void notifyMainComputer(Computer computer, String message) {
        computer.showError(message, this.id);
    }

    @Override
    public void showError(String error, String from) {
        throw new UnsupportedOperationException("secondary is unable to show errors");
    }

    @Override
    public void turnOnForAll(List<Computer> secondaryComputers) {
        throw new UnsupportedOperationException("secondary is unable to show turn on all computers");
    }

    @Override
    public void turnOffForAll(List<Computer> secondaryComputers) {
        throw new UnsupportedOperationException("secondary is unable to show turn off all computers");
    }

    @Override
    public void reboot(List<Computer> secondaryComputers) {
        throw new UnsupportedOperationException("secondary is unable to show turn off all computers");
    }

    @Override
    public String toString() {
        return "SecondaryComputer{" +
                "id='" + id + '\'' +
                ", status=" + status +
                '}';
    }
}
