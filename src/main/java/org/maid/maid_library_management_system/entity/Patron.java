package org.maid.maid_library_management_system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Data
@NoArgsConstructor
@DynamicUpdate
public class Patron {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patron_generator")
    @SequenceGenerator(name = "patron_generator", sequenceName = "patron_seq", allocationSize = 1)
    private Integer id;
    private String contactName;
    private String contactNumber;
    @Email
    private String email;
}
