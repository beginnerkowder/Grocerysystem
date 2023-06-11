import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;

public class GrocerySystem {
    public static void main(String[] args) {
        ArrayList<String> productNames = new ArrayList<String>();
        ArrayList<Integer> productQuantity = new ArrayList<Integer>();
        ArrayList<Double> productPrice = new ArrayList<Double>();
        menu();
        order(productNames, productQuantity, productPrice);
    }

    public static Scanner input = new Scanner(System.in);
    public static String decision;
    public static int choose, quantity = 1;
    public static double total = 0, pay;

    public static void menu() {
        System.out.println("====================================");
        System.out.println("\t     Dhaniel's Grocery          ");
        System.out.println("MEATS:");
        System.out.println("1. BEEF 1kg              Php. 348.75");
        System.out.println("2. PORK 1kg              Php. 288.48");
        System.out.println("3. CHICKEN 1kg           Php. 180.00");
        System.out.println("DAIRY PRODUCTS:");
        System.out.println("4. BUTTER                Php. 56.55");
        System.out.println("5. MILK                  Php. 168.00");
        System.out.println("6. MARGARINE             Php. 59.00");
        System.out.println("BAKED GOODS:");
        System.out.println("7. TASTY                 Php. 42.50");
        System.out.println("8. PANDESAL              Php. 30.00");
        System.out.println("9. BAGUETTE              Php. 108.00");
        System.out.println("CANNED GOODS:");
        System.out.println("10. SARDINES             Php. 151.00");
        System.out.println("11. PORK&BEANS           Php. 150.00");
        System.out.println("12. TUNA                 Php. 70.00");
        System.out.println("CONDIMENTS:");
        System.out.println("13. SUGAR 500g           Php. 106.00");
        System.out.println("14. SALT 500g            Php. 25.75");
        System.out.println("15. PEPPER 500g          Php. 65.00");
        System.out.println("====================================");
    }

    public static void order(ArrayList<String> productNames, ArrayList<Integer> productQuantity, ArrayList<Double> productPrice) {
        System.out.println("Type the number of the product that you want to add to cart. Type 0 to Cancel.");
        System.out.print("Add to cart: ");
        choose = input.nextInt();

        if (choose == 1) {

            System.out.println("BEEF");
            System.out.print("Quantity:");
            quantity = input.nextInt();
            total = total + (quantity * 348.75);

            if (productNames.contains("BEEF")) {
                int index = productNames.indexOf("BEEF");

                int newQuantity = productQuantity.get(index) + quantity;

                productQuantity.set(index, newQuantity);
                productPrice.set(index, 348.75 * Double.valueOf(newQuantity));

            } else {
                productNames.add("BEEF");
                productQuantity.add(quantity);
                productPrice.add(348.75 * Double.valueOf(quantity));
            }

            System.out.println("Do you want to buy again? ");
            System.out.print("Press Y for Yes and N for No : ");
            decision = input.next();
            if (decision.equalsIgnoreCase("Y")) {
                order(productNames, productQuantity, productPrice);
            }
        } else {
            System.out.println("Enter your payment: ");
            pay = input.nextDouble();
            if (pay <= total) {
                System.out.println("Not enough payment");

                if (choose == 1) {

                    System.out.println("BEEF");
                    System.out.print("Quantity:");
                    quantity = input.nextInt();
                    total = total + (quantity * 348.75);

                    if (productNames.contains("BEEF")) {
                        int index = productNames.indexOf("BEEF");

                        int newQuantity = productQuantity.get(index) + quantity;

                        productQuantity.set(index, newQuantity);
                        productPrice.set(index, 348.75 * Double.valueOf(newQuantity));

                    } else {
                        productNames.add("BEEF");
                        productQuantity.add(quantity);
                        productPrice.add(348.75 * Double.valueOf(quantity));
                    }

                    System.out.println("Do you want to buy again? ");
                    System.out.print("Press Y for Yes and N for No : ");
                    decision = input.next();
                    if (decision.equalsIgnoreCase("Y")) {
                        order(productNames, productQuantity, productPrice);
                    }
                } else {
                    System.out.println("Enter your payment: ");
                    pay = input.nextDouble();
                    if (pay <= total) {
                        System.out.println("Not enough payment");
                    } else {
                        System.out.println("-----------------------------------------------------------INVOICE--------------------------------------------------------");
                        System.out.println("\t\t\t\t                          Dhaniel's Grocery");
                        System.out.println("\t\t\t\t                 Purok 3, Santo Cristo Street");
                        System.out.println("\t\t\t\t                    Quezon, Nueva Ecija");
                        System.out.println("BIR Permit: FP102020-044-0270134-00007" + "\t\t\t\t\t\t\tContact: (+91)9950569066");
                        System.out.println("ACCR.# 11600005420700016753681" + "\t\t\t\t\t\t\t\tMIN # 2010241710120003");
                        System.out.println("SHOPPING / POS #1 / SN:P5J80371");

                        System.out.println("\n\t   PRODUCT/S" + "\t\t\t\t\t   QUANTITY" + "\t\t\t\t  PRICE");
                        System.out.println("==========================================================================================================================");

                        for (int i = 0; i < productNames.size(); i++) {

                            System.out.println("\t" + "     " + productNames.get(i) + "\t\t\t\t\t" + "      " + productQuantity.get(i) + "\t\t\t\t\t" + "  " + productPrice.get(i));
                        }
                        System.out.println("\nAmount Due: PHP " + total);
                        System.out.println("Payment: PHP " + pay);
                        total = pay - total;
                        System.out.println("Change: PHP " + total);

                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                        Date date = new Date();
                        Calendar calendar = Calendar.getInstance();
                        String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

                        System.out.println("\nDate Issued: " + formatter.format(date) + " " + days[calendar.get(Calendar.DAY_OF_WEEK) - 1]);
                        System.out.println("\t\t\t\t ----------------This is your official receipt.----------------");
                        System.out.println("\t\t\t\t                      THANK YOU, COME AGAIN!");
                        System.out.println("-------------------------------------------------------------------------------------------------------------------");
                    }
                }
            }
        }
    }
}