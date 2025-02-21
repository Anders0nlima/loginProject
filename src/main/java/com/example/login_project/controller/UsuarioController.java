package com.example.login_project.controller;


import com.example.login_project.dto.UsuarioDTO;
import com.example.login_project.entity.UsuarioEntity;
import com.example.login_project.repository.UsuarioRepository;
import com.example.login_project.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @Autowired
    private UsuarioRepository usuarioRepository;


    @GetMapping
    public List<UsuarioDTO> listarTodos(){
        return usuarioService.listarTodos();
    }


    @PostMapping
    public void inserir(@RequestBody UsuarioDTO usuario) {
        usuarioService.inserir(usuario);
    }


    @PutMapping
    public UsuarioDTO alterar(@RequestBody UsuarioDTO usuario) {
        return usuarioService.alterar(usuario);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        usuarioService.excluir(id);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioDTO usuarioDTO) {
        UsuarioEntity usuarioExistente = usuarioRepository.findByEmail(usuarioDTO.getEmail());        if (usuarioExistente == null) {
            return ResponseEntity.status(401).body("Usuário não encontrado");
        }
        if (!usuarioExistente.getSenha().equals(usuarioDTO.getSenha())) {
            return ResponseEntity.status(401).body("Senha incorreta");
        }
        return ResponseEntity.ok("Login realizado com sucesso!");
    }




}
