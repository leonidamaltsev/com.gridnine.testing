package com.gridnine.testing.rules;

import com.gridnine.testing.models.Flight;
import com.gridnine.testing.service.FlightBuilder;
import com.gridnine.testing.service.SorterFlights;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

public class DepartureAfterTimeRuleTest {
    private final SorterFlights sorterFlights = new SorterFlights();
    private final List<Flight> flights = FlightBuilder.createFlights();

    @Test
    public void whenGetDepartureAfter3DaysThenGetTheSameFlight() {
        DepartureAfterTimeRule rule = new DepartureAfterTimeRule(LocalDateTime.now().plusDays(3));
        Flight expected = FlightBuilder.createFlight(
                LocalDateTime.now().plusDays(4), LocalDateTime.now().plusDays(4).plusHours(2)
        );
        List<Flight> result = sorterFlights.getFlightsAccordingRules(
                flights, List.of(rule)
        );
        assertEquals(expected, result.get(0));
    }

    @Test
    public void whenGetDepartureFromNowThenGet5Flights() {
        var rule = new DepartureAfterTimeRule(LocalDateTime.now());
        List<Flight> result = sorterFlights.getFlightsAccordingRules(
                flights, List.of(rule)
        );
        assertThat(5, is(result.size()));
    }
}