package com.sia.main.web.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sia.main.data.dao.PdDAO;
import com.sia.main.data.dao.PtkDAO;
import com.sia.main.data.dao.SatuanManajemenDAO;
import com.sia.main.data.dao.TipePenggunaDAO;
import com.sia.main.data.dao.BasicDAO;
import com.sia.main.domain.Pd;
import com.sia.main.domain.Pengguna;
import com.sia.main.domain.Ptk;
import com.sia.main.domain.SatMan;
import com.sia.main.domain.TipePengguna;
import com.sia.main.service.services.PenggunaService;
import com.sia.main.web.model.Response;

@Controller
@RequestMapping(value = "/admin/user")
public class UserController {

	@Autowired
	private PenggunaService penggunaService;
	
	@Autowired
	private PdDAO pdDAO;
	
	@Autowired
	private PtkDAO ptkDAO;
	
	@Autowired
	private TipePenggunaDAO tipePenggunaDAO;
	
	@Autowired
	private SatuanManajemenDAO satuanManajemenDAO;
	
	@Autowired
	private BasicDAO basicDAO;
	
	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	public ModelAndView viewUsers() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("users", this.penggunaService.getByParam("where statusKeaktifan is true"));
		modelAndView.addObject("satManList", this.satuanManajemenDAO.getAll());
		List<String> daftarAngkatan= new ArrayList<String>();
		for(Object obj : this.basicDAO.getObjects("select distinct pd.angkatanPd from Pengguna")) {
			Integer angkatan = (Integer) obj;
 			daftarAngkatan.add(angkatan.toString());
		}
		modelAndView.addObject("angkatanList", daftarAngkatan);
		List<String> userTypes = new ArrayList<String>();
		for(Object obj : this.basicDAO.getObjects("select namaTipe from TipePengguna")) {
 			userTypes.add((String) obj);
		}
		modelAndView.addObject("userTypes", userTypes);
		modelAndView.setViewName("PengelolaanPengguna");
		return modelAndView;
	}
	
	@RequestMapping(value = "/multiDelete", method = RequestMethod.POST)
	public @ResponseBody Response deleteUsers(@RequestBody String[] userIds) {
		boolean success = true;
		Pengguna last = null;
		Response response = null;
		for(String userId: userIds) {
			Pengguna user = this.penggunaService.getById(UUID.fromString(userId));
			if(this.penggunaService.delete(user) == null) {
				success = false;
				last = user;
				break;
			}
		}
		if(!success) {
			response = new Response("error", "penghapusan pengguna gagal pada " + last.getUsername(), null);
		} else {
			response = new Response("success", "penghapusan pengguna berhasil", null);
		}
		return response;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody Response deleteUser(@RequestParam("userId") String userId) {
		boolean success = true;
		Response response = null;
		Pengguna user = this.penggunaService.getById(UUID.fromString(userId));
		if(this.penggunaService.delete(user) == null) {
			success = false;
		} 
		if(!success) {
			response = new Response("error", "pengguna gagal dihapus", null);
		} else {
			response = new Response("success", "pengguna berhasil dihapus", null);
		}
		return response;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addUser() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("satManList", this.satuanManajemenDAO.getAll());
		List<String> userTypes = new ArrayList<String>();
		for(Object obj: this.basicDAO.getObjects("select namaTipe from TipePengguna")){
			userTypes.add((String) obj);
		}
		modelAndView.addObject("userTypes", userTypes);
		modelAndView.setViewName("TambahPengguna");
		return modelAndView;
	}
	
	@RequestMapping(value = "/add/", method = RequestMethod.POST)
	public ModelAndView submitUser(@RequestParam("ni") String ni, @RequestParam("username") String username, @RequestParam("tipe") String tipe, @RequestParam("satMan") String satMan) {
		ModelAndView modelAndView = new ModelAndView();
		SatMan newSatMan = this.satuanManajemenDAO.getByParam("where nmSatMan = '" + satMan + "'").get(0);
		Pd pd = null;
		Ptk ptk = null;
		if(tipe.toLowerCase().equals("pd")) {
			pd = this.pdDAO.getByParam("where niPd = '" + ni + "'").get(0);
		} else {
			ptk = this.ptkDAO.getByParam("where niPtk = '" + ni + "'").get(0);
		}
		TipePengguna tp = this.tipePenggunaDAO.getByParam("where namaTipe = '" + tipe + "'").get(0);
		Pengguna user = new Pengguna(UUID.randomUUID(), pd, ptk, newSatMan, username, ni, true, "", null, tp);
		this.penggunaService.insertInto(user);
		modelAndView.setViewName("redirect:/admin/user/");
		return modelAndView;
	}
	
	@RequestMapping(value = "/add/upload", method = RequestMethod.POST)
	public ModelAndView uploadCSV(@RequestParam("file") Object file) {
		ModelAndView modelAndView = new ModelAndView();
		MultipartFile multipartFile = (MultipartFile) file;
		BufferedReader  br = null;
		try {
			File newFile = new File(multipartFile.getOriginalFilename());
			multipartFile.transferTo(newFile);
			String line = "";
			br = new BufferedReader(new FileReader(newFile));
			while ((line = br.readLine()) != null) {
				String[] userData = line.split(",");
				SatMan satMan = this.satuanManajemenDAO.getByParam("where nmSatMan = '" + userData[3] + "'").get(0);
				Pd pd = null;
				Ptk ptk = null;
				if(userData[2].toLowerCase().equals("pd")) {
					pd = this.pdDAO.getByParam("where niPd = '" + userData[0] + "'").get(0);
				} else {
					ptk = this.ptkDAO.getByParam("where niPtk = '" + userData[0] + "'").get(0);
				}
				TipePengguna tp = this.tipePenggunaDAO.getByParam("where namaTipe = '" + userData[2] + "'").get(0);
				Pengguna user = new Pengguna(UUID.randomUUID(), pd, ptk, satMan, userData[1], userData[0], true, "", null, tp);
				this.penggunaService.insertInto(user);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		modelAndView.setViewName("redirect:/admin/user/");
		return modelAndView;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updateUser(@RequestParam("id") String id, @RequestParam("username") String username, @RequestParam("satMan") String satMan) {
		ModelAndView modelAndView = new ModelAndView();
		SatMan newSatMan = this.satuanManajemenDAO.getByParam("where nmSatMan = '" + satMan + "'").get(0);
		Pengguna user = this.penggunaService.getById(UUID.fromString(id));
		user.setUsername(username);
		user.setSatMan(newSatMan);
		this.penggunaService.update(user);
		modelAndView.setViewName("redirect:/admin/user/");
		return modelAndView;
	}
	
}
