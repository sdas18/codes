package com.cg.banking.services;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.daoservices.AccountDAO;
import com.cg.banking.daoservices.TransactionDAO;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficentAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;

@Component("bankingServices")
public class BankingServicesImpl implements BankingServices {
	@Autowired
	private AccountDAO accountDao; 
	@Autowired
	private TransactionDAO transactionDao ;

	@Override
	public void pinVerify(long accountNo,int pinNumber,int counter) throws AccountBlockedException,InvalidPinNumberException {
		Account account = getAccountDetails(accountNo);
		if(pinNumber!=account.getPinNumber()) {
			if(counter==3) {
				account.setAccountStatus("Blocked");
				throw new AccountBlockedException("Account Blocked :"+accountNo);
			}
			else throw new InvalidPinNumberException("Invalid Pin Number. Please Enter a Valid PIN!");
		}
	}

	@Override
	public Account openAccount(Account account)
			throws InvalidAmountException, InvalidAccountTypeException, BankingServicesDownException {
		if(account.getAccountBalance()<500)
			throw new InvalidAmountException("Minimum Balance should be 500:");
		account = accountDao.save(account);
		return account;
	}

	@Override
	public float depositAmount(long accountNo, float amount)
			throws AccountNotFoundException, BankingServicesDownException, AccountBlockedException {
		Account account = getAccountDetails(accountNo);
		account.setAccountBalance(account.getAccountBalance() + amount);
		Transaction transaction = new Transaction(amount,"Deposit",account);
		transaction = transactionDao.save(transaction);
		accountDao.save(account);
		return account.getAccountBalance();
	}

	@Override
	public float withdrawAmount(long accountNo, float amount) throws InsufficentAmountException, BankingServicesDownException, AccountBlockedException {
		Account account = getAccountDetails(accountNo);
		if(amount>account.getAccountBalance())
			throw new InsufficentAmountException("Insufficient balance in your account!!");
		else
			account.setAccountBalance(account.getAccountBalance() - amount);
		Transaction transaction = new Transaction(amount,"Withdraw",account);
		transactionDao.save(transaction);
		accountDao.save(account);
		return account.getAccountBalance();
	}

	@Override
	public void fundTransfer(long accountNoTo, long accountNoFrom, float transferAmount)
			throws InsufficentAmountException,BankingServicesDownException, AccountBlockedException {
		Account accountTo =getAccountDetails(accountNoTo);
		withdrawAmount(accountNoFrom, transferAmount);
		depositAmount(accountNoTo, transferAmount);
	}

	@Override
	public Account getAccountDetails(long accountNo) throws AccountNotFoundException{
		Account account=accountDao.findById(accountNo).orElseThrow(()-> new AccountNotFoundException("Account not found"));
		return account;
	}

	@Override
	public List<Account> getAllAccountDetails() throws BankingServicesDownException {
		return accountDao.findAll();
	}

	@Override
	public List<Transaction> getAccountAllTransaction(long accountNo)
			throws BankingServicesDownException, AccountNotFoundException {
		return null;    //transactionDao.findAllById(accountNo);
	}

	@Override
	public String accountStatus(long accountNo)
			throws BankingServicesDownException, AccountNotFoundException, AccountBlockedException {
		Account account = getAccountDetails(accountNo);
		if(account.getAccountStatus()=="Active")
			account.setAccountStatus("Blocked");
		else if(account.getAccountStatus()=="Blocked")
			account.setAccountStatus("Active");
		return account.getAccountStatus() ;
	}
public int getPIN_NUMBER() {
	return (int)Math.pow(5,  5-1 )+new Random().nextInt(90000);
}
}
