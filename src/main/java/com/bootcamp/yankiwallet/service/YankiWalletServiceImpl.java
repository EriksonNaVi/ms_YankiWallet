package com.bootcamp.yankiwallet.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.yankiwallet.model.AccountWallet;
import com.bootcamp.yankiwallet.producer.YankiWalletSendProducer;
import com.bootcamp.yankiwallet.repository.WalletAccountRepository;

import reactor.core.publisher.Mono;

@Service
public class YankiWalletServiceImpl implements YankiWalletService {

	private static final Logger LOGGER = LoggerFactory.getLogger(YankiWalletServiceImpl.class);

	@Autowired
	private WalletAccountRepository walletAccountRepository;

	@Autowired
	private YankiWalletSendProducer yankiWalletSendProducer;

	@Override
	public Mono<AccountWallet> saveAccount(AccountWallet accountWallet) {

		return walletAccountRepository.findByPhoneNumber(accountWallet.getPhoneNumber())
				.flatMap(accountFound -> Mono.error(new RuntimeException("The cell phone number is already registered.")))
				.then(Mono.just(accountWallet))
				.flatMap(createAccount -> walletAccountRepository.save(createAccount).map(yankiWallet -> {
					yankiWalletSendProducer.sendData(accountWallet);
					LOGGER.info("Request, {}", accountWallet);
					return yankiWallet;
				}));
	}
}