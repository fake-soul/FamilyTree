package com.example.Family.Problem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class FamilyRepoTest {

	
	
	FamilyRepo familyRepo = new FamilyRepo();
	
	@Test
	public void testFamilyRepo() {
		
		String name = "testuser";
		String gender = "Male";
		Member testMember = new Member(name, gender, null);
		
		assertNull(familyRepo.get(name));

		familyRepo.addMember(testMember);
		Member result = familyRepo.get(name);
		assertNotNull(result);
		assertEquals(name, result.getName());
		assertEquals(gender, result.getGender());
		assertEquals(null, result.getFather());
		assertEquals(null, result.getMother());
		assertEquals(null, result.getspouse());
		assertEquals(0, result.getChildren().size());

		
	}
	
}
