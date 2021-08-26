package application;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entites.Client;
import entites.Order;
import entites.OrderItem;
import entites.Product;
import entites.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = Order.sdf1.parse(sc.nextLine());

		Client client = new Client(name, email, birthDate);

		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String orderStatus = sc.nextLine();
		System.out.print("How many items to this order? ");
		int quantityOrder = sc.nextInt();

		Date moment = new Date();

		Order order = new Order(moment, OrderStatus.valueOf(orderStatus), client);

		for (int i = 0; i < quantityOrder; i++) {

			sc.nextLine();
			System.out.println("Enter #" + (i+1) + " item data:");
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();

			Product product = new Product(productName, productPrice);

			OrderItem orderItem = new OrderItem(productQuantity, productPrice, product);

			order.addItem(orderItem);
			
		}

		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
		
		sc.close();

	}

}
