package com.gridnine.testing.rules;

import com.gridnine.testing.models.Flight;

public interface Rule {
    boolean test(Flight flight);
}
