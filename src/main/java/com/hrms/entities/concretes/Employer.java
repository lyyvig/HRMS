package com.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employers")
@Entity
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Valid
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email_verification_id", nullable = false, referencedColumnName = "id")
    private EmailVerification emailVerification;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_verification_id", nullable = false, referencedColumnName = "id")
    private AccountVerification accountVerification;

    @NotNull
    @Size(min = 2, max = 100)
    @Column(name = "company_name")
    private String companyName;

    @NotNull
    @Size(min = 5, max = 100)
    @Column(name = "website_address")
    private String websiteAddress;

    @NotNull
    @Size(min = 10, max = 10)
    @Column(name = "phone_number")
    private String phoneNumber;
}