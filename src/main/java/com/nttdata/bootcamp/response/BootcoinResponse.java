package com.nttdata.bootcamp.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BootcoinResponse {

    private String phoneNumber;
    private Double amount;
    private String modePayment;

}
