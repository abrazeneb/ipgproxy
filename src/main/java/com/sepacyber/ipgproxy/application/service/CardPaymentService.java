package com.sepacyber.ipgproxy.application.service;

import an.awesome.pipelinr.Pipeline;
import com.sepacyber.ipgproxy.application.ports.in.command.PayWithCardCommand;
import com.sepacyber.ipgproxy.application.ports.in.responses.PayWithCardResponse;
import com.sepacyber.ipgproxy.application.ports.in.result.PayWithCardCommandResponse;
import com.sepacyber.ipgproxy.application.ports.in.PayWithCardUseCase;
import com.sepacyber.ipgproxy.application.ports.out.CardPaymentPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CardPaymentService implements PayWithCardUseCase {

    private final CardPaymentPort cardPaymentPort;
    private final Pipeline pipeline;

    public PayWithCardResponse payWithCard(String authToken, PayWithCardCommand payWithCardCommand) {
        //TODO build the card details model
        // Pull customer data
        // enrich command with details from customer-service, wallet
        PayWithCardResponse commandResult = cardPaymentPort.pay(authToken, payWithCardCommand);
        //TransactionDto transactionDto = TransactionDto.builder().build();
        //Assume transactionDto is a result from pay enriched with further details
        //TODO pass result,  from payment to integration handler
        // e.g Handlers would take data from transactionDto
       // pipeline.send(transactionDto); // e.g Wallet WalletTransactionHandler, FinancialInstitutionsCardDetailsHandler
        //Card details get validated -> FinancialInstitutionsCardDetailsHandler
        // Wallet transaction gets created -> WalletTransactionHandler

        return commandResult;
    }


}
