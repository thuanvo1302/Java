package tdtu.edu.vn.Lab03.Program;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import tdtu.edu.vn.Lab03.Dao.ManufactureDao;
import tdtu.edu.vn.Lab03.Dao.PhoneDAO;
import tdtu.edu.vn.Lab03.Pojo.Manufacture;
import tdtu.edu.vn.Lab03.Pojo.Phone;

public class Program {
	private static SessionFactory FACTORY = null;

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		FACTORY = new Configuration().configure().addAnnotatedClass(Phone.class).addAnnotatedClass(Manufacture.class)
				.buildSessionFactory();

		PhoneDAO phoneDAO = new PhoneDAO();
		ManufactureDao manufactureDao = new ManufactureDao();
		
		// getAll()
//		phoneDAO.getAll().forEach(c -> System.out.println(c.toString()));
		
		// getById
//		System.out.print(phoneDAO.get(1).toString());
		
//		Add Product	
//		Phone p = new Phone();
//		p.setId("6");
//		p.setColor("Yellow");
//		p.setName("Macbook M1");
//		p.setCountry("UK");
//		p.setPrice(200000);
//		p.setQuantity(30);
//		Manufacture m = getFactory().openSession().get(Manufacture.class, "1");
//		p.setManufacture(m);
//		phoneDAO.add(p);

//		phoneDAO.remove(1);

//		update
//		Manufacture manufacture = manufactureDao.get(1);
//		phoneDAO.update(new Phone("3", "Iphone13", 10000, "yellow", null, 0, manufacture));
		
//		System.out.print(phoneDAO.phoneByPriceHighest().toString());
		
//		phoneDAO.sortPhoneByName();
		
		manufactureDao.getSumEmployee();
		
		manufactureDao.getMan();
		
	}

	public static SessionFactory getFactory() {
		return FACTORY;
	}

}
