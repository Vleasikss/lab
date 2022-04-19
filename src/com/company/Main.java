package com.company;

import com.company.model.Computer;
import com.company.model.MainComputer;
import com.company.model.SecondaryComputer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

// TODO: 4/20/22 remove extra code
public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Computer mainComputer = new MainComputer("100");

    // TODO: 4/20/22 provide documentation
    public static void main(String[] args) {

        // TODO: 4/20/22 handle case if user input some invalid data
        System.out.print("Input a count of secondary computers: ");
        int n = scanner.nextInt();

        List<Computer> computers = generateSecondaryComputers(n);
        computers.forEach(c -> c.notifyMainComputer(mainComputer, "some-error-" + UUID.randomUUID()));

        // TODO: 4/20/22 provide more tests, JUNIT ?
        Computer someComputer = computers.get(0);
        try {
            someComputer.showError("error", mainComputer.getId());
        } catch (UnsupportedOperationException e) {
            mainComputer.showError(e.getMessage(), someComputer.getId());
        }

        mainComputer.turnOnForAll(computers);
        mainComputer.turnOffForAll(computers);
    }

    private static List<Computer> generateSecondaryComputers(int n) {
        List<Computer> computers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Computer someComputer = new SecondaryComputer(String.valueOf(i + 1));
            computers.add(someComputer);
        }

        return computers;
    }
}
