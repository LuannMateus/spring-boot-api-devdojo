package com.luanmateus.springessentials.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "TB_STUDENT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student extends AbstractEntity {

    @NotEmpty
    private String name;

    @Email
    private String email;
}
