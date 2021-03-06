package com.yuanluesoft.chd.evaluation.data.actions.indicatordata;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuanluesoft.chd.evaluation.data.forms.IndicatorData;
import com.yuanluesoft.chd.evaluation.data.service.EvaluationDataService;
import com.yuanluesoft.jeaf.database.Record;
import com.yuanluesoft.jeaf.exception.PrivilegeException;
import com.yuanluesoft.jeaf.form.ActionForm;
import com.yuanluesoft.jeaf.form.actions.FormAction;
import com.yuanluesoft.jeaf.security.service.RecordControlService;
import com.yuanluesoft.jeaf.sessionmanage.model.SessionInfo;
import com.yuanluesoft.jeaf.system.exception.SystemUnregistException;
import com.yuanluesoft.jeaf.util.DateTimeUtils;

/**
 * 
 * @author linchuan
 *
 */
public class IndicatordataAction extends FormAction {

	public IndicatordataAction() {
		super();
		externalAction = true;
	}

	/* (non-Javadoc)
	 * @see com.yuanluesoft.jeaf.form.actions.FormAction#checkLoadPrivilege(com.yuanluesoft.jeaf.form.ActionForm, javax.servlet.http.HttpServletRequest, com.yuanluesoft.jeaf.database.Record, java.lang.String, java.util.List, com.yuanluesoft.jeaf.sessionmanage.model.SessionInfo)
	 */
	public char checkLoadPrivilege(ActionForm form, HttpServletRequest request, Record record, String openMode, List acl, SessionInfo sessionInfo) throws PrivilegeException, SystemUnregistException {
		return RecordControlService.ACCESS_LEVEL_EDITABLE;
	}

	/* (non-Javadoc)
	 * @see com.yuanluesoft.jeaf.form.actions.FormAction#initForm(com.yuanluesoft.jeaf.form.ActionForm, com.yuanluesoft.jeaf.sessionmanage.model.SessionInfo, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void initForm(ActionForm form, List acl, SessionInfo sessionInfo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		super.initForm(form, acl, sessionInfo, request, response);
		IndicatorData dataForm = (IndicatorData)form;
		if(dataForm.getDataYear()==0) {
			dataForm.setDataYear(DateTimeUtils.getYear(DateTimeUtils.date()));
		}
		if(dataForm.getDataMonth()==0) {
			dataForm.setDataMonth(DateTimeUtils.getMonth(DateTimeUtils.date()) + 1);
		}
		EvaluationDataService evaluationDataService = (EvaluationDataService)getService("chdEvaluationDataService");
		dataForm.setIndicatorDataList(evaluationDataService.loadIndicatorDataList(dataForm.getDirectoryId(), dataForm.getDataYear(), dataForm.getDataMonth(), true, sessionInfo));
	}

	/* (non-Javadoc)
	 * @see com.yuanluesoft.jeaf.form.actions.FormAction#saveRecord(com.yuanluesoft.jeaf.form.ActionForm, javax.servlet.http.HttpServletRequest, com.yuanluesoft.jeaf.database.Record, com.yuanluesoft.jeaf.sessionmanage.model.SessionInfo, java.lang.String)
	 */
	public Record saveRecord(ActionForm form, Record record, String openMode, HttpServletRequest request, HttpServletResponse response, SessionInfo sessionInfo) throws Exception {
		EvaluationDataService evaluationDataService = (EvaluationDataService)getService("chdEvaluationDataService");
		IndicatorData dataForm = (IndicatorData)form;
		evaluationDataService.saveIndicatorDataList(dataForm.getDirectoryId(), dataForm.getDataYear(), dataForm.getDataMonth(), request, sessionInfo);
		return null;
	}
}