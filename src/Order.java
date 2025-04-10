import java.util.ArrayList;
import java.util.List;

class Order {
    private List<MenuItem> orderedItems;
    public Order() {
        orderedItems = new ArrayList<>();
    }
    public void addItem(MenuItem item) {
        orderedItems.add(item);
    }
    public void removeItem(String itemName) throws ItemNotFoundException {
        boolean removed = orderedItems.removeIf(item -> item.getName().equalsIgnoreCase(itemName));
        if (!removed) {
            throw new ItemNotFoundException("Item '" + itemName + "' not found in your order.");
        }
    }
    public double calculateTotal() {
        double total = 0;
        for (MenuItem item : orderedItems) {
            total += item.getPrice();
        }
        return total;
    }
    public void showOrder() {
        if (orderedItems.isEmpty()) {
            System.out.println("Your order is empty.");
            return;
        }
        for (MenuItem item : orderedItems) {
            System.out.println(item);
        }
    }
}