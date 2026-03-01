package com.lunetras.model;

import jakarta.persistence.*;

@Entity
@Table(name = "turmas")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @Column(nullable = false)
   private String nome;

   @Column(nullable = false)
   private Integer ano; // primeiro ao quinto

   public Long getId() {
   return id;
   }

   public String getNome() {
       return nome;
   }

   public Integer getAno() {
       return ano;
   }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }
}