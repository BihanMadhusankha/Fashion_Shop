import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.event.*;
public class home extends JFrame{
	private JLabel title;
	
	private JButton placeOrderBtn;
	private JButton searchCustomerBtn;
	private JButton searchOrderBtn;
	private JButton viewReportBtn;
	private JButton changeStatusBtn;
	private JButton deleteOrderBtn;

	home(CustomerList Orders){
		setSize(600,600);
		setTitle("Fashion Shop");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		 title = new JLabel("FASHION SHOP");
		 title.setFont(new Font("",1,50));
		 title.setHorizontalAlignment(JLabel.CENTER);
		 add("North",title);
		 
		JPanel buttonHomeComponent = new JPanel(new GridLayout(0,1,2,5));
		
		placeOrderBtn = new JButton("Place Order");
		placeOrderBtn.setFont(new Font("",1,20));
		buttonHomeComponent.add(placeOrderBtn);
		
		placeOrderBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new placeOrder(Orders).setVisible(true);
			}
		});

		
		searchCustomerBtn = new JButton("Search Customer");
		searchCustomerBtn.setFont(new Font("",1,20));
		buttonHomeComponent.add(searchCustomerBtn);
		
		searchCustomerBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new searchCustomer(Orders).setVisible(true);
			}
		});
		
		searchOrderBtn = new JButton("Search Order");
		searchOrderBtn.setFont(new Font("",1,20));
		buttonHomeComponent.add(searchOrderBtn);
		
		searchOrderBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new searchOrder(Orders).setVisible(true);
			}
		});
		
		viewReportBtn = new JButton("View Report");
		viewReportBtn.setFont(new Font("",1,20));
		buttonHomeComponent.add(viewReportBtn);
		
		viewReportBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new viewReport(Orders).setVisible(true);
			}
		});
		
		changeStatusBtn = new JButton("Change Status");
		changeStatusBtn.setFont(new Font("",1,20));
		buttonHomeComponent.add(changeStatusBtn);
		
		changeStatusBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new changeOrderStatus(Orders).setVisible(true);
			}
		});
		
		
		deleteOrderBtn = new JButton("Delete Order");
		deleteOrderBtn.setFont(new Font("",1,20));
		buttonHomeComponent.add(deleteOrderBtn);
		
		deleteOrderBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new deleteOrder(Orders).setVisible(true);
			}
		});
		
		
		Border lineBorder = BorderFactory.createLineBorder(Color.BLACK, 2); 
        Border paddingBorder = BorderFactory.createEmptyBorder(20, 20, 20, 20);
        Border combinedBorder = BorderFactory.createCompoundBorder(lineBorder, paddingBorder);
        
        buttonHomeComponent.setBorder(combinedBorder);
		add(buttonHomeComponent);
	}

}
