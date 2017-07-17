package dg.hexagonal.services.database;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import dg.hexagonal.domain.Event;
import dg.hexagonal.domain.EventPlace;
import dg.hexagonal.domain.EventType;
import dg.hexagonal.domain.ports.required.EventRepository;

@Repository
public class HibernateEventRepo implements EventRepository {

	private SessionFactory sessionFactory;
	
	public Event addEvent(Event event) {
		sessionFactory.getCurrentSession().saveOrUpdate(event);
		return event;
	}

	public Event updateEvent(Event event) {
		sessionFactory.getCurrentSession().saveOrUpdate(event);
		return event;
	}

	public Event getEventById(Long eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public Event getEventBy(String name, DateTime date, EventType type, EventPlace place) {
		List<Event> result = sessionFactory.getCurrentSession()
				.createCriteria(Event.class)
				.add(Restrictions.eq("name", name))
				.add(Restrictions.eq("date", date.getMillis()))
				.add(Restrictions.eq("type", type))
				.list();
		
		if (result.size() > 0) {
			for (Event ev : result) {
				if (ev.getPlace().equals(place)) {
					return ev;
				}
			}
		} 
		return null;
	}

	public Event deleteEvent(Long eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public EventPlace getEventPlaceBy(EventPlace place) {
		List<EventPlace> result = sessionFactory.getCurrentSession()
				.createCriteria(EventPlace.class)
				.add(Restrictions.eq("coordX", place.getCoordX()))
				.add(Restrictions.eq("coordY", place.getCoordY()))
				.add(Restrictions.eq("name", place.getName()))
				.list();
		
		if (result.size() > 0) {
			return result.get(0);
		} 
		return null;
	}

	
}
