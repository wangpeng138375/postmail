package com.cvte.mail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

public class MailMessage {
	private JSONObject jsonmain=new JSONObject();
	private JSONObject jsonhead=new JSONObject();
	private JSONObject jsonbody=new JSONObject();

	
	
	public MailMessage() {
		super();
		jsonmain.put("head", jsonhead);
		jsonmain.put("body", jsonbody);
	}

	/**
	 * @param mstype 消息类型，暂时不可用
	 * @return this
	 */
	private MailMessage setMstype(String mstype) {
		jsonhead.put("Ms-Type", mstype);
		return this;
	}
	
	/**
	 * @param priority 优先级
	 * @return this
	 */
	@Deprecated
	public MailMessage setPriority(String priority) {
		jsonhead.put("Priority", priority);
		return this;
	}
	/**
	 * @param sys_id 系统id
	 * @return this
	 */
	public MailMessage setSys_id(String sys_id) {
		jsonhead.put("Sys-Id", sys_id);
		return this;
	}
	/**
	 * @param sys_mod_id 系统模块id
	 * @return this
	 */
	public MailMessage setSys_mod_id(String sys_mod_id) {
		jsonhead.put("Sys-Module", sys_mod_id);
		return this;
	}
	/**
	 * @param fixedtime 定时发送时间，例：60表示1分钟后发送；2015-10-27 08:46:18 表示固定时间点
	 * @return this
	 */
	public MailMessage setFixedtime(String fixedtime) {
		jsonhead.put("Fixed-Time", fixedtime);
		return this;
	}
	/**
	 * @param merge 合并的规则，目前只支持time 例：{"time":"10"}表示按照10秒钟合并一次
	 * @return this
	 */
	public MailMessage setMerge(Map<String, String> merge) {
		jsonhead.put("Merge", merge);
		return this;
	}
	/**
	 * @param mergeSubject 自定义合并后的主题
	 * @return this
	 */
	public MailMessage setMergeSubject(String mergeSubject) {
		jsonhead.put("Merge-Subject", mergeSubject);
		return this;
	}
	
	
	
	
	
	
	/**
	 * @param templateid 模板id，默认empty
	 * @return this
	 */
	public MailMessage setTemplateid(String templateid) {
		jsonbody.put("Template-Id", templateid);
		return this;
	}
	
	/**
	 * @param fromAddress 发件人地址
	 * @return this
	 */
	public MailMessage setFromAddress(String fromAddress) {
		jsonbody.put("From-Add", fromAddress);
		return this;
	}
	/**
	 * @param toAddress 收件人地址
	 * @return
	 */
	public MailMessage setToAddress(List<String> toAddress) {
		jsonbody.put("To-Add", toAddress);
		return this;
	}
	/**
	 * @param ccAddress 抄送人地址
	 * @return this
	 */
	public MailMessage setCcAddress(List<String> ccAddress) {
		jsonbody.put("Cc-Add", ccAddress);
		return this;
	}
	/**
	 * @param bccAddress 密抄送人地址
	 * @return this
	 */
	public MailMessage setBccAddress(List<String> bccAddress) {
		jsonbody.put("Bcc-Add", bccAddress);
		return this;
	}
	/**
	 * @param replyAddress 回复地址
	 * @return this
	 */
	public MailMessage setReplyAddress(List<String> replyAddress) {
		jsonbody.put("Reply-Add", replyAddress);
		return this;
	}
	
	/**
	 * @param subject 邮件主题 
	 * @return this
	 */
	public MailMessage setSubject(String subject) {
		jsonbody.put("Subject", subject);
		return this;
	}
	/**
	 * @param content 参照模板id设置content,如果模板id为空，请设置{"ContentBody":"content"},或者使用setContent(String content)
	 * @return this
	 */
	public MailMessage setContent(Map<String, String> content) {
		jsonbody.put("Content", content);
		return this;
	}
	/**
	 * @param content 在模板id为空或者为empty的时候方便使用
	 * @return
	 */
	public MailMessage setContent(String content) {
		Map<String, String> cmap=new HashMap<String, String>();
		cmap.put("ContentBody", content);
		jsonbody.put("Content", cmap);
		return this;
	}
	/**
	 * @param attachFileNames 附件信息，map的key为附件文件名，value为BASE64编码之后的字符串
	 * @return
	 */
	public MailMessage setAttachFileNames(Map<String, String> attachFileNames) {
		jsonbody.put("Attachments", attachFileNames);
		return this;
	}

	@Override
	public String toString() {
		return jsonmain.toString();
	}
	
	

}
