package com.sia.main.web.controllers;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sia.main.domain.Peran;
import com.sia.main.service.services.PeranService;
import com.sia.main.web.AjaxResponse;

@Controller
@RequestMapping(value = "/pengelolaan_peran")
public class PeranController {
	
	PeranService peranService;
	
	public PeranService getPeranService() {
		return peranService;
	}

	public void setPeranService(PeranService peranService) {
		this.peranService = peranService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView kelolaPeran() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("PengelolaanPeran");
		return modelAndView;
	}
	
	//debugging
	@RequestMapping(value = "/tambah/", method = RequestMethod.POST)
	//public @ResponseBody AjaxResponse tambahPeran(@RequestBody String namaPeran) { 
	public @ResponseBody AjaxResponse tambahPeran(@RequestParam("namaPeran") String namaPeran) { 
			
		return new AjaxResponse("ok", "msg", namaPeran);
	}
	//debugging
	
//	@RequestMapping(value = "/tambah/", method = RequestMethod.POST)
//	public @ResponseBody AjaxResponse tambahPeran(@RequestBody Peran peran) {
////		Peran peran = new Peran();
////		peran.setNamaPeran(namaPeran);
//		boolean success = peranService.insertInto(peran);
//		if(success) {
//			return new AjaxResponse("ok", "peran " + peran.getNamaPeran() + " berhasil ditambahkan", null);
//		} else {
//			return new AjaxResponse("error","peran " + peran.getNamaPeran() + " gagal ditambahkan", null );
//		}
//	}
	
//	@RequestMapping(value = "/ubah/", method = RequestMethod.POST)
//	public @ResponseBody AjaxResponse ubahPeran(@RequestParam("namaPeranLama") String namaPeranLama, @RequestParam("namaPeran") String namaPeran) {
//		boolean success = peranService.update(namaPeranLama, namaPeran);
//		if(success) {
//			return new AjaxResponse("ok", "peran " + peran.getNamaPeran() + " berhasil diubah", null);
//		} else {
//			return new AjaxResponse("error","peran " + peran.getNamaPeran() + " gagal diubah", null );
//		}
//	}
	
	@RequestMapping(value = "/hapus/", method = RequestMethod.POST)
	public @ResponseBody  AjaxResponse hapusPeran(@RequestBody Peran peran) {
		peranService.delete(peran);
		return new AjaxResponse("ok", "peran " + peran.getNamaPeran() + " berhasil dihapus", null);
	}
	
}
