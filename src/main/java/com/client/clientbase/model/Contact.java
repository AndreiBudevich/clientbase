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

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "contact")
public class Contact implements HasId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "contact_info")
    private String contactInfo;

    @Enumerated(EnumType.STRING)
    @Column(name = "contact_type")
    private ContactType contactType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonBackReference(value = "client-contact")
    private Client client;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !this.getClass().equals(o.getClass())) {
            return false;
        }
        Contact that = (Contact) o;
        return id != null && id.equals(that.id);
    }

    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " id:" + id;
    }

    public Contact(Long id, String contactInfo, ContactType contactType) {
        this.id = id;
        this.contactInfo = contactInfo;
        this.contactType = contactType;
    }

    public Contact(String contactInfo, ContactType contactType) {
        this.contactInfo = contactInfo;
        this.contactType = contactType;
    }
}