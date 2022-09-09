package com.klymchuk.elevator.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class CommandLineService implements CommandLineRunner {
    private final PrintService printService;
    private final BuildingService buildingService;
    private final PersonService personService;

    public CommandLineService(PrintService printService, BuildingService buildingService, PersonService personService) {
        this.printService = printService;
        this.buildingService = buildingService;
        this.personService = personService;
    }

    @Override
    public void run(String... args) throws Exception {
        buildingService.addPersons(personService.get());
        printService.print(buildingService.get());

        for (int i = 0; i < 100; i++) {
            buildingService.moveElevator();
            printService.print(buildingService.get());
        }
    }
}
