package com.vphilip.finance.app.account.model;

import org.springframework.data.annotation.Id;

public record AccountType (
    @Id
    Long id,
    String label,
    String description
) {}
