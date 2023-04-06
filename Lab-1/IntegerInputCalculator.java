import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IntegerInputCalculator {
    private JFrame mainFrame;
    private JPanel inputPanel, resultPanel;
    private JTextField firstNumberField, secondNumberField, resultField;

    public IntegerInputCalculator() {
        prepareGUI();
    }

    public static void main(String[] args) {
        IntegerInputCalculator calculator = new IntegerInputCalculator();
        calculator.showInputScreen();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Integer Input Calculator");
        mainFrame.setSize(400, 400);
        mainFrame.setLayout(new CardLayout());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel firstNumberLabel = new JLabel("Enter first integer:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(firstNumberLabel, gbc);

        firstNumberField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 0;
        inputPanel.add(firstNumberField, gbc);

        JLabel secondNumberLabel = new JLabel("Enter second integer:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(secondNumberLabel, gbc);

        secondNumberField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 1;
        inputPanel.add(secondNumberField, gbc);

        JButton calculateButton = new JButton("Calculate");
        gbc.gridx = 1;
        gbc.gridy = 2;
        inputPanel.add(calculateButton, gbc);

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int firstNumber = Integer.parseInt(firstNumberField.getText());
                int secondNumber = Integer.parseInt(secondNumberField.getText());
                int result = firstNumber + secondNumber;

                resultField.setText(String.valueOf(result));
                ((CardLayout) mainFrame.getContentPane().getLayout()).show(mainFrame.getContentPane(), "resultPanel");
            }
        });

        resultPanel = new JPanel(new GridBagLayout());

        resultField = new JTextField(10);
        resultField.setEditable(false);
        gbc.gridx = 1;
        gbc.gridy = 0;
        resultPanel.add(resultField, gbc);

        JButton backButton = new JButton("Back");
        gbc.gridx = 1;
        gbc.gridy = 1;
        resultPanel.add(backButton, gbc);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                firstNumberField.setText("");
                secondNumberField.setText("");
                resultField.setText("");
                ((CardLayout) mainFrame.getContentPane().getLayout()).show(mainFrame.getContentPane(), "inputPanel");
            }
        });

        mainFrame.add(inputPanel, "inputPanel");
        mainFrame.add(resultPanel, "resultPanel");
        mainFrame.setVisible(true);
    }

    private void showInputScreen() {
        ((CardLayout) mainFrame.getContentPane().getLayout()).show(mainFrame.getContentPane(), "inputPanel");
    }
}