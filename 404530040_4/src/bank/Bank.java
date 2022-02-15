package bank;

import java.util.ArrayList;


public class Bank {
	private ArrayList<BankAccount>account;
	BankAccount myAccount;
	//constructor
	public Bank() {
		account=new ArrayList<BankAccount>();
	}
	
	/**
	 *get a reference to the account and then calls the appropriate account method 
	 *@return myAccount
	 */
	public BankAccount find(int AccountNumber){
		myAccount=null;
		for(BankAccount a:account){
			if(a.accountNumber==AccountNumber){
				myAccount=a;
			}
		}
		return myAccount;
	}
	
	/**
	 *Creates a new BankAccount object with initial balance and add it to this bank
	 */
	void addAccount(int accountNumber, double initialBalance){
		myAccount=new BankAccount(accountNumber,initialBalance);
		account.add(myAccount);
	}
	
	/**
	 *calls deposit() to update the account balances
	 */
	void deposit(int accountNumber, double initialBalance){
		find(accountNumber).deposit(initialBalance);
	}
	
	/**
	 *calls withdraw() to update the account balances
	 */
	void withdraw(int accountNumber, double initialBalance){
		find(accountNumber).withdraw(initialBalance);
	}
	
	/**
	 *calls getBalance() to get the value of balance
	 */
	double getBalance(int accountNumber){
		return find(accountNumber).getBalance();
	}
	
	/**
	 *calls suspend() to change the account status 
	 */
	void suspendAccount(int accountNumber){
		find(accountNumber).suspend();
	}
	
	/**
	 *calls reOpen() to change the account status 
	 */
	void reOpenAccount(int accountNumber){
		find(accountNumber).reOpen();
	}
	
	/**
	 *calls close() to change the account status 
	 */
	void closeAccount(int accountNumber){
		find(accountNumber).close();
	}
	
	/**
	 *get the account status 
	 *@return state
	 */
	String getAccountStatus(int accountNumber){
		return find(accountNumber).state;
	}
	
	/**
	 *calls getTransactions() to show the output
	 *@return getTransactions()
	 */
	String summarizeAccountTransactions(int accountNumber){
		return find(accountNumber).getTransactions();
	}
	
	/**
	 *calls getAccountNumber() to get the accountNumber
	 *@return getAccountNumber()
	 */
	int getAccountNumber(int accountNumber){
		return find(accountNumber).getAccountNumber();
	}
	
	/**
	 *summary of the bank's Account
	 *@return summary
	 */
	String summarizeAllAccounts(){
		String summary="";
		summary="Bank Account Summary\n\nAccount\tBalance\t#Transactions\tstatus\n";
		for(int i=0;i<account.size();i++){
			summary+=account.get(i).getAccountNumber()+"\t"+account.get(i).getBalance()
					+"\t"+account.get(i).retrieveNumberOfTransactions()+"\t\t"
					+account.get(i).state+"\n";
		}
		summary+="End of Account Summary";
		return summary;
	} 
}
