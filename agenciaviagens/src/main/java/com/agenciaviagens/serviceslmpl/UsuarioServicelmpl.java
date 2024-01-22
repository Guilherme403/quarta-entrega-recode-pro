package com.agenciaviagens.serviceslmpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agenciaviagens.model.Usuario;
import com.agenciaviagens.repositories.UsuarioRepository;
import com.agenciaviagens.services.UsuarioService;

@Service
public class UsuarioServicelmpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> getAllUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario getUsuarioById(Long id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Usuario saveUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario updateUsuario(Long id, Usuario usuarioAtualizado) {
		Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);
		if (usuarioExistente != null) { 
			usuarioExistente.setNome(usuarioAtualizado.getNome());
			usuarioExistente.setCpf(usuarioAtualizado.getCpf());
			usuarioExistente.setTelefone(usuarioAtualizado.getTelefone());
			usuarioExistente.setEmail(usuarioAtualizado.getEmail());
			return usuarioRepository.save(usuarioExistente);
		} else { 
			throw new RuntimeException("Usuario com o ID" + id + "não encontrado.");
		}
	}

	@Override
	public void deleteUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}

}
