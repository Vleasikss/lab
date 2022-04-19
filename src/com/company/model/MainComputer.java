package com.company.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainComputer extends Computer {

    public MainComputer(String id) {
        super(id, null, true);
    }

    @Override
    public void notifyMainComputer(Computer computer, String error) {
        throw new UnsupportedOperationException("main computer can't notify itself");
    }

    @Override
    public void showError(String error, String from) {
        String errorMessage = getPrefix() + " retrieved an error from " + from + ": " + error;
        System.out.println(errorMessage);
    }

    @Override
    public void turnOnForAll(List<Computer> secondaryComputers) {
        Stream<String> stringStream = secondaryComputers.stream().map(c -> c.id);
        System.out.println(getPrefix() + " turned secondary computers " + stringStream.collect(Collectors.joining(", ")) + " to status " + Status.ON);
    }

    @Override
    public void turnOffForAll(List<Computer> secondaryComputers) {
        Stream<String> stringStream = secondaryComputers.stream().map(c -> c.id);
        System.out.println(getPrefix() + " turned secondary computers " + stringStream.collect(Collectors.joining(", ")) + " to status " + Status.OFF);
    }

    @Override
    public void reboot(List<Computer> secondaryComputers) {
        turnOffForAll(secondaryComputers);
        turnOnForAll(secondaryComputers);
    }

}
