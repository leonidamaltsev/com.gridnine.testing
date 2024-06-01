package com.gridnine.testing;

import com.gridnine.testing.models.Flight;
import com.gridnine.testing.rules.DepartureAfterTimeRule;
import com.gridnine.testing.rules.MaxHoursChangingRule;
import com.gridnine.testing.rules.NoErrorTimeSegmentsRule;
import com.gridnine.testing.service.FlightBuilder;
import com.gridnine.testing.service.SorterFlights;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        SorterFlights sorterFlights = new SorterFlights();

        System.out.println("The list of flights with right time segments:");
        sorterFlights.getFlightsAccordingRules(
                flights, List.of(
                        new NoErrorTimeSegmentsRule()
                )
        ).forEach(System.out::println);
        System.out.println();

        System.out.println("The list of flights with right time segments and "
                + "departure time before tomorrow the same time:");
        sorterFlights.getFlightsAccordingRules(
                flights, List.of(
                        new DepartureAfterTimeRule(LocalDateTime.now().minusDays(1)),
                        new NoErrorTimeSegmentsRule()
                )
        ).forEach(System.out::println);
        System.out.println();

        System.out.println("The list of flights with right time segments, "
                + "up to 2 hours changing time and departures before 4 days later:");
        sorterFlights.getFlightsAccordingRules(
                flights, List.of(
                        new DepartureAfterTimeRule(LocalDateTime.now().minusDays(4)),
                        new MaxHoursChangingRule(2),
                        new NoErrorTimeSegmentsRule()
                )
        ).forEach(System.out::println);
    }
}
