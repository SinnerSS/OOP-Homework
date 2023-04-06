import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame {


    private double num1, num2;



    public SimpleCalculator() {


        setTitle("Simple Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        JPanel inputPanel = new JPanel(new GridBagLayout());


        addComponentToPanel(inputPanel, new JLabel("Input the first number:"), 0, 0);


        JTextField num1TextField = addComponentToPanel(inputPanel, new JTextField(10), 1, 0);


        addComponentToPanel(inputPanel, new JLabel("Input the second number:"), 0, 1);


        JTextField num2TextField = addComponentToPanel(inputPanel, new JTextField(10), 1, 1);



        JPanel settingPanel = new JPanel(new GridBagLayout());

        

        addComponentToPanel(inputPanel, new JButton("Confirm"), 1, 2, (event) -> {


            num1 = Double.parseDouble(num1TextField.getText());
            num2 = Double.parseDouble(num2TextField.getText());


            remove(inputPanel);
            add(settingPanel);
            revalidate();
            repaint();


        });



        addComponentToPanel(settingPanel, new JLabel("Choose display options:"), 0, 0);


        JCheckBox add_check = addComponentToPanel(settingPanel, new JCheckBox("Add"), 0, 1);


        JCheckBox sub_check = addComponentToPanel(settingPanel, new JCheckBox("Subtract"), 0, 2);


        JCheckBox mul_check = addComponentToPanel(settingPanel, new JCheckBox("Muliply"), 0, 3);


        JCheckBox div_check = addComponentToPanel(settingPanel, new JCheckBox("Divide"), 0, 4);


        addComponentToPanel(settingPanel, new JButton("Confirm"), 0, 5);



        getContentPane().add(inputPanel, BorderLayout.CENTER);
        setVisible(true);


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
        new SimpleCalculator();
    }


}