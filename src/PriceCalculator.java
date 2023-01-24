import java.util.Scanner;

public class PriceCalculator {

    public static double enterWeight() {

        // get user input
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the weight of the item in pounds: ");
        String weight = input.next();
        double weightDouble = 0;

        // check if the weight is a double
        try {
            weightDouble = Double.parseDouble(weight);
            System.out.println("The weight is: " + weightDouble);
        } catch (NumberFormatException e) {
            System.out.println("The weight is not a number");
        }

        // check if its a positive number
        if (weightDouble < 1) {
            System.out.println("The weight is not a positive number");
            // if its not, ask to input again
            enterWeight();
        }


        return weightDouble;
    }


    public static String userInput(String question, String type, String[] options) {


        // get user input
        Scanner input = new Scanner(System.in);

        System.out.println(question);
        String answer = input.next();

        // check if the answer is the same type as parameter type

        if (type == "double") {
            try {
                double answerDouble = Double.parseDouble(answer);
                System.out.println("The answer is: " + answerDouble);
            } catch (NumberFormatException e) {
                System.out.println("The answer is not a number");
            }
        }

        if (type == "string") {
            try {
                String answerString = answer;
                System.out.println("The answer is: " + answerString);
            } catch (NumberFormatException e) {
                System.out.println("The answer is not a string");
            }
        }

        Boolean answerIsInArray = false;
        for (int i = 0; i < options.length; i++) {
            if (options[i].contains(answer)) {
                answerIsInArray = true;
                break;
            }
        }

        if (!answerIsInArray) {
            System.out.println("The answer is not one of the options");
            userInput(question, type, options);
        }


        return answer;


    }

    public static void main(String[] args) {

        // get user input
        Scanner input = new Scanner(System.in);

        double weight = enterWeight();
        // we declare global variables
        double pricePerPound;
        double totalPrice;
        double shippingPrice = 0;

        if (weight <= 5) {
            pricePerPound = 5.0;
        } else if (weight <= 10 && weight > 5) {
            pricePerPound = 4.0;
        } else if (weight <= 15 && weight > 10) {
            pricePerPound = 3.0;
        } else if (weight <= 20 && weight > 15) {
            pricePerPound = 2.0;
        } else {
            pricePerPound = 1.0;
        }

        totalPrice = weight * pricePerPound;


        System.out.println("The total price is: $" + totalPrice + " because the weight is: " + weight + " pounds and the price per pound is: $" + pricePerPound);


        String shippingMethod = userInput("Please choose your shipping method (a) Ground | (b) Air:", "string", new String[]{"a", "b"});

        if (shippingMethod.equalsIgnoreCase("a")) {
            shippingPrice = weight * 1.5;
        } else if (shippingMethod.equalsIgnoreCase("b")) {
            shippingPrice = weight * 2.5;
        }

        System.out.println("Shipping method: " + shippingMethod);
        System.out.println("Shipping price: $" + shippingPrice);

        // New section to calculate package price
        System.out.println("What type of package will you use ? ");
        System.out.println("letter ($ 0.1), box ($ 5), package ($ 10) : ");
        String packageType = input.next();
        double packagePrice = 0;
        if (packageType.equalsIgnoreCase("letter")) {
            packagePrice = 0.1;
            System.out.println("Package price: $" + packagePrice);
        } else if (packageType.equalsIgnoreCase("box")) {
            packagePrice = 5.0;
            System.out.println("Package price: $" + packagePrice);
        } else if (packageType.equalsIgnoreCase("package")) {
            packagePrice = 10.0;
            System.out.println("Package price: $" + packagePrice);
        } else {
            System.out.println("Invalid package type. Please enter 'letter', 'box' or 'package'.");
        }

        // Add package price to the total price
        double finalPrice = totalPrice + shippingPrice + packagePrice;
        System.out.println("Total price: $" + finalPrice);

        //New Section to calculate insurance
        // - Standard : 5% of the value of the package
        // - Premium : 20% of the value of the package

        System.out.println("Do you want to add insurance ? (yes/no) : ");
        String insurance = input.next();
        double insurancePrice = 0;
        if (insurance.equalsIgnoreCase("yes")) {
            System.out.println("What type of insurance do you want? (Standard/Premium) : ");
            String insuranceType = input.next();
            if (insuranceType.equalsIgnoreCase("Standard")) {
                insurancePrice = finalPrice * 0.05;
                System.out.println("Insurance price: $" + insurancePrice);
            } else if (insuranceType.equalsIgnoreCase("Premium")) {
                insurancePrice = finalPrice * 0.2;
                System.out.println("Insurance price: $" + insurancePrice);
            } else {
                System.out.println("Invalid insurance type. Please enter 'Standard' or 'Premium'.");
            }
        } else if (insurance.equalsIgnoreCase("no")) {
            System.out.println("No insurance added.");
        } else {
            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
        }
        // Add insurance price to the final price
        double finalPriceWithInsurance = finalPrice + insurancePrice;
        System.out.println("Total price including insurance: $" + finalPriceWithInsurance);

        // Distance of how far the package travel
        System.out.println("How far will your package travel ? ");
        System.out.println("Please enter in kilometers : ");
        double distance = input.nextDouble();
        System.out.println("Your package will travel " + distance + " kilometers.");

        // Client data
        System.out.println("PLease enter your email : ");
        String client_email = input.next();
        System.out.println("PLease enter your phone number : ");
        String client_number = input.next();
        System.out.println("PLease enter your address : ");
        String client_address = input.next();
        System.out.println("Please enter your name: ");
        String client_name = input.next();
        System.out.println("Thank you " + client_name + ", for using our services.");
        double tax = finalPrice * 0.13;
        finalPrice += tax;
        System.out.println("Total cost of the shipment is " + finalPrice + "$ including taxes (13%)");
        finalPrice += insurancePrice;
        System.out.println("Total cost of the shipment is " + finalPrice + "$ including taxes, insurance and delivery.");


        // End of [[ public static void main(String[] args) ]]
    }


}
