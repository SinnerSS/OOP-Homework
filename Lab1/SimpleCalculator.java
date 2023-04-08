import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame {


    private double num1, num2;



    public SimpleCalculator() {


        setTitle("Simple Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        createInputPanel();


    }



    private void createInputPanel() {


        JPanel inputPanel = new JPanel(new GridBagLayout());
        addComponentToPanel(inputPanel, new JLabel("Input the first number:"), 0, 0);
        JTextField num1TextField = addComponentToPanel(inputPanel, new JTextField(10), 1, 0);
        addComponentToPanel(inputPanel, new JLabel("Input the second number:"), 0, 1);
        JTextField num2TextField = addComponentToPanel(inputPanel, new JTextField(10), 1, 1);


        JButton confirmInput = addComponentToPanel(inputPanel, new JButton("Confirm"), 1, 2, (event) -> {
            try {


                num1 = Double.parseDouble(num1TextField.getText());
                num2 = Double.parseDouble(num2TextField.getText());


                remove(inputPanel);
                createSettingPanel();
                revalidate();
                repaint();


            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers.", "Invalid input", JOptionPane.ERROR_MESSAGE);
            }
        });


        getContentPane().add(inputPanel);
        getRootPane().setDefaultButton(confirmInput);


    }



    private void createSettingPanel() {


        JPanel settingPanel = new JPanel(new GridBagLayout()), resultPanel = new JPanel(new GridBagLayout());
        addComponentToPanel(settingPanel, new JLabel("Choose display options:"), 0, 0);
        JCheckBox add_check = addComponentToPanel(settingPanel, new JCheckBox("Add"), 0, 1);
        JCheckBox sub_check = addComponentToPanel(settingPanel, new JCheckBox("Subtract"), 0, 2);
        JCheckBox mul_check = addComponentToPanel(settingPanel, new JCheckBox("Muliply"), 0, 3);
        JCheckBox div_check = addComponentToPanel(settingPanel, new JCheckBox("Divide"), 0, 4);


        addComponentToPanel(settingPanel, new JButton("Back"), 0, 5, (event) -> {


            remove(settingPanel);
            createInputPanel();
            revalidate();
            repaint();


        });


        JButton confirmSetting = addComponentToPanel(settingPanel, new JButton("Confirm"), 1, 5, (event) -> {


            if (!add_check.isSelected() && !sub_check.isSelected() && !mul_check.isSelected() && !div_check.isSelected()) {
                JOptionPane.showMessageDialog(this, "Please select at least one operation.", "No operation selected", JOptionPane.ERROR_MESSAGE);
                return;
            }


            if (add_check.isSelected()) {
                addComponentToPanel(resultPanel, new JLabel("Sum: " + (num1 + num2)), 0, 1);
            }


            if (sub_check.isSelected()) {
                addComponentToPanel(resultPanel, new JLabel("Difference: " + (num1 - num2)), 0, 2);
            }


            if (mul_check.isSelected()) {
                addComponentToPanel(resultPanel, new JLabel("Product: " + (num1 * num2)), 0, 3);
            }


            if (div_check.isSelected()) {
                addComponentToPanel(resultPanel, new JLabel("Quotient: " + (num1 / num2)), 0, 4);
            }


            remove(settingPanel);
            add(resultPanel);
            revalidate();
            repaint();


        });


        addComponentToPanel(resultPanel, new JButton("Back"), 0, 5, (event) -> {


            remove(resultPanel);
            createInputPanel();
            revalidate();
            repaint();


        });

        
        getContentPane().add(settingPanel);
        getRootPane().setDefaultButton(confirmSetting);


        add_check.setFocusTraversalKeysEnabled(false);
        sub_check.setFocusTraversalKeysEnabled(false);
        mul_check.setFocusTraversalKeysEnabled(false);
        div_check.setFocusTraversalKeysEnabled(false);


        SwingUtilities.invokeLater(() -> add_check.requestFocusInWindow());


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


    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new SimpleCalculator().setVisible(true));

    }
}