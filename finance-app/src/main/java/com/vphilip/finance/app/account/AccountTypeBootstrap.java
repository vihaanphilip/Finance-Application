package com.vphilip.finance.app.account;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Component
public class AccountTypeBootstrap implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(AccountTypeBootstrap.class);
    private final ObjectMapper objectMapper;
    private final AccountRepository accountRepository;

    public AccountTypeBootstrap(ObjectMapper objectMapper, AccountRepository accountRepository) {
        this.objectMapper = objectMapper;
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(accountRepository.count() == 0) {
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/account_types.json")) {
                AccountTypes allAccountTypes = objectMapper.readValue(inputStream, AccountTypes.class);
                log.info("Reading {} runs from JSON data and saving to in-memory collection.", allAccountTypes.accountTypes().size());
                accountRepository.saveAll(allAccountTypes.accountTypes());
            } catch (IOException e) {
                throw new RuntimeException("Failed to read JSON data", e);
            }
        } else {
            log.info("Not loading Runs from JSON data because the collection contains data.");
        }
    }
}
