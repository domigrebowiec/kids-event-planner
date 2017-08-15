package dg.hexagonal.adapters.required;

import java.util.HashMap;
import java.util.Map;

import dg.hexagonal.domain.Family;
import dg.hexagonal.domain.ports.required.FamilyRepository;

public class MockFamilyRepository implements FamilyRepository {
	
	private Map<Long, Family> familyMap;
	
	public MockFamilyRepository() {
		familyMap = new HashMap<Long, Family>();
	}
	
	public Family addFamily(Family family) {
		Long id = (long) (familyMap.size() + 1);
		
		family.setFamilyId(id);
		familyMap.put(id, family);
		
		return family;
	}

	public void updateFamily(Family family) {
		familyMap.put(family.getFamilyId(), family);		
	}

	public Family getFamilyById(Long familyId) {
		return familyMap.get(familyId);
	}

}
