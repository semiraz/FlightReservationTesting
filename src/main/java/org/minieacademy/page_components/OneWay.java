package org.minieacademy.page_components;

import org.minieacademy.abstract_components.SearchFlightAvailability;

import java.util.HashMap;

public class OneWay implements SearchFlightAvailability {
    @Override
    public void checkAvailability(HashMap<String, String> reservationDetails) {
        System.out.println("One Way");
    }
}
