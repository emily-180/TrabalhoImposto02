package model;

import java.util.ArrayList;
import java.util.List;

public class Product {
	private String name;
	private double costPrince; //preco de custo
	private double profit; //margem de lucro
	private List<Tax> taxes;
	private boolean industrialized;
    private boolean imported;
	//ctrl shift o importa bibliotecas que são necessárias
	
	public Product(String name, double costPrince, double profit, boolean industrialized, boolean imported) throws Exception{ //erro será tratado no Main
		setName(name);
		setCostPrince(costPrince);
		setProfit(profit);
		this.industrialized = industrialized;
		this.imported = imported;
		this.taxes = new ArrayList<>();
	}
	
	public boolean addTax(Tax tax) throws Exception{
		if(tax == null) 
			throw new Exception("Imposto não pode ser nulo");
		if(taxes.contains(tax)) //se contem blz, nao addd
			return false;
		else 
			taxes.add(tax);
		return true;
	}
	
	public double calculateSalePrince() {
		//calcular os impostos
		double taxesSum = 0;
		for(Tax tax: taxes) {
			taxesSum += tax.calculate(this); //to passando ele mesmo
		}
		double finalCost = this.costPrince + taxesSum;
		double finalPrince = finalCost + (finalCost * getProfit());
		return finalPrince;
	}
	
	public double getCostPrince() {
		return this.costPrince;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isIndustrialized() {
		return industrialized;
	}

	public boolean isImportaded() {
		return imported;
	}

	public double getProfit() {
		return profit;
	}

	private void setProfit(double profit)  throws Exception{
		if(profit<=0)
			throw new Exception("MargemPreço de custo está inválido.");
		this.profit = profit/100;//pra ficar mais facil vou dividir aqui
		
	}

	private void setCostPrince(double costPrince) throws Exception{
		if(costPrince<=0)
			throw new Exception("Preço de custo está inválido.");
		this.costPrince = costPrince;
	}

	private void setName(String name) throws Exception{
		if(name == null || name.equals(""))
			throw new Exception("Nome Invalido");
		this.name = name;
	}
	
}
