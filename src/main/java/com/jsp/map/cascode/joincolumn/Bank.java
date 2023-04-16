package com.jsp.map.cascode.joincolumn;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.jsp.bank.branches.Branches;

@Entity
public class Bank {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	private String name;
	
	@OneToMany (mappedBy="bank",cascade=CascadeType.ALL)

	private List<Branches> branches;
	
	public List<Branches> getBranches() {
		return branches;
	}
	public void setBranches(List<Branches> branches) {
		this.branches = branches;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}