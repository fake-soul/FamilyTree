package com.example.Family.Problem;

import com.example.family.exceptions.MemberNotFoundException;

public class CreateService {
	private FamilyRepo familyRepo;

	public CreateService(FamilyRepo familyRepo) {
		this.familyRepo = familyRepo;
	}

	public boolean addToFamily(String name, String gender, String motherName) {
		Member mother = familyRepo.get(motherName);
		if (mother == null) {
			throw new MemberNotFoundException();
			
		}
		if ("Male".equalsIgnoreCase(mother.getGender())) {
			return false;
		}
		Member member = new Member(name, gender, mother);
		mother.addChild(member);
		mother.getspouse().addChild(member);

		familyRepo.addMember(member);
		return true;
	}

}
