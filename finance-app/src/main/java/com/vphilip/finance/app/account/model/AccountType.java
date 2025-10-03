package com.vphilip.finance.app.account.model;

import org.springframework.data.annotation.Id;

public record AccountType (
    @Id
    Integer id,
    String label,
    String description
) {
    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }
}
