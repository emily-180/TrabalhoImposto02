package model;

public class Tax {
	private String abbr;
	private String name;
	private double impostoFixo;

	
	public Tax(String abbr, String name, double impostoFixo) {
		//TODO devemos validar todos os atributos
		this.abbr = abbr;
		this.name = name;
		setImpostoFixo(impostoFixo);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) 
			return false;
		if(!(obj instanceof Tax)) //determinado objto é instancia de uma determinada classe, no caso Tax, produto não pode ser igual uma taxa
			return false;
		Tax tax = (Tax) obj; //cast(Tax)obj informando que obj ela  está opontando para Tax 
		return this.abbr.equals(tax.abbr);
	}
	
	
	public double calculate(Product p) {
		double costPrice = p.getCostPrince();
        if (this.abbr.equals("ICMS")) {
            if (p.isIndustrialized()) {
                return costPrice * 0.05;
            } else {
                return costPrice * impostoFixo;
            }
        } else if (this.abbr.equals("IPI")) {
            if (p.isImportaded()) {
                return costPrice * impostoFixo;
            } else {
                return costPrice * 0.08;
            }
        } else if (this.abbr.equals("ISS")) {
            return costPrice * impostoFixo;
        }
        return 0;
	}
	
	
	private void setImpostoFixo(double impostoFixo) {
		if (impostoFixo == 0) {
	        throw new IllegalArgumentException("O imposto não pode ser zero.");
	    }
		this.impostoFixo = impostoFixo/100; 
	}
}
