package com.nttdata.bootcamp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "bootcoin")
@Builder
public class Bootcoin {

    @Id
    private String id;
    private String identityDocument;
    private String phoneNumber;
    private String email;
    private Double amount;
    private String modePayment;
    private String numberTransaction;

}
