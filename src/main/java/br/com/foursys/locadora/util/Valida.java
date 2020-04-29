package br.com.foursys.locadora.util;

import java.util.ArrayList;
import java.util.Date;

import br.com.caelum.stella.validation.CPFValidator;

public class Valida {

	public static boolean verificaVazio(String aux) {
		aux = aux.replace(".", " ");
		aux = aux.replace("-", " ");
		aux = aux.replace("/", " ");
		aux = aux.replace("(", " ");
		aux = aux.replace(")", " ");
		if (aux.trim().equals("") || aux == null) {
			return true;
		}
		return false;
	}

	public static boolean validaCpf(String cpf) {
		CPFValidator cpfValidator = new CPFValidator();

		try {
			cpfValidator.assertValid(cpf);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean validaRg(String rg) {
		try {
			if (rg.equals("00.000.000-0") || rg.equals("11.111.111-1") || rg.equals("22.222.222-2")
					|| rg.equals("33.333.333-3") || rg.equals("44.444.444-4") || rg.equals("55.555.555-5")
					|| rg.equals("66.666.666-6") || rg.equals("77.777.777-7") || rg.equals("88.888.888-8")
					|| rg.equals("99.999.999-9")) {
				return false;
			}
			String auxRg = rg.replace(".", "").replace("-", "");
			String n1 = (auxRg.substring(0, 1));
			String n2 = (auxRg.substring(1, 2));
			String n3 = (auxRg.substring(2, 3));
			String n4 = (auxRg.substring(3, 4));
			String n5 = (auxRg.substring(4, 5));
			String n6 = (auxRg.substring(5, 6));
			String n7 = (auxRg.substring(6, 7));
			String n8 = (auxRg.substring(7, 8));
			String dv = (auxRg.substring(8, 9).toUpperCase());
			int digito;
			if (dv.equals("X")) {
				digito = 10;
			} else {
				digito = Integer.parseInt(dv);
			}

			int soma = (9 * Integer.parseInt(n1)) + (8 * Integer.parseInt(n2)) + (7 * Integer.parseInt(n3))
					+ (6 * Integer.parseInt(n4)) + (5 * Integer.parseInt(n5)) + (4 * Integer.parseInt(n6))
					+ (3 * Integer.parseInt(n7)) + (2 * Integer.parseInt(n8));

			soma = soma % 11;
			
			if (soma == digito) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			return false;
		}
	}

	public static boolean validaDataVazia(Date data) {
		if (data == null) {
			return true;
		}

		return false;
	}
	
	public static boolean validaDataMaiorQueHoje(Date data) {
		Date dataHoje = new Date(System.currentTimeMillis());
		if (data.after(dataHoje)) {
			return false;
		}

		return true;
	}

	public static boolean validaListaStringVazia(ArrayList<String> lista) {
		if (lista.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

}
