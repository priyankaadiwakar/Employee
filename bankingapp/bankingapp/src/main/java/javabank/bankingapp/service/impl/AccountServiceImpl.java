package javabank.bankingapp.service.impl;

import javabank.bankingapp.dto.AccountDto;
import javabank.bankingapp.entity.Account;
import javabank.bankingapp.mapper.AccountMapper;
import javabank.bankingapp.repository.AccountRepository;
import javabank.bankingapp.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account=AccountMapper.maptoAccount(accountDto);
        Account savedentity=accountRepository.save(account);
        return AccountMapper.maptoAccountdto(savedentity);
    }

    @Override
    public AccountDto getAccountById(Long id) {
      Account account=  accountRepository.
              findById(id).
              orElseThrow(() -> new RuntimeException("Account Not Exist"));
        return AccountMapper.maptoAccountdto(account);
    }

    @Override
    public AccountDto deposite(Long id, double amount) {
        Account account=  accountRepository.
                findById(id).
                orElseThrow(() -> new RuntimeException("Account Not Exist"));
        double total=account.getBalanced() + amount;
        account.setBalanced(total);
        Account savedbalance=accountRepository.save(account);
        return AccountMapper.maptoAccountdto(savedbalance);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account=  accountRepository.
                findById(id).
                orElseThrow(() -> new RuntimeException("Account Not Exist"));

        if(account.getBalanced() < amount){
            throw new RuntimeException("unsuffient amount");

            //double total=account.getBalanced() - amount;

        }
        double total =account.getBalanced() - amount;
        account.setBalanced(total);
        Account savedbalance=accountRepository.save(account);
        return AccountMapper.maptoAccountdto(savedbalance);

    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map((account -> AccountMapper.maptoAccountdto(account)))
                .collect(Collectors.toList());

    }

    @Override
    public void deleteAcccount(Long id) {
        Account account=  accountRepository.
                findById(id).
                orElseThrow(() -> new RuntimeException("Account Not Exist"));
         accountRepository.deleteById(id);

    }
}
