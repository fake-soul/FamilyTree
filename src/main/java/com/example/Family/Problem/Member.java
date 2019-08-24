package com.example.Family.Problem;
import java.util.LinkedList;

public class Member {
	private String name;
	private String gender;
	private Member mother;
	private Member father;
	private Member spouse;
	private LinkedList<Member> children = new LinkedList<Member>();

	Member(String name, String gender,Member mother, Member spouse) {
		this.name = name;
		this.gender = gender;
		this.mother = mother;
		this.father = mother.getspouse() == null ? null : mother.getspouse();
		this.spouse = spouse;
	}
	
	Member(String name, String gender,Member mother) {
		this.name = name;
		this.gender = gender;
		this.mother = mother;
		this.father = mother== null || mother.getspouse() == null ? null : mother.getspouse();
	}

	public String getName() {
		return this.name;
	}

	public Member getMother() {
		return this.mother;
	}

	public Member getFather() {
		return this.father;
	}

	public String getGender() {
		return this.gender;
	}

	public Member getspouse() {
		return this.spouse;
	}

	public LinkedList<Member> getChildren() {
		return this.children;
	}

	public void setSpouse(Member spouse) {
		this.spouse = spouse;
	}

	public void addChild(Member child) {
		this.children.add(child);
	}

	public LinkedList<Member> getSons() {
		LinkedList<Member> currentMemberChildren = this.getChildren();
		LinkedList<Member> finalCurrentMemberChildren =  new LinkedList<Member>();
		for(Member i: currentMemberChildren) {
			if("Male".equalsIgnoreCase(i.getGender())) {
				finalCurrentMemberChildren.add(i);
			}
		}
		return finalCurrentMemberChildren;
	}

	public LinkedList<Member> getDaughter() {
		LinkedList<Member> currentMemberChildren = this.getChildren();
		LinkedList<Member> finalCurrentMemberChildren =  new LinkedList<Member>();
		for(Member i: currentMemberChildren) {
			if("Female".equalsIgnoreCase(i.getGender())) {
				finalCurrentMemberChildren.add(i);
			}
		}
		return finalCurrentMemberChildren;
	}

	public LinkedList<Member> getSiblings() {
		Member mother = this.getMother();
		if(mother != null) {
			LinkedList<Member> siblings = mother.getChildren();
			siblings.remove(this);
			return siblings;
		}
		return new LinkedList<Member>();
	}

	public LinkedList<Member> getSisters() {
		Member mother = this.getMother();
		if(mother != null) {
			LinkedList<Member> siblings = mother.getChildren();
			LinkedList<Member> finalSiblings = new LinkedList<Member>();
			siblings.remove(this);
			for(Member i : siblings) {
				if("Female".equalsIgnoreCase(i.getGender())) {
					finalSiblings.add(i);
				}
			}
			return finalSiblings;
		}
		return new LinkedList<Member>();
	}

	public LinkedList<Member> getBrothers() {
		Member mother = this.getMother();
		if(mother != null) {
			LinkedList<Member> siblings = mother.getChildren();
			LinkedList<Member> finalSiblings = new LinkedList<Member>();
			siblings.remove(this);
			for(Member i : siblings) {
				if("Male".equalsIgnoreCase(i.getGender())) {
					finalSiblings.add(i);
				}
			}
			return finalSiblings;
		}
		return new LinkedList<Member>();
	}

	public LinkedList<Member> getSpouseSisters() {
		Member spouse = this.getspouse();
		if(spouse != null) {
			return spouse.getSisters();
		}
		return new LinkedList<Member>();
	}

	public LinkedList<Member> getSpouseBrothers() {
		Member spouse = this.getspouse();
		if(spouse != null) {
			return spouse.getBrothers();
		}
		return new LinkedList<Member>();
	}

	public LinkedList<Member> getBrothersSpouses() {
		LinkedList<Member> brothers =  this.getBrothers();
		LinkedList<Member> brothersSpouses = new LinkedList<Member>();
		for(Member i: brothers) {
			Member spouse = i.getspouse();
			if(spouse != null) {
				brothersSpouses.add(spouse);
			}
		}
		return brothersSpouses;
	}

	public LinkedList<Member> getSisterSpouses() {
		LinkedList<Member> sisters =  this.getSisters();
		LinkedList<Member> sistersSpouses = new LinkedList<Member>();
		for(Member i: sisters) {
			Member spouse = i.getspouse();
			if(spouse != null) {
				sistersSpouses.add(spouse);
			}
		}
		return sistersSpouses;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + "]";
	}
	
	
}
