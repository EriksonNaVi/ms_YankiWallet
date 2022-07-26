package com.bootcamp.yankiwallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.yankiwallet.model.AccountWallet;
import com.bootcamp.yankiwallet.service.YankiWalletCacheService;
import com.bootcamp.yankiwallet.service.YankiWalletService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/yanki")
public class YankiWalletController {
  
  @Autowired
  private YankiWalletService walletService;
  
  @Autowired
  private YankiWalletCacheService yankiWalletCacheService;
  
  @PostMapping
  public Mono<AccountWallet> saveAccount(@RequestBody AccountWallet accountWallet){
    System.out.println(accountWallet);
    return walletService.saveAccount(accountWallet);
  }
  
  @GetMapping("/{id}")
  public Mono<AccountWallet> getById(@PathVariable("id") String id){
    return yankiWalletCacheService.findById(id);
  }
  
}