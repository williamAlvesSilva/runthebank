package br.com.runthebank.utils;

public class CPF_CNPJ_Utils {

	public static String returnJustNumbers(String cpfCnpj)
	{
		String caracteres[] = {".", "-", "/"};
		
		for(String caracter : caracteres)
		{
			cpfCnpj = cpfCnpj.replace(caracter, "");
		}
		
		return cpfCnpj;
	}
	
	public static long string2justLongNumbers(String cpfCnpj) 
	{
		cpfCnpj = returnJustNumbers(cpfCnpj);
		
		return Long.parseLong(cpfCnpj);
	}
}
