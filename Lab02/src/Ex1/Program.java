package Ex1;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
//    	if (args.length != 1) {
//            System.out.println("Usage: java Program <connection_url>");
//            return;
//        }
    	ProductDAO productDAO = new ProductDAO();
        

        try (Connection connection = productDAO.connect()) {
            

            Scanner scanner = new Scanner(System.in);
            boolean exit = false;
            while (!exit) {
                // Display menu options and handle user input
                System.out.println("Menu:");
                System.out.println("1. Read product list");
                System.out.println("2. Read a product by input id");
                System.out.println("3. Add a new product");
                System.out.println("4. Update a product");
                System.out.println("5. Delete a product");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                    	List<Product> prd = productDAO.readAll();
                    	for(Product p : prd) {
                    		System.out.print(p.getId()+"\t");
                    		System.out.print(p.getName()+"\t");
                    		System.out.print(p.getPrice()+"\t");
                    		System.out.println(p.getColor()+"\t");
                    		
                    	}

                        break;
                    case 2:
                    	System.out.print("id: "); 
                    	int id = scanner.nextInt();
                    	Product p = productDAO.read(id);
                    	System.out.print(p.getId()+"\t");
                		System.out.print(p.getName()+"\t");
                		System.out.print(p.getPrice()+"\t");
                		System.out.println(p.getColor()+"\t");
                        break;
                    case 3:
                    	System.out.print("name:"); 
                    	String name = scanner.nextLine();
                    	System.out.print("price:"); 
                    	int price = scanner.nextInt();
                    	scanner.nextLine(); 
                    	System.out.print("color:"); 
                    	String color = scanner.nextLine();

                    	Product pt = new Product();
                    	pt.setName(name);
                    	pt.setPrice(price);
                    	pt.setColor(color);
                    	
                    	int result= productDAO.add(pt);
                    	if(result==1) {
                    		System.out.println("Them thanh cong");
                    	}
                        break;
                    case 4:
                    	System.out.print("id:"); 
                    	int idUpdate = scanner.nextInt();
                    	scanner.nextLine(); 
                    	System.out.print("name:"); 
                    	String nameUpdate = scanner.nextLine();
                    	System.out.print("price:"); 
                    	int priceUpdate = scanner.nextInt();
                    	scanner.nextLine(); 
                    	System.out.print("color:"); 
                    	String colorUpdate = scanner.nextLine();
                    	Product prt = new Product();
                    	prt.setId(idUpdate);
                    	prt.setName(nameUpdate);
                    	prt.setPrice(priceUpdate);
                    	prt.setColor(colorUpdate);
                    	
                    	productDAO.update(prt);
                        break;
                    case 5:
                    	System.out.print("id:"); 
                    	int idDel = scanner.nextInt();
      
                    	productDAO.delete(idDel);
                        break;
                    case 6:
                        exit = true;
                        System.out.println("Exiting the program.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
