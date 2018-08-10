package com.processing.processing_engine.transaction;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.processing.processing_engine.transaction.Transaction;

@Repository
@Service
@Transactional(readOnly = true)
public class TransactionImpl implements TransactionRepository{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Transaction> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Transaction> cq = cb.createQuery(Transaction.class);
		Root<Transaction> root = cq.from(Transaction.class);
		cq.select(root);
		Query<Transaction> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Transactional
	@Override
	public int save(Transaction transaction) {
		sessionFactory.getCurrentSession().save(transaction);
		return transaction.getID();
	}

}
