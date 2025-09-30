//Tamya Burch
//Comp 170 Fall 25
//C. Fulton
//JDoodle
import java.util.Scanner;

public class VendingMachine {
    public static void main(String args[]) {
        final String[][] MENU_ITEMS = {
            {"Garrett Mix", "Caramel Crisps", "Cheese Corn"},
            {"Pecan Caramel Crisps", "Cashew Caramel Crisps", "Almond Caramel Crisps"},
            {"Plain", "Buttery", " Sweet Corn"}
        };

        Double[][] prices = {
            {14.99, 10.99, 6.99},
            {16.99, 9.99, 8.99},
            {12.99, 11.99, 7.99}
        };

        int itemsPurchased = 0;
        double totalPrice = 0.0;
        double price;
        char selectedColumn;
        int row;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Garrett's Popcorn Vending Machine");
        System.out.println("Row\t Column P\t Column N\t Column R");

        for (row = 0; row < 100; row++) { 
            
            for (int i = 0; i < MENU_ITEMS.length; i++) {
                System.out.print(i + "\t"); 
                for (int column = 0; column < MENU_ITEMS[i].length; column++) {
                    System.out.print(MENU_ITEMS[i][column]);
                    if (column < MENU_ITEMS[i].length - 1) {
                        System.out.print("\t");
                    }
                }
                System.out.println();
            }

            System.out.println("Listed above are items you can select.");
            System.out.println("Please enter row of desired product or -1 to EXIT: ");
            int selectedRow = scanner.nextInt();

            if (selectedRow == -1) {
                System.out.println("Summary of items purchased:");
                System.out.println("*****************************");
                System.out.println(itemsPurchased + " items purchased for a total cost of $" + totalPrice);
                scanner.close();
                return;
            }

            if (selectedRow < 0 || selectedRow > 2) { 
                System.out.println("Invalid entry, Please enter row of desired products: ");
                selectedRow = scanner.nextInt();
                row--; 
            } else {
                System.out.println("Please enter column of desired product: ");
                selectedColumn = scanner.next().charAt(0);
                int columnNum = -1;

                if (selectedColumn == 'P') {
                    columnNum = 0;
                } else if (selectedColumn == 'N') {
                    columnNum = 1;
                } else if (selectedColumn == 'R') {
                    columnNum = 2;
                } else {
                    System.out.println("Invalid Entry, Please enter either capital P, N or R of desired product: ");
                    selectedColumn = scanner.next().charAt(0);
                    if (selectedColumn == 'P') {
                        columnNum = 0;
                    } else if (selectedColumn == 'N') {
                        columnNum = 1;
                    } else if (selectedColumn == 'R') {
                        columnNum = 2;
                    }
                    row--; 
                    row--;
                }
    

                if (columnNum != -1) {
                    String product = MENU_ITEMS[selectedRow][columnNum];
                    price = prices[selectedRow][columnNum]; 
                    System.out.println("You have selected " + product + " for a price of $" + price);
                    itemsPurchased++;
                    totalPrice += price;
                }
            }
        }
        scanner.close();
    }
}