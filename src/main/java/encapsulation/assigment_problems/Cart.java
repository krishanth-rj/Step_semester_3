package encapsulation.assigment_problems;

public class Cart {
    private final String cartId;
    private final int[] prices;
    private int itemCount;

    public Cart(String cartId, int maximumItems) {
        if (maximumItems < 0) throw new IllegalArgumentException("Maximum item count cannot be negative.");
        this.cartId = cartId;
        prices = new int[maximumItems];
    }

    public boolean addItem(int price) {
        if (itemCount == prices.length) return false;
        prices[itemCount++] = price;
        return true;
    }

    public int getTotal() {
        int total = 0;
        for (int i = 0; i < itemCount; i++) total += prices[i];
        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getCartId() {
        return cartId;
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);
        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item count: " + cart.getItemCount());
    }
}
