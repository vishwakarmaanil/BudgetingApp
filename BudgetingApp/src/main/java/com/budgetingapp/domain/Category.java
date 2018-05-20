package com.budgetingapp.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Category
{

	private Long id;
	private BigDecimal budget;
	private String name;
	private Date startDate;
	private Date endDate;

	private Group group;
	private Set<Transaction> transactions = new TreeSet<>();

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

	public BigDecimal getBudget()
	{
		return budget;
	}

	public void setBudget(BigDecimal budget)
	{
		this.budget = budget;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Date getStartDate()
	{
		return startDate;
	}

	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}

	public Date getEndDate()
	{
		return endDate;
	}

	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}

	@ManyToOne
	public Group getGroup()
	{
		return group;
	}

	public void setGroup(Group group)
	{
		this.group = group;
	}

	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY, mappedBy ="category")
	public Set<Transaction> getTransactions()
	{
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions)
	{
		this.transactions = transactions;
	}

}
