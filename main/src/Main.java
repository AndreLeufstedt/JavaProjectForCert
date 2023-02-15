import jdk.jfr.Description;

import java.awt.*;
import java.util.Objects;
import java.util.Scanner;


/**
 * DOCUMENTATION
 * ADDBUTTON(name, x, y, width, height)    - Adds a button to the screen
 * ADDTEXTFIELD(name, x, y, width, height) - Adds a text field to the screen
 *
 *
 *
 *
 *
 * Version: 1.0.0
 * Author: André Leufstedt
 * Program Name: String Input
 */





public class Main {
    public static void main(String[] args) {
        /* Entrance Point of the Program */

        // Constant Variables for documentation
        final String VERSION = "1.0.0";
        final String AUTHOR = "André Leufstedt";
        final String PROGRAM_NAME = "String Input";

        oFunc.printInfo("Program Name: " + PROGRAM_NAME);
        oFunc.printInfo("Program Version: " + VERSION);
        oFunc.printInfo("Program Author: " + AUTHOR);


        oFunc.printSpace();
        oFunc.printSpace();

        // Constructs the current Class as an object to use the functions included
        Main main = new Main();

        // New ScreenObj object
        ScreenObj screenObj = new ScreenObj("String Input", 100, 100, 500, 500, Color.GREEN, 1.0f, true, false, false, true);


        oFunc.printInfo("Parsing Arguments");

        // Using the parseArgs function
        try {
            main.parseArgs(args);
        } catch (Exception e) {
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
        while (!Objects.equals(input, "QUIT")) {

            /* if statement to check if the array is full */
            if (currentIndex >= savedInput.length) {
                oFunc.printError("Array is ful\nEXITING PROGRAM!");
                System.exit(1);
            }

            // Gets the input from the user
            input = main.getUserInput("Enter a String: ");
            oFunc.printInfo("You entered: " + input);

            // If the input is TITLE: then set the title of the window to the input after the messa
            if (Objects.equals(input, "TITLE: ")) {
                screenObj.setTitle(input.substring(7));
            }

            // If the input is SIZE: then set the size of the window to the input after the message
            if (Objects.equals(input, "SIZE: ")) {
                String[] size = input.substring(6).split("x");
                screenObj.setSize(Integer.parseInt(size[0]), Integer.parseInt(size[1]));
            }

            // If the input is ADDBUTTON add a new button at the specified location
            if (input.startsWith("ADDBUTTON: ")) {
                String[] button = input.substring(11).split(",");
                oFunc.printInfo("Button: " + button[0] + " X: " + button[1] + " Y: " + button[2] + " Width: " + button[3] + " Height: " + button[4]);
                screenObj.addButton(button[0], Integer.parseInt(button[1]), Integer.parseInt(button[2]), Integer.parseInt(button[3]), Integer.parseInt(button[4]));
            }

            // If the input is ADDTEXTFIELD add a new textfield at the specified location
            if (input.startsWith("ADDTEXTFIELD: ")) {
                String[] textField = input.substring(14).split(",");
                oFunc.printInfo("TextField: " + textField[0] + " X: " + textField[1] + " Y: " + textField[2] + " Width: " + textField[3] + " Height: " + textField[4]);
                screenObj.addTextField(textField[0], Integer.parseInt(textField[1]), Integer.parseInt(textField[2]), Integer.parseInt(textField[3]), Integer.parseInt(textField[4]));
            }


            // Switch statement for single commands.
            switch (input) {


                case "VISIBILITY: TRUE"     -> screenObj.setVisible(true);
                case "VISIBILITY: FALSE"    -> screenObj.setVisible(false);
                case "COLOR: RED"           -> screenObj.setBackground(Color.RED);
                case "COLOR: BLUE"          -> screenObj.setBackground(Color.BLUE);
                case "COLOR: GREEN"         -> screenObj.setBackground(Color.GREEN);
                case "COLOR: YELLOW"        -> screenObj.setBackground(Color.YELLOW);
                case "COLOR: BLACK"         -> screenObj.setBackground(Color.BLACK);
                case "COLOR: WHITE"         -> screenObj.setBackground(Color.WHITE);
                case "COLOR: GRAY"          -> screenObj.setBackground(Color.GRAY);
                case "COLOR: PINK"          -> screenObj.setBackground(Color.PINK);
                case "COLOR: ORANGE"        -> screenObj.setBackground(Color.ORANGE);
                case "COLOR: CYAN"          -> screenObj.setBackground(Color.CYAN);
                case "COLOR: MAGENTA"       -> screenObj.setBackground(Color.MAGENTA);
                case "COLOR: LIGHT_GRAY"    -> screenObj.setBackground(Color.LIGHT_GRAY);
                case "COLOR: DARK_GRAY"     -> screenObj.setBackground(Color.DARK_GRAY);
                case "COLOR: RANDOM"        -> screenObj.setBackground(new Color((int) (Math.random() * 0x1000000)));



                case "SAVED" -> {
                    oFunc.printInfo("Printing Saved Input: ");
                    for (String s : savedInput) {
                        if (s != null && s.length() > 0) {
                            oFunc.printNormal(s);
                        }
                    }
                }

                default -> {
                    savedInput[currentIndex] = input;
                    currentIndex++;
                }
            }


            // If the input is QUIT then exit the program
            if (Objects.equals(input, "SAVED")) {
                oFunc.printInfo("Printing Saved Input: ");
                for (String s : savedInput) {
                    if (s != null && s.length() > 0) {
                        oFunc.printNormal(s);
                    }
                }
                continue;
            }


        }

        // Prints out the saved input
        oFunc.printInfo("Printing Saved Input: ");
        for (String s : savedInput) {
            if (s != null && s.length() > 0) {
                oFunc.printNormal(s);
            }
        }

        // Prints out the exit message
        oFunc.printWarning("Exiting Program");
        System.exit(0);
    }


    @Description("Prints out the Arguments passed in during runtime")
    private void parseArgs(String[] args) {
        int nArg = 0;
        // For a loop for the arguments
        for (String arg : args) {
            nArg++;
            // Prints out
            oFunc.printInfo("Argument " + nArg + " returned as: " + arg);
        }
    }


    /**
     * getUserInput is a helper function that gets the input with a single function and returns the line inputted.
     * Takes one Param that is the message to be printed before the line that is read.
     **/
    private String getUserInput(String inputMessage) {
        // Makes a scan object to be used to
        Scanner scan = new Scanner(System.in);
        oFunc.printInfo(inputMessage);
        return scan.nextLine();
    }


}


