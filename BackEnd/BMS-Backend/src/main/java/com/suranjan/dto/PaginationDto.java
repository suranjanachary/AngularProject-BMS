package com.suranjan.dto;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

public class PaginationDto {

	private int pageNumber ;
	
	private int pageSize ;
	
	private String name ;
	
	private String sortBy ;
	
	private boolean direction ;
	
	public PaginationDto() {
		// TODO Auto-generated constructor stub
	}

	public PaginationDto(int pageNumber, int pageSize, String name, String sortBy, boolean direction) {
		super();
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.name = name;
		this.sortBy = sortBy;
		this.direction = direction;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public boolean isDirection() {
		return direction;
	}

	public void setDirection(boolean direction) {
		this.direction = direction;
	}


	

}
