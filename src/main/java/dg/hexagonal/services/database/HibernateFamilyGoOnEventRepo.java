package dg.hexagonal.services.database;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import dg.hexagonal.domain.ports.required.FamilyGoOnEventRepository;
import dg.hexagonal.services.database.object.EventParticipantDO;

@Repository
public class HibernateFamilyGoOnEventRepo implements FamilyGoOnEventRepository {

	private SessionFactory sessionFactory;

	@Override
	public void familyGoOnEvent(Long eventId, Long familyId) {
		EventParticipantDO eventParticipant = new EventParticipantDO();
		eventParticipant.setEventId(eventId);
		eventParticipant.setFamilyId(familyId);

		sessionFactory.getCurrentSession().saveOrUpdate(eventParticipant);
	}

	@Override
	public void familyIsInterestedInEvent(Long eventId, Long familyId) {
		EventParticipantDO eventParticipant = new EventParticipantDO();
		eventParticipant.setEventId(eventId);
		eventParticipant.setFamilyId(familyId);
		eventParticipant.setOnlyInterested(true);

		sessionFactory.getCurrentSession().saveOrUpdate(eventParticipant);
	}

	@Override
	public void familyResignFromEvent(Long eventId, Long familyId) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Long> getFamiliesGoOnEvent(Long eventId) {
		List<EventParticipantDO> list = sessionFactory.getCurrentSession().createCriteria(EventParticipantDO.class)
				.add(Restrictions.eq("eventId", eventId))
				.add(Restrictions.eq("onlyInterested", false))
				.list();
		
		List<Long> familiesId = new ArrayList<Long>();
		for (EventParticipantDO eventParticipant : list) {
			familiesId.add(eventParticipant.getFamilyId());
		}
		
		return familiesId;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Long> getFamiliesInterestedInEvent(Long eventId) {
		List<EventParticipantDO> list = sessionFactory.getCurrentSession().createCriteria(EventParticipantDO.class)
				.add(Restrictions.eq("eventId", eventId))
				.add(Restrictions.eq("onlyInterested", true))
				.list();
		
		List<Long> familiesId = new ArrayList<Long>();
		for (EventParticipantDO eventParticipant : list) {
			familiesId.add(eventParticipant.getFamilyId());
		}
		
		return familiesId;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
