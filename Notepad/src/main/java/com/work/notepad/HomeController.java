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
	//Properties class'ýndan bir arraylist yarattýk. Bu arraylistin içinde objeler yer alacak.
 	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("data", ls); 
		//home sayfasý açýlýnca arraylist içindeki tüm objeleri data ile view katmanýna gönderdik.
		
		return "home";
	}
	
	//formdan datalar POST methoduyla gönderilir, POST methoduyla da alýnýr.
	@RequestMapping(value="/dataSend", method = RequestMethod.POST) 
	public String dataSend(Properties pro, Model model) { //Properties class'ýndan pro objesi yaratýldý.
		if(pro.getName().equals("")) {
			return "redirect:/";
		}else {
			ls.add(pro); //ls arraylistine pro objesini ekledik.
			model.addAttribute("data", ls); // add  iþleminden sonra listin son hali view katmanýna gönderilir
			return "detail";
		}
	}
	
	//View'dan gelen silinecek itemin id'si controller'da bu þekilde yakalanýr. 
	@RequestMapping(value="/deleteItem/{name}", method = RequestMethod.GET) 
	public String deleteItem(@PathVariable String name, Model model) {
		for(int i=0; i<ls.size(); i++) {
			if(ls.get(i).getName().equals(name)) { //Listteki sýfýrýncý objenin name ini al, yukarýda okuduðun name ile eþitse sil
				ls.remove(i);			//Listteki birinci objenin name ini al, yukarýda okuduðun name ile eþitse sil
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
