package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Runs the program as many times as the user would like until the user chooses the exit option (7)
        boolean exit = false;
        while (!exit) {
            System.out.println("\nWelcome to the calculator. Please choose from the options below: ");
            System.out.println("1. Binary to Decimal");
            System.out.println("2. Decimal to Binary");
            System.out.println("3. Hexadecimal to Decimal");
            System.out.println("4. Decimal to Hexadecimal");
            System.out.println("5. Binary to Binary Using (+, -, *, /)");
            System.out.println("6. Hexadecimal to Hexadecimal Using (+, -, *, /)");
            System.out.println("7. Exit");

            int choice = new Scanner(System.in).nextInt();
            switch (choice) {
                // Binary to Decimal conversion
                case 1:
                    System.out.println("Please enter a Binary Value: ");
                    convertBinaryToDecimal(new Scanner(System.in).nextLine());
                    break;

                // Decimal to Binary conversion
                case 2:
                    System.out.println("Please enter a Decimal Value: ");
                    convertDecimalToBinary(new Scanner(System.in).nextLine());
                    break;

                // Hexadecimal to Decimal conversion
                case 3:
                    System.out.println("Please enter a Hexadecimal Value: ");
                    convertHexadecimalToDecimal(new Scanner(System.in).nextLine());
                    break;

                // Decimal to Hexadecimal conversion
                case 4:
                    System.out.println("Please enter a Decimal Value: ");
                    convertDecimalToHexadecimal(new Scanner(System.in).nextLine());
                    break;

                // Binary to Binary using (+, -, *, /)
                case 5:
                    // Gets first value
                    System.out.println("Please enter the First Binary Value: ");
                    String firstValue = new Scanner(System.in).nextLine();

                    // Gets second value
                    System.out.println("Please enter the Second Binary Value: ");
                    String secondValue = new Scanner(System.in).nextLine();

                    // Gets the operator value
                    System.out.println("Please chose an operation (+, -, *, /): ");
                    String operation = new Scanner(System.in).nextLine();

                    // Checks for valid operation
                    if (operation.equals("+") || operation.equals("-") || operation.equals("*")
                            || operation.equals("/")) {
                        binaryOperation(firstValue, secondValue, operation);
                    } else {
                        System.out.println("Error!! Please choose the correct operation: ");
                    }
                    break;

                // Hexadecimal to Hexadecimal using (+, -, *, /)
                case 6:
                    // Gets first value
                    System.out.println("Please enter the First Hexadecimal Value: ");
                    firstValue = new Scanner(System.in).nextLine();

                    // Gets second value
                    System.out.println("Please enter the Second Hexadecimal Value: ");
                    secondValue = new Scanner(System.in).nextLine();

                    // Gets the operator value
                    System.out.println("Please chose an operation (+, -, *, /): ");
                    operation = new Scanner(System.in).nextLine();

                    // Checks for valid operation
                    if (operation.equals("+") || operation.equals("-") || operation.equals("*")
                            || operation.equals("/")) {
                        hexadecimalOperation(firstValue, secondValue, operation);
                    } else {
                        System.out.println("Error!! Please choose the correct operation: ");
                    }
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Please choose the correct option: ");
            }
        }
    }

    /**
     * Prints Binary Value to Decimal
     * @param binaryValue The Binary Value to be converted
     */
    public static void convertBinaryToDecimal(String binaryValue) {
        System.out.println("Decimal value of " + binaryValue + " is: "
                + getBinaryToDecimal(binaryValue) + "\n");
    }

    /**
     * Converts Binary Value to Decimal
     * @param binaryValue The Binary Value to be converted
     * @return The Decimal Value
     */
    public static int getBinaryToDecimal(String binaryValue) {
        // Convert binary string to binary int
        int binaryValueInt = Integer.parseInt(binaryValue);
        int decimalValue = 0;
        int power = 0;
        // Keep iterating until binary value is not 0
        while (binaryValueInt != 0) {
            int remainder = binaryValueInt % 10;
            decimalValue += remainder * Math.pow(2, power);
            binaryValueInt = binaryValueInt / 10;
            power++;
        }
        return decimalValue;
    }

    /**
     * Prints decimal value to binary
     * @param decimalValue The decimal value to be converted
     */
    public static void convertDecimalToBinary(String decimalValue) {
        System.out.println("Binary value of " + decimalValue + " is: "
                + getDecimalToBinary(decimalValue) + "\n");
    }

    /**
     * Converts decimal value to binary
     * @param decimalValue The decimal value to be converted
     * @return The binary value
     */
    public static String getDecimalToBinary(String decimalValue) {
        int decimalIntValue = Integer.parseInt(decimalValue);

        // Creates an array to hold 0's and 1's
        int[] binaryElementsArray = new int[40];
        int index = 0;
        while (decimalIntValue > 0) {
            // Gets the last digit everytime and stores it in the array
            binaryElementsArray[index++] = decimalIntValue % 2;
            decimalIntValue = decimalIntValue / 2;
        }
        // Traverses the array in reverse order and stores it in the String
        StringBuilder binaryString = new StringBuilder();
        for (int i = index - 1; i >= 0; i--) {
            // Appends to the string
            binaryString.append(binaryElementsArray[i]);
        }
        return binaryString.toString();
    }

    /**
     * Prints hexadecimal value to decimal form
     * @param hexadecimalValue The hexadecimal value to be converted
     */
    public static void convertHexadecimalToDecimal(String hexadecimalValue) {
        System.out.println("Decimal value of " + hexadecimalValue + " is: "
                + getHexadecimalToDecimal(hexadecimalValue) + "\n");
    }

    /**
     * Converts hexadecimal value to decimal form
     * @param hexadecimalValue The hexadecimal value to be converted
     * @return The decimal value
     */
    public static int getHexadecimalToDecimal(String hexadecimalValue) {
        String hexadecimalCharString = "0123456789ABCDEF";
        // Convert input string to uppercase as in hexadecimal, all chars are upper case
        hexadecimalValue = hexadecimalValue.toUpperCase();
        int decimalValue = 0;
        // Iterate on given value to convert it to decimal
        for (int i = 0; i < hexadecimalValue.length(); i++) {
            char ch = hexadecimalValue.charAt(i);
            int n = hexadecimalCharString.indexOf(ch);
            decimalValue = 16 * decimalValue + n;
        }
        return decimalValue;
    }

    /**
     * Prints decimal value to hexadecimal form
     * @param decimalValue The decimal value to be converted
     */
    public static void convertDecimalToHexadecimal(String decimalValue) {
        System.out.println("Hexadecimal value of " + decimalValue + " is: "
                + getDecimalToHexadecimal(decimalValue) + "\n");
    }

    /**
     * Converts decimal value to hexadecimal form
     * @param decimalValue The decimal value to be converted
     * @return The hexadecimal value
     */
    public static String getDecimalToHexadecimal(String decimalValue) {
        int decimalIntValue = Integer.parseInt(decimalValue);
        String hexadecimalValue = "";
        int remainder;
        // Creates a list of applicable hex chars
        char[] hexadecimalCharacters = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        // Gets the last digit by dividing by 16
        while (decimalIntValue > 0) {
            remainder = decimalIntValue % 16;
            hexadecimalValue = String.format("%s%s", hexadecimalCharacters[remainder], hexadecimalValue);
            decimalIntValue = decimalIntValue / 16;
        }
        return hexadecimalValue;
    }

    /**
     * Binary calculator supports (+, -, /, *) operations on two binary inputs
     * @param firstValue 1st binary value
     * @param secondValue 2nd binary value (non-zero in case of division)
     * @param operation The result of the operation (+, -, /, *)
     */
    public static void binaryOperation(String firstValue, String secondValue, String operation) {
        int firstIntValue = getBinaryToDecimal(firstValue);
        int secondIntValue = getBinaryToDecimal(secondValue);
        int result = 0;
        // Enhanced switch statement
        switch (operation) {
            case "+" -> result = firstIntValue + secondIntValue;
            case "-" -> result = firstIntValue - secondIntValue;
            case "*" -> result = firstIntValue * secondIntValue;
            case "/" -> {
                if (secondIntValue == 0) {
                    System.out.println("Sorry the divisor can't be 0\n");
                    return;
                }
                result = firstIntValue / secondIntValue;
            }
        }
        System.out.println("Result of " + firstValue + " " + operation + " " + secondValue + " = "
                + getDecimalToBinary(String.valueOf(result)) + "\n");
    }

    /**
     * Hexadecimal calculator supports (+, -, /, *) operations on two binary inputs
     * @param firstValue 1st hexadecimal value
     * @param secondValue 2nd hexadecimal value (non-zero in case of division)
     * @param operation The result of the operation (+, -, /, *)
     */
    public static void hexadecimalOperation(String firstValue, String secondValue, String operation) {
        int firstIntValue = getHexadecimalToDecimal(firstValue);
        int secondIntValue = getHexadecimalToDecimal(secondValue);
        int result = 0;
        // Enhanced switch statement
        switch (operation) {
            case "+" -> result = firstIntValue + secondIntValue;
            case "-" -> result = firstIntValue - secondIntValue;
            case "*" -> result = firstIntValue * secondIntValue;
            case "/" -> {
                if (secondIntValue == 0) {
                    System.out.println("Sorry the divisor can't be 0\n");
                    return;
                }
                result = firstIntValue / secondIntValue;
            }
        }
        System.out.println("Result of " + firstValue + " " + operation + " " + secondValue + " = "
                + getDecimalToHexadecimal(String.valueOf(result)) + "\n");
    }
}
