package com.hrms.core.utilities.adapters.mernis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MernisPerson {
    private String firstName;
    private String lastName;
    private String nationalIdentity;
    private int birthYear;

}
