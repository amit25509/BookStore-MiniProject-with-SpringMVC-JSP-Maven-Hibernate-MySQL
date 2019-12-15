package com.bookstore.daoimpl;

import java.math.BigInteger;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bookstore.dao.BookDAO;
import com.bookstore.entity.Book;

@Repository
@Transactional
public class BookDAOImpl implements BookDAO {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Override
	public List<Book> getAllBook() {
		// TODO Auto-generated method stub
		System.out.println("BookDAOImpl>getAllBook()");
		return hibernateTemplate.loadAll(Book.class);
	}
	
	@Override
	public List<Book> getAllBook(int start, int total) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria=DetachedCriteria.forClass(Book.class);
		return (List<Book>) hibernateTemplate.findByCriteria(criteria, start, total);
	}

	@Override
	public void deleteBook(Integer bid) {
		// TODO Auto-generated method stub
		System.out.println("BookDAOImpl>deleteBook()");
		Book book= hibernateTemplate.get(Book.class, bid);
		hibernateTemplate.delete(book);
	}

	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(book);
	}

	@Override
	public Book getBookById(Integer bid) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Book.class, bid);
	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(book);
	}

	@Override
	public int totalAvailableBooks() {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory=hibernateTemplate.getSessionFactory();
		Session session=sessionFactory.openSession();
		String sql="select count(*) from books";
		BigInteger bigInteger= (BigInteger)session.createNativeQuery(sql).uniqueResult();
		return bigInteger.intValue();
	}
}
