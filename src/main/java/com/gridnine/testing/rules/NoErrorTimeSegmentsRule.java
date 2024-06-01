package com.gridnine.testing.rules;

import com.gridnine.testing.models.Flight;
import com.gridnine.testing.models.Segment;

import java.util.ArrayList;
import java.util.List;

public class NoErrorTimeSegmentsRule implements Rule {

    @Override
    public boolean test(Flight flight) {
        boolean result = true;
        List<Segment> list = new ArrayList<>(flight.getSegments());
        Segment[] segments = list.toArray(new Segment[0]);
        for (int i = 0; i < segments.length; i++) {
            if (segments[i].getDepartureDate().isAfter(segments[i].getArrivalDate())) {
                return false;
            }
        }
        return result;
    }
}
