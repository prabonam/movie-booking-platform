/**
 * 
 */
package com.xyz.common.util;

/**
 * @author PrasadBonam
 *
 */

public class DiscountUtil {

    public static double applyThirdTicketDiscount(double totalPrice, int ticketCount) {
        if (ticketCount >= 3) {
            double discount = totalPrice / ticketCount * 0.5; // 50% off one ticket
            return totalPrice - discount;
        }
        return totalPrice;
    }

    public static double applyAfternoonShowDiscount(double totalPrice, int hour) {
        if (hour >= 12 && hour < 16) {
            return totalPrice * 0.8; // 20% discount
        }
        return totalPrice;
    }
}

