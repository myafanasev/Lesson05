package ru.dl;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ResponseAccountId {
    ResponseAccountBody data;

    public ResponseAccountId(Long accountId) {
        this.data = new ResponseAccountBody(accountId);
    }
    @Data
    @AllArgsConstructor
    private static class ResponseAccountBody {
        private Long accountId;
    }
}
