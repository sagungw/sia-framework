package com.sia.main.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.filter.GenericFilterBean;

import com.sia.main.domain.Menu;
import com.sia.main.domain.Peran;

public class ModuleSecurityFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response =  (HttpServletResponse) servletResponse;
		HttpSession session = request.getSession();
		
		for(String split : request.getRequestURI().split("/", 5)) {
			System.out.println("string: " + split);
		}
		
		if(session.getAttribute("userSession") != null) {
			Peran role = (Peran) session.getAttribute("roleSession");
			if(role != null) {
				if(!role.getNamaPeran().toLowerCase().equals("admin")) {
					String requestMenuUrl = "/" + request.getRequestURI().split("/", 5)[4];
					List<Menu> menuList = (List<Menu>)session.getAttribute("menuSession");
					boolean roleValid = false;
					for(Menu menu : menuList) {
						String menuUrl = this.normalizeUrl(menu.getUrlPattern()); 
						if(requestMenuUrl.contains(menuUrl)) {
							roleValid = true;
							break;
						}
					}
					if(!roleValid) {
						response.sendRedirect("/sia-web/account/login");					// ganti ke access denied page
					}
				}
			} else {
				response.sendRedirect("/sia-web/account/login");					// ganti ke must choose role page
			}
		} else {
			response.sendRedirect("/sia-web/account/login");					// ganti ke must login page
		}
		
		filterChain.doFilter(request, response);
	}
	
	private String normalizeUrl(String url) {
		return url.charAt(url.length() - 1) == '*' ? url.split("*")[0] : url;
	}
	
}
