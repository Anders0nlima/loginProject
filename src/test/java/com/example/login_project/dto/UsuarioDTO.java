package com.example.login_project.dto;

import com.example.login_project.entity.UsuarioEntity;
import org.springframework.beans.BeanUtils;

public class UsuarioDTO {
    private Long id;
    private String nome;
    private String email;
    private String senha;




    public UsuarioDTO(UsuarioEntity usuario){
        BeanUtils.copyProperties(usuario, this);
    }


    public UsuarioDTO(){


    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getSenha() {
        return senha;
    }


    public void setSenha(String senha) {
        this.senha = senha;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


}
