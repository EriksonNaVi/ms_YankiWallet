package com.bootcamp.yankiwallet.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.yankiwallet.model.AccountWallet;

@Repository
public interface WalletCacheRepository extends ReactiveMongoRepository<AccountWallet, String>{

}
