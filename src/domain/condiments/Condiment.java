package domain.condiments;

public class Condiment {
	private String name;
	private int qty;
	
	public Condiment(String name, int qty) {
		this.name = name;
		this.qty = qty;
	}
	
	public String getName() {
		return name;
	}
	
	public int getQty() {
		return qty;
	}
}
