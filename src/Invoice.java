import java.util.ArrayList;

public class Invoice {
    private Address address;
    private ArrayList<LineItem> items;

    public Invoice() {
        items = new ArrayList<>();
    }

    public Invoice(Address address) {
        this.address = address;
    }

    public Invoice(Address address, ArrayList<LineItem> items) {
        this.address = address;
        this.items = items;
    }

    public void addItem(Product product, int quantity) {
        LineItem item = new LineItem(product, quantity);
        items.add(item);
    }

    public void addItem(LineItem item) {
        items.add(item);
    }

    public void addItems(ArrayList<LineItem> items) {
        this.items.addAll(items);
    }

    public void getAmountDue() {
        double total = 0.0;
        for(LineItem item : items) {
            total += item.getTotalPrice();
        }
        System.out.println("Total Amount Due: $" + total);
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append("Invoice:\n");
        if(address != null) {
            sb.append(address).append("\n");
        }
        sb.append("=====================\n");
        sb.append("Items:\n");
        for(LineItem item : items) {
            sb.append(item.getProduct().getName())
              .append(" - Quantity: ").append(item.getQuantity())
              .append(", Total Price: $").append(item.getTotalPrice())
              .append("\n");
        }
        sb.append("======================\n");
        sb.append("Amount Due: $").append(items.stream().mapToDouble(LineItem::getTotalPrice).sum());
        return sb.toString();
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
