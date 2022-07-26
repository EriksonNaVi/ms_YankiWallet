package com.bootcamp.yankiwallet.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.bootcamp.yankiwallet.model.AccountWallet;
import com.bootcamp.yankiwallet.repository.WalletCacheRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class YankiWalletCacheServiceImpl implements YankiWalletCacheService{
  
  final Logger logger = LoggerFactory.getLogger(YankiWalletCacheServiceImpl.class);
  
  @Autowired
  private WalletCacheRepository walletCacheRepository;
  
  @Override
  @Cacheable(value = "userCache")
  public Mono<AccountWallet> findById(String id) {
    logger.info("Getting user with ID {}.", id);
    return walletCacheRepository.findById(id)
        .switchIfEmpty(Mono.error(new RuntimeException("Customer id doesn't exist")));
  }

}
