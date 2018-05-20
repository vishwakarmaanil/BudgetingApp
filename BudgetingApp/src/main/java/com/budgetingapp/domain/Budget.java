package com.budgetingapp.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Budget
{
	private Long id;
	private String name;
	private Set<User> users = new HashSet<>();
	private Set<Group> group = new TreeSet<>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@ManyToMany
	@JoinTable(inverseJoinColumns = @JoinColumn(name = "user_id"), joinColumns = @JoinColumn(name = "budget_id"))
	public Set<User> getUser()
	{
		return users;
	}

	public void setUser(Set<User> users)
	{
		this.users = users;
	}

	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "budget")
	public Set<Group> getGroup()
	{
		return group;
	}

	public void setGroup(Set<Group> group)
	{
		this.group = group;
	}

}
