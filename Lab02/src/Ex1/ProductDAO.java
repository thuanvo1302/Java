package Ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements Repository<Product, Integer> {
    
//    private Connection conn = this.connect();
    
    String connectionUrl = "jdbc:mysql://localhost:3308/productmanagement";
    String username = "root";
    String password = "root";

   
    
    public Connection connect(){
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(connectionUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public Integer add(Product item) {
    	
    	
    	String query = "INSERT INTO product(id, name, price, color) " +
                "VALUES (null, ?,?,?)";

        PreparedStatement pstm = null;
        try {
        	Connection conn = this.connect();
            pstm = conn.prepareStatement(query);

            pstm.setString(1, item.getName());
            pstm.setInt(2, item.getPrice());
            pstm.setString(3, item.getColor());

            int row = pstm.executeUpdate();
            if(row != 0){
                return 1;
            }

            
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return 0;
	}
    public  List<Product> readAll() {
    	String query = "SELECT * FROM product";
    	List<Product> pr = new ArrayList<Product>();
    	
    	Connection conn = this.connect();
    	try {
    		Statement stm = null;
            stm = conn.createStatement();

            
            ResultSet rs = stm.executeQuery(query);

            
            while (rs.next()){  
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                String color = rs.getString("color");
                
                Product p = new Product();
                p.setId(id);
                p.setName(name);
                p.setPrice(price);
                p.setColor(color);
                
                pr.add(p);
            }
            
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	
		return pr;
	}
    public Product read(Integer id) {
    	Product p = new Product();
    	String query = "SELECT * FROM product WHERE id = ?";

    	Connection conn = this.connect();

        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(query);

            pstm.setInt(1, id);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()){
                int Id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                String color = rs.getString("color");
                
               
                p.setId(Id);
                p.setName(name);
                p.setPrice(price);
                p.setColor(color);

                
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	
		return p;
	}
    public  boolean update(Product item) {
    	
    	String query = "UPDATE product SET name = ?, price = ?, color = ? WHERE id = ?";
    	Connection conn = this.connect();


        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(query);

            pstm.setString(1, item.getName());
            pstm.setInt(2, item.getPrice());
            pstm.setString(3, item.getColor());
            pstm.setInt(4, item.getId());


            int row = pstm.executeUpdate();
            if(row != 0){
                System.out.println("Cập nhật thành công " + row);
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return false;
	}
    public  boolean delete(Integer id) {
    	String query = "DELETE FROM product WHERE id = ?";
    	Connection conn = this.connect();


        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(query);

            pstm.setInt(1, id);

            int row = pstm.executeUpdate();
            if(row != 0){
                System.out.println("Xóa thành công " + row);
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return false;
	}
}

