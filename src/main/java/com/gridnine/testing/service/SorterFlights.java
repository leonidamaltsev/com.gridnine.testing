package com.gridnine.testing.service;

import com.gridnine.testing.models.Flight;
import com.gridnine.testing.rules.Rule;

import java.util.ArrayList;
import java.util.List;

public class SorterFlights {
    public List<Flight> getFlightsAccordingRules(List<Flight> flights, List<Rule> rules) {
        List<Flight> result = new ArrayList<>();
        try {
            for (Flight flight : flights) {
                boolean res = true;
                for (Rule rule : rules) {
                    if (!rule.test(flight)) {
                        res = false;
                        break;
                    }
                }
                if (res) {
                    result.add(flight);
                }
            }
        } catch (NullPointerException | IllegalArgumentException npe) {
            System.out.println("Flights list or rules list must not be empty!");
        }
        return result;
    }
}
