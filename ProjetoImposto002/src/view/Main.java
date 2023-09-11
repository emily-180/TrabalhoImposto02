package view;

import model.Product;
import model.Tax;

public class Main {
	public static void main(String[] args) throws Exception{
		
		Tax iss = new Tax("ISS", "Imposto sobre Serviços de Qualquer Natureza", 5);
		Tax ipi = new Tax("IPI", "Imposto Prod. Industralizado", 10);		
		Tax icms = new Tax("ICMS", "Imposto Circ. Mercadorias", 7);
		
		Product arroz = new Product("Arroz", 7.00, 20, false, true);
		arroz.addTax(icms);
		arroz.addTax(iss);

		Product feijao = new Product("Feijão", 7.00, 25, false, true);
		feijao.addTax(icms);
		feijao.addTax(iss);

		Product carne = new Product("Carne", 7.00, 35, true, false);
		carne.addTax(icms);
		carne.addTax(ipi);

		Product cerveja = new Product("Cerveja", 7.00, 30, true, true);
		cerveja.addTax(icms);
		cerveja.addTax(iss);
		cerveja.addTax(ipi);

		Product gas = new Product("Gás", 7.00, 15, true, false);
		gas.addTax(icms);
		gas.addTax(ipi);

		Product gasolina = new Product("Gasolina", 7.00, 15, false, true);
		gasolina.addTax(icms);
		
		System.out.printf(arroz.getName() +"  R$: %.2f\n",arroz.calculateSalePrince());
		System.out.print("----------------\n ");
		System.out.printf(feijao.getName() +" R$: %.2f\n",feijao.calculateSalePrince());
		System.out.print("----------------\n ");
		System.out.printf(carne.getName() +"  R$: %.2f\n",carne.calculateSalePrince());
		System.out.print("----------------\n ");
		System.out.printf(cerveja.getName() +"  R$: %.2f\n",cerveja.calculateSalePrince());
		System.out.print("----------------\n ");
		System.out.printf(gasolina.getName() +"  R$: %.2f\n", gasolina.calculateSalePrince());
		System.out.print("----------------\n ");
		System.out.printf(gas.getName() +" R$: %.2f\n",gas.calculateSalePrince());
		System.out.print("----------------\n ");

		
	}
}
 