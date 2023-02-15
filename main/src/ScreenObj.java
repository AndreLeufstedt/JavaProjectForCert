import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;




// Path: main\src\ScreenObj.java


public class ScreenObj {

    /**
     * Name is a String that is used to set the name of the JFrame.
     */
    private final String name;
    /**
     * X is a int that is used to set the x position of the JFrame.
     */
    private final int x;
    /**
     * Y is a int that is used to set the y position of the JFrame.
     */
    private final int y;
    /**
     * Width is a int that is used to set the width of the JFrame.
     */
    private final int width;
    /**
     * Height is a int that is used to set the height of the JFrame.
     */
    private final int height;
    /**
     * Color is of type Color that is used to set the color of the JFrame.
     */
    private final Color color;
    /**
     * Opacity is a float that is used to set the opacity of the JFrame.
     */
    private final float opacity;
    /**
     * AlwaysOnTop is a boolean that is used to set the JFrame to always be on top of other windows.
     */
    private final boolean alwaysOnTop;
    /**
     * Resizable is a boolean that is used to set the JFrame to be resizable.
     */
    private final boolean resizable;
    /**
     * Undecorated is a boolean that is used to remove the title bar and the border of the JFrame.
     */
    private final boolean undecorated;
    /**
     * Visible is a boolean that is used to set the visibility of the JFrame.
     */
    private final boolean visible;

    /**
     * Frame is a JFrame that is used to create the JFrame.
     */
    private final JFrame frame;

    /**
     * Array to store the keys pressed
     */
    public String[] Keys;


    public ScreenObj(String name, int x, int y, int width, int height, Color color, float opacity, boolean alwaysOnTop, boolean resizable, boolean undecorated, boolean visible) {

        // Set the variables to the values passed in the constructor
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.opacity = opacity;
        this.alwaysOnTop = alwaysOnTop;
        this.resizable = resizable;
        this.undecorated = undecorated;
        this.visible = visible;

        this.Keys = new String[512];

        // Create the JFrame. This is the main window of the program.
        this.frame = new JFrame(name);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(width, height);
        this.frame.setLocation(x, y);
        this.frame.setBackground(color);
        this.frame.setOpacity(opacity);
        this.frame.setAlwaysOnTop(alwaysOnTop);
        this.frame.setResizable(resizable);
        this.frame.setUndecorated(undecorated);
        this.frame.setVisible(visible);


        // Add a key listener to the JFrame using the KeyListener function in this class
       handleInput();


    }

    /**
     * Change the title of the object
     */
    public void setTitle(String title) {
        this.frame.setTitle(title);
    }

    /**
     * Change the size of the object
     */
    public void setSize(int width, int height) {
        this.frame.setSize(width, height);
    }

    /**
     * Change the location of the object
     */
    public void setLocation(int x, int y) {
        this.frame.setLocation(x, y);
    }

    /**
     * Change the background color of the object
     */
    public void setBackground(Color color) {
        this.frame.getContentPane().setBackground(color);
    }

    /**
     * Change the opacity of the object
     */
    public void setOpacity(float opacity) {
        this.frame.setOpacity(opacity);
    }

    /**
     * Change the always on top of the object
     */
    public void setAlwaysOnTop(boolean alwaysOnTop) {
        this.frame.setAlwaysOnTop(alwaysOnTop);
    }

    /**
     * Change the resizable of the object
     */
    public void setResizable(boolean resizable) {
        this.frame.setResizable(resizable);
    }

    /**
     * Change the undecorated of the object
     */
    public void setUndecorated(boolean undecorated) {
        this.frame.setUndecorated(undecorated);
    }

    /**
     * Change visibility of the object
     */
    public void setVisible(boolean visible) {
        this.frame.setVisible(visible);
    }

    /**
     * Get the JFrame
     */
    public JFrame getFrame() {
        return this.frame;
    }

    /**
     * Add a label to the JFrame. This is used to add text to the JFrame.
     */
    public void addLabel(String text, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setOpaque(true);
        this.frame.add(label);
    }

    /**
     * Add a button to the JFrame. This is used to add a button to the JFrame.
     */
    public void addButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setOpaque(true);
        this.frame.add(button);
    }


    /**
     * Add a text field to the JFrame. This is used to add a text field to the JFrame.
     */
    public void addTextField(String text, int x, int y, int width, int height) {
        JTextField textField = new JTextField(text);
        textField.setBounds(x, y, width, height);
        textField.setOpaque(true);
        this.frame.add(textField);
    }

    /**
     * Add keyboard inputs on JFrame
     */
    public void addKeyListener(KeyListener keyListener) {
            this.frame.addKeyListener(keyListener);
    }

    /**
     * Remove keyboard inputs on JFrame
     */
    public void removeKeyListener(KeyListener keyListener) {
            this.frame.removeKeyListener(keyListener);
    }

    /**
     * Handles input keys and prints them
     */
    public void handleInput() {
        this.frame.addKeyListener(new KeyListener() {

            /*
                * This function is called when a key is typed.
                * This function is not used in this program.
            */
            @Override
            public void keyTyped(KeyEvent e) {
            }

            /*
                * This function is called when a key is pressed.
             */
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("Pressed: " + e.getKeyChar());
                // Adds the key pressed to the Keys array
                Keys[e.getKeyCode()] = e.getKeyChar() + "";

                // Print out the keys pressed in the array on one line with spaces in between each key
                StringBuilder output = new StringBuilder("Keys Pressed: ");
                for (String key : Keys) {
                    if (key != null)
                        output.append(key).append(" "); // Adds the key to the output
                }

                // Prints the output
                oFunc.printNormal(output.toString());
            }

            /*
                * This function is called when a key is released.
             */
            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("Released: " + e.getKeyChar());
                // Removes the key released from the Keys array
                Keys[e.getKeyCode()] = null;

            }
        });
    }

}