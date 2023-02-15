import jdk.jfr.Description;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class oFunc {
    /**
     * Includes three static methods that is used to make a better looking print for the console,
     * This includes: printInfo, printError and the GetTime that is used to get the formatted time.
     * Info print statement that includes time
     */


    public static void printInfo(String message) {
        System.out.println(GetTime() + " - INFO: " + message);
    }


    /**
     * Error print statement that includes time
     */
    public static void printError(String message) {
        System.out.println(GetTime() + " - ERROR: " + message);
    }


    /**
     * Warning print statement that includes time
     */
    public static void printWarning(String message) {
        System.out.println(GetTime() + " - WARNING: " + message);
    }

    /**
     * Normal print statement
     */
    public static void printNormal(String message) {
        System.out.println(message);
    }


    // Print space in console
    public static void printSpace() {
        System.out.println();
    }

    /**
     * Get the time in a formatted way (h:m:s)
     */
    public static String GetTime() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("h:m:s"));
    }


}

