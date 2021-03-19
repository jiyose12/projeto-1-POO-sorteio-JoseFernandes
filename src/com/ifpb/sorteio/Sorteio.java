package com.ifpb.sorteio;

import java.util.Arrays;
import java.util.Random;

public class Sorteio {
	private int n; 
	private int[] numeros;
	private int min;
	private int max;
	private boolean terminouSorteio = false;
	private int numeroGerado;
	private int contador = 0;

	public Sorteio(int n, int min, int max) throws Exception {
		if ((n < 0 && n > 100) || min < 0 || max < 0 || min >= max) {
			throw new Exception("0<n<100, min>0, max>0 e min<=max");
		}
		this.n = n;
		this.min = min;
		this.max = max;
		this.numeros = new int[this.n];
	}

	public void gerarNumeros() {
		this.contador = 0;
		for (int i = 0; i < this.n; i++) {
			try {
				this.contador++;
				proximoNumero();
				this.numeros[i] = this.numeroGerado;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (isVerificadoDuplicados()) {
			gerarNumeros();
		}
	}

	public void proximoNumero() throws Exception {
		if (!terminou()) {
			throw new Exception("só pode gerar um número se o sorteio não terminou");
		}
		Random sorteio = new Random();
		int numeroAleatorio = sorteio.nextInt(max + 1 - min) + min;
		this.numeroGerado = numeroAleatorio;
	}
	
	public boolean isVerificadoDuplicados() {
		boolean duplicado = false;
		for (int i = 0; i < this.numeros.length; i++) {
			for (int j = i + 1 ; j < this.numeros.length; j++) {
				if (this.numeros[i] == (this.numeros[j])) {
					duplicado = true;
				}
			}
		}
		return duplicado;
	}

	public boolean terminou() {
		if (contador == this.n) {
			this.terminouSorteio = true;
		}
		return this.terminouSorteio;
	}

	public String resultado(String padrao) throws Exception {
		String join = "";
		String[] resultadoFinal = new String[this.n];
		if (padrao == null) {
			throw new Exception("o padrao pode ser qualquer string, mas não pode ser null");
		} else {
			for (int i = 0; i < this.n; i++) {
				resultadoFinal[i] = Integer.toString(numeros[i]);
				join = String.join(padrao, resultadoFinal);
				
			}
		}
		return join;
	}
}
