<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-ext" prefix="ext" %>

<ext:form action="/submit" applicationName="jeaf/usermanage" pageName="member">
	<script language="JavaScript" charset="utf-8" src="<%=request.getContextPath()%>/jeaf/common/js/passwordStrength.js"></script>
	<script>
		function FormUtils.reloadValidateCodeImage() {
			var now = new Date();
			document.getElementById('validateCodeImage').src = document.getElementById('validateCodeImage').src + "?reload=true&seq=" + (now.getSeconds()*1000 + now.getMilliseconds());
		}
		function checkLoginNameInUse() {
			var loginName = document.getElementsByName("loginName")[0].value;
			if(loginName!="") {
				ScriptUtils.appendJsFile(document, "../isLoginNameInUse.shtml?loginName=" + StringUtils.utf8Encode(loginName) + "&seq=" + Math.random(), "scriptCheckLoginNameInUse");
			}
		}
		function loginNameInUse(inUse) {
			var obj = document.getElementById("loginNamePrompt");
			obj.innerHTML = (inUse ? "用户名已经被占用" : "");
			obj.style.display = (inUse ? "" : "none");
		}
		function formOnSubmit() {
			var password = document.getElementsByName("password");
			if(password[0].value!=password[1].value) {
				alert("密码不一致！");
				return false;
			}
			return true;
		}
	</script>
	<table border="0" cellpadding="2" cellspacing="0" style="color:#000000; width:100%" align="center">
		<col align="left">
		<col width="100%">
		<col>
		<tr valign="middle">
			<td>用户名：</td>
			<td><ext:field onblur="checkLoginNameInUse()" property="loginName"/></td>
			<td nowrap>字母开头,允许使用字母、数字和下划线<div id="loginNamePrompt" style="color:#FF0000; display:none"></div></td>
		</tr>
		<tr>
			<td>口令：</td>
			<td><ext:field property="password"/></td>
		</tr>
		<tr>
			<td nowrap="nowrap">口令安全等级：</td>
			<td>
				<span id="passwordStrength"></span>
				<script>writePasswordStrength(document.getElementsByName('password')[0], document.getElementById('passwordStrength'));</script>
			</td>
			<td nowrap></td>
		</tr>
		<tr>
			<td>口令确认：</td>
			<td><ext:field property="password"/></td>
			<td nowrap></td>
		</tr>
		<tr>
			<td nowrap>单位名称：</td>
			<td><ext:field property="company"/></td>
			<td nowrap></td>
		</tr>
		<tr>
			<td>法人代表：</td>
			<td><ext:field property="name"/></td>
			<td nowrap></td>
		</tr>
		<tr>
			<td>证照号：</td>
			<td><ext:field property="identityCard"/></td>
			<td nowrap></td>
		</tr>
		
		<tr>
			<td>手机：</td>
			<td><ext:field property="cell"/></td>
			<td nowrap></td>
		</tr>
		<tr>
			<td>联系电话：</td>
			<td><ext:field property="telephone"/></td>
			<td nowrap></td>
		</tr>
		
		<tr>
			<td>电子邮箱：</td>
			<td><ext:field property="email"/></td>
			<td nowrap></td>
		</tr>
		
		
		<tr>
			<td>地址：</td>
			<td><ext:field property="address"/></td>
			<td nowrap></td>
		</tr>
		<tr>
			<td>传真：</td>
			<td><ext:field property="fax"/></td>
			<td nowrap></td>
		</tr>
		
		<tr>
			<td valign="bottom">验证码：</td>
			<td>
				<img id="validateCodeImage" src="<%=request.getContextPath()%>/jeaf/validatecode/generateValidateCodeImage.shtml"> <a style="color:blue" href="javascript:FormUtils.reloadValidateCodeImage()">看不清，换一张</a>
				<ext:field property="validateCode"/>
			</td>
			<td nowrap="nowrap"></td>
		</tr>
		<tr>
			<td colspan="3" align="center" style="padding-top:8px">
				<ext:button onclick="FormUtils.submitForm()" width="80" name="注册"/>
			</td>
		</tr>
	</table>
</ext:form>