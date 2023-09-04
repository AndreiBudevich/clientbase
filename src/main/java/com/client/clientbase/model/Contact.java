package com.client.clientbase.model;

import com.client.clientbase.HasId;
import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
@Table(name = "contact", uniqueConstraints =
        {@UniqueConstraint(columnNames = {"contact_info", "contact_type", "client_id"},
                name = "contact_info_contact_typ_client_id_idx")})
public class Contact implements HasId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Column(name = "contact_info", nullable = false)
    @NotBlank
    @Size(min = 1, max = 200)
    private String contactInfo;

    @Enumerated(EnumType.STRING)
    @Column(name = "contact_type", nullable = false)
    private ContactType contactType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @Schema(hidden = true)
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