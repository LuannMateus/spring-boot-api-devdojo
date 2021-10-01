package com.luanmateus.springessentials.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TB_STUDENT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student extends AbstractEntity {

    private String name;
}
