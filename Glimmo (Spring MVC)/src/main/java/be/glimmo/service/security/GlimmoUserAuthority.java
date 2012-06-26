package be.glimmo.service.security;

import org.springframework.security.core.GrantedAuthority;

import be.glimmo.domain.enumeration.UserGrade;

public class GlimmoUserAuthority implements GrantedAuthority {
	private static final long serialVersionUID = -5189930805956709085L;
	
	private UserGrade userGrade;
	
	public GlimmoUserAuthority(UserGrade userGrade){
		this.userGrade = userGrade;
	}
	
	public String getAuthority() {
		return userGrade.name();
	}

}
