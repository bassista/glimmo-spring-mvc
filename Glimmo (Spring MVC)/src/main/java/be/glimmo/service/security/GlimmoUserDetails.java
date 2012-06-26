package be.glimmo.service.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class GlimmoUserDetails implements UserDetails{
	private static final long serialVersionUID = 469391597485421166L;

	private Set<GlimmoUserAuthority> authorities = new HashSet<GlimmoUserAuthority>(); 
	private String password;
	private String username;
	
	public GlimmoUserDetails(String username, String password, Set<GlimmoUserAuthority> authorities){
		this.username = username;
		this.password = password;
		
		if(authorities != null){
			for(GlimmoUserAuthority authority : authorities){
				this.authorities.add(authority);
			}
		}
	}
	
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public String getPassword() {
		return this.password;
	}

	public String getUsername() {
		return this.username;
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}

}
