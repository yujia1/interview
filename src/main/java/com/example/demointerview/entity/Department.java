package com.example.demointerview.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //AUTO: JPA chooses the generation strategy based on the database dialect.
    //IDENTITY: Database auto-increments the primary key.
    //SEQUENCE: Uses a database sequence.
    //TABLE: Uses a table to generate unique identifiers.
    private Long id;
    private String name;
    //Cascading Types:
    //Here are the types of cascade operations:
    //PERSIST: When the parent is persisted, the child entities are also persisted.
    //MERGE: Changes to the parent will merge into the child entities as well.
    //REMOVE: Deleting the parent will delete the child entities.
    //REFRESH: Refreshing the parent will refresh the state of the child entities.
    //DETACH: Detaching the parent will detach the child entities from the persistence context.
    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees = new ArrayList<>();


}
