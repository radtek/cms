<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-ext" prefix="ext" %>

<table valign="middle" width="100%" border="1" cellpadding="0" cellspacing="0" class="table">
	<col>
	<col width="100%">
	<tr>
		<td class="tdtitle" valign="top" nowrap="nowrap">内容</td>
		<td class="tdcontent"><ext:field property="preapproval.body"/></td>
	</tr>
	<tr>
		<td class="tdtitle" nowrap="nowrap">公示期限(天)</td>
		<td class="tdcontent"><ext:field property="preapproval.publicLimit"/></td>
	</tr>
</table>