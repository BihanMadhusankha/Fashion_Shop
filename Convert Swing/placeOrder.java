import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.event.*;
import java.util.concurrent.atomic.AtomicInteger;

public class placeOrder extends JFrame{
	private static final AtomicInteger counter = new AtomicInteger(0);
	
	private JLabel title;
	
	private JLabel lblOrderId;
	private JLabel lblOrderPhoneNumber;
	private JLabel lblTShirtSize;
	private JLabel lblQuantity;
	private JLabel lblAmount;
	
	private JTextField txtOrderId;
	private JTextField txtOrderPhoneNumber;
	private JTextField txtTShirtSize;
	private JTextField txtQuantity;
	private JTextField txtAmount;
	
	private JButton buttonPlaceOrder;
	private JButton buttonCancelOrder;
	private JButton checkAmount;
	placeOrder(CustomerList Orders ){
		setSize(600,600);
		setTitle("Fashion Shop");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		title = new JLabel("Place Order");
		title.setFont(new Font("",1,50));
		title.setHorizontalAlignment(JLabel.CENTER);
		add("North",title);
		 
		 JPanel textFieldPanel = new JPanel(new GridLayout(5,2,3,3));
		
		lblOrderId = new JLabel("Enter Order Id :");
		lblOrderId.setFont(new Font("",1,20));
		lblOrderId.setHorizontalAlignment(JLabel.CENTER);
		textFieldPanel.add(lblOrderId);
		
		txtOrderId = new JTextField(10);
		txtOrderId.setText(generateOrderID());
		txtOrderId.setFont(new Font("",1,20));
		textFieldPanel.add(txtOrderId);
		
		lblOrderPhoneNumber = new JLabel("Enter Phone Number :");
		lblOrderPhoneNumber.setFont(new Font("",1,20));
		lblOrderPhoneNumber.setHorizontalAlignment(JLabel.CENTER);
		textFieldPanel.add(lblOrderPhoneNumber);
		
		txtOrderPhoneNumber = new JTextField(10);
		txtOrderPhoneNumber.setFont(new Font("",1,20));
		textFieldPanel.add(txtOrderPhoneNumber);
		
		lblTShirtSize = new JLabel("Enter T-Shirt Size :");
		lblTShirtSize.setFont(new Font("",1,20));
		lblTShirtSize.setHorizontalAlignment(JLabel.CENTER);
		textFieldPanel.add(lblTShirtSize);
		
		txtTShirtSize = new JTextField(10);
		txtTShirtSize.setFont(new Font("",1,20));
		textFieldPanel.add(txtTShirtSize);
		
		lblQuantity = new JLabel("Enter T-Shirt Quantity :");
		lblQuantity.setFont(new Font("",1,20));
		lblQuantity.setHorizontalAlignment(JLabel.CENTER);
		textFieldPanel.add(lblQuantity);
		
		txtQuantity = new JTextField(10);
		txtQuantity.setFont(new Font("",1,20));
		textFieldPanel.add(txtQuantity);
		
		lblAmount = new JLabel("Amount :");
		lblAmount.setFont(new Font("",1,20));
		lblAmount.setHorizontalAlignment(JLabel.CENTER);
		textFieldPanel.add(lblAmount);
		 		
		txtAmount = new JTextField(10);
		txtAmount.setFont(new Font("",1,20));
		textFieldPanel.add(txtAmount); 
		
		Border lineBorder = BorderFactory.createLineBorder(Color.BLACK, 2); 
        Border paddingBorder = BorderFactory.createEmptyBorder(20, 20, 20, 20);
        Border combinedBorder = BorderFactory.createCompoundBorder(lineBorder, paddingBorder);
        
        textFieldPanel.setBorder(combinedBorder);
		add("Center",textFieldPanel);
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		checkAmount = new JButton("Check Amount");
		checkAmount.setFont(new Font("",1,10));
		buttonPanel.add("South",checkAmount);
		
		checkAmount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String tShirtSize = txtTShirtSize.getText();
					int index = indexSizeArray(tShirtSize);

					String quantityStr = txtQuantity.getText();
					if (quantityStr.isEmpty()) {
						throw new NumberFormatException("Quantity cannot be empty.");
					}
					int quantity = Integer.parseInt(quantityStr);

					double amountPerShirt = searchValue(index);
					double totalAmount = quantity * amountPerShirt;

					txtAmount.setText(Double.toString(totalAmount));
		
			}
		});
		buttonPlaceOrder = new JButton("Place Order");
		buttonPlaceOrder.setFont(new Font("",1,10));
		buttonPanel.add("South",buttonPlaceOrder);
		buttonPlaceOrder.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
				try {
					
					String orderId = txtOrderId.getText();
					String phoneNumber = txtOrderPhoneNumber.getText();
					String tShirtSize = txtTShirtSize.getText();
					int index = indexSizeArray(tShirtSize);
					String quantityStr = txtQuantity.getText();
					int quantity = Integer.parseInt(quantityStr);
					double amountPerShirt = searchValue(index);
					double totalAmount = quantity * amountPerShirt;

					Orders.placeOrder(orderId, phoneNumber, tShirtSize, quantity, totalAmount);
					new home(Orders).setVisible(true);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Invalid input: " + e.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		
		buttonCancelOrder = new JButton("Cancel Order");
		buttonCancelOrder.setFont(new Font("",1,10));
		buttonPanel.add("South",buttonCancelOrder);
		buttonCancelOrder.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				counter.decrementAndGet();		
				dispose();
			}
		});

		add("South",buttonPanel);
		
	}
	private String generateOrderID() {
        int id = counter.getAndIncrement();
        return String.format("ODR#%05d", id);
    }
    private static int indexSizeArray(String size) {
        String[] sizes = {"XS", "S", "M", "L", "XL", "XXL"};
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i].equals(size)) {
                return i;
            }
        }
        
        return -1;
    }
    private static double searchValue(int a){
		double[] tShirtPrice = {600.00,800.00,900.00,1000.00,1100.00,1200.00};
		for (int i = 0; i < tShirtPrice.length; i++)
		{
			if(i==a){
				return (tShirtPrice[i]);
				}
		}
		return 0.0;
	}
}
