package ru.dl.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import ru.dl.exception.ExceptionBadRequest;
import ru.dl.exception.ExceptionNotFound;
import ru.dl.model.ModelProduct;
import ru.dl.response.AccountResponse;
import ru.dl.model.ModelAccount;
import ru.dl.response.ProductResponse;
import ru.dl.service.AccountService;
import ru.dl.service.ProductService;

import java.util.stream.Collectors;

@RestController
public class MainController {
    @Autowired
    AccountService accountService; // обработка запроса создания продуктового регистра

    @Autowired
    ProductService productService; // обработка запроса создания нового объекта ЭКЗЕМПЛЯР ПРОДУКТА

    @PostMapping("/corporate-settlement-account/create")
    public ResponseEntity<AccountResponse> handleAccount(@RequestBody @Validated ModelAccount modelAccount) {
        System.out.println(modelAccount);

        return new ResponseEntity<>(accountService.make(modelAccount), HttpStatus.OK);
    }

    @PostMapping("/corporate-settlement-instance/create")
    public ResponseEntity<ProductResponse> handleProduct(@RequestBody @Validated ModelProduct modelProduct) {
        System.out.println(modelProduct);

        return new ResponseEntity<>(productService.make(modelProduct), HttpStatus.OK);
    }

    // обработчики исключений:
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageError> handle(MethodArgumentNotValidException e) {
        MessageError messageError = new MessageError(e.getBody().getStatus(), HttpStatus.BAD_REQUEST,
               null,
               e.getBindingResult()
                       .getFieldErrors()
                       .stream().collect(Collectors.toMap(x -> x.getField(), x -> x.getDefaultMessage()))
        );
        //messageError.setMessage(e.getMessage());
        return new ResponseEntity<>(messageError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExceptionBadRequest.class)
    public ResponseEntity<MessageError> handle(ExceptionBadRequest e) {
        MessageError messageError = new MessageError(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
                e.getMessage(),
                null
        );
        return new ResponseEntity<>(messageError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExceptionNotFound.class)
    public ResponseEntity<MessageError> handle(ExceptionNotFound e) {
        MessageError messageError = new MessageError(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND,
                e.getMessage(),
                null
        );
        return new ResponseEntity<>(messageError, HttpStatus.NOT_FOUND);
    }

}