/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodecoin;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        NodeCoin nodeCoin = new NodeCoin();
        Scanner scanner = new Scanner(System.in);

        // Read and process input line by line
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] tokens = input.split(" ");
            int command = Integer.parseInt(tokens[0]);
            
            String date = (tokens.length >= 2) ? tokens[1] : ""; // check for date
            if (date.length() == 7) date = "0" + date; // add leading zero for single digit months

            switch (command) {
                case 1: // Insert transaction
                    double amount = Double.parseDouble(tokens[2]);
                    nodeCoin.addTransaction(date, amount);
                    break;

                case 2: // Get max transaction
                    System.out.println(nodeCoin.fetchMaxTransaction(date));
                    break;

                case 3: // Remove max transaction
                    nodeCoin.deleteMaxTransaction(date);
                    break;

                case 4: // Retrieve all transactions
                    System.out.println(nodeCoin.retrieveAllTransactions(date));
                    break;

                default:
                    System.out.println("-1"); // Unknown command
            }
        }
    }
}
