package dg.hexagonal.domain.ports.required;

import dg.hexagonal.domain.Family;

public interface FamilyRepository {

	public Family addFamily(Family family);

	public void updateFamily(Family family);

	public Family getFamilyById(Long familyId);

}
