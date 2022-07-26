package com.nttdata.bootcamp.service;

import com.nttdata.bootcamp.model.Bootcoin;
import com.nttdata.bootcamp.repository.BootcoinRepository;
import com.nttdata.bootcamp.response.BootcoinResponse;
import com.nttdata.bootcamp.service.impl.BootcoinServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BootcoinService implements BootcoinServiceImpl {

    @Autowired
    BootcoinRepository bootcoinRepository;

    @Override
    public Flux<Bootcoin> getAllBootcoin() {
        return bootcoinRepository.findAll();
    }

    @Override
    public Flux<BootcoinResponse> getByNumberTransaction(String numberTransaction) {
        return bootcoinRepository.findAll().filter(bootcoin -> bootcoin.getNumberTransaction().equals(numberTransaction))
                .map(bootcoin -> BootcoinResponse.builder().amount(bootcoin.getAmount())
                        .modePayment(bootcoin.getModePayment())
                        .phoneNumber(bootcoin.getPhoneNumber()).build());
    }

    @Override
    public Mono<Bootcoin> createBootcoin(Bootcoin bootcoin) {
        return bootcoinRepository.save(bootcoin);
    }
}
