

import java.util.Scanner;

public class AtmSys{
	static{
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Welcome to HosPs Atm System");
		System.out.println("++++++++++++++++++++++++++++++++\n");
	}
	public static void main2(){
		InterUI obj= new InterUI();
		HosPs obj3= new HosPs();
	}
	public static void main(String args[]){
		Scanner inputNew = new Scanner(System.in);
		System.out.println("\n1-Proceed\n2-About\n3-Exit");
		int choiceNew=inputNew.nextInt();
		About abt= new About();
		switch(choiceNew){
			case 1:
				main2();
				break;
			case 2:
				abt.about();
				break;
			case 3:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("invalid choice Exiting...");
		}
	}
}
class HosPs extends UserInterface{
	{
		choiceUser();
	}
	public void choiceUser(){
		finalScreen();
		PinUpdater pinupdater= new PinUpdater();
		CheckCurrentBalance currentbalancechecker= new CheckCurrentBalance();
		WithDrawlMoney moneywithdrawler = new WithDrawlMoney();
		AddMoney moneyadder= new AddMoney();
		Exit quit= new Exit();
		System.out.print("Enter Your Choice:");
		int choice=input.nextInt();
		switch(choice){
			case 1:
				pinupdater.pinUpdater();
				choiceUser();
				break;
			case 2:
				currentbalancechecker.checkCurrentAmount();
				choiceUser();
				break;
			case 3:
				moneywithdrawler.withDrawlMoney();
				choiceUser();
				break;
			case 4:
				moneyadder.addMoney();
				choiceUser();
				break;
			case 5:
				quit.exit();
				System.out.println("Hope will see you soon ");
				break;
			default:
				System.out.println("Enter a valid choice");
				choiceUser();
				break;
		}
	}
}
class MainAtm{
	public final static int ac_no=1234567890;
	public static final String superUserName="HosPs";
	public static final int superPin=7890;
	public static String name;
	public static int pin=1234;
	public static int current_balance=4000;
	public static int withDrawlAmount;
	Scanner input= new Scanner(System.in);
	public static int length(int var){
			int flag=0;
			while(var!=0){
				var=var/10;
				flag++;
			}
			return flag;
		}
}
class UserInterface extends MainAtm{
	public int getPin(){
		System.out.print("Enter your 4 digit Pin please :");
		int temp_Pin=input.nextInt();
		try{
			if(length(temp_Pin)>4 || length(temp_Pin)<4){
			throw new ArithmeticException("Pin must be 4 digit");
			}
		}catch(ArithmeticException e){
			System.out.println("Error:"+e.getMessage());
			getPin();
			
			}
		return temp_Pin;
	}
	public static void finalScreen(){
		String str="++++++++++++++++++++++++++++++++++++++++";
		System.out.println();
		System.out.println(str);
		System.out.println("Name :"+name);
		System.out.println("your Accoount Number: "+ac_no);
		System.out.println("your pin: "+pin);
		System.out.println("1-Update Pin: ");
		System.out.println("2-Check Current Balance");
		System.out.println("3-Withdrawl Money");
		System.out.println("4-Deposit Money");
		System.out.println("5-Exit");
		System.out.println(str);
		System.out.println();
	}
}
class InterUI extends MainAtm{
	{
		UserInterface obj2= new UserInterface();
		pin=obj2.getPin();
		if (pin==superPin){
			SuperUser su= new SuperUser();
		}
		else{
			getData();
		}
	}
	public void getData(){
		System.out.print("Enter your Name :");
		name=input.nextLine();
	}
}
class PinUpdater extends MainAtm{
	public void pinUpdater(){
		System.out.print("Enter your New Pin :");
		int newPin;
		newPin=input.nextInt();
		if(length(newPin)==4){
			pin= newPin;
			System.out.println("Pin Modified Successfully");
		}
		else{
			System.out.println("length of Pin must be 4");
			pinUpdater();
		}
	}
}
class CheckCurrentBalance extends MainAtm{
	public void checkCurrentAmount(){
		System.out.println("your current balance is :"+current_balance);
	}
}
class AddMoney extends MainAtm{
	public void addMoney(){
		int new_bal;
		System.out.print("Enter the Money to add:");
		new_bal= input.nextInt();
		current_balance=current_balance+new_bal;
		System.out.println("your new Balance is :"+current_balance);
	}
}
class WithDrawlMoney extends MainAtm{
	public void withDrawlMoney(){
		System.out.print("Enter the money to withdraw :");
		withDrawlAmount=input.nextInt();
		try{
			if(withDrawlAmount>current_balance){
				throw new ArithmeticException("Insufficient Balance can't withdraw");
			}
		}catch(ArithmeticException e){
			System.out.println("Error :"+e.getMessage());
			newShow();
		}
		if(withDrawlAmount<=current_balance){
			current_balance=current_balance-withDrawlAmount;
			System.out.println("Transaction successful");
			System.out.println("your new Account Balance is "+current_balance);
		}
	}
	public void newDraw(){
		System.out.print("your choice :");
		int chk=input.nextInt();
		switch(chk){
			case 1:
				withDrawlMoney();
				break;
			case 2:
				break;
			default:
				System.out.println("Enter a Valid choice");
				newDraw();
		}
	}
	public void newShow(){
		String str="---------------------------------------------";
		System.out.println();
		System.out.println(str);
		System.out.println("1- Enter new Amount:");
		System.out.println("2- Cancel Withdrawaling process:");
		System.out.println(str);
		System.out.println();
		newDraw();
	}
}
class About extends MainAtm{
	public void about(){
		System.out.println("This is an ATM System Programm made by Hariom singh \nversion- v1.0\n");
		System.out.println("1-Proceed\n2-Exit");
		int jk= input.nextInt();
		switch(jk){
			case 1:
				InterUI obj= new InterUI();
				HosPs obj3= new HosPs();
				break;
			case 2:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("invalid choice Exiting...");
		}	
	}
}
class SuperUser extends MainAtm{
	public SuperUser(){
		System.out.println("\n-------------------Developer HosPs-----------------");
		System.out.println("hi am Hariom singh The Developer");
		System.out.println("-------------------Developer HosPs-----------------\n");
		name="HariOm Singh+Ps";
		pin=superPin;
		current_balance=999999999;
	}
}
class Exit{
	public void exit(){
		System.out.println("Press Ctrl+z any time to quit");
	}
}
