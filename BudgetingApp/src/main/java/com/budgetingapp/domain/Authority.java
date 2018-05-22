package com.budgetingapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.springframework.security.core.GrantedAuthority;

@Entity
public class Authority implements GrantedAuthority
{

	private Long id;
	private String authority;
	private static final long serialVersionUID = 6105958109360884024L;
	private User user;

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

	public String getAuthority()
	{
		return authority;
	}

	public void setAuthority(String authority)
	{
		this.authority = authority;
	}

	@ManyToOne
	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

}
