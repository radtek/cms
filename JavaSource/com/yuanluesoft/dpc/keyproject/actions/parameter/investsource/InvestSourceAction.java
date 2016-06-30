package com.yuanluesoft.dpc.keyproject.actions.parameter.investsource;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.PropertyUtils;

import com.yuanluesoft.dpc.keyproject.actions.parameter.ParameterAction;
import com.yuanluesoft.dpc.keyproject.service.KeyProjectService;
import com.yuanluesoft.jeaf.database.Record;
import com.yuanluesoft.jeaf.form.ActionForm;
import com.yuanluesoft.jeaf.sessionmanage.model.SessionInfo;
import com.yuanluesoft.jeaf.util.ListUtils;

/**
 * 
 * @author linchuan
 *
 */
public class InvestSourceAction extends ParameterAction {
	/* (non-Javadoc)
	 * @see com.yuanluesoft.jeaf.form.actions.FormAction#loadComponent(com.yuanluesoft.jeaf.form.ActionForm, java.lang.Object, java.lang.String, java.lang.String, com.yuanluesoft.jeaf.sessionmanage.model.SessionInfo, javax.servlet.http.HttpServletRequest)
	 */
	public Record loadComponentRecord(ActionForm form, Record mainRecord, String componentName, SessionInfo sessionInfo, HttpServletRequest request) throws Exception {
		KeyProjectService keyProjectService = (KeyProjectService)getService("keyProjectService");
		return (Record)ListUtils.findObjectByProperty(keyProjectService.listKeyProjectInvestSources(), "id", PropertyUtils.getProperty(form, componentName + ".id"));
	}
}