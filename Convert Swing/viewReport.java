import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.event.*;
public class viewReport extends JFrame{
		private JLabel title;
		
		private JButton bestCustomerBtn;
		private JButton allOrdersBtn;
		viewReport(CustomerList Orders){
			setSize(600,600);
			setTitle("Fashion Shop");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			
			title = new JLabel("View Report");
			title.setFont(new Font("",1,50));
			title.setHorizontalAlignment(JLabel.CENTER);
			add("North",title);
			
			JPanel buttonHomeComponent = new JPanel(new GridLayout(0,1,2,5));
		
		bestCustomerBtn = new JButton("Best In Customer");
		bestCustomerBtn.setFont(new Font("",1,20));
		buttonHomeComponent.add(bestCustomerBtn);
		
		bestCustomerBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new bestInCustomer(Orders).setVisible(true);
			}
		});

		
		allOrdersBtn = new JButton("All Orders");
		allOrdersBtn.setFont(new Font("",1,20));
		buttonHomeComponent.add(allOrdersBtn);
		
		allOrdersBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new allOrders(Orders).setVisible(true);
			}
		});
		
		Border lineBorder = BorderFactory.createLineBorder(Color.BLACK, 2); 
        Border paddingBorder = BorderFactory.createEmptyBorder(20, 20, 20, 20);
        Border combinedBorder = BorderFactory.createCompoundBorder(lineBorder, paddingBorder);
        
        buttonHomeComponent.setBorder(combinedBorder);
		add("Center",buttonHomeComponent);
		}
}
