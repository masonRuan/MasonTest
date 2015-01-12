package Test.Orders.model;

import Test.Hibernate.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;



public class OrdersDAO implements OrdersDAO_interface {

	private static final String GET_ALL_STMT = "from OrdersVO order by ORD_ID";

	@SuppressWarnings("unchecked")
	@Override
	public List<OrdersVO> read_Orders() {
		List<OrdersVO> listOrdVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_ALL_STMT);
			listOrdVO = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return listOrdVO;
	} 

	@Override
	public void delete_Orders(OrdersVO ordersVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();

//        【此時多方(宜)可採用HQL刪除】
			Query query = session.createQuery("delete OrdersVO where ORD_ID=?");
			query.setParameter(0, ordersVO.getOrd_ID());
			System.out.println("刪除的筆數=" + query.executeUpdate());

//        【或此時多方(也)可採用去除關聯關係後，再刪除的方式】
//			EmpVO empVO = new EmpVO();
//			empVO.setEmpno(empno);
//			session.delete(empVO);

//        【此時多方不可(不宜)採用cascade聯級刪除】
//        【多方emp2.hbm.xml如果設為 cascade="all"或 cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除】
//			EmpVO empVO = (EmpVO) session.get(EmpVO.class, empno);
//			session.delete(empVO);

			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void create_Orders(OrdersVO ordersVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(ordersVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
}
