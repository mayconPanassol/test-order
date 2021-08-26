package entites;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entites.enums.OrderStatus;

public class Order {

	private Date moment;
	private OrderStatus status;

	private Client client;
	private List<OrderItem> items = new ArrayList<>();

	public static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
	public static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyy");

	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItem() {
		return items;
	}

	public void addItem(OrderItem orderItem) {
		items.add(orderItem);
	}

	public void removeItem(OrderItem orderItem) {
		items.remove(orderItem);
	}

	public Double total() {

		double total = 0.0;

		for (OrderItem c : items) {
			total += c.subTotal();
		}

		return total;
	}

	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append("Order moment: " + sdf2.format(moment) + "\n");
		sb.append("Order status: " + status + "\n");
		sb.append("Client: " + client.getName() + " (" + sdf1.format(client.getBirthDate()) + ") - " + client.getEmail()
				+ "\n");
		sb.append("Order Items: " + "\n");

		for (OrderItem c : items) {
					sb.append(c.getProduct().getName() + ", $" 
					+ String.format("%.2f", c.getProduct().getPrice()) 
					+ ", Quantity: " + c.getQuantity() 
					+ ", Subtotal: $" + String.format("%.2f", c.subTotal()) + "\n");
		}

		sb.append("Total price: $ " + String.format("%.2f", total()));

		return sb.toString();

	}

}
