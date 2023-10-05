   package tdtu.edu.vn.Lab03.Dao;

import java.util.Comparator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.validator.constraints.CreditCardNumber;

import tdtu.edu.vn.Lab03.Pojo.Phone;
import tdtu.edu.vn.Lab03.Program.Program;
import tdtu.edu.vn.Lab03.repository.Repository;

public class PhoneDAO implements Repository<Phone, Integer> {

	private static SessionFactory factory;

	public PhoneDAO() {
		factory = Program.getFactory();
	}

	@Override
	public Integer add(Phone item) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction transaction;
		int res = 0;
		try {
			transaction = session.beginTransaction();
			session.save(item);
			transaction.commit();
			res = 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
		return res;
	}

	@Override
	public Phone get(Integer id) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Query query = session.createQuery("From Phone where id = :id_phone");
		query.setParameter("id_phone", String.valueOf(id));
		Phone rPhones = (Phone) query.getSingleResult();
		session.close();
		return rPhones;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Phone> getAll() {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		List<Phone> rPhones = null;
		try {
			Query query = session.createQuery("From Phone");
			rPhones = query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
		return rPhones;
	}

	@Override
	public boolean remove(Integer id) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		boolean flag = false;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			Phone phone = session.get(Phone.class, String.valueOf(id));
			session.delete(phone);
			transaction.commit();
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return flag;
	}

	public boolean remove(Phone item) {
		// TODO Auto-generated method stub
		return remove(Integer.parseInt(item.getId()));
	}

	@Override
	public boolean update(Phone item) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		boolean flag = false;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			Phone phone = session.get(Phone.class, item.getId());
			phone.setColor(item.getColor());
			phone.setName(item.getName());
			phone.setPrice(item.getPrice());
			phone.setQuantity(item.getQuantity());
			phone.setCountry(item.getCountry());
			phone.setManufacture(item.getManufacture());
			session.save(phone);
			transaction.commit();
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return flag;
	}

	public Phone phoneByPriceHighest() {
		Phone phone = null;
		try (Session session = factory.openSession()) {
			String hql = "FROM Phone WHERE price = (SELECT MAX(price) FROM Phone)";
			Query query = session.createQuery(hql);
			phone = (Phone) query.getSingleResult();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return phone;
	}

	@SuppressWarnings("unchecked")
	public void sortPhoneByName() {
		try (Session session = factory.openSession()) {
			List<Phone> phones = session.createQuery("from Phone").getResultList();
			phones.sort(Comparator.comparing(Phone::getCountry).thenComparing(Phone::getPrice));
			phones.forEach(System.out::println);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
