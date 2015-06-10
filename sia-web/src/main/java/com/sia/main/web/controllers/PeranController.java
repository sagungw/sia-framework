package com.sia.main.web.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sia.main.web.utils.AjaxResponse;
import com.sia.main.domain.Peran;
import com.sia.main.service.services.PeranService;

@Controller
@RequestMapping(value = "/pengelolaanPeran")
public class PeranController {
	
	@Autowired
	PeranService peranService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView kelolaPeran() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("PengelolaanPeran");
		modelAndView.addObject("daftarPeran", peranService.getAll() );
		return modelAndView;
	}
	
	@RequestMapping(value = "/tambah", method = RequestMethod.POST)
	public @ResponseBody AjaxResponse tambahPeran(@RequestParam("namaPeran") String namaPeran) { 
		Peran peran = new Peran();
		peran.setNamaPeran(namaPeran);
		Peran res = peranService.insertInto(peran);
		if(res != null) {
			return new AjaxResponse("ok", "peran " + peran.getNamaPeran() + " berhasil ditambahkan", null);
		} else {
			return new AjaxResponse("error","peran " + peran.getNamaPeran() + " gagal ditambahkan", null );
		}
	}
	
	@RequestMapping(value = "/ubah", method = RequestMethod.POST)
	public @ResponseBody AjaxResponse ubahPeran(@RequestParam("idPeran") UUID idPeran, @RequestParam("namaPeran") String namaPeran) {
		Peran peran = new Peran();
		peran.setIdPeran(idPeran);
		peran.setNamaPeran(namaPeran);
		Peran res = peranService.update(peran);
		if(res != null) {
			return new AjaxResponse("ok", "peran " + peran.getNamaPeran() + " berhasil diubah", null);
		} else {
			return new AjaxResponse("error","peran " + peran.getNamaPeran() + " gagal diubah", null );
		}
	}
	
	@RequestMapping(value = "/hapus", method = RequestMethod.POST)
	public @ResponseBody  AjaxResponse hapusPeran(@RequestParam("idPeran") UUID idPeran, @RequestParam("namaPeran") String namaPeran) {
		Peran peran = new Peran();
		peran.setIdPeran(idPeran);
		peranService.delete(peran);
		return new AjaxResponse("ok", "peran " + namaPeran + " berhasil dihapus", null);
	}
	
}
