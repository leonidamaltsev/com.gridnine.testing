package com.gridnine.testing.rules;

import com.gridnine.testing.models.Flight;
import com.gridnine.testing.service.FlightBuilder;
import com.gridnine.testing.service.SorterFlights;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class MaxHoursChangingRuleTest {
    private final SorterFlights sorterFlights = new SorterFlights();
    private final List<Flight> flights = FlightBuilder.createFlights();

    @Test
    public void whenGetDeparturesLess1HourTransferThenGet4Flights() {
        var rule = new MaxHoursChangingRule(1);
        List<Flight> result = sorterFlights.getFlightsAccordingRules(
                flights, List.of(rule)
        );
        assertThat(4, is(result.size()));
    }

    @Test
    public void whenGetDeparturesWithoutTransfersThenGet3Flights() {
        var rule = new MaxHoursChangingRule(0);
        List<Flight> result = sorterFlights.getFlightsAccordingRules(
                flights, List.of(rule)
        );
        assertThat(3, is(result.size()));
    }
}