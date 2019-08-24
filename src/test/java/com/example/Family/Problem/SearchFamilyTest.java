package com.example.Family.Problem;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.example.family.exceptions.MemberNotFoundException;

public class SearchFamilyTest {
	FamilyRepo familyRepo = new FamilyRepo();
	CreateService createService =  new CreateService(familyRepo);
	SetupFamily setupFamily = new SetupFamily(familyRepo, createService);
	
	SearchService searchService = new SearchService(familyRepo);
	
	
	@Before
	public void initialize() {
		setupFamily.setupFunction();
	}

	@Test
	public void testGetMember() {
		
		Member result = searchService.getMember("King Shan");
		assertNotNull(result);
		assertEquals("King Shan", result.getName());
		assertEquals("Male", result.getGender());
		assertEquals(null, result.getFather());
		assertEquals(null, result.getMother());
		assertEquals("Queen Anga", result.getspouse().getName());
		assertNotEquals(0, result.getChildren().size());
	}

	@Test
	public void getPaternalUncle() {
		String name = "Vila";
		Member currentMember = familyRepo.get(name);
		List<Member> result = searchService.getPaternalUncle(currentMember);
		List<Member> expected = new LinkedList<Member>();
		expected.add(familyRepo.get("Chit"));
		expected.add(familyRepo.get("Ish"));
		expected.add(familyRepo.get("Aras"));
		assertEquals(expected, result);
	}

	@Test
	public void getPaternalAunt() {
		String name = "Vila";
		Member currentMember = familyRepo.get(name);
		List<Member> result = searchService.getPaternalAunt(currentMember);
		List<Member> expected = new LinkedList<Member>();
		expected.add(familyRepo.get("Satya"));
		assertEquals(expected, result);
	}

	@Test
	public void getMaternalUncle() {
		String name = "Laki";
		Member currentMember = familyRepo.get(name);
		List<Member> result = searchService.getMaternalUncle(currentMember);
		List<Member> expected = new LinkedList<Member>();
		expected.add(familyRepo.get("Ahit"));
		assertEquals(expected, result);
	}
	
	@Test
	public void getMaternalAunt() {
		String name = "Yodhan";
		Member currentMember = familyRepo.get(name);
		List<Member> result = searchService.getMaternalAunt(currentMember);
		List<Member> expected = new LinkedList<Member>();
		expected.add(familyRepo.get("Tritha"));
		assertEquals(expected, result);
	}

	@Test
	public void getSisterInLaw() {
		String name = "Jaya";
		Member currentMember = familyRepo.get(name);
		List<Member> result = searchService.getSisterInLaw(currentMember);
		List<Member> expected = new LinkedList<Member>();
		expected.add(familyRepo.get("Tritha"));
		assertEquals(expected, result);
	}

	@Test
	public void getBrotherInLaw() {
		String name = "Jaya";
		Member currentMember = familyRepo.get(name);
		List<Member> result = searchService.getBrotherInLaw(currentMember);
		List<Member> expected = new LinkedList<Member>();
		expected.add(familyRepo.get("Vritha"));
		assertEquals(expected, result);
	}

	@Test
	public void getRelationship() {
		String name1 = "Chit";
		String relation1 = "Son";
		String relation2 = "Daughter";
		String name2 = "Ish";
		String relation3 = "Siblings";

		List<Member> result1 = searchService.getRelationship(name1, relation1);
		List<Member> result2 = searchService.getRelationship(name1, relation2);
		List<Member> result3 = searchService.getRelationship(name2, relation3);

		List<Member> expected1 = new LinkedList<Member>();
		List<Member> expected2 = new LinkedList<Member>();
		List<Member> expected3 = new LinkedList<Member>();

		expected1.add(familyRepo.get("Vritha"));
		expected2.add(familyRepo.get("Dritha"));
		expected2.add(familyRepo.get("Tritha"));
		expected3.add(familyRepo.get("Chit"));
		expected3.add(familyRepo.get("Vich"));
		expected3.add(familyRepo.get("Aras"));
		expected3.add(familyRepo.get("Satya"));

		assertEquals(expected1, result1);
		assertEquals(expected2, result2);
		assertEquals(expected3, result3);
		
	}
	@Test(expected = MemberNotFoundException.class)
	public void getNonExistingMember() {
		String name1 = "Chit2";
		String relation1 = "Son";
		searchService.getRelationship(name1, relation1);
	}		
}
