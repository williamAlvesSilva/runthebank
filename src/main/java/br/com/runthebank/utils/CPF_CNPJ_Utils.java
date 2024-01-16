package br.com.runthebank.utils;

import br.com.runthebank.model.conta.TipoConta;

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
	
	public static TipoConta isClientePFByCPF(String cpf_cnpj) {
		cpf_cnpj = returnJustNumbers(cpf_cnpj);
		
		if(cpf_cnpj.trim().length() <= 11)
		{
			return TipoConta.PF;
		}
		else {
			return TipoConta.PJ;
		}
	}
}
