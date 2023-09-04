package com.client.clientbase.model;

import com.client.clientbase.HasId;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "client")
public class Client implements HasId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference(value = "client-contact")
    private List<Contact> contacts;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !this.getClass().equals(o.getClass())) {
            return false;
        }
        Client that = (Client) o;
        return id != null && id.equals(that.id);
    }

    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " id:" + id;
    }

    public Client(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Client(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}