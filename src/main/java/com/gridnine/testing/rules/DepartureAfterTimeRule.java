package com.gridnine.testing.rules;

import com.gridnine.testing.models.Flight;

import java.time.LocalDateTime;

public class DepartureAfterTimeRule implements Rule {
    private final LocalDateTime timePoint;

    public DepartureAfterTimeRule(LocalDateTime timePoint) {
        this.timePoint = timePoint;
    }

    @Override
    public boolean test(Flight flight) {
        return flight.getSegments().get(0).getDepartureDate()
                .isAfter(timePoint);
    }
}
