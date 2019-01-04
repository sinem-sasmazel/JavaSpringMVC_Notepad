package com.work.notepad;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	ArrayList<Properties> ls = new ArrayList<Properties>(); 
	//Properties class'�ndan bir arraylist yaratt�k. Bu arraylistin i�inde objeler yer alacak.
 	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("data", ls); 
		//home sayfas� a��l�nca arraylist i�indeki t�m objeleri data ile view katman�na g�nderdik.
		
		return "home";
	}
	
	//formdan datalar POST methoduyla g�nderilir, POST methoduyla da al�n�r.
	@RequestMapping(value="/dataSend", method = RequestMethod.POST) 
	public String dataSend(Properties pro, Model model) { //Properties class'�ndan pro objesi yarat�ld�.
		if(pro.getName().equals("")) {
			return "redirect:/";
		}else {
			ls.add(pro); //ls arraylistine pro objesini ekledik.
			model.addAttribute("data", ls); // add  i�leminden sonra listin son hali view katman�na g�nderilir
			return "detail";
		}
	}
	
	//View'dan gelen silinecek itemin id'si controller'da bu �ekilde yakalan�r. 
	@RequestMapping(value="/deleteItem/{name}", method = RequestMethod.GET) 
	public String deleteItem(@PathVariable String name, Model model) {
		for(int i=0; i<ls.size(); i++) {
			if(ls.get(i).getName().equals(name)) { //Listteki s�f�r�nc� objenin name ini al, yukar�da okudu�un name ile e�itse sil
				ls.remove(i);			//Listteki birinci objenin name ini al, yukar�da okudu�un name ile e�itse sil
				model.addAttribute("data", ls);
				break;					//....
			
			}
		}
		
		return "detail";
	}
	
	@RequestMapping(value="/detailDisplay", method = RequestMethod.GET)
	public String detailDisplay(Model model) {
		model.addAttribute("data", ls);
		return "detail";
	}
	
	
	
	
}
