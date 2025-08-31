/**
 * 
 */
package com.xyz.booking.strategy;

/**
 * @author PrasadBonam
 *
 */
 
public class ThirdTicketHalfOffStrategy implements DiscountStrategy {
    @Override
    public int apply(int subtotalCents, DiscountContext ctx) {
        if (ctx.seatCount() < 3) return 0;
        int pricePerSeat = subtotalCents / ctx.seatCount();
        // 50% off the third ticket once
        return pricePerSeat / 2;
    }

    @Override
    public String code() { return "THIRD_TICKET_50PCT"; }
}
