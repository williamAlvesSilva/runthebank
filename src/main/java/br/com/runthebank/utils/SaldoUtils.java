package br.com.runthebank.utils;

import br.com.runthebank.model.conta.SaldoState;

public class SaldoUtils {
	
	public static SaldoState sigNumber(int saldo)
	{
		if (saldo > 0) {
	        return SaldoState.POSITIVE;
	    } else if (saldo < 0) {
	        return SaldoState.NEGATIVE;
	    }
	    return SaldoState.ZERO;
	}
	
	public static SaldoState sigNumber(String saldo)
	{
		int saldoInt = ContaUtils.STRING_2_INT(saldo);
		return SaldoUtils.sigNumber(saldoInt);
	}
}
