package com.agenciaviagens.controllers;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.agenciaviagens.model.Usuario;
import com.agenciaviagens.services.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	// Listar
	@GetMapping
	public String listUsuarios(Model model) {
		List<Usuario> usuarios = usuarioService.getAllUsuarios();
		model.addAttribute("usuario", usuarios);
		return "ListarUsuarios";
	}
	
	// Formulário de criação
	@GetMapping("/novo")
	public String showFormForAdd(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		return "usuarioForm";
	}
	
	// Persistencia da criação
	@PostMapping("/save")
	public String saveUsuario(@ModelAttribute("usuario") Usuario usuario) {
		usuarioService.saveUsuario(usuario);
		return "redirect:/usuarios";
	}
	
	// Formulário de edição
	@GetMapping("/editar/{id}")
	public String showFormForUpdate(@PathVariable Long id, Model model) {
		Usuario usuario = usuarioService.getUsuarioById(id);
		model.addAttribute("usuario", usuario);
		return "editarUsuario";
	}
	
	//Persistencia da edição
	@PostMapping ("/editar/{id}")
	public String updateUsuario(@PathVariable Long id, @ModelAttribute("usuario") Usuario usuario) {
		usuarioService.updateUsuario(id, usuario);
		return "redirect:/usuarios";
	}
	
	//Excluir usuario
	@GetMapping("/deletar/{id}")
	public String deleteUsuario(@PathVariable Long id) {
		usuarioService.deleteUsuario(id);
		return "redirect:/usuarios";
	}

}
