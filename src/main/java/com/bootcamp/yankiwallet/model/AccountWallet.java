package com.bootcamp.yankiwallet.model;

//import java.time.LocalDate;

//import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "account_wallet")
public class AccountWallet {

  @Id
  private String idYankiAccount;
  
  private String documentType;
  private String documentNumber;
  private String phoneNumber;
  private String imei;
  private String email;
  private String debitCard;
  private String associatedAccount;
  private Double balance;
  
  /*@CreatedDate
  private LocalDate date;*/

}
