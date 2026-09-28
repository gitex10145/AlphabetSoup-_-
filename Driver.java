//Name: Danilo Vranic
//Date: 09/28/26
//Description: This program runs the alphabet soup commands and lets the user interact with the Soup class through the terminal.
import java.util.*;

public class Driver {
    // Input: The user enters commands such as add, company, centered, removeWord, and exit.
    // Output: The program calls the matching Soup methods and prints the result of each command.

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Soup mySoup = new Soup();

        while (true) {
            String input = scan.nextLine().trim();
            if (input.isEmpty()) {
                continue;
            }

            if (input.startsWith("add ")) {
                mySoup.add(input.substring(4));
                System.out.println("new letters is " + mySoup.getLetters());
            }
            else if (input.equals("add")) {
                mySoup.add("");
                System.out.println("new letters is " + mySoup.getLetters());
            }
            else if (input.equals("randomLetter")) {
                System.out.println(mySoup.randomLetter());
            }
            else if (input.equals("centered")) {
                System.out.println(mySoup.companyCentered());
            }
            else if (input.startsWith("company ")) {
                mySoup.setCompany(input.substring("company ".length()));
            }
            else if (input.equals("removeVowel")) {
                mySoup.removeFirstVowel();
                System.out.println("new letters is " + mySoup.getLetters());
            }
            else if (input.startsWith("removeSome ")) {
                try {
                    int amount = Integer.parseInt(input.substring("removeSome ".length()).trim());
                    mySoup.removeSome(amount);
                    System.out.println("new letters is " + mySoup.getLetters());
                } catch (NumberFormatException e) {
                    System.out.println("not a legal command please try again!");
                }
            }
            else if (input.startsWith("removeWord ")) {
                mySoup.removeWord(input.substring("removeWord ".length()));
                System.out.println("new letters is " + mySoup.getLetters());
            }
            else if (input.equals("exit")) {
                break;
            }
            else {
                System.out.println("not a legal command please try again!");
            }
        }

        scan.close();
    }
}