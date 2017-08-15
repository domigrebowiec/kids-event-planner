package dg.hexagonal.services.database;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import dg.hexagonal.domain.Family;
import dg.hexagonal.domain.FamilyMember;
import dg.hexagonal.domain.ports.required.FamilyRepository;

@Repository
public class HibernateFamilyRepo implements FamilyRepository {

	private SessionFactory sessionFactory;
	
	@Override
	public Family addFamily(Family family) {
		sessionFactory.getCurrentSession().saveOrUpdate(family);
		sessionFactory.getCurrentSession().saveOrUpdate(family.getMother());
		sessionFactory.getCurrentSession().saveOrUpdate(family.getFather());
		for (FamilyMember fm : family.getKids()) {
			sessionFactory.getCurrentSession().saveOrUpdate(fm);
		}
		return family;
	}

	@Override
	public void updateFamily(Family family) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Family getFamilyById(Long familyId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
