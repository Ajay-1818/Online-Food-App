import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<MenuItem> menu = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        MenuList();

        Order order = new Order();

        while (true) {

            System.out.println("\n1. View Menu\n2. Add Item to Order\n3. Remove Item from Order\n4. View Order\n5. Checkout\n6. Exit");

            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            scanner.nextLine();

            try {

                switch (choice) {

                    case 1:

                        showMenu();

                        break;

                    case 2:

                        System.out.print("Enter item name to add: ");

                        String addItem = scanner.nextLine();

                        MenuItem foundItem = findMenuItem(addItem);

                        if (foundItem != null) {

                            order.addItem(foundItem);

                            System.out.println("Added: " + foundItem);

                        } else {

                            System.out.println("Item not found.");

                        }

                        break;

                    case 3:

                        System.out.print("Enter item name to remove: ");

                        String removeItem = scanner.nextLine();

                        order.removeItem(removeItem);

                        System.out.println("Item removed.");

                        break;

                    case 4:

                        System.out.println("Your Order:");

                        order.showOrder();

                        break;

                    case 5:

                        double total = order.calculateTotal();

                        System.out.println("Total: Rs." + total);

                        System.out.print("Pay with (1) Credit Card or (2) Cash: ");

                        int payOption = scanner.nextInt();

                        PaymentMethod payment;

                        if (payOption == 1) {

                            payment = new CreditCardPayment();

                        } else {

                            payment = new CashPayment();

                        }

                        payment.pay(total);

                        return;

                    case 6:

                        System.out.println("Thank u");

                        return;

                    default:

                        System.out.println("Invalid option.");

                }

            } catch (ItemNotFoundException e) {

                System.out.println(e.getMessage());

            }

        }

    }

    private static void MenuList() {

        menu.add(new MenuItem(" ", 5.99, Category.Starters));

        menu.add(new MenuItem("Burger", 8.99, Category.Meals));

        menu.add(new MenuItem("Ice Cream", 3.49, Category.Desserts));

        menu.add(new MenuItem("Coffee", 2.99, Category.Drinks));

    }

    private static void showMenu() {

        System.out.println("----- Menu -----");

        for (MenuItem item : menu) {

            System.out.println(item);

        }

    }

    private static MenuItem findMenuItem(String name) {

        for (MenuItem item : menu) {

            if (item.getName().equalsIgnoreCase(name)) {

                return item;


            }

        }

        return null;

    }

}
