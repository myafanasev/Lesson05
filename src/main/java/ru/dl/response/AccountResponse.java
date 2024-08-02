package ru.dl.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class AccountResponse {
    ResponseAccountBody data;

    public AccountResponse(Long accountId) {
        this.data = new ResponseAccountBody(accountId);
    }
    @Data
    @AllArgsConstructor
    private static class ResponseAccountBody {
        private Long accountId;
    }
}
