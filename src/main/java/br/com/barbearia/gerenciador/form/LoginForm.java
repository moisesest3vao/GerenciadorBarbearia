package br.com.barbearia.gerenciador.form;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


public class LoginForm {
	
	@Length(min = 5, max = 100)
	private String email;
	@Length(min = 3, max = 16)
	private String senha;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public UsernamePasswordAuthenticationToken toToken() {
		return new UsernamePasswordAuthenticationToken(email, senha);
	}
}
