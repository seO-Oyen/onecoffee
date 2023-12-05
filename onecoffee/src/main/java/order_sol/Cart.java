package order_sol;

public class Cart {
	private String category;
	private String drink_type;
	private String name;
	private int price;
	private int cnt;
	private int no;
	public Cart() {
		// TODO Auto-generated constructor stub
	}
	public Cart(String category, String drink_type, String name, int price, int cnt, int no) {
		this.category = category;
		this.drink_type = drink_type;
		this.name = name;
		this.price = price;
		this.cnt = cnt;
		this.no = no;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDrink_type() {
		return drink_type;
	}
	public void setDrink_type(String drink_type) {
		this.drink_type = drink_type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}

}
