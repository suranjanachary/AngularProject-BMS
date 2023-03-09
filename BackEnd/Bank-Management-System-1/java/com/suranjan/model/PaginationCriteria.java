package com.suranjan.model;

import java.io.Serializable;

public class PaginationCriteria implements Serializable {

	    private int page;

	    private int limit;

	    private String sortType;

	    private String sortField;

	    private String searchItem;
	    
	    
	    public PaginationCriteria() {
			// TODO Auto-generated constructor stub
		}


		public PaginationCriteria(int page, int limit, String sortType, String sortField, String searchItem) {
			super();
			this.page = page;
			this.limit = limit;
			this.sortType = sortType;
			this.sortField = sortField;
			this.searchItem = searchItem;
		}


		public int getPage() {
			return page;
		}


		public void setPage(int page) {
			this.page = page;
		}


		public int getLimit() {
			return limit;
		}


		public void setLimit(int limit) {
			this.limit = limit;
		}


		public String getSortType() {
			return sortType;
		}


		public void setSortType(String sortType) {
			this.sortType = sortType;
		}


		public String getSortField() {
			return sortField;
		}


		public void setSortField(String sortField) {
			this.sortField = sortField;
		}


		public String getSearchItem() {
			return searchItem;
		}


		public void setSearchItem(String searchItem) {
			this.searchItem = searchItem;
		}


		@Override
		public String toString() {
			return "PaginationCriteria [page=" + page + ", limit=" + limit + ", sortType=" + sortType + ", sortField="
					+ sortField + ", searchItem=" + searchItem + "]";
		}
	    
	    
}
