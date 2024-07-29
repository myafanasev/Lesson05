package ru.dl;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IncomingDataController {
    @PostMapping("/corporate-settlement-account/create")
    public ResponseEntity<ResponseAccountId> handlerAccount(@RequestBody SettlementAccount settlementAccount) {
        System.out.println(settlementAccount);
        ResponseAccountId responseAccountId = new ResponseAccountId(10L);
        return new ResponseEntity<>(responseAccountId, HttpStatus.OK);
    }
}
