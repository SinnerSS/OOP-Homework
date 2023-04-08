import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EquationSolver extends JFrame {


    private double a, b, c;



    public EquationSolver() {
        setTitle("Equation Solver");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createInputPanel();
    }



    private void createInputPanel() {
        JPanel inputPanel = new JPanel(new GridBagLayout());
        addComponentToPanel(inputPanel, new JLabel("Choose equation type:"), 0, 0);


        JButton linearOneVariable = addComponentToPanel(inputPanel, new JButton("Linear - One Variable"), 0, 1, (event) -> {
            remove(inputPanel);
            createLinearOneVariablePanel();
            revalidate();
            repaint();
        });


        JButton linearTwoVariable = addComponentToPanel(inputPanel, new JButton("Linear - Two Variables"), 0, 2, (event) -> {
            remove(inputPanel);
            createLinearTwoVariablePanel();
            revalidate();
            repaint();
        });


        JButton quadraticTwoVariable = addComponentToPanel(inputPanel, new JButton("Quadratic - Two Variables"), 0, 3, (event) -> {
            remove(inputPanel);
            createQuadraticTwoVariablePanel();
            revalidate();
            repaint();
        });

        getContentPane().add(inputPanel);


        enableTabTraversalAndEnterAction(linearOneVariable);
        enableTabTraversalAndEnterAction(linearTwoVariable);
        enableTabTraversalAndEnterAction(quadraticTwoVariable);


        SwingUtilities.invokeLater(() -> linearOneVariable.requestFocusInWindow());


    }



    private void createLinearOneVariablePanel() {


        JPanel panel = new JPanel(new GridBagLayout());


        addComponentToPanel(panel, new JLabel("Enter coefficients (a, b) for ax + b = 0:"), 0, 0);
        JTextField aTextField = addComponentToPanel(panel, new JTextField(10), 0, 1);
        JTextField bTextField = addComponentToPanel(panel, new JTextField(10), 1, 1);


        addComponentToPanel(panel, new JButton("Back"), 0, 2, (event) -> {
            remove(panel);
            createInputPanel();
            revalidate();
            repaint();
        });


        JButton solve = addComponentToPanel(panel, new JButton("Solve"), 1, 2, (event) -> {
            try {


                a = Double.parseDouble(aTextField.getText());
                b = Double.parseDouble(bTextField.getText());


                double x = -b / a;


                if(a != 0) {

                    JOptionPane.showMessageDialog(this, "x = " + x, "Solution", JOptionPane.INFORMATION_MESSAGE);

                } else if(b!=0){

                    JOptionPane.showMessageDialog(this, "No solution", "Solution", JOptionPane.INFORMATION_MESSAGE);

                } else{

                    JOptionPane.showMessageDialog(this, "Infinite solution", "Solution",JOptionPane.INFORMATION_MESSAGE);

                }
            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(this, "Please enter valid coefficients.", "Invalid input", JOptionPane.ERROR_MESSAGE);

            }
        });


        getContentPane().add(panel);
        getRootPane().setDefaultButton(solve);


        SwingUtilities.invokeLater(() -> aTextField.requestFocusInWindow());


    }



    private void createLinearTwoVariablePanel() {


        JPanel panel = new JPanel(new GridBagLayout());


        addComponentToPanel(panel, new JLabel("Enter coefficients (a1, b1, c1) for a1x + b1y = c1:"), 0, 0);
        JTextField a1TextField = addComponentToPanel(panel, new JTextField(10), 0, 1);
        JTextField b1TextField = addComponentToPanel(panel, new JTextField(10), 1, 1);
        JTextField c1TextField = addComponentToPanel(panel, new JTextField(10), 2, 1);
    

        addComponentToPanel(panel, new JLabel("Enter coefficients (a2, b2, c2) for a2x + b2y = c2:"), 0, 2);
        JTextField a2TextField = addComponentToPanel(panel, new JTextField(10), 0, 3);
        JTextField b2TextField = addComponentToPanel(panel, new JTextField(10), 1, 3);
        JTextField c2TextField = addComponentToPanel(panel, new JTextField(10), 2, 3);
    

        addComponentToPanel(panel, new JButton("Back"), 0, 4, (event) -> {


            remove(panel);
            createInputPanel();
            revalidate();
            repaint();


        });
    

        JButton solve = addComponentToPanel(panel, new JButton("Solve"), 1, 4, (event) -> {
            try {


                double a1 = Double.parseDouble(a1TextField.getText());
                double b1 = Double.parseDouble(b1TextField.getText());
                double c1 = Double.parseDouble(c1TextField.getText());
    

                double a2 = Double.parseDouble(a2TextField.getText());
                double b2 = Double.parseDouble(b2TextField.getText());
                double c2 = Double.parseDouble(c2TextField.getText());
    

                double determinant = a1 * b2 - a2 * b1;
    

                if (determinant != 0) {


                    double x = (c1 * b2 - c2 * b1) / determinant;
                    double y = (a1 * c2 - a2 * c1) / determinant;


                    JOptionPane.showMessageDialog(this, "x = " + x + ", y = " + y, "Solution", JOptionPane.INFORMATION_MESSAGE);


                } else if(c1 / c2 == a1 / a2){

                    JOptionPane.showMessageDialog(this, "Infinite solution", "Solution", JOptionPane.INFORMATION_MESSAGE);

                } else{

                    JOptionPane.showMessageDialog(this, "No solution", "Solution", JOptionPane.INFORMATION_MESSAGE);

                }
            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(this, "Please enter valid coefficients.", "Invalid input", JOptionPane.ERROR_MESSAGE);

            }
        });

    
        getContentPane().add(panel);
        getRootPane().setDefaultButton(solve);


        SwingUtilities.invokeLater(() -> a1TextField.requestFocusInWindow());


    }



    private void createQuadraticTwoVariablePanel() {


        JPanel panel = new JPanel(new GridBagLayout());


        addComponentToPanel(panel, new JLabel("Enter coefficients (a, b, c) for ax^2 + bx + c = 0:"), 0, 0);
        JTextField aTextField = addComponentToPanel(panel, new JTextField(10), 0, 1);
        JTextField bTextField = addComponentToPanel(panel, new JTextField(10), 1, 1);
        JTextField cTextField = addComponentToPanel(panel, new JTextField(10), 2, 1);


        addComponentToPanel(panel, new JButton("Back"), 0, 2, (event) -> {


            remove(panel);
            createInputPanel();
            revalidate();
            repaint();


        });


        JButton solve = addComponentToPanel(panel, new JButton("Solve"), 1, 2, (event) -> {
            try {


                a = Double.parseDouble(aTextField.getText());
                b = Double.parseDouble(bTextField.getText());
                c = Double.parseDouble(cTextField.getText());


                double discriminant = b * b - 4 * a * c;


                if (a != 0){
                    if (discriminant < 0) {

                        JOptionPane.showMessageDialog(this, "No real solutions.", "Solution", JOptionPane.INFORMATION_MESSAGE);

                    } else if (discriminant == 0) {


                        double x = -b / (2 * a);
                        JOptionPane.showMessageDialog(this, "x = " + x, "Solution", JOptionPane.INFORMATION_MESSAGE);


                    } else {


                        double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                        double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                        JOptionPane.showMessageDialog(this, "x1 = " + x1 + ", x2 = " + x2, "Solution", JOptionPane.INFORMATION_MESSAGE);


                    }
                } else {
                    if(b != 0){


                        double x = -c/b;
                        JOptionPane.showMessageDialog(this, "x = " + x, "Solution", JOptionPane.INFORMATION_MESSAGE);


                    } else if(c!=0){

                        JOptionPane.showMessageDialog(this, "No solution", "Solution", JOptionPane.INFORMATION_MESSAGE);

                    } else{

                        JOptionPane.showMessageDialog(this, "Infinite solution", "Solution",JOptionPane.INFORMATION_MESSAGE);

                    }
                }
            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(this, "Please enter valid coefficients.", "Invalid input", JOptionPane.ERROR_MESSAGE);

            }
        });


        getContentPane().add(panel);
        getRootPane().setDefaultButton(solve);


        SwingUtilities.invokeLater(() -> aTextField.requestFocusInWindow());


    }



    private <T extends Component> T addComponentToPanel(JPanel panel, T component, int x, int y) {
        return addComponentToPanel(panel, component, x, y, null);
    }



    private <T extends Component> T addComponentToPanel(JPanel panel, T component, int x, int y, ActionListener listener) {


        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = x;
        gbc.gridy = y;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(5, 5, 5, 5);


        panel.add(component, gbc);
        if (listener != null) {
            ((JButton) component).addActionListener(listener);
        }


        return component;


    }

    private void enableTabTraversalAndEnterAction(JButton button) {


        button.setFocusable(true);


        button.addKeyListener(new KeyAdapter() {


            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    button.doClick();
                }
            }


        });
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new EquationSolver().setVisible(true));
        
    }
}