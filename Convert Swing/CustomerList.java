
public class CustomerList{
	
	public static final int PROCESSING = 0;
	public static final int DELIVERING = 1;
	public static final int DELIVERED = 2;
	public static customer[] order = new customer[0];
	
	private String id;
	private String phoneNumber;
	private String size;
	private int quantity;
	private double amount;
	private int status;
	
	public  void placeOrder(String txtOrderId,String txtOrderPhoneNumber,String txtTShirtSize,int txtQuantity,double txtAmount){
						id = txtOrderId;
						phoneNumber = txtOrderPhoneNumber;
						size = txtTShirtSize;
						quantity = txtQuantity;
						amount = txtAmount;
						status = PROCESSING;
						
						customer order = new customer(id,phoneNumber,size,quantity,amount,status);
						customer[] or=extendObjectArray(order);
									
	}
	
	public static customer[] extendObjectArray(customer or){
		
			customer[] temp = new customer[order.length+1];
			for (int r = 0; r < order.length; r++){
				temp[r] = order[r];
			}
			order= temp;
			order[order.length-1]=or;
			return order;
		
	} 
	public static String center(String text, int length) {
        if (text.length() >= length) {
            return text;
        }
        int leftPadding = (length - text.length()) / 2;
        int rightPadding = length - text.length() - leftPadding;
        return " ".repeat(leftPadding) + text + " ".repeat(rightPadding);
    }
    
	public void getSearchCustomerDetails(String phoneNumber, searchCustomer searchCus){
		
		int[] tempQTY = new int[6];
		double[] tempAmount = new double[6];
		String[] tempSize = {"XS","S","M","L","XL","XXL"};
		
		for (int i = 0; i < order.length; i++){
			customer ar = order[i];
				if (ar.searchPhoneNumber(phoneNumber)){
					if (ar.getSize().equals("XS")){
						tempSize[0]="XS";
						tempQTY[0]+=ar.getQty();
						tempAmount[0]+=ar.getAmount();
					}
					else if(ar.getSize().equals("S")){
						tempSize[1]="S";
						tempQTY[1]+=ar.getQty();
						tempAmount[1]+=ar.getAmount();
					}
					else if (ar.getSize().equals("M")){
						tempSize[2]="M";
						tempQTY[2]+=ar.getQty();
						tempAmount[2]+=ar.getAmount();
					}
					else if (ar.getSize().equals("L")){
						tempSize[3]="L";
						tempQTY[3]+=ar.getQty();
						tempAmount[3]+=ar.getAmount();
					}
					else if (ar.getSize().equals("XL")){
						tempSize[4]="XL";
						tempQTY[4]+=ar.getQty();
						tempAmount[4]+=ar.getAmount();
					}
					else if (ar.getSize().equals("XXL")){
						tempSize[5]="XXL";
						tempQTY[5]+=ar.getQty();
						tempAmount[5]+=ar.getAmount();
					}
				}
		}
		int[] tempQTYArraySort = new int[6];
		double[] tempAmountArraySort = new double[6];
		String[] tempSizeArraySort = new String[6];
		
		for (int i = 0; i < tempQTYArraySort.length; i++){
			tempQTYArraySort[i] = tempQTY[i];
			tempAmountArraySort[i] = tempAmount[i];
			tempSizeArraySort[i] = tempSize[i];
		}
		
		for (int i = 0; i < tempAmountArraySort.length - 1; i++) {
			for (int j = 0; j < tempAmountArraySort.length - 1 - i; j++) {
				if (tempAmountArraySort[j] < tempAmountArraySort[j + 1]) {
					
					double tempAmounts = tempAmountArraySort[j];
					tempAmountArraySort[j] = tempAmountArraySort[j + 1];
					tempAmountArraySort[j + 1] = tempAmounts;

					int tempQty = tempQTYArraySort[j];
					tempQTYArraySort[j] = tempQTYArraySort[j + 1];
					tempQTYArraySort[j + 1] = tempQty;

					String tempSizes = tempSizeArraySort[j];
					tempSizeArraySort[j] = tempSizeArraySort[j + 1];
					tempSizeArraySort[j + 1] = tempSizes;
				}
			}
		}
		
		searchCus.setsizeArray(tempSizeArraySort);
		searchCus.setquantityArray(tempQTYArraySort);
		searchCus.setamountArray(tempAmountArraySort);
		
	}
	
	public void searchcustomer (String phoneNumber , searchCustomer searchCus){
			for (int i = 0; i < order.length; i++){
					customer b1 = order[i];
					boolean itsValue = b1.searchPhoneNumber(phoneNumber);
				if (itsValue==true){
					getSearchCustomerDetails(phoneNumber,searchCus);
				}else{
					
				}
			}
			
	}
	
	 public void searchorder(String id, searchOrder searchOr) {
        for (int i = 0; i < order.length; i++) {
            customer idIndex = order[i];
            boolean itValue = idIndex.searchOrderId(id);
            
            if (itValue) {
                
                searchOr.setPhoneNumber(idIndex.grtPhoneNumber());
                searchOr.setSize(idIndex.getSize());
                searchOr.setQuantity(idIndex.getQty());
                searchOr.setAmount(idIndex.getAmount());
                 int statusValue = idIndex.getStatus();
                if (statusValue==0){
					searchOr.setStatus("Processing");
				}
                else if (statusValue==1){
					searchOr.setStatus("Delivering ");
				}
                else{
					searchOr.setStatus("Deliverd");
				}
                
                searchOr.updateFields();
                
                break; 
            }
        }
    }
    
    public static void deleteorder(String id, searchOrder deleteOr){
		
			
			int index = -1;
				L1:for (int i = 0; i < order.length; i++){
					customer idIndex = order[i];
					boolean itsValue = idIndex.searchOrderId(id);
					if (itsValue==true)
					{
						index = i;
					}else{
						continue L1;
					}
			if(index>=0){
				remove(index);
                break; 
			}
				
		}
	}
	
	public static void remove(int index){
			customer[] tempOrderOrder = new customer[order.length-1]; 
			
		for(int i = index; i< order.length-1; i++){
			order[i] =order[i+1];	
		}
		for(int i = 0; i< order.length-1; i++){
			tempOrderOrder[i] = order[i];	
		}
		order = tempOrderOrder;
	}

	public static void bestIncustomer(bestInCustomer bestCus){
	
		int[] tempQTY = new int[0];
		double[] tempAmount = new double[0];
		String[] tempPhoneNumber = new String[0];
		
		for (int i = 0; i < order.length; i++){
			customer ar = order[i];
			boolean exists = false;
			for (int k = 0; k < tempPhoneNumber.length; k++) {
				if (ar.searchPhoneNumber(tempPhoneNumber[k])) {
					tempQTY[k] += ar.getQty();
					tempAmount[k] += ar.getAmount();
					exists = true;
					break;
				}
			}
			
				if (!exists) {
					int[] tempQTYOne = new int[tempQTY.length + 1];
					double[] tempAmountOne = new double[tempAmount.length + 1];
					String[] tempPhoneNumberOne = new String[tempPhoneNumber.length + 1];
					
					for (int r = 0; r < tempQTY.length; r++) {
						tempQTYOne[r] = tempQTY[r];
						tempAmountOne[r] = tempAmount[r];
						tempPhoneNumberOne[r] = tempPhoneNumber[r];
					}
					
					tempQTY = tempQTYOne;
					tempAmount = tempAmountOne;
					tempPhoneNumber = tempPhoneNumberOne;
					
					tempQTY[tempQTY.length - 1] = ar.getQty();
					tempAmount[tempAmount.length - 1] = ar.getAmount();
					tempPhoneNumber[tempPhoneNumber.length - 1] = ar.grtPhoneNumber();
				}
		}

			int[] tempQTYArraySort = new int[tempQTY.length];
			double[] tempAmountArraySort = new double[tempQTY.length];
			String[] tempPhoneNumberArraySort = new String[tempQTY.length];
		
			for (int i = 0; i < tempQTYArraySort.length; i++){
				tempQTYArraySort[i] = tempQTY[i];
				tempAmountArraySort[i] = tempAmount[i];
				tempPhoneNumberArraySort[i] = tempPhoneNumber[i];
			}
		
			for (int i = 0; i < tempAmountArraySort.length - 1; i++) {
				for (int j = 0; j < tempAmountArraySort.length - 1 - i; j++) {
					if (tempAmountArraySort[j] < tempAmountArraySort[j + 1]) {
						
						double tempAmounts = tempAmountArraySort[j];
						tempAmountArraySort[j] = tempAmountArraySort[j + 1];
						tempAmountArraySort[j + 1] = tempAmounts;

						int tempQty = tempQTYArraySort[j];
						tempQTYArraySort[j] = tempQTYArraySort[j + 1];
						tempQTYArraySort[j + 1] = tempQty;

						String tempPhoneNumberS = tempPhoneNumberArraySort[j];
						tempPhoneNumberArraySort[j] = tempPhoneNumberArraySort[j + 1];
						tempPhoneNumberArraySort[j + 1] = tempPhoneNumberS;
					}
				}
			}
			
		bestCus.setphoneNumberArray(tempPhoneNumberArraySort);
		bestCus.setquantityArray(tempQTYArraySort);
		bestCus.setamountArray(tempAmountArraySort);
    
	}
	
