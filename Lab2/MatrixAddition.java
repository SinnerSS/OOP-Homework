import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MatrixAddition extends JFrame {


    private int rows, columns;


    public MatrixAddition() {


        setTitle("Matrix Addition");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createInputPanel();


    }

    private void createInputPanel() {


        JPanel inputPanel = new JPanel(new GridBagLayout());


        addComponentToPanel(inputPanel, new JLabel("Enter number of rows:"), 0, 0);
        JTextField rowTextField = addComponentToPanel(inputPanel, new JTextField(10), 1, 0);
        addComponentToPanel(inputPanel, new JLabel("Enter number of columns:"), 0, 1);
        JTextField columnTextField = addComponentToPanel(inputPanel, new JTextField(10), 1, 1);


        JButton confirmInput = addComponentToPanel(inputPanel, new JButton("Confirm"), 1, 2, (event) -> {
            try {


                rows = Integer.parseInt(rowTextField.getText());
                columns = Integer.parseInt(columnTextField.getText());

                if(rows <= 0 || columns <= 0) throw new ArithmeticException();


                remove(inputPanel);
                createMatrixInputPanel();
                revalidate();
                repaint();


            } catch (NumberFormatException|ArithmeticException e) {

                JOptionPane.showMessageDialog(this, "Please enter valid numbers.", "Invalid input", JOptionPane.ERROR_MESSAGE);

            }
        });


        getContentPane().add(inputPanel);
        getRootPane().setDefaultButton(confirmInput);


    }

    private void createMatrixInputPanel() {


        JPanel matrixInputPanel = new JPanel(new GridBagLayout());
        JTextField[][] matrix1Fields = new JTextField[rows][columns];
        JTextField[][] matrix2Fields = new JTextField[rows][columns];


        addComponentToPanel(matrixInputPanel, new JLabel("Enter elements of first matrix:"), 0, 0, null, 4);


        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                matrix1Fields[i][j] = addComponentToPanel(matrixInputPanel, new JTextField(3), j, i + 1);

            }
        }


        addComponentToPanel(matrixInputPanel, new JLabel("Enter elements of second matrix:"), 0, rows + 1, null, 4);


        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                matrix2Fields[i][j] = addComponentToPanel(matrixInputPanel, new JTextField(3), j, i + rows + 2);

            }
        }


        addComponentToPanel(matrixInputPanel, new JButton("Back"), 0, 2 * rows + 2, (event) -> {


            remove(matrixInputPanel);
            createInputPanel();
            revalidate();
            repaint();


        }, 2);


        JButton addButton = addComponentToPanel(matrixInputPanel, new JButton("Add Matrices"), 2, 2 * rows + 2, (event) -> {
            try {


                int[][] matrix1 = new int[rows][columns];
                int[][] matrix2 = new int[rows][columns];


                for (int i = 0; i < rows; i++) {

                    for (int j = 0; j < columns; j++) {

                        matrix1[i][j] = Integer.parseInt(matrix1Fields[i][j].getText());
                        matrix2[i][j] = Integer.parseInt(matrix2Fields[i][j].getText());

                    }
                }


                int[][] result = addMatrices(matrix1, matrix2);
                displayResult(result);


            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(this, "Please enter valid numbers.", "Invalid input", JOptionPane.ERROR_MESSAGE);

            }
        }, 2);


        getContentPane().add(matrixInputPanel);
        getRootPane().setDefaultButton(addButton);


        SwingUtilities.invokeLater(() -> matrix1Fields[0][0].requestFocusInWindow());


    }



    private int[][] addMatrices(int[][] matrix1, int[][] matrix2) {


        int[][] result = new int[rows][columns];


        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                result[i][j] = matrix1[i][j] + matrix2[i][j];

            }
        }


        return result;


    }



    private void displayResult(int[][] result) {


        StringBuilder resultString = new StringBuilder("Result:\n");


        for (int i = 0; i < rows; i++) {


            for (int j = 0; j < columns; j++) {

                resultString.append(result[i][j]).append(" ");

            }


            resultString.append("\n");


        }


        JOptionPane.showMessageDialog(this, resultString.toString(), "Result", JOptionPane.INFORMATION_MESSAGE);


    }



    private <T extends Component> T addComponentToPanel(JPanel panel, T component, int x, int y) {

        return addComponentToPanel(panel, component, x, y, null);

    }



    private <T extends Component> T addComponentToPanel(JPanel panel, T component, int x, int y, ActionListener listener) {

        return addComponentToPanel(panel, component, x, y, listener, 1);

    }



    private <T extends Component> T addComponentToPanel(JPanel panel, T component, int x, int y, ActionListener listener, int width) {


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = width;
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
    public static void main(String[] args){

        SwingUtilities.invokeLater(() -> new MatrixAddition().setVisible(true));

    }
}