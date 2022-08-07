package com.ciandt.fullstack.project.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="NOME")
    private String name;

    @Column(name="EMAIL")
    private String email;

    @Column(name="TELEFONE")
    private String phone;

    @Column(name="ENDERECO")
    private String address;

    @Column(name="CPF_CNPJ")
    private String CPF_CNPJ;

    @Column(name="OCUPACAO")
    private String occupation;

}
