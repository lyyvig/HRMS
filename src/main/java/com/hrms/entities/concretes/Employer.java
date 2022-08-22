package com.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employers")
@Entity
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

	@NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private User user;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email_verification_id", nullable = false, referencedColumnName = "id")
    private EmailVerification emailVerification;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_verification_id", nullable = false, referencedColumnName = "id")
    private AccountVerification accountVerification;

	@NotNull
	@NotBlank
	@Size(min = 2, max = 100)
    @Column(name = "company_name")
    private String companyName;

    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(name = "website_address")
    private String websiteAddress;

    @NotNull
    @NotBlank
    @Size(min = 12, max = 12)
    @Column(name = "phone_number")
    private String phoneNumber;
}