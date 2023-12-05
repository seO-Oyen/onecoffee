package order_sol;

public class Menu {
	private int no;
	private String category;
	private String name;
	private String drink_Type;
	private int price;
	private String detail;
	public Menu() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Menu(String category, String drink_Type, String name) {
		this.category = category;
		this.drink_Type = drink_Type;
		this.name = name;
	}


	public Menu(int no, String category, String name, String drink_Type, int price, String detail) {
		this.no = no;
		this.category = category;
		this.name = name;
		this.drink_Type = drink_Type;
		this.price = price;
		this.detail = detail;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDrink_Type() {
		return drink_Type;
	}
	public void setDrink_Type(String drink_Type) {
		this.drink_Type = drink_Type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
}
