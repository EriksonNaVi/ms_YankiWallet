package com.bootcamp.yankiwallet.producer;

import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.bootcamp.yankiwallet.events.AccountWalletCreateEvent;
import com.bootcamp.yankiwallet.events.Event;
import com.bootcamp.yankiwallet.events.EventType;
import com.bootcamp.yankiwallet.model.AccountWallet;

@Component
public class YankiWalletSendProducer {

  private static final Logger LOGGER = LoggerFactory.getLogger(YankiWalletSendProducer.class);

  @Value("${topic.wallet.name:validation}")
  private String topicWallet;

  private final KafkaTemplate<String, Event<?>> kafkaTemplate;

  public YankiWalletSendProducer(@Qualifier("kafkaStringTemplate") KafkaTemplate<String, Event<?>> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendData(AccountWallet accountWallet) {

    AccountWalletCreateEvent create = new AccountWalletCreateEvent();
    create.setData(accountWallet);
    create.setId(UUID.randomUUID().toString());
    create.setDate(new Date());
    create.setType(EventType.CREATED);
    LOGGER.info("Create AccountWallet {}", create);
    this.kafkaTemplate.send(topicWallet, create);
  }

}
