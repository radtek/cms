package com.yuanluesoft.bidding.enterprise.pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.html.HTMLDocument;

import com.yuanluesoft.bidding.enterprise.pojo.BiddingEnterprise;
import com.yuanluesoft.cms.pagebuilder.PageService;
import com.yuanluesoft.cms.pagebuilder.exception.PageNotFoundException;
import com.yuanluesoft.cms.pagebuilder.model.page.SitePage;
import com.yuanluesoft.jeaf.database.DatabaseService;
import com.yuanluesoft.jeaf.exception.ServiceException;
import com.yuanluesoft.jeaf.sessionmanage.model.SessionInfo;
import com.yuanluesoft.jeaf.util.ListUtils;
import com.yuanluesoft.jeaf.util.RequestUtils;

/**
 * 
 * @author linchuan
 *
 */
public class BiddingEnterprisePageService extends PageService {
	private DatabaseService databaseService;

	/* (non-Javadoc)
	 * @see com.yuanluesoft.cms.pagebuilder.spring.BasePageService#resetTemplate(org.w3c.dom.html.HTMLDocument, java.lang.String, java.lang.String, com.yuanluesoft.cms.sitemanage.model.SitePage, long, javax.servlet.http.HttpServletRequest, boolean)
	 */
	protected void resetTemplate(HTMLDocument template, String applicationName, String pageName, SitePage sitePage, long siteId, HttpServletRequest request, HttpServletResponse response, boolean editMode) throws ServiceException {
		super.resetTemplate(template, applicationName, pageName, sitePage, siteId, request, response, editMode);
		BiddingEnterprise enterprise = (BiddingEnterprise)sitePage.getAttribute("record");
		//设置标题
		String title = template.getTitle();
		template.setTitle((title==null || title.equals("") ? "企业信息" : title) + " - " + enterprise.getName());
	}

	/* (non-Javadoc)
	 * @see com.yuanluesoft.cms.pagebuilder.spring.BasePageService#setPageAttributes(java.lang.String, java.lang.String, com.yuanluesoft.cms.sitemanage.model.SitePage, long, javax.servlet.http.HttpServletRequest, boolean)
	 */
	protected void setPageAttributes(String applicationName, String pageName, SitePage sitePage, long siteId, HttpServletRequest request, boolean editMode) throws ServiceException {
		long id = RequestUtils.getParameterLongValue(request, "id");
		if(id==0) {
			SessionInfo sessionInfo = RequestUtils.getSessionInfo(request);
			id = sessionInfo.getDepartmentId();
		}
		//获取企业记录
		BiddingEnterprise enterprise = (BiddingEnterprise)databaseService.findRecordById(BiddingEnterprise.class.getName(), id, ListUtils.generateList("certs,jobholders", ","));
		if(enterprise==null) {
			throw new PageNotFoundException();
		}
		//设置record属性
		sitePage.setAttribute("record", enterprise);
		super.setPageAttributes(applicationName, pageName, sitePage, siteId, request, editMode);
	}

	/**
	 * @return the databaseService
	 */
	public DatabaseService getDatabaseService() {
		return databaseService;
	}

	/**
	 * @param databaseService the databaseService to set
	 */
	public void setDatabaseService(DatabaseService databaseService) {
		this.databaseService = databaseService;
	}
}