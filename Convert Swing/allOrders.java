import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.event.*;

public class allOrders extends JFrame{
		private JLabel title; 
		private JTable customerTable;
		private JScrollPane tableScrollPane;

		private String[] phoneNumber = new String[0];
		private String[] id = new String[0];
		private String[] size = new String[0];
		private int[] quantity = new int[0];
		private double[] amount = new double[0];
		
		allOrders(CustomerList Orders){
			setSize(600,600);
			setTitle("Fashion Shop");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			
			title = new JLabel("All Orders");
			title.setFont(new Font("",1,50));
			title.setHorizontalAlignment(JLabel.CENTER);
			add("North",title);
			
			Orders.allorders(allOrders.this);
        
			String[] columnNames = {"Order Id","Customer Id","Size", "Quantity", " Amount"};
			Object[][] data = new Object[phoneNumber.length][5];

			customerTable = new JTable(data, columnNames);
			tableScrollPane = new JScrollPane(customerTable);
			add("Center", tableScrollPane);

			updateTable();
		}
		
		 public void setidArray(String[] id) {
			this.id = id;
		}
		
		 public void setphoneNumberArray(String[] phoneNumber) {
			this.phoneNumber = phoneNumber;
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

		private void updateTable() {
			for (int i = 0; i < phoneNumber.length; i++) {
				customerTable.setValueAt(id[i], i, 0);
				customerTable.setValueAt(phoneNumber[i], i, 1);
				customerTable.setValueAt(size[i], i, 2);
				customerTable.setValueAt(quantity[i], i, 3);
				customerTable.setValueAt(amount[i], i, 4);
			}
		}
}
