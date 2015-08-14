package com.sia.main.web.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sia.main.domain.Pengguna;
import com.sia.main.domain.PeranPengguna;
import com.sia.main.service.services.PenggunaService;

public class SIAUserService implements UserDetailsService {

	private PenggunaService penggunaService;

	public PenggunaService getPenggunaService() {
		return penggunaService;
	}

	public void setPenggunaService(PenggunaService penggunaService) {
		this.penggunaService = penggunaService;
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Pengguna user = penggunaService.getByParam(
				"where username = '" + username + "'").get(0);
		return new SIAUser(user.getUsername(), user.getPassword(),
				user.isStatusKeaktifan(), true, true, true,
				this.buildUserAuthorities(user.getPeranPenggunas()),
				user.getIdPengguna(), user.getSatMan());
	}

	private List<GrantedAuthority> buildUserAuthorities(
			List<PeranPengguna> userRoles) {
		List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		for (PeranPengguna userRole : userRoles) {
			auths.add(new SimpleGrantedAuthority("ROLE_"
					+ userRole.getPeran().getNamaPeran()));
		}
		return auths;
	}

}
