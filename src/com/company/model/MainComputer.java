package com.company.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// TODO: 4/20/22 add toString
public class MainComputer extends Computer {

    public MainComputer(String id) {
        super(id, null, true);
    }

    @Override
    public void notifyMainComputer(Computer computer, String error) {
        throw new UnsupportedOperationException("main computer can't notify itself");
    }

    // TODO: 4/20/22 handle case if showError has id from MainComputer
    @Override
    public void showError(String error, String from) {
        String errorMessage = getPrefix() + " retrieved an error from " + from + ": " + error;
        System.out.println(errorMessage);
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

    private static String getIds(List<Computer> computers) {
        return computers.stream().map(c -> c.id).collect(Collectors.joining(", "));
    }
}
