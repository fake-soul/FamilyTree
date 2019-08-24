package com.example.Family.Problem;

import java.util.LinkedList;
import java.util.List;

import com.example.family.exceptions.MemberNotFoundException;

public class SearchService {

	private FamilyRepo family;

	public SearchService(FamilyRepo familyRepo) {
		this.family = familyRepo;
	}

	public Member getMember(String name) {
		return family.get(name);
	}

	public List<Member> getRelationship (String name, String relation) {
		if (family.get(name) == null) {
			throw new MemberNotFoundException();
		}
		Member currentMember = family.get(name);
		
		if ("Paternal-Uncle".equalsIgnoreCase(relation)) {
			return getPaternalUncle(currentMember);
		}
			

		else if ("Paternal-Aunt".equalsIgnoreCase(relation)) {
			return getPaternalAunt(currentMember);
		}

		else if ("Maternal-Uncle".equalsIgnoreCase(relation)) {
			return getMaternalUncle(currentMember);
		}

		else if ("Maternal-Aunt".equalsIgnoreCase(relation)) {
			return getMaternalAunt(currentMember);
		}

		else if("Sister-In-Law".equalsIgnoreCase(relation)) {
			return getSisterInLaw(currentMember);
		}

		else if("Brother-In-Law".equalsIgnoreCase(relation)) {
			return getBrotherInLaw(currentMember);
		}

		else if("Son".equalsIgnoreCase(relation)) {
			return currentMember.getSons();
		}

		else if ("Daughter".equalsIgnoreCase(relation)) {
			return currentMember.getDaughter();
		}

		else if("Siblings".equalsIgnoreCase(relation)) {
			return currentMember.getSiblings();
		}
		else {
			return new LinkedList<Member>();
		}
	}
	
	public List<Member> getPaternalUncle (Member currentMember) {
		if(currentMember.getFather() != null) {
			return currentMember.getFather().getBrothers();
		}
		return new LinkedList<Member>();
	}

	public List<Member> getPaternalAunt(Member currentMember) {
		if(currentMember.getFather() != null) {
			return currentMember.getFather().getSisters();
		}
		return new LinkedList<Member>();
	}

	public List<Member> getMaternalUncle(Member currentMember) {
		if(currentMember.getMother() != null) {
			return currentMember.getMother().getBrothers();
		}
		return new LinkedList<Member>();
	}

	public List<Member> getMaternalAunt(Member currentMember) {
		if(currentMember.getMother() != null) {
			return currentMember.getMother().getSisters();
		}
		return new LinkedList<Member>();
	}

	public List<Member> getSisterInLaw(Member currentMember) {
		LinkedList<Member> SisterInLaw = currentMember.getSpouseSisters();
		SisterInLaw.addAll(currentMember.getBrothersSpouses());
		return SisterInLaw;
	}

	public List<Member> getBrotherInLaw(Member currentMember) {
		LinkedList<Member> BrotherInLaw = currentMember.getSpouseBrothers();
		BrotherInLaw.addAll(currentMember.getSisterSpouses());
		return BrotherInLaw;
	}

}
