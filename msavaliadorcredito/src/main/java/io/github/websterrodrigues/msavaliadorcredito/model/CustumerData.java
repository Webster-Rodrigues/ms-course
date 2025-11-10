package io.github.websterrodrigues.msavaliadorcredito.model;

import java.util.UUID;

public class CustumerData {

    private UUID id;
    private String name;
    private Long age;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}
