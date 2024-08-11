import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.event.*;

public class searchOrder extends JFrame {
    
   private String phoneNumber;
   private String size ;
   private int quantity ;
   private double amount;
   private String status ;  
    
    private JLabel title;
    
    private JLabel lblEnterOrderId;
    private JTextField txtEnterOrderId;
    private JButton buttonSearchOrder;
    private JButton buttonDeleteOrder;
    private JButton buttonHome;
    
    private JLabel lblOrderId;
    private JLabel lblOrderPhoneNumber;
    private JLabel lblTShirtSize;
    private JLabel lblQuantity;
    private JLabel lblAmount;
    private JLabel lblStatus;
    
    private JTextField txtOrderId;
    private JTextField txtOrderPhoneNumber;
    private JTextField txtTShirtSize;
    private JTextField txtQuantity;
    private JTextField txtAmount;
    private JTextField txtStatus;
    
    public searchOrder(CustomerList Orders) {
        
        setSize(600, 600);
        setTitle("Fashion Shop");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        title = new JLabel("Search Order");
        title.setFont(new Font("", Font.BOLD, 50));
        title.setHorizontalAlignment(JLabel.CENTER);
        titlePanel.add(title);
        
        JPanel textViewFieldPanel = new JPanel(new GridLayout(7, 2, 3, 3));
        JPanel orderNumber = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        lblEnterOrderId = new JLabel("Enter Order ID:");
        lblEnterOrderId.setFont(new Font("", Font.BOLD, 20));
        orderNumber.add(lblEnterOrderId);
        textViewFieldPanel.add(orderNumber);
        
        txtEnterOrderId = new JTextField(10);
        txtEnterOrderId.setFont(new Font("", Font.PLAIN, 20));
        orderNumber.add(txtEnterOrderId);
        textViewFieldPanel.add(orderNumber);
        
        buttonSearchOrder = new JButton("Search Order");
        buttonSearchOrder.setFont(new Font("", Font.BOLD, 10));
        textViewFieldPanel.add(buttonSearchOrder);
        
        lblOrderPhoneNumber = new JLabel("Phone Number:");
        lblOrderPhoneNumber.setFont(new Font("", Font.BOLD, 20));
        lblOrderPhoneNumber.setHorizontalAlignment(JLabel.CENTER);
        textViewFieldPanel.add(lblOrderPhoneNumber);
        
        txtOrderPhoneNumber = new JTextField(10);
        txtOrderPhoneNumber.setFont(new Font("", Font.PLAIN, 20));
        textViewFieldPanel.add(txtOrderPhoneNumber);
        
        lblTShirtSize = new JLabel("T-Shirt Size:");
        lblTShirtSize.setFont(new Font("", Font.BOLD, 20));
        lblTShirtSize.setHorizontalAlignment(JLabel.CENTER);
        textViewFieldPanel.add(lblTShirtSize);
        
        txtTShirtSize = new JTextField(10);
        txtTShirtSize.setFont(new Font("", Font.PLAIN, 20));
        textViewFieldPanel.add(txtTShirtSize);
        
        lblQuantity = new JLabel("T-Shirt Quantity:");
        lblQuantity.setFont(new Font("", Font.BOLD, 20));
        lblQuantity.setHorizontalAlignment(JLabel.CENTER);
        textViewFieldPanel.add(lblQuantity);
        
        txtQuantity = new JTextField(10);
        txtQuantity.setFont(new Font("", Font.PLAIN, 20));
        textViewFieldPanel.add(txtQuantity);
        
        lblAmount = new JLabel("Amount:");
        lblAmount.setFont(new Font("", Font.BOLD, 20));
        lblAmount.setHorizontalAlignment(JLabel.CENTER);
        textViewFieldPanel.add(lblAmount);
        
        txtAmount = new JTextField(10);
        txtAmount.setFont(new Font("", Font.PLAIN, 20));
        textViewFieldPanel.add(txtAmount);
        
        lblStatus = new JLabel("Status:");
        lblStatus.setFont(new Font("", Font.BOLD, 20));
        lblStatus.setHorizontalAlignment(JLabel.CENTER);
        textViewFieldPanel.add(lblStatus);
        
        txtStatus = new JTextField(10);
        txtStatus.setFont(new Font("", Font.PLAIN, 20));
        textViewFieldPanel.add(txtStatus);
        
        buttonSearchOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String orderId = txtEnterOrderId.getText();
                Orders.searchorder(orderId, searchOrder.this); 
            }
        });
        
        JPanel deleteButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonDeleteOrder = new JButton("Delete Order");
        buttonDeleteOrder.setFont(new Font("", Font.BOLD, 10));
        deleteButtonPanel.add(buttonDeleteOrder);
        textViewFieldPanel.add(deleteButtonPanel);
        
        buttonHome = new JButton("Go Home");
        buttonHome.setFont(new Font("", Font.BOLD, 10));
        deleteButtonPanel.add(buttonHome);
        textViewFieldPanel.add(deleteButtonPanel);
        
        buttonDeleteOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String orderId = txtEnterOrderId.getText();
                Orders.deleteorder(orderId, searchOrder.this); 
                new home(Orders).setVisible(true);
            }
        });
        
        buttonHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                 
                new home(Orders).setVisible(true);
            }
        });
        
        Border lineBorder = BorderFactory.createLineBorder(Color.BLACK, 2); 
        Border paddingBorder = BorderFactory.createEmptyBorder(20, 20, 20, 20);
        Border combinedBorder = BorderFactory.createCompoundBorder(lineBorder, paddingBorder);
        
        add(titlePanel, BorderLayout.NORTH);
        add(textViewFieldPanel, BorderLayout.CENTER);
    }
    
    private String getPhoneNumber() {
        return phoneNumber;
    }
    
    private String getsize() {
        return size;
    }
    
    private int getQuantity() {
        return quantity;
    }
    
    private double getAmount() {
        return amount;
    }
    
    private String getStatus() {
        return status;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public void setSize(String size) {
        this.size = size;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public void updateFields() {
        txtOrderPhoneNumber.setText(getPhoneNumber());
        txtTShirtSize.setText(getsize());
        txtQuantity.setText(Integer.toString(getQuantity()));
        txtAmount.setText(Double.toString(getAmount()));
        txtStatus.setText(getStatus());
        
    }
}
