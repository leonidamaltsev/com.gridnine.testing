package com.gridnine.testing.rules;

import com.gridnine.testing.models.Flight;
import com.gridnine.testing.models.Segment;

import java.time.temporal.ChronoUnit;
import java.util.List;

public class MaxHoursChangingRule implements Rule {
    private final long changingHours;

    public MaxHoursChangingRule(long changingHours) {
        this.changingHours = changingHours;
    }

    @Override
    public boolean test(Flight flight) {
        long groundMinutes = 0;
        List<Segment> list = flight.getSegments();
        Segment[] segments = list.toArray(new Segment[0]);
        for (int i = 0; i < segments.length - 1; i++) {
            groundMinutes += segments[i].getArrivalDate().until(
                    segments[i + 1].getDepartureDate(), ChronoUnit.MINUTES
            );
            if (groundMinutes / 60 > changingHours) {
                return false;
            }
        }
        return true;
    }
}
