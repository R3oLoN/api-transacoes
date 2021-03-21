package com.reolon.transacoes.api;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.reolon.transacoes.exceptinos.NotFoundException;
import com.reolon.transacoes.model.accounts.Account;
import com.reolon.transacoes.model.accounts.AccountRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accouts")
@Transactional(TxType.SUPPORTS)
public class AccountController {

    private final AccountRepository repository;

    public AccountController(final AccountRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody final Account account){
        repository.save(account);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> findById(@PathVariable("id") final Long id) throws NotFoundException {
        return ResponseEntity.ok(repository.findById(id).orElseThrow(NotFoundException::new));
    }

}
