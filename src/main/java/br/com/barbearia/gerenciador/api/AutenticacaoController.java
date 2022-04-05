package br.com.barbearia.gerenciador.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.barbearia.gerenciador.config.security.TokenService;
import br.com.barbearia.gerenciador.form.LoginForm;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<?> autentica(@RequestBody @Valid LoginForm form){
		UsernamePasswordAuthenticationToken user = form.toToken();
		System.out.println(form.getEmail());
		System.out.println(form.getSenha());
		
		try {
			Authentication auth = authenticationManager.authenticate(user);
			String token = tokenService.gerarToken(auth);
			
			
			return ResponseEntity.ok().build();
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
}
