package ch17.sec04.exam01;

import java.util.Objects;

public class Product {
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Product product = (Product) o;
		return pno == product.pno;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pno);
	}

	private int pno;
	private String name;
	private String company;
	private int price;
	
	public Product(int pno, String name, String company, int price) {
		this.pno = pno;
		this.name = name;
		this.company = company;
		this.price = price;
	}

	public int getPno() { return pno; }
	public String getName() { return name; }
	public String getCompany() { return company; }
	public int getPrice() { return price; }
	
	@Override
	public String toString() {
		return new StringBuilder()
                .append("{")
                .append("pno:").append(pno).append(",").append("name:").append(name).append(", ").append("company:").append(company).append(", ").append("price:").append(price)
				.append("}")
				.toString();
	}
}