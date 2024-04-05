package javabank.bankingapp.mapper;

import javabank.bankingapp.dto.AccountDto;
import javabank.bankingapp.entity.Account;

public class AccountMapper {
    public static Account maptoAccount(AccountDto accountDto)
    {
        Account account=new Account(
                accountDto.getId(),
                accountDto.getAccount_holder_name(),
                accountDto.getBalanced()
        );
        return account;
    }

    public static AccountDto maptoAccountdto(Account account)
    {
        AccountDto accountDto=new AccountDto(
                account.getId(),
                account.getAccount_holder_name(),
                account.getBalanced()
        );
        return accountDto;
    }
}
