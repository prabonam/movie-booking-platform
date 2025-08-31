/**
 * 
 */
package com.xyz.booking.strategy;

/**
 * @author PrasadBonam
 *
 */
package com.xyz.booking.strategy;

public class AfternoonTwentyPercentStrategy implements DiscountStrategy {
    @Override
    public int apply(int subtotalCents, DiscountContext ctx) {
        if (!ctx.isAfternoon()) return 0;
        return (int) Math.floor(subtotalCents * 0.20);
    }

    @Override
    public String code() { return "AFTERNOON_20PCT"; }
}
