package edu.csumb.cst438.productdb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Hero")
public class Hero {
    @Id
    private String id;
    private Identity identity;
    private AlterEgo alterEgo;
    private Powers powers;

    public Hero (Identity identity, AlterEgo alterEgo, Powers powers) {
        this.identity = identity;
        this.alterEgo = alterEgo;
        this.powers = powers;
    }

    public String getId () {
        return this.id;
    }

    public Identity getIdentity () {
        return this.identity;
    }

    public AlterEgo getAlterEgo () {
        return this.alterEgo;
    }

    public Powers getPowers () {
        return this.powers;
    }
}