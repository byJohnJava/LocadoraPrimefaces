package br.com.foursys.locadora.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Data {

	public static String dataAtualFormatada = (new java.text.SimpleDateFormat("dd/MM/yyyy")
			.format(new java.util.Date(System.currentTimeMillis())));
	
	public static String formataData(Date data) {
		
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = format.format(data);	
		
		return dataFormatada;		
	}

}
