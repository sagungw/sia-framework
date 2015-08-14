package com.sia.main.web.security;

import java.util.Collection;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.sia.main.domain.SatMan;

@SuppressWarnings("serial")
public class SIAUser extends User{

	private UUID userId;
	
	private SatMan satuanManajemen;

	public SIAUser(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities, UUID userId,
			SatMan satuanManajemen) {
		super(username, password, enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);
		this.userId = userId;
		this.satuanManajemen = satuanManajemen;
	}

	public SIAUser(String username, String password,
			Collection<? extends GrantedAuthority> authorities, UUID userId,
			SatMan satuanManajemen) {
		super(username, password, authorities);
		this.userId = userId;
		this.satuanManajemen = satuanManajemen;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public SatMan getSatuanManajemen() {
		return satuanManajemen;
	}

	public void setSatuanManajemen(SatMan satuanManajemen) {
		this.satuanManajemen = satuanManajemen;
	}
	
}
