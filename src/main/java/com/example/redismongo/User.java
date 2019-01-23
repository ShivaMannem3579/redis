package com.example.redismongo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
public class User implements Serializable{

    private static final long serialVersionUID = 7156526077883281623L;

    @Id
    @GeneratedValue

    private Long id;
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }
}
