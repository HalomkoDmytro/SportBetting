package com.epam.training.form.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerPersonalInfoUpdateForm {

    private String name;
    private String dateOfBirth;
}
