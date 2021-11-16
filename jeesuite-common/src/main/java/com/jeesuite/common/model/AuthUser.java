package com.jeesuite.common.model;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.jeesuite.common.util.SimpleCryptUtils;


/**
 * 
 * <br>
 * Class Name   : AuthUser
 *
 * @author jiangwei
 * @version 1.0.0
 * @date 2020年10月17日
 */
public class AuthUser {

	private static final String CONTACT_CHAR = "#";
	private static final String PLACEHOLDER_CHAR = "{-}";
	
	private String id;
	private String username;
	private String userType;//用户类型类型
	private String departmentId;
	private boolean admin;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	public String toEncodeString(){
		StringBuilder builder = new StringBuilder();
		builder.append(id).append(CONTACT_CHAR);
		builder.append(trimToPlaceHolder(username)).append(CONTACT_CHAR);
		builder.append(trimToPlaceHolder(userType)).append(CONTACT_CHAR);
		builder.append(trimToPlaceHolder(departmentId)).append(CONTACT_CHAR);
		builder.append(admin).append(CONTACT_CHAR);
		return SimpleCryptUtils.encrypt(builder.toString());
	}
	
	public static AuthUser decode(String encodeString){
		
		if(StringUtils.isBlank(encodeString))return null;
		encodeString = SimpleCryptUtils.decrypt(encodeString);
		String[] splits = encodeString.split(CONTACT_CHAR);
		AuthUser user = new AuthUser();
		user.setId(placeHolderToNull(splits[0]));
		user.setUsername(placeHolderToNull(splits[1]));
		user.setUserType(placeHolderToNull(splits[2]));
		user.setDepartmentId(placeHolderToNull(splits[3]));
		user.setAdmin(Boolean.parseBoolean(splits[4]));
		
		return user;
	}
	

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
	
	private static String trimToPlaceHolder(String value){
		value = StringUtils.trimToNull(value);
		return value == null ? PLACEHOLDER_CHAR : value;
	}
	
	private static String placeHolderToNull(String value){
		return PLACEHOLDER_CHAR.equals(value) ? null : value;
	}
}