	public static void allorders(allOrders allOr){
		        
		int[] tempQTYArraySort = new int[order.length];
		double[] tempAmountArraySort = new double[order.length];
		String[] tempSizeArraySort = new String[order.length];
		String[] tempIdArraySort = new String[order.length];
		String[] tempPhoneNumberArraySort = new String[order.length];
		
		for (int i = 0; i < order.length; i++){
			customer ar = order[i];
			tempQTYArraySort[i] = ar.getQty();
			tempAmountArraySort[i] = ar.getAmount();
			tempSizeArraySort[i] = ar.getSize();
			tempIdArraySort[i] = ar.getId();
			tempPhoneNumberArraySort[i] = ar.grtPhoneNumber();
		}
		
		allOr.setidArray(tempIdArraySort);
		allOr.setphoneNumberArray(tempPhoneNumberArraySort);
		allOr.setsizeArray(tempSizeArraySort);
		allOr.setquantityArray(tempQTYArraySort);
		allOr.setamountArray(tempAmountArraySort);
		
	}
	
	 public void searchChangeStatusorder(String id, changeOrderStatus searchOr) {
        for (int i = 0; i < order.length; i++) {
            customer idIndex = order[i];
            boolean itValue = idIndex.searchOrderId(id);
            
            if (itValue) {
                
                searchOr.setPhoneNumber(idIndex.grtPhoneNumber());
                searchOr.setSize(idIndex.getSize());
                searchOr.setQuantity(idIndex.getQty());
                searchOr.setAmount(idIndex.getAmount());
                int statusValue = idIndex.getStatus();
                if (statusValue==0){
					searchOr.setStatus("Processing");
				}
                else if (statusValue==1){
					searchOr.setStatus("Delivering ");
				}
                else{
					searchOr.setStatus("Deliverd");
				}
                
                searchOr.updateFields();
                
                break; 
            }
        }
    }
    public void changeStatus (String id, int st ,changeOrderStatus searchOr){
		
                for (int i = 0; i < order.length; i++) {
				customer idIndex = order[i];
				boolean itValue = idIndex.searchOrderId(id);
            
            if (itValue) {
                
                searchOr.setPhoneNumber(idIndex.grtPhoneNumber());
                searchOr.setSize(idIndex.getSize());
                searchOr.setQuantity(idIndex.getQty());
                searchOr.setAmount(idIndex.getAmount());
                
                if (st==0){
					idIndex.SetStatus(PROCESSING);
					searchOr.setStatus("Processing");
				}
                else if (st==1){
					idIndex.SetStatus(DELIVERING);
					searchOr.setStatus("Delivering");
				}
                else{
					idIndex.SetStatus(DELIVERED);
					searchOr.setStatus("Deliverd");
				}
                
                searchOr.updateFields();
                
                break; 
            }
        }
    }
	
}
