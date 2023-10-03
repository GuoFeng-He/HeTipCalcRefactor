import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome user");
        // initializes variables
        System.out.print("Number of people eating: ");
        int peopleEating = scan.nextInt();
        System.out.print("Tip Percentage? (as an int): ");
        int tipPercentage = scan.nextInt();
        StringBuilder itemList = new StringBuilder();
        double itemCost = 0;

        TipCalculator t = new TipCalculator(peopleEating, tipPercentage);

        while (itemCost != -1) {
            System.out.print("\nEnter a cost in dollars and cents, (e.g. 12.50) -1 to end: ");
            itemCost = scan.nextDouble();
            scan.nextLine();
            if (itemCost != -1) {
                System.out.print("Enter item name: ");
                String itemName = scan.nextLine();
                System.out.print("Enter amount: ");
                int amount = scan.nextInt();
                itemList.append(itemName).append(" (").append(amount).append("x)").append("(Cost: $").append(itemCost).append(" each)").append("\n"); // adding spaces courtesy of: https://stackoverflow.com/questions/7833689/how-can-i-print-a-string-adding-newlines-in-java
                t.addMeal(itemCost);
            }
        }
        scan.close();

        // prints the receipt
        System.out.println("----------------------");
        System.out.println("Total bill before tip: $" + t.getTotalBillBeforeTip());
        System.out.println("Total Percentage: " + t.getTipPercentage() + "%");
        System.out.println("Total Tip: $" + String.format("%.2f", t.tipAmount()));
        System.out.println("Total bill with tip: $" + String.format("%.2f", t.totalBill()));
        System.out.println("Per person cost before tip: $" + String.format("%.2f", t.perPersonCostBeforeTip()));
        System.out.println("Tip per person: $" + String.format("%.2f", t.perPersonTipAmount()));
        System.out.println("Number of people eating: " + t.getNumPeople());
        System.out.println("Total cost per person: $" + String.format("%.2f", t.perPersonTotalCost()));
        System.out.println("------------------------");
        System.out.println("Items Ordered:");
        System.out.println(itemList);
    }
}