package br.com.runthebank.utils;

import br.com.runthebank.model.conta.SaldoState;

public class ContaUtils {

	public static long STRING_2_LONG(String str)
	{
		return Long.parseLong(str);
	}
	
	public static int STRING_2_INT(String str)
	{
		return Integer.parseInt(str);
	}
	
	public static String saldo_negative_zero_positive(SaldoState state)
	{
		String retorno = "";
		switch(state)
		{
		case NEGATIVE:
			retorno = "-";
			break;
		case ZERO:
			retorno = "0";
			break;
		case POSITIVE:
			retorno = "+";
			break;
		}
		
		return retorno;
	}
	
	public static SaldoState saldo_negative_zero_positive2SaldoState(String state_N_Z_P)
	{
		SaldoState state = null;
		
		switch(state_N_Z_P)
		{
		case "-":
			state = SaldoState.NEGATIVE;
			break;
		case "0":
			state = SaldoState.ZERO;
			break;
		case "+":
			state = SaldoState.POSITIVE;
			break;
		}
		
		return state;
	}
}
