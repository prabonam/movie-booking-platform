/**
 * 
 */
package com.xyz.booking.strategy;

/**
 * @author PrasadBonam
 *
 */

import com.xyz.booking.entity.Show;

public interface DiscountStrategy {
    /**
     * @param subtotalCents current subtotal in cents
     * @param ctx context for discount calculation
     * @return discount amount in cents
     */
    int apply(int subtotalCents, DiscountContext ctx);
    String code();
}
