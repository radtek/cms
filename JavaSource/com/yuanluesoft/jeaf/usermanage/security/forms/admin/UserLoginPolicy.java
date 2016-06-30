package com.yuanluesoft.jeaf.usermanage.security.forms.admin;

import com.yuanluesoft.jeaf.form.ActionForm;
import com.yuanluesoft.jeaf.security.model.RecordVisitorList;

/**
 * 用户管理:登录限制(user_login)
 * @author linchuan
 *
 */
public class UserLoginPolicy extends ActionForm {
	private String name; //策略名称
	private String ips; //IP地址列表
	private String mac; //MAC地址
	
	private RecordVisitorList policyUsers = new RecordVisitorList(); //查询权限
	
	/**
	 * @return the ips
	 */
	public String getIps() {
		return ips;
	}
	/**
	 * @param ips the ips to set
	 */
	public void setIps(String ips) {
		this.ips = ips;
	}
	/**
	 * @return the mac
	 */
	public String getMac() {
		return mac;
	}
	/**
	 * @param mac the mac to set
	 */
	public void setMac(String mac) {
		this.mac = mac;
	}
	/**
	 * @return the policyUsers
	 */
	public RecordVisitorList getPolicyUsers() {
		return policyUsers;
	}
	/**
	 * @param policyUsers the policyUsers to set
	 */
	public void setPolicyUsers(RecordVisitorList policyUsers) {
		this.policyUsers = policyUsers;
	}
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
}