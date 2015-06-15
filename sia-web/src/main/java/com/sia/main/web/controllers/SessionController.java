package com.sia.main.web.controllers;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sia.main.domain.Pengguna;
import com.sia.main.domain.Peran;
import com.sia.main.domain.PeranPengguna;
import com.sia.main.service.services.PeranPenggunaService;
import com.sia.main.service.services.PeranService;

@Controller
@RequestMapping(value = "/session")
public class SessionController {
	
	@Autowired
	private PeranPenggunaService peranPenggunaService;
	
	@Autowired
	private PeranService peranService;
	
	@RequestMapping(value = "/pilihPeran", method = RequestMethod.GET)
	public ModelAndView showAvailableRole(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		if (session.getAttribute("userSession") == null) {
			modelAndView.setViewName("redirect:/account/login");
		} else {
			Pengguna pengguna = (Pengguna)session.getAttribute("userSession");
			String queryParam = "where pengguna.idPengguna = '" +  pengguna.getIdPengguna() + "'";
			List<PeranPengguna> peranPenggunaList = this.peranPenggunaService.getByParam(queryParam);
			if(peranPenggunaList.size() > 1) {
				modelAndView.setViewName("PilihPeran");
				modelAndView.addObject("peranList", peranPenggunaList);	
			} else {
				session.setAttribute("roleSession", peranPenggunaList.get(0).getPeran());
				modelAndView.setViewName("redirect:/pilihModul");												//----->>>>>> PERLU GANTI
			}
		}
		return modelAndView;
	}

	@RequestMapping(value = "/pilihPeran/", method = RequestMethod.POST)
	public ModelAndView submitRole(HttpSession session, @RequestParam("idPeran") UUID idPeran) {
		ModelAndView modelAndView = new ModelAndView();
		Peran peran = peranService.getById(idPeran);
		session.setAttribute("roleSession", peran);
		modelAndView.setViewName("redirect:/pilihModul");												//----->>>>>> PERLU GANTI
		return modelAndView;
	}
	
}
