package com.vphilip.finance.app.account.model;

import org.springframework.data.annotation.Id;

public record Account (
    @Id
    Long id,
    String accountName,
    Long accountTypeId
) {}
