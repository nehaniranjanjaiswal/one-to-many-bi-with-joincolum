package com.jsp.map.cascode.joincolumn;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.bank.branches.Bank;
import com.jsp.bank.branches.Branches;

public class Driver {
public static void main(String[] args) {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("neha");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	Bank bank=new Bank();
	bank.setName("SBI");                                                           //@joincolum is only use for bi direction
	
	Branches branches1=new Branches();
	branches1.setLoc("SBI-VASHI");
	branches1.setIfsc_code("SBI123456");
	Branches branches2=new Branches();
	branches2.setLoc("SBI-THANE");
	branches2.setIfsc_code("SBI56789");
	
	Branches branches3=new Branches();
	branches3.setLoc("SBI-PANVEL");
	branches3.setIfsc_code("SBI7890");
	
	
	ArrayList<Branches> branches=new ArrayList<Branches>();
	branches.add(branches1);
	branches.add(branches2);
	branches.add(branches3);	
	
	ArrayList<Branches> branches=new ArrayList<Branches>();
	branches.add(branches1);
	branches.add(branches2);
	branches.add(branches3);
	//for id creating
	bank.setBranches(branches);
	branches1.setBank(bank);
	branches2.setBank(bank);
	branches3.setBank(bank);
	
	et.begin();
	em.persist(branches1);
	em.persist(branches2);
	em.persist(branches3);
	em.persist(bank);
	et.commit();
}

}

