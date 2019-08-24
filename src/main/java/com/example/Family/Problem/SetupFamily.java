package com.example.Family.Problem;

public class SetupFamily {
	private FamilyRepo familyRepo;
	private CreateService createService;

	SetupFamily(FamilyRepo familyRepo, CreateService createService) {
		this.familyRepo = familyRepo;
		this.createService = createService;
	}

	public void setupFunction() {
		Member king = new Member("King Shan", "Male", null);
		Member queen = new Member("Queen Anga", "Female", null);

		king.setSpouse(queen);
		queen.setSpouse(king);
		familyRepo.addMember(king);
		familyRepo.addMember(queen);

		// level one

		createService.addToFamily("Chit", "Male", "Queen Anga");
		createService.addToFamily("Ish", "Male", "Queen Anga");
		createService.addToFamily("Vich", "Male", "Queen Anga");
		createService.addToFamily("Aras", "Male", "Queen Anga");
		createService.addToFamily("Satya", "Female", "Queen Anga");

		Member ChitSpouse = new Member("Amba", "Female", null);
		Member VichSpouse = new Member("Lika", "Female", null);
		Member ArasSpouse = new Member("Chitra", "Female", null);
		Member SatyaSpouse = new Member("Vyan", "Male", null);

		ChitSpouse.setSpouse(familyRepo.get("Chit"));
		familyRepo.get("Chit").setSpouse(ChitSpouse);
		VichSpouse.setSpouse(familyRepo.get("Vich"));
		familyRepo.get("Vich").setSpouse(VichSpouse);
		ArasSpouse.setSpouse(familyRepo.get("Aras"));
		familyRepo.get("Aras").setSpouse(ArasSpouse);
		SatyaSpouse.setSpouse(familyRepo.get("Satya"));
		familyRepo.get("Satya").setSpouse(SatyaSpouse);

		familyRepo.addMember(ChitSpouse);
		familyRepo.addMember(VichSpouse);
		familyRepo.addMember(ArasSpouse);
		familyRepo.addMember(SatyaSpouse);

		// level two

		createService.addToFamily("Dritha", "Female", "Amba");
		createService.addToFamily("Tritha", "Female", "Amba");
		createService.addToFamily("Vritha", "Male", "Amba");

		createService.addToFamily("Vila", "Female", "Lika");
		createService.addToFamily("chika", "Female", "Lika");

		createService.addToFamily("Jnki", "Female", "Chitra");
		createService.addToFamily("Ahit", "Male", "Chitra");

		createService.addToFamily("Asva", "Male", "Satya");
		createService.addToFamily("Vyas", "Male", "Satya");
		createService.addToFamily("Atya", "Female", "Satya");
		

		Member DrithaSpouse = new Member("Jaya", "Male", null);
		Member JnkiSpouse = new Member("Arit", "Male", null);
		Member AsvaSpouse = new Member("Satvy", "Female", null);
		Member VyasSpouse = new Member("Krpi", "Female", null);

		
		DrithaSpouse.setSpouse(familyRepo.get("Dritha"));
		familyRepo.get("Dritha").setSpouse(DrithaSpouse);
		JnkiSpouse.setSpouse(familyRepo.get("Jnki"));
		familyRepo.get("Jnki").setSpouse(JnkiSpouse);
		AsvaSpouse.setSpouse(familyRepo.get("Asva"));
		familyRepo.get("Asva").setSpouse(AsvaSpouse);
		VyasSpouse.setSpouse(familyRepo.get("Vyas"));
		familyRepo.get("Vyas").setSpouse(VyasSpouse);

		familyRepo.addMember(DrithaSpouse);
		familyRepo.addMember(JnkiSpouse);
		familyRepo.addMember(AsvaSpouse);
		familyRepo.addMember(VyasSpouse);

		// level three

		
		createService.addToFamily("Yodhan", "Male", "Dritha");
		createService.addToFamily("Laki", "Male", "Jnki");
		createService.addToFamily("Lavnya", "Female", "Jnki");
		createService.addToFamily("Vasa", "Male", "Satvy");
		createService.addToFamily("Kriya", "Male", "Krpi");
		createService.addToFamily("Krithi", "Female", "Krpi");
		
		
		
	}

}
