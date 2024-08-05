import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class convertFashionshop{
	private static final AtomicInteger counter = new AtomicInteger(0);
	static Order[] orders = new Order[0];
	public static final int PROCESSING = 0;
	public static final int DELIVERING = 1;
	public static final int DELIVERED = 2;

public final static void clearConsole() {
		try {
			final String os = System.getProperty("os.name");
			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		} catch (final Exception e) {
			e.printStackTrace();

		}
	}
	
	public static String center(String text, int length) {
        if (text.length() >= length) {
            return text;
        }
        int leftPadding = (length - text.length()) / 2;
        int rightPadding = length - text.length() - leftPadding;
        return " ".repeat(leftPadding) + text + " ".repeat(rightPadding);
    }
    
	public static void main(String[] args){
		home();
		
	}
	public static void home(){
		System.out.println("\n\n");
		System.out.println("\t\t\t  /$$$$$$$$                 /$$       /$$                            /$$$$$$  /$$");                          
		System.out.println("\t\t\t | $$_____/                | $$      |__/                           /$$__  $$| $$  ");                        
		System.out.println("\t\t\t | $$    /$$$$$$   /$$$$$$$| $$$$$$$  /$$  /$$$$$$  /$$$$$$$       | $$  \\__/| $$$$$$$   /$$$$$$   /$$$$$$ ");
		System.out.println("\t\t\t | $$$$$|____  $$ /$$_____/| $$__  $$| $$ /$$__  $$| $$__  $$      |  $$$$$$ | $$__  $$ /$$__  $$ /$$__  $$");
		System.out.println("\t\t\t | $$__/ /$$$$$$$|  $$$$$$ | $$  \\ $$| $$| $$  \\ $$| $$  \\ $$       \\____  $$| $$  \\ $$| $$  \\ $$| $$  \\ $$");
		System.out.println("\t\t\t | $$   /$$__  $$ \\____  $$| $$  | $$| $$| $$  | $$| $$  | $$       /$$  \\ $$| $$  | $$| $$  | $$| $$  | $$");
		System.out.println("\t\t\t | $$  |  $$$$$$$ /$$$$$$$/| $$  | $$| $$|  $$$$$$/| $$  | $$      |  $$$$$$/| $$  | $$|  $$$$$$/| $$$$$$$/");
		System.out.println("\t\t\t |__/   \\_______/|_______/ |__/  |__/|__/ \\______/ |__/  |__/       \\______/ |__/  |__/ \\______/ | $$____/ ");
		System.out.println("\t\t\t                                                                                                 | $$   ");   
		System.out.println("\t\t\t                                                                                                 | $$  ");    
		System.out.println("\t\t\t                                                                                                 |__/  ");    
		System.out.println("\t\t============================================================================================================================");
		
		System.out.print("\n\t\t\t[1] Place Order");
		System.out.println("\t\t\t\t\t[2] Search Customer\n");
		System.out.print("\t\t\t[3] Search Order");
		System.out.println("\t\t\t\t[4] View Report\n");
		System.out.print("\t\t\t[5] Change Order Status");
		System.out.println("\t\t\t\t[6] Delete Order\n");
		goOption();

	}
	public static void goOption(){
		Scanner input = new Scanner(System.in);
		System.out.print("\t\tInput Option :");
		int option = input.nextInt();
		
		switch(option){
			case 1: clearConsole();placeOrder(); break;
			case 2: clearConsole();searchCustomer(); break;
			case 3: clearConsole();searchOrder(); break;
			case 4:	clearConsole();viewReport(); break;
			case 5: clearConsole();changeOrderStatus(); break;
			case 6: clearConsole();deleteOrder(); break;
			default:System.out.println("Invalid input");break;
			}
	}
	public static String generateOrderID() {
        int id = counter.getAndIncrement();
        return String.format("ODR#%05d", id);
    }
    
    public static String enterPhoneNumber(){
		Scanner input = new Scanner(System.in);
		System.out.print("\t\t\tEnter Customer Phone Number : ");
		String phoneNumber = input.next();
		if(phoneNumber.length()==10 && phoneNumber.charAt(0)=='0'){
			return phoneNumber;
		}else{
			return "Invalid Phone Number";
			}
		 
	}
	public static boolean checkSizeInSystem(String size) {
        String[] sizes = {"XS", "S", "M", "L", "XL", "XXL"};
        for (String s : sizes) {
            if (s.equalsIgnoreCase(size)) {
                return true;
            }
        }
        return false;
    }

    public static String enterSize() {
        Scanner input = new Scanner(System.in);
        
        L1:while(true){
				System.out.print("\t\t\tEnter T-Shirt Size: ");
				String size = input.next();
			if (checkSizeInSystem(size)) {
				return size;
			} else {
				System.out.print("\033[10J");
				continue  L1;
			}
		}
    }
    
    public static int enterQty(){
		Scanner input = new Scanner(System.in);
        System.out.print("\t\t\tEnter QTY : ");
        int quantity = input.nextInt();
		return quantity;
		}
	public static int indexSizeArray(String size) {
        String[] sizes = {"XS", "S", "M", "L", "XL", "XXL"};
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i].equals(size)) {
                return i;
            }
        }
        
        return -1;
    }
	public static double searchValue(int a){
		double[] tShirtPrice = {600.00,800.00,900.00,1000.00,1100.00,1200.00};
		for (int i = 0; i < tShirtPrice.length; i++)
		{
			if(i==a){
				return (tShirtPrice[i]);
				}
		}
		return 0.0;
	}
	public static Order[] extendObjectArray(Order order){
		
			Order[] temp = new Order[orders.length+1];
			for (int r = 0; r < orders.length; r++){
				temp[r] = orders[r];
			}
			orders= temp;
			orders[orders.length-1]=order;
			return orders;
		
	} 
	public static void placeOrder(){
	
		do{
					System.out.println("\t\t\t _____  _                   ____          _        ");   
					System.out.println("\t\t\t|  __ \\| |                 / __ \\        | |          ");
					System.out.println("\t\t\t| |__) | | __ _  ___ ___  | |  | |_ __ __| | ___ _ __ ");
					System.out.println("\t\t\t|  ___/| |/ _` |/ __/ _ \\ | |  | | '__/ _` |/ _ \\ '__|");
					System.out.println("\t\t\t| |    | | (_| | (_|  __/ | |__| | | | (_| |  __/ |   ");
					System.out.println("\t\t\t|_|    |_|\\__,_|\\___\\___|  \\____/|_|  \\__,_|\\___|_| ");
					System.out.println("\t\t\t=======================================================\n\n");

					Scanner input = new Scanner(System.in);
						
						String Id = generateOrderID();
						System.out.println("\t\t\tEnter Order Id : "+Id+"\n");

						String phoneNumber = enterPhoneNumber();
						if (phoneNumber.equals("Invalid Phone Number")){
							System.out.print("\t\t\tDo you want to enter  phone number again ? (y/n) : ");
							char yesORno = input.next().charAt(0);
							if(yesORno=='y'|| yesORno=='Y' ){
									counter.decrementAndGet();
									clearConsole();
									placeOrder();
								}
						}else{
							String size = enterSize();
							int index =indexSizeArray(size);
							int quantity=enterQty();
							double Amount = searchValue(index);
							double totalAmount =Amount*quantity;
							int status = PROCESSING;
							System.out.println("\t\t\tAmount : "+totalAmount+"\n");
							 
							System.out.print("\t\t\tDo you want to place this order ? (y/n) : ");
							char yesORno = input.next().charAt(0);
							if(yesORno=='y'|| yesORno=='Y' ){
								
								Order order = new Order(Id,phoneNumber,size,quantity,totalAmount,status);
								Order[] or=extendObjectArray(order);
								
								System.out.println("\t\t\t\t Order Placed..!\n");
								System.out.print("\t\t\tDo you want to place another order ? (y/n) : ");
								
									char yesorno = input.next().charAt(0);
									if(yesorno=='y'|| yesorno=='Y' ){
										clearConsole();
										placeOrder();
										
									}else{
										clearConsole();
										home();
										}
						
							}else{
								clearConsole();
								counter.decrementAndGet();
								placeOrder();
							}
						}
			
				} while (true);
	}
	
	public static void getSearchCustomerDetails(String phoneNumber){
		
		int[] tempQTY = new int[6];
		double[] tempAmount = new double[6];
		String[] tempSize = {"XS","S","M","L","XL","XXL"};
		
		for (int i = 0; i < orders.length; i++){
			Order ar = orders[i];
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
		System.out.println("\t\t\t\t+----------+-----------+-------------------+");
		System.out.printf("\t\t\t\t|%10s|%10s|%20s|%n", center("Size", 10), center("QTY", 10), center("Amount", 20));
		System.out.println("\t\t\t\t+----------+-----------+-------------------+");
		
		 for (int i = 0; i < tempSizeArraySort.length; i++) {
            System.out.printf("\t\t\t\t|%10s|%10d|%20.2f|%n", center(tempSizeArraySort[i], 10), tempQTYArraySort[i], tempAmountArraySort[i]);
            
		}
		double allTotals = 0.0;
				for (int i =0; i<tempAmountArraySort.length;i++) {
						allTotals += tempAmountArraySort[i];
		}
				System.out.println("\t\t\t\t+----------+-----------+-------------------+");
				System.out.printf("\t\t\t\t|%20s |%20.2f|%n", "Total", allTotals);
				System.out.println("\t\t\t\t+----------+-----------+-------------------+");
		
		
	}
	
	
	public static void searchCustomer(){
		do{
			Scanner input = new Scanner(System.in);
			
			 System.out.println("\t\t\t  _____                     _        _____          _                            ");
			 System.out.println("\t\t\t / ____|                   | |      / ____|        | |                           ");
			 System.out.println("\t\t\t| (___   ___  __ _ _ __ ___| |__   | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ ");
			 System.out.println("\t\t\t \\___ \\ / _ \\/ _` | '__/ __| '_ \\  | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__|");
			 System.out.println("\t\t\t ____) |  __/ (_| | | | (__| | | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |   ");
			 System.out.println("\t\t\t|_____/ \\___|\\__,_|_|  \\___|_| |_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|   ");
			 System.out.println("\t\t\t====================================================================================\n\n");                                                                                 
                                                                                  

			System.out.print("\t\tEnter Customer Phone Number : ");
			String phoneNumber = input.next();
			 
			for (int i = 0; i < orders.length; i++){
					Order b1 = orders[i];
					boolean itsValue = b1.searchPhoneNumber(phoneNumber);
				if (itsValue==true){
					getSearchCustomerDetails(phoneNumber);
					System.out.print("\t\tDo you want search another customer? (y/n):");
					char option = input.next().charAt(0);
					if (option=='y'|| option=='Y'){
						clearConsole();
						searchCustomer();
					}else{
						clearConsole();
						home();
					}
				}else{
					System.out.println("\t\t\tInvalid Input......");	
					System.out.print("\t\tDo you want search another customer? (y/n):");
					char option = input.next().charAt(0);
					if (option=='y'|| option=='Y'){
						clearConsole();
						continue;
					}else{
						clearConsole();
						home();
						}
				}
			}
		
		}while(true);
		
	}
	
	
	public static void searchOrder(){
		do{
			
			Scanner input = new Scanner(System.in);
			
			System.out.println("\t\t\t   _____                     _        ____          _           ");
			System.out.println("\t\t\t  / ____|                   | |      / __ \\        | |          ");
			System.out.println("\t\t\t | (___   ___  __ _ _ __ ___| |__   | |  | |_ __ __| | ___ _ __ ");
			System.out.println("\t\t\t  \\___ \\ / _ \\/ _` | '__/ __| '_ \\  | |  | | '__/ _` |/ _ \\ '__|");
			System.out.println("\t\t\t  ____) |  __/ (_| | | | (__| | | | | |__| | | | (_| |  __/ |   ");
			System.out.println("\t\t\t |_____/ \\___|\\__,_|_|  \\___|_| |_|  \\____/|_|  \\__,_|\\___|_|   ");
            System.out.println("\t\t\t====================================================================================\n\n");                                                    
                                                                

		System.out.print("\t\tEnter order ID : ");
		String id = input.next();
			for (int i = 0; i < orders.length; i++){
				Order idIndex = orders[i];
				boolean itValue = idIndex.searchOrderId(id);
				
				if(itValue==false){
				System.out.println("\t\t\tInvalid input....");
				System.out.print("\t\tDo you want to search anothr order? (y/n) :");
				char yesorno = input.next().charAt(0);
							if(yesorno=='y'|| yesorno=='Y' ){
								clearConsole();
								searchOrder();
								
							}else{
								clearConsole();
								home();
							}
				}else{
				
					System.out.println("\n\t\tPhone Number :"+idIndex.grtPhoneNumber());
					System.out.println("\t\tSize :"+idIndex.getSize());
					System.out.println("\t\tQTY :"+idIndex.getQty());
					System.out.println("\t\tAmount :"+idIndex.getAmount());
					if(idIndex.getStatus() == PROCESSING){
						System.out.println("\t\tStatus : Processing");
					}else if(idIndex.getStatus() == DELIVERING){
						System.out.println("Status : Delivering");
					}else{
						System.out.println("Status : Delivered");
					}

					System.out.print("\t\tDo you want to search anothr order? (y/n) :");
					char yesornO = input.next().charAt(0);
								if(yesornO=='y'|| yesornO=='Y' ){
									clearConsole();
									searchOrder();
									
								}else{
									clearConsole();
									home();
								}
				}
			}
		
		
		} while (true);
		
	}
	
	public static void bestInCustomer(){
		
		System.out.println("\t\t\t  ____            _     _____          _____          _                                ");
		System.out.println("\t\t\t |  _ \\          | |   |_   _|        / ____|        | |                               ");
		System.out.println("\t\t\t | |_) | ___  ___| |_    | |  _ __   | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ ___ ");
		System.out.println("\t\t\t |  _ < / _ \\/ __| __|   | | | '_ \\  | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__/ __|");
		System.out.println("\t\t\t | |_) |  __/\\__ \\ |_   _| |_| | | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |  \\__ \\");
		System.out.println("\t\t\t |____/ \\___||___/\\__| |_____|_| |_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|  |___/");
		System.out.println("\t\t\t====================================================================================\n\n");                                                                                       
                                                                                       
	Scanner input = new Scanner(System.in);
		
    int[] tempQTY = new int[0];
    double[] tempAmount = new double[0];
    String[] tempPhoneNumber = new String[0];
    
    for (int i = 0; i < orders.length; i++){
		Order ar = orders[i];
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
    
    System.out.println("\t\t\t\t+---------------+----------+-------------------+");
    System.out.printf("\t\t\t\t|%15s|%10s|%20s|%n", center("Customer ID", 15), center("QTY", 10), center("Amount", 20));
    System.out.println("\t\t\t\t+---------------+----------+-------------------+");
    
    for (int l = 0; l < tempAmountArraySort.length; l++) {
        System.out.printf("\t\t\t\t|%15s|%10d|%20.2f|%n", center(tempPhoneNumberArraySort[l], 15), tempQTYArraySort[l], tempAmountArraySort[l]);
    }
		System.out.println("\t\t\t\t+---------------+----------+-------------------+");
		System.out.print("To access the main Menu, pleaSe enter 0 :");
		char zero = input.next().charAt(0);
		while (zero == '0'){
			clearConsole();
				home();
		}
		clearConsole();	
}
public static void allOrders(){
		
		System.out.println("\t\t\t           _ _    ____          _               ");
		System.out.println("\t\t\t     /\\   | | |  / __ \\        | |              ");
		System.out.println("\t\t\t    /  \\  | | | | |  | |_ __ __| | ___ _ __ ___ ");
		System.out.println("\t\t\t   / /\\ \\ | | | | |  | | '__/ _` |/ _ \\ '__/ __|");
		System.out.println("\t\t\t  / ____ \\| | | | |__| | | | (_| |  __/ |  \\__ \\");
		System.out.println("\t\t\t /_/    \\_\\_|_|  \\____/|_|  \\__,_|\\___|_|  |___/");
		System.out.println("\t\t\t====================================================================================\n\n");                                                 
                                                

		Scanner input = new Scanner(System.in);
		int[] tempQTYArraySort = new int[orders.length];
		double[] tempAmountArraySort = new double[orders.length];
		String[] tempSizeArraySort = new String[orders.length];
		String[] tempIdArraySort = new String[orders.length];
		String[] tempPhoneNumberArraySort = new String[orders.length];
		
		for (int i = 0; i < orders.length; i++){
			Order ar = orders[i];
			tempQTYArraySort[i] = ar.getQty();
			tempAmountArraySort[i] = ar.getAmount();
			tempSizeArraySort[i] = ar.getSize();
			tempIdArraySort[i] = ar.getId();
			tempPhoneNumberArraySort[i] = ar.grtPhoneNumber();
		}
		
		System.out.println("\t\t\t\t+----------+---------------+----------+-----------+-------------------+");
		System.out.printf("\t\t\t\t|%10s|%15s|%10s|%10s|%20s|%n", center("Order ID", 10),center("Customer ID", 15),center("Size", 10), center("QTY", 10), center("Amount", 20));
		System.out.println("\t\t\t\t+----------+---------------+----------+-----------+-------------------+");
		
		 for (int i = 0; i < tempSizeArraySort.length; i++) {
            System.out.printf("\t\t\t\t|%10s|%15s|%10s|%10d|%20.2f|%n", center(tempIdArraySort[i], 10),center(tempPhoneNumberArraySort[i], 15),center(tempSizeArraySort[i], 10), tempQTYArraySort[i], tempAmountArraySort[i]);
            
		}
		System.out.println("\t\t\t\t+----------+---------------+----------+-----------+-------------------+\n");
		System.out.print("To access the main Menu, pleaSe enter 0 :");
		char zero = input.next().charAt(0);
		while (zero == '0'){
			clearConsole();
				home();
		}
		clearConsole();	
	}
		
	public static void viewReport(){
		do{
			
			System.out.println("\t\t\t __      ___                 _____                       _   ");
			System.out.println("\t\t\t \\ \\    / (_)               |  __ \\                     | |  ");
			System.out.println("\t\t\t  \\ \\  / / _  _____      __ | |__) |___ _ __   ___  _ __| |_ ");
			System.out.println("\t\t\t   \\ \\/ / | |/ _ \\ \\ /\\ / / |  _  // _ \\ '_ \\ / _ \\| '__| __|");
			System.out.println("\t\t\t    \\  /  | |  __/\\ V  V /  | | \\ \\  __/ |_) | (_) | |  | |_ ");
			System.out.println("\t\t\t     \\/   |_|\\___| \\_/\\_/   |_|  \\_\\___| .__/ \\___/|_|   \\__|");
			System.out.println("\t\t\t                                       | |                   ");
			System.out.println("\t\t\t                                       |_|                   ");
			System.out.println("\t\t\t====================================================================================\n\n");

			Scanner input = new Scanner(System.in);
			System.out.println("\t\t\t\t[1] Best In Customers");
			System.out.println("\t\t\t\t[2] All Orders\n");
			System.out.print("\t\t\tEnter Option :");
			
			int option = input.nextInt();
			
			switch(option){
				case 1: clearConsole();bestInCustomer();break;
				case 2: clearConsole();allOrders();break;
				default:System.out.println("Invalid input");break;
				}
		
		} while (true);
		
		
	}
	
	public static void changeOrderStatus(){
			
			do{
				
				System.out.println("\t\t\t   _____ _                               ____          _              _____ _        _             ");
				System.out.println("\t\t\t  / ____| |                             / __ \\        | |            / ____| |      | |            ");
				System.out.println("\t\t\t | |    | |__   __ _ _ __   __ _  ___  | |  | |_ __ __| | ___ _ __  | (___ | |_ __ _| |_ _   _ ___ ");
				System.out.println("\t\t\t | |    | '_ \\ / _` | '_ \\ / _` |/ _ \\ | |  | | '__/ _` |/ _ \\ '__|  \\___ \\| __/ _` | __| | | / __|");
				System.out.println("\t\t\t | |____| | | | (_| | | | | (_| |  __/ | |__| | | | (_| |  __/ |     ____) | || (_| | |_| |_| \\__ \\");
				System.out.println("\t\t\t  \\_____|_| |_|\\__,_|_| |_|\\__, |\\___|  \\____/|_|  \\__,_|\\___|_|    |_____/ \\__\\__,_|\\__|\\__,_|___/");
				System.out.println("\t\t\t                            __/ |                                                                  ");
				System.out.println("\t\t\t                           |___/                                                                   ");
				System.out.println("\t\t\t====================================================================================\n\n");
				
				Scanner input = new Scanner(System.in);
				System.out.print("\t\t\tEnter Orde Id : ");
				String orderId  = input.next();

				int index = -1;
				L1:for (int i = 0; i < orders.length; i++){
						Order ar = orders[i];
						boolean itsValue = ar.searchOrderId(orderId);
						if (itsValue==true){
							index = i;
						}else{
							continue L1;
						}
				
						if(index<0){
						System.out.println("\nInvalid Id...");
						}else{
						
								System.out.println("\t\tPhone Number :"+ar.grtPhoneNumber());
								System.out.println("\t\tSize :"+ar.getSize());
								System.out.println("\t\tQTY :"+ar.getQty());
								System.out.println("\t\tAmount :"+ar.getAmount());
								if(ar.getStatus() == PROCESSING){
									System.out.println("\t\tStatus : Processing");
								}else if(ar.getStatus() == DELIVERING){
									System.out.println("Status : Delivering");
								}else{
									System.out.println("Status : Delivered");
								}
								 int statusValue = ar.getStatus();
								 if (statusValue==DELIVERED){
									 System.out.print("\n\t\t\tCan't change this order status, Order already delivered...!");
									 System.out.print("\n\t\t\tDo you want to change this order status? (y/n) : ");
									 char ch = input.next().charAt(0);
										if(ch == 'y' || ch == 'Y'){
											if (ar.getStatus()==0){
												System.out.println("\n\t[1]Order Delivering ");
												System.out.println("\n\t[2]Order Deliverd ");	
												System.out.print("\n\tEnter option : ");
												int option = input.nextInt();
												if(option==1){
													ar.setOrderStatus(DELIVERING);
												}
												else if(option==2){
													ar.setOrderStatus(DELIVERED);
												}
											}else if(ar.getStatus()==1){
												System.out.println("\n\t[1]Order Deliverd ");
												System.out.print("\n\tEnter option : ");
												int option = input.nextInt();
												if(option==1){
													ar.setOrderStatus(DELIVERED);
												}
											}
									
											clearConsole();
											home();
										}else if(ch == 'n' || ch=='N'){
											clearConsole();
											home();
										}
								 }
								 else{
									System.out.print("\nDo you want to change this order status? (y/n) : ");
									char ch = input.next().charAt(0);
										if(ch == 'y' || ch == 'Y'){
											if (ar.getStatus()==0){
												System.out.println("\n\t[1]Order Delivering ");
												System.out.println("\n\t[2]Order Deliverd ");	
												System.out.print("\n\tEnter option : ");
												int option = input.nextInt();
												if(option==1){
													ar.setOrderStatus(DELIVERING);
												}
												else if(option==2){
													ar.setOrderStatus(DELIVERED);
												}
											}else if(ar.getStatus()==1){
												System.out.println("\n\t[1]Order Deliverd ");
												System.out.print("\n\tEnter option : ");
												int option = input.nextInt();
												if(option==1){
													ar.setOrderStatus(DELIVERED);
												}
											}
									
											clearConsole();
											home();
										}else if(ch == 'n' || ch=='N'){
											clearConsole();
											home();
										}
								}
					}		
				}	
			}while (true);
			
	}
	
	public static void remove(int index){
			Order[] tempOrderOrder = new Order[orders.length-1]; 
			
		for(int i = index; i< orders.length-1; i++){
			orders[i] =orders[i+1];	
		}
		for(int i = 0; i< orders.length-1; i++){
			tempOrderOrder[i] = orders[i];	
		}
		orders = tempOrderOrder;
	}

	public static void deleteOrder(){
		do{
			
			
			System.out.println("\t\t\t  _____       _      _          ____          _           ");
			System.out.println("\t\t\t |  __ \\     | |    | |        / __ \\        | |          ");
			System.out.println("\t\t\t | |  | | ___| | ___| |_ ___  | |  | |_ __ __| | ___ _ __ ");
			System.out.println("\t\t\t | |  | |/ _ \\ |/ _ \\ __/ _ \\ | |  | | '__/ _` |/ _ \\ '__|");
			System.out.println("\t\t\t | |__| |  __/ |  __/ ||  __/ | |__| | | | (_| |  __/ |   ");
			System.out.println("\t\t\t |_____/ \\___|_|\\___|\\__\\___|  \\____/|_|  \\__,_|\\___|_|   ");
			System.out.println("\t\t\t====================================================================================\n\n");                                                          
			
			Scanner input = new Scanner(System.in);
			System.out.print("\n\t\t\tEnter Orde Id : ");
			String orderId  = input.next();
			int index = -1;
				L1:for (int i = 0; i < orders.length; i++){
					Order ar = orders[i];
					boolean itsValue = ar.searchOrderId(orderId);
					if (itsValue==true)
					{
						index = i;
					}else{
						continue L1;
					}
			if(index<0){
				System.out.println("\nInvalid Id...");
			}else{
			System.out.println("\t\tPhone Number :"+ar.grtPhoneNumber());
			System.out.println("\t\tSize :"+ar.getSize());
			System.out.println("\t\tQTY :"+ar.getQty());
			System.out.println("\t\tAmount :"+ar.getAmount());
			if(ar.getStatus() == PROCESSING){
				System.out.println("\t\tStatus : Processing");
			}else if(ar.getStatus() == DELIVERING){
				System.out.println("Status : Delivering");
			}else{
				System.out.println("Status : Delivered");
			}
			
				System.out.print("\nDo you want to delete this order (y/n)? ");
				char ch = input.next().charAt(0);
				if(ch == 'y' || ch == 'Y'){
					remove(i);	
					System.out.println("\n\tOrder Deleted !");
				}else if(ch == 'n' || ch=='N'){
					clearConsole();
					home();
				}
			}
			System.out.print("\nDo you want to delete another oreder (y/n)? ");
			char op  = input.next().charAt(0);
			if(op == 'y' || op == 'Y'){
				clearConsole();
				continue;
			}else if(op == 'n' || op == 'N'){
				clearConsole();
                home();
			}
		}

		}while(true);
	}
	
}
