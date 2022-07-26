package com.nttdata.bootcamp.controller;

import com.nttdata.bootcamp.model.Bootcoin;
import com.nttdata.bootcamp.response.BootcoinResponse;
import com.nttdata.bootcamp.service.BootcoinService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bootcoin")
@Slf4j
public class BootcoinController {

    @Autowired
    BootcoinService bootcoinService;

    private static final String BOOTCOIN = "bootcoin";

    @GetMapping(value = "/getAllBootcoin")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Bootcoin> getAllBootcoin(){
        log.info("Listar todos los pagos del bootcoin.");
        return bootcoinService.getAllBootcoin();
    }

    @PostMapping(value = "/create")
    @CircuitBreaker(name = BOOTCOIN, fallbackMethod = "bootcoin")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Bootcoin> createBootcoin(@RequestBody Bootcoin bootcoin){
        log.info("Pago del bootcoin creada con Exito.");
        return bootcoinService.createBootcoin(bootcoin);
    }

    @GetMapping(value = "/{numberTransaction}")
    @ResponseStatus(HttpStatus.OK)
    public Flux<BootcoinResponse> getByNumberTransaction(@PathVariable String numberTransaction){
        log.info("Listar los pagos del bootcoin por numberTransaction.");
        return bootcoinService.getByNumberTransaction(numberTransaction);
    }
}
