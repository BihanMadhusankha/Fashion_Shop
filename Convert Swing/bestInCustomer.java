import javax.swing.*;
import java.awt.*;

public class bestInCustomer extends JFrame {
    private JLabel title;
    private JTable customerTable;
    private JScrollPane tableScrollPane;

    private String[] phoneNumber = new String[0];
    private int[] quantity = new int[0];
    private double[] amount = new double[0];

    bestInCustomer(CustomerList Orders) {
        setSize(600, 600);
        setTitle("Fashion Shop");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        title = new JLabel("Best In Customer");
        title.setFont(new Font("", 1, 50));
        title.setHorizontalAlignment(JLabel.CENTER);
        add("North", title);

        Orders.bestIncustomer(bestInCustomer.this);
        
        String[] columnNames = {"Customer Id", "All Quantity", "Total Amount"};
        Object[][] data = new Object[phoneNumber.length][3];

        customerTable = new JTable(data, columnNames);
        tableScrollPane = new JScrollPane(customerTable);
        add("Center", tableScrollPane);

        updateTable();
    }

    public void setphoneNumberArray(String[] phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setquantityArray(int[] quantity) {
        this.quantity = quantity;
    }

    public void setamountArray(double[] amount) {
        this.amount = amount;
    }

    private void updateTable() {
        for (int i = 0; i < phoneNumber.length; i++) {
            customerTable.setValueAt(phoneNumber[i], i, 0);
            customerTable.setValueAt(quantity[i], i, 1);
            customerTable.setValueAt(amount[i], i, 2);
        }
    }
}
