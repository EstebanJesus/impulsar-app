package com.impulsar.app.api.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authority")
public class Authority {

    @Id
    private String name;

    public String getName() {
        return name;
    }
}
