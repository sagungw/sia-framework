package com.sia.main.web.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sia.main.domain.MenuPeran;
import com.sia.main.domain.Modul;
import com.sia.main.domain.Pengguna;
import com.sia.main.domain.Peran;
import com.sia.main.domain.PeranPengguna;
import com.sia.main.service.services.MenuPeranService;
import com.sia.main.service.services.ModulService;
import com.sia.main.service.services.PenggunaService;
import com.sia.main.service.services.PeranPenggunaService;
import com.sia.main.service.services.PeranService;

@Controller
@RequestMapping(value = "/session")
public class SessionController {
	
	@Autowired
	private PenggunaService penggunaService;
	
	@Autowired
	private PeranPenggunaService peranPenggunaService;
	
	@Autowired
	private PeranService peranService;
	
	@Autowired
	private ModulService modulService;
	
	@Autowired
	private MenuPeranService menuPeranService;
	
	@RequestMapping(value = "/chooseUserRole", method = RequestMethod.GET)
	public ModelAndView showAvailableRole(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		Pengguna pengguna = (Pengguna) session.getAttribute("userSession");
		
		if (pengguna == null) {
			modelAndView.setViewName("redirect:/error/403");
		} else {
			String queryParam = "where pengguna.idPengguna = '" +  pengguna.getIdPengguna() + "'";
			List<PeranPengguna> peranPenggunaList = this.peranPenggunaService.getByParam(queryParam);
			if(peranPenggunaList .size() > 0) {
				if(peranPenggunaList.size() > 1) {
					modelAndView.setViewName("PilihPeran");
					modelAndView.addObject("peranList", peranPenggunaList);
				} else {
					session.setAttribute("roleSession", peranPenggunaList.get(0).getPeran());
					session.setAttribute("moduleSession", getRoleModules(peranPenggunaList.get(0).getPeran().getIdPeran()));
					modelAndView.setViewName("redirect:/home");												
				}
			} else {
				modelAndView = null;
			}
		}
		return modelAndView;
	}

	@RequestMapping(value = "/chooseUserRole/", method = RequestMethod.POST)
	public ModelAndView submitRole(HttpSession session, @RequestParam("idPeran") UUID idPeran) {
		ModelAndView modelAndView = new ModelAndView();
		Peran peran = peranService.getById(idPeran);
		session.setAttribute("roleSession", peran);
		session.setAttribute("moduleSession", getRoleModules(idPeran));
		modelAndView.setViewName("redirect:/home");												
		return modelAndView;
	}
	
	private List<Modul> getRoleModules(UUID roleId) {
		List<Modul> roleModules = new ArrayList<Modul>();
		List<MenuPeran> roleMenues = this.menuPeranService.getByParam("where idPeran = '" + roleId + "'");
		for(MenuPeran mp: roleMenues) {
			if(!roleModules.contains(mp.getMenu().getModul())) {
				roleModules.add(mp.getMenu().getModul());
			}
		}
		return roleModules;
	}
	
}
