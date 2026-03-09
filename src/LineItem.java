public class LineItem {
    //Store product, quantity, total price
    private Product product;
    private int quantity;
    private double totalPrice;

    //Constructor
    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        calculateTotalPrice();
    }

    //Calculate total price
    private void calculateTotalPrice() {
        // Assuming Product has a method getPrice()
        totalPrice = product.getPrice() * quantity;
    }

    //Getters
    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
