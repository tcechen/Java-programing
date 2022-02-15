package bank;

import java.util.ArrayList;

import javax.swing.SortingFocusTraversalPolicy;

public class BankAccount {
	String state="open";
	int accountNumber;
	private double balance;
	ArrayList<Double> transactionList=new ArrayList<Double>();
	
	//constructor
	public BankAccount(){
		this.accountNumber=-1;
		this.balance=-1;
	}
	public BankAccount(int anAccountNumber){
		this.accountNumber=anAccountNumber;
		this.balance=0;
	}
	public BankAccount(int anAccountNumber,double balance){
		this.accountNumber=anAccountNumber;
		this.balance=balance;
		
	}
	/**
	 *check the account current state
	 *@return boolean	
	 */
	private Boolean isOpen(){		
		return this.state.equalsIgnoreCase("open");
	}
	
	private Boolean isSuspended(){
		return this.state.equalsIgnoreCase("suspended");
	}
	
	private Boolean isClosed(){
		return this.state.equalsIgnoreCase("closed");
	}
	
	/**
	 *check if the status is "open" and amount > 0
	 *add amount to balance and transaction list	
	 */
	void deposit(double amount){
		if(!isOpen()||amount<0){
			//System.out.println("Error! Fail to deposit!");			
		}
		else{
			balance += amount;
			addTransaction(amount);
		}
		
	}
	
	/**
	 *check if the status is "open" and amount > 0 and amount > balance
	 *add negative amount to balance and transaction list	
	 */
	void withdraw(double amount){
		if(!isOpen()||amount<0||amount>balance){
			//System.out.println("Error! Fail to withdraw!");			
		}	
		else{
			amount = 0 - amount;
			balance += amount;
			addTransaction(amount);
		}
	}
	
	/**
	 *change the account status	
	 */
	void suspend(){
		this.state="suspended";
	}
	
	void close(){
		this.state="closed";
	}
	
	void reOpen(){
		this.state="open";
	}	
	
	/**
	 *Add the amount to the account’s list 
	 */
	void addTransaction(double amount){
		this.transactionList.add(amount);
	}
	
	/**
	 *the number of transaction list
	 *@return transactionlist.size()
	 */
	int retrieveNumberOfTransactions(){
		return this.transactionList.size();
	}
	
	/**
	 *show the output of transaction list
	 *@return rlt the output of transaction
	 */
	String getTransactions(){
		String rlt="";
		rlt="Account # "+accountNumber+" transactions:\n\n"; 
		for(int i=0;i<this.transactionList.size();i++){
			rlt+=(i+1)+": "+transactionList.get(i)+"\n";
		}
		rlt+="End of transactions\n\n";
		return rlt;
	}
	
	/**
	 *get the account balance
	 *@return balance
	 */
	public double getBalance(){
		return this.balance;
	}
	
	/**
	 *get the account number
	 *@return accountNumber
	 */
	public int getAccountNumber(){
		return this.accountNumber;
	} 
	
	}
