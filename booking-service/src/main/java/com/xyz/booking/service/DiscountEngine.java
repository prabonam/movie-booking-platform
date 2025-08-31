/**
 * 
 */
package com.xyz.booking.service;

/**
 * @author PrasadBonam
 *
 */

import com.xyz.booking.strategy.AfternoonTwentyPercentStrategy;
import com.xyz.booking.strategy.DiscountContext;
import com.xyz.booking.strategy.DiscountStrategy;
import com.xyz.booking.strategy.ThirdTicketHalfOffStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DiscountEngine {
    private final List<DiscountStrategy> strategies = List.of(
            new AfternoonTwentyPercentStrategy(),
            new ThirdTicketHalfOffStrategy()
    );

    /**
     * For now pick the single best discount (max). If you need to compose discounts, change logic here.
     */
    public int calculateDiscountCents(int subtotalCents, DiscountContext ctx) {
        return strategies.stream()
                .mapToInt(s -> s.apply(subtotalCents, ctx))
                .max()
                .orElse(0);
    }
}

