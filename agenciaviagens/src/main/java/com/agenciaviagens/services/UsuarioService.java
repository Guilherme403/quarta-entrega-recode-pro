package com.agenciaviagens.services;

import java.util.List;

import com.agenciaviagens.model.Usuario;

public interface UsuarioService {

List<Usuario> getAllUsuarios();
	
	Usuario getUsuarioById(Long id);
	
	Usuario saveUsuario(Usuario usuario);
	
	Usuario updateUsuario(Long id, Usuario usuarioAtualizado);
	
	void deleteUsuario(Long id);
}
