package com.yuanluesoft.jeaf.timetable.actions.timetable.commutetime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * 
 * @author linchuan
 *
 */
public class Save extends CommuteTimeAction {
    
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return executeSaveComponentAction(mapping, form, "commuteTime", "commuteTimes", "timetableId", "refreshTimetable", false, request, response);
    }
}