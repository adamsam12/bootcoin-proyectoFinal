package com.nttdata.bootcamp.repository;

import com.nttdata.bootcamp.model.Bootcoin;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BootcoinRepository extends ReactiveCrudRepository<Bootcoin, String> {
}
