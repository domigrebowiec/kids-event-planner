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
		eventParticipant.setFamilyIdGo(familyId);

		sessionFactory.getCurrentSession().saveOrUpdate(eventParticipant);
	}

	@Override
	public void familyIsInterestedInEvent(Long eventId, Long familyId) {
		EventParticipantDO eventParticipant = new EventParticipantDO();
		eventParticipant.setEventId(eventId);
		eventParticipant.setFamilyIdInterested(familyId);

		sessionFactory.getCurrentSession().saveOrUpdate(eventParticipant);
	}

	@Override
	public void familyResignFromEvent(Long eventId, Long familyId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Long> getFamiliesGoOnEvent(Long eventId) {
		List<EventParticipantDO> list = sessionFactory.getCurrentSession().createCriteria(EventParticipantDO.class)
				.add(Restrictions.eq("eventId", eventId))
				.add(Restrictions.isNotNull("familyIdGo"))
				.list();
		
		List<Long> familiesId = new ArrayList<Long>();
		for (EventParticipantDO eventParticipant : list) {
			familiesId.add(eventParticipant.getFamilyIdGo());
		}
		
		return familiesId;
	}

	@Override
	public List<Long> getFamiliesInterestedInEvent(Long eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
