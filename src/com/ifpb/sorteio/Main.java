package com.ifpb.sorteio;

public class Main {

	public static void main(String[] args) {
		
		try {
			Sorteio sorteio = new Sorteio(4, 90, 99);
			sorteio.gerarNumeros();
			
			System.out.println(sorteio.resultado("-"));
			System.out.println(sorteio.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
