import java.util.ArrayList;

public class Invoice {
    //Store title, customer address, line items, total amount
    private String title;
    private Address customerAddress;
    private ArrayList<LineItem> lineItems;
    private double totalAmount;

    //Constructor
    public Invoice(String title, Address customerAddress, ArrayList<LineItem> lineItems) {
        this.title = title;
        this.customerAddress = customerAddress;
        this.lineItems = lineItems;
        calculateTotalAmount();
    }

    //Calculate total amount
    private void calculateTotalAmount() {
        totalAmount = 0;
        for (LineItem item : lineItems) {
            totalAmount += item.getTotalPrice();
        }
    }

    //Getters
    public String getTitle() {
        return title;
    }

    public Address getCustomerAddress() {
        return customerAddress;
    }

    public ArrayList<LineItem> getLineItems() {
        return lineItems;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setAddress(Address address) {
        this.customerAddress = address;
    }

    public void addItem(LineItem item) {
        lineItems.add(item);
        calculateTotalAmount();
    }
}
