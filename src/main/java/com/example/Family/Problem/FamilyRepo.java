package com.example.Family.Problem;
import java.util.HashMap;

public class FamilyRepo {

	private HashMap<String, Member> map = new HashMap<String, Member>();

	public void addMember(Member member) {
		map.put(member.getName(), member);
	}

	public Member get(String name) {
		return map.get(name);
	}

}
