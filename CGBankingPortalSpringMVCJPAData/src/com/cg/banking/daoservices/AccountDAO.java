package com.cg.banking.daoservices;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.banking.beans.Account;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.InvalidPinNumberException;
public interface AccountDAO extends JpaRepository<Account,Long> {
	
}
