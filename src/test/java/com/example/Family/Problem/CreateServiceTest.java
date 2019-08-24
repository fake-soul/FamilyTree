package com.example.Family.Problem;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.example.family.exceptions.MemberNotFoundException;

public class CreateServiceTest {
	FamilyRepo familyRepo = new FamilyRepo();
	CreateService createService =  new CreateService(familyRepo);
	SetupFamily setupFamily = new SetupFamily(familyRepo, createService);
	
	SearchService searchService = new SearchService(familyRepo);
	
	
	@Before
	public void initialize() {
		setupFamily.setupFunction();
	}

	@Test
	public void addToFamily() {
		String name = "qwerty";
		String gender = "Female";
		String motherName = "Lika";
		String fatherName = "Vich";
		boolean result1 = createService.addToFamily(name, gender, motherName);
		boolean result2 = createService.addToFamily(name, gender, fatherName);
		assertEquals(true, result1);
		assertEquals(false, result2);
	}
	@Test(expected = MemberNotFoundException.class)
	public void getNonExistingMember() {
		String name = "qwerty";
		String gender = "Female";
		String motherName = "Likha12";
		createService.addToFamily(name, gender, motherName);
	}	
}
