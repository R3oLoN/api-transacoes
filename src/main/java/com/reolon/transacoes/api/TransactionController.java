package com.reolon.transacoes.api;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.reolon.transacoes.model.transacoes.Transaction;
import com.reolon.transacoes.model.transacoes.TransactionRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
@Transactional(TxType.SUPPORTS)
public class TransactionController {

    private final TransactionRepository repository;

    public TransactionController(final TransactionRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody final Transaction account){
        repository.save(account);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
