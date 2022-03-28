package com.sepacyber.ipgproxy.application.service;

import an.awesome.pipelinr.Pipeline;
import com.sepacyber.ipgproxy.application.ports.in.PayWithCardCommand;
import com.sepacyber.ipgproxy.application.ports.in.PayWithCardUseCase;
import com.sepacyber.ipgproxy.application.ports.out.CardPaymentPort;
import com.sepacyber.ipgproxy.shared.integrationpayload.TransactionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CardPaymentService implements PayWithCardUseCase {

    private final CardPaymentPort cardPaymentPort;
    private final Pipeline pipeline;

    public void payWithCard(PayWithCardCommand payWithCardCommand) {
        //TODO build the card details model
        // Pull customer data
        cardPaymentPort.pay();
        TransactionDto transactionDto = TransactionDto.builder().build();
        //Assume transactionDto is a result from pay enriched with further details
        //TODO pass result,  from payment to integration handler
        // e.g Handlers would take data from transactionDto
        pipeline.send(transactionDto); // e.g Wallet WalletTransactionHandler, FinancialInstitutionsCardDetailsHandler
        //Card details get validated -> FinancialInstitutionsCardDetailsHandler
        // Wallet transaction gets created -> WalletTransactionHandler

        // Recurring -> standalone
        //Direct payment -> including saving transaction
        // payout

        // Authentication -> Aklil
        //Merchant model

        // ==============Payment and customer service ====== Abraham
        //
        //==================Organization and Customer============== Eyoel
        //Create Customer domain classes


        //Create organization domain classes
        //==============IPG adapter
        //Create ipg integration request/response dtos
        // ipg feign client endpoints
        //@GetMapping("/pay")
        //ResponseEntity<PayResponseDTO> pay(@RequestBody PayRequestDTO requestDto)

        //IpgServicePaymentResponseDto -> Transaction Response, FIS, IPGResponse -> Enriched
        // fromClassAToClassB(A a, B b)
        //mapper.map(a, B.class)
        //mapper.mapToList(List<A> as, B.class) LocalDateTime
        // paymentDto


        //No outer layer classes can be used on inner layer components
        //** ================== layers ========
        /*
        ========outer ===
            Api:
            provideradapter
            integrationhandler
         */
            /*
            ======inner ========

                application
                    domain
         */
             /*
            ======shared ========
            shared
         */

    // merchantId -> tenantId
        //try access details
        //
        //memberid/partnerid
    //in port merchant identifier -> inner -> out port

        //Orika mapper

        //github
        // dev
            //from dev feature-[jira id]/[description]
    }


}
