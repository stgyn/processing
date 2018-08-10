package gson;

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

import com.processing.processing_engine.transaction.Transaction_POJORepository;
import com.processing.processing_engine.transaction.Transaction_POJO;

@Repository
@Service
@Transactional(readOnly = true)
public class Transaction_POJOImpl implements Transaction_POJORepository{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public int save(Transaction_POJO transaction) {
		sessionFactory.getCurrentSession().save(transaction);
		return transaction.getId();
	}

	@Override
	public List<Transaction_POJO> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Transaction_POJO> cq = cb.createQuery(Transaction_POJO.class);
		Root<Transaction_POJO> root = cq.from(Transaction_POJO.class);
		cq.select(root);
		Query<Transaction_POJO> query = session.createQuery(cq);
		return query.getResultList();
	}
}
