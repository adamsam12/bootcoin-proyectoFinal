package com.nttdata.bootcamp.service.impl;

import com.nttdata.bootcamp.model.Bootcoin;
import com.nttdata.bootcamp.response.BootcoinResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BootcoinServiceImpl {

    Flux<Bootcoin> getAllBootcoin();
    Flux<BootcoinResponse> getByNumberTransaction(String numberTransaction);
    Mono<Bootcoin> createBootcoin(Bootcoin bootcoin);

}
