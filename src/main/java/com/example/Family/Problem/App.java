package com.example.Family.Problem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.example.family.exceptions.MemberNotFoundException;

/**
 * Hello world!
 *
 */
public class App 


{
	static FamilyRepo familyRepo = new FamilyRepo();
	static CreateService createService =  new CreateService(familyRepo);
	static SetupFamily setupFamily = new SetupFamily(familyRepo, createService);
	
	static SearchService searchService = new SearchService(familyRepo);

    public static void main( String[] args ) throws IOException
    {
        setupFamily.setupFunction();
    	FileReader freader = new FileReader(args[0]);
        BufferedReader br = new BufferedReader(freader);
        // /Users/apple/eclipse-workspace/Family.Problem/src/main/resources/input.txt
        // /home/bharat/Downloads/FamilyTree-master/src/main/resources/input.txt

        String str;
        while((str = br.readLine()) != null) {
        	String[] input = str.split(" ");
        	if("ADD_CHILD".equalsIgnoreCase(input[0])) {
        		addChild(input[2], input[3], input[1]);
        	}
        	else {
        		getRelationship(input[1], input[2]);
        	}
        	System.out.println();
        }
        freader.close();
    }

    private static void getRelationship(String name, String relation) {
    	List<Member> res = new LinkedList<Member>();
    	try {
    		res = searchService.getRelationship(name, relation);
    	}
    	catch(MemberNotFoundException me) {
    		System.out.print("PERSON_NOT_FOUND");
    		return;
    	}
    	if(res.isEmpty()) {
    		System.out.print("NONE");
    		return;
    	}
    	else {
    		for(Member i: res) {
    			System.out.print(i.getName() + " ");
    		}
    		return;
    	}
    	
    }
    
    private static void addChild(String name,String gender, String motherName) {
    	boolean res = false;
    	try {
    		res = createService.addToFamily(name, gender,motherName);
    	}
    	catch(MemberNotFoundException me) {
    		System.out.print("PERSON_NOT_FOUND");
    		return;
    	}
    	
    	if(res) {
    		System.out.print("CHILD_ADDITION_SUCCEEDED");
    	}
    	else {
    		System.out.print("CHILD_ADDITION_FAILED");
    	}
    	
    }
}
