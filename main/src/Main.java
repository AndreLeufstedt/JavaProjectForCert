import jdk.jfr.Description;
import org.jetbrains.annotations.NotNull;


import java.sql.Savepoint;
import java.util.Objects;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        /* Entrance Point of the Program */

        final String VERSION      = "1.0.0";
        final String AUTHOR       = "André Leufstedt";
        final String PROGRAM_NAME = "String Input";
        final String PROGRAM_DESC = "Program that takes in multiple strings and saves them into an array and prints them out when the user types in SAVED or QUIT to exit the program.";


        // Constructs the current Class as an object to use the functions included
        Main main = new Main();

        oFunc.printInfo("Parsing Arguments");

        // Using the parseArgs function
        try {
            main.parseArgs(args);
        }
        catch (Exception e) {
            // If not arguments are given exit program.
            oFunc.printError("No Arguments passed in during runtime.");
            System.exit(1);
        }

        // String input to store the string that is inserted.
        String input = "";

        // Array init for the saved input
        String[] savedInput = new String[512];

        int currentIndex = 0;


        // Loop to get multiple strings, KEYWORD: "QUIT" is used to exit the program or the array has reached the maximum input of 10
        while(!Objects.equals(input, "QUIT")) {


            input = main.getUserInput("Enter a String: ");
            oFunc.printInfo("You entered: " + input);


            if(Objects.equals(input, "SAVED")) {
                oFunc.printInfo("Printing Saved Input: ");
                for (String s : savedInput) {
                    if (s != null && s.length() > 0) {
                        oFunc.printNormal(s);
                    }
                }
                continue;
            }


            // Saves the input into the array at the current index and increments the index
            savedInput[currentIndex++] = input;


        }

        oFunc.printInfo("Printing Saved Input: ");
        for (String s : savedInput) {
            if (s != null && s.length() > 0) {
                oFunc.printNormal(s);
            }
        }
        oFunc.printWarning("Exiting Program");




    }


    @Description("Prints out the Arguments passed in during runtime")
    private void parseArgs(String @NotNull [] args) {
        int nArg = 0;
        // For loop for the arguments
        for (String arg: args) {
            nArg++;
            // Prints out
            oFunc.printInfo("Argument " + nArg + " returned as: " + arg);
        }
    }


    /** getUserInput is a helper function that gets the input with a single function and returns the line inputted.
     * Takes one Param that is the message to be printed before the line that is read.
     * **/
    private String getUserInput(String inputMessage) {
        // Makes a scan object to be used to
        Scanner scan = new Scanner(System.in);
        oFunc.printInfo(inputMessage);
        return scan.nextLine();
    }


}


