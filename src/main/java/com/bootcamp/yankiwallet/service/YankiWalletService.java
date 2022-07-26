package com.bootcamp.yankiwallet.service;

import com.bootcamp.yankiwallet.model.AccountWallet;

import reactor.core.publisher.Mono;

public interface YankiWalletService {
  
  Mono<AccountWallet> saveAccount(AccountWallet accountWallet);
  

}
