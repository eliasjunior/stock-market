package org.labs.ej.stockMarket.domain.util;

import java.util.UUID;

public interface IdGenerator {
    // just very basic idGenerator for demonstration
    default Long generateId() {
        return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }
}
