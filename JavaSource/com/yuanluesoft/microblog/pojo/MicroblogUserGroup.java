package com.yuanluesoft.microblog.pojo;

import com.yuanluesoft.jeaf.database.Record;

/**
 * 微博:用户分组(microblog_user_group)
 * @author linchuan
 *
 */
public class MicroblogUserGroup extends Record {
	private long unitId; //单位ID
	private String name; //分组名称
	private String platformGroupIds; //平台ID,分组在各个微博平台上的ID
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the platformGroupIds
	 */
	public String getPlatformGroupIds() {
		return platformGroupIds;
	}
	/**
	 * @param platformGroupIds the platformGroupIds to set
	 */
	public void setPlatformGroupIds(String platformGroupIds) {
		this.platformGroupIds = platformGroupIds;
	}
	/**
	 * @return the unitId
	 */
	public long getUnitId() {
		return unitId;
	}
	/**
	 * @param unitId the unitId to set
	 */
	public void setUnitId(long unitId) {
		this.unitId = unitId;
	}
}