public interface Promotion {

    /**
     * Returns a promotion discount.
     *
     * @param originalPrice amount to apply discount
     * @param quantity number of items affected by the promotion. this parameter is
     *                 used to determine if we should or should not apply the discount.
     *
     */
    float getPromotionDiscount(float originalPrice, int quantity);
}
