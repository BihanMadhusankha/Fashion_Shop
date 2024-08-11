import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.event.*;

public class searchCustomer extends JFrame {
    private JLabel title;

    private JLabel lblEnterPhoneNumber;
    private JTextField txtEnterPhoneNumber;
    private JButton buttonSearchCustomer;
    private JButton buttonHome;

    private String[] size = new String[6];
    private int[] quantity = new int[6];
    private double[] amount = new double[6];

    private JTable customerTable;
    private JScrollPane tableScrollPane;

    searchCustomer(CustomerList Orders) {

        setSize(600, 600);
        setTitle("Fashion Shop");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        title = new JLabel("Search Customer");
        title.setFont(new Font("", 1, 50));
        title.setHorizontalAlignment(JLabel.CENTER);
        add("North", title);

        JPanel textFieldPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        lblEnterPhoneNumber = new JLabel("Enter Customer Phone Number :");
        lblEnterPhoneNumber.setFont(new Font("", 1, 20));
        lblEnterPhoneNumber.setHorizontalAlignment(JLabel.CENTER);
        textFieldPanel.add(lblEnterPhoneNumber);

        txtEnterPhoneNumber = new JTextField(10);
        txtEnterPhoneNumber.setFont(new Font("", 1, 20));
        textFieldPanel.add(txtEnterPhoneNumber);

        buttonSearchCustomer = new JButton("Search Customer");
        buttonSearchCustomer.setFont(new Font("", 1, 10));
        textFieldPanel.add(buttonSearchCustomer);
        
        JPanel deleteButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonHome = new JButton("Go Home");
        buttonHome.setFont(new Font("", Font.BOLD, 10));
        deleteButtonPanel.add(buttonHome);
        
        buttonHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				new home(Orders).setVisible(true);
            }
        });
        
        
        buttonSearchCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    String phoneNumber = txtEnterPhoneNumber.getText();
                    Orders.searchcustomer(phoneNumber, searchCustomer.this);
                    updateTable(); 
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input: " + e.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        Border lineBorder = BorderFactory.createLineBorder(Color.BLACK, 2);
        Border paddingBorder = BorderFactory.createEmptyBorder(20, 20, 20, 20);
        Border combinedBorder = BorderFactory.createCompoundBorder(lineBorder, paddingBorder);

        textFieldPanel.setBorder(combinedBorder);
        add("North", textFieldPanel);

        String[] columnNames = {"Size", "Quantity", "Amount"};
        Object[][] data = new Object[6][3];
        customerTable = new JTable(data, columnNames);
        tableScrollPane = new JScrollPane(customerTable);
        add("Center", tableScrollPane);
        add("South",deleteButtonPanel);
    }

    public void setsizeArray(String[] size) {
        this.size = size;
    }

    public void setquantityArray(int[] quantity) {
        this.quantity = quantity;
    }

    public void setamountArray(double[] amount) {
        this.amount = amount;
    }

    // Method to update the JTable with the data arrays
    private void updateTable() {
        for (int i = 0; i < 6; i++) {
            customerTable.setValueAt(size[i], i, 0);
            customerTable.setValueAt(quantity[i], i, 1);
            customerTable.setValueAt(amount[i], i, 2);
        }
    }
    
  }
