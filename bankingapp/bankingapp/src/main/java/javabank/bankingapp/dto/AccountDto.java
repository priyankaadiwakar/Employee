package javabank.bankingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDto {

    private Long Id;
    private String account_holder_name;
    private double balanced;
}
