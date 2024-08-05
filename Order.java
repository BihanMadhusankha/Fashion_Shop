import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Order{
	String id;
	String phoneNumber;
	String size;
	int quantity;
	double amount;
	int status;
	
	 Order(String id,String phoneNumber,String size,int quantity,double amount,int status){
		this.id = id;
		this.phoneNumber= phoneNumber;
		this.size = size;
		this.quantity = quantity;
		this.amount = amount;
		this.status = status;
	}
	public boolean searchPhoneNumber(String Number){
		
				if(phoneNumber.equals(Number)){
					return true;	
				}	
			return false;	
	}
	
	public int getQty(){
		
		return quantity;
	}
	
	public double getAmount(){
		
		return amount;
	}
	public String grtPhoneNumber(){
		return phoneNumber;
	}
	
	public String getSize(){
		return size;
	}
	
	public String getId(){
		return id;
	}
	
	public int getStatus(){
		return status;
	}
	
	public boolean searchOrderId(String i){
		
			if(id.equalsIgnoreCase(i)){
				return true;
			}
		
		return false;
	}
	
	public void setOrderStatus(int status){
			this.status=status;
	}
}
