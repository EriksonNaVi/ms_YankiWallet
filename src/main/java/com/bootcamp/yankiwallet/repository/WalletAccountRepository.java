package com.bootcamp.yankiwallet.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.yankiwallet.model.AccountWallet;
import reactor.core.publisher.Mono;

@Repository
public interface WalletAccountRepository extends ReactiveMongoRepository<AccountWallet, String>{
  
  Mono<AccountWallet> findByPhoneNumber(String phoneNumber);

}
