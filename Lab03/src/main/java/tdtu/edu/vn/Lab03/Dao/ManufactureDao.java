package tdtu.edu.vn.Lab03.Dao;

import java.awt.dnd.InvalidDnDOperationException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tdtu.edu.vn.Lab03.Pojo.Manufacture;
import tdtu.edu.vn.Lab03.Program.Program;
import tdtu.edu.vn.Lab03.repository.Repository;

public class ManufactureDao implements Repository<Manufacture, Integer> {
	private static SessionFactory factory;

	@Override
	public Integer add(Manufacture item) {
		// TODO Auto-generated method stub
		return null;
	}

	public ManufactureDao() {
		factory = Program.getFactory();
	}

	@Override
	public Manufacture get(Integer id) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Manufacture manufacture = null;
		try {
			manufacture = session.get(Manufacture.class, Integer.toString(id));
		} catch (Exception e) {
			// TODO: handle exception

		} finally {
			session.close();
		}
		return manufacture;
	}

	@Override
	public List<Manufacture> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean remove(Manufacture item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Manufacture item) {
		// TODO Auto-generated method stub
		return false;
	}

	public void getSumEmployee() {
		Session session = factory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Integer> query = builder.createQuery(Integer.class);
		Root<Manufacture> root = query.from(Manufacture.class);
		Expression<Integer> p1 = builder.sum(root.get("employee"));
		query.select(p1);
		Integer sum = session.createQuery(query).getSingleResult();
		System.out.print(sum);
	}
	
	public void getMan () {
		try(Session session = factory.openSession()){
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Manufacture> query = builder.createQuery(Manufacture.class);
			Root<Manufacture>  root = query.from(Manufacture.class);
			Predicate p1 = builder.equal(root.get("location" ),"Us");
			query.select(root).where(p1);
			List<Manufacture> manufactures = session.createQuery(query).getResultList();
			if (manufactures.size() != 0) {
				 System.out.print(manufactures.get(manufactures.size()-1)); 
			}
			else {
				System.out.print("Null");
			}
		}
//		throw new InvalidDnDOperationException();
	}

}
