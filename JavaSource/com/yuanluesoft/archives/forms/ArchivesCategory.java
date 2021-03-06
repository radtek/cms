package com.yuanluesoft.archives.forms;

import com.yuanluesoft.jeaf.form.ActionForm;


/**
 * 
 * @author linchuan
 * 
 */
public class ArchivesCategory extends ActionForm {
	private String categoryCode; //分类号
	private String category; //分类
	private long parentCategoryId; //父类ID
	
	/**
	 * @return Returns the category.
	 */
	public java.lang.String getCategory() {
		return category;
	}
	/**
	 * @param category The category to set.
	 */
	public void setCategory(java.lang.String category) {
		this.category = category;
	}
	/**
	 * @return Returns the categoryCode.
	 */
	public java.lang.String getCategoryCode() {
		return categoryCode;
	}
	/**
	 * @param categoryCode The categoryCode to set.
	 */
	public void setCategoryCode(java.lang.String categoryCode) {
		this.categoryCode = categoryCode;
	}
	/**
	 * @return Returns the parentCategoryId.
	 */
	public long getParentCategoryId() {
		return parentCategoryId;
	}
	/**
	 * @param parentCategoryId The parentCategoryId to set.
	 */
	public void setParentCategoryId(long parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}
}