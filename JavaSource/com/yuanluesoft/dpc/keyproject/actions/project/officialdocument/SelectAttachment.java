package com.yuanluesoft.dpc.keyproject.actions.project.officialdocument;

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
public class SelectAttachment extends OfficialDocumentAction {
    
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return executeComponentAttachmentAction(mapping, form, "officialDocument", request, response);
    }
}