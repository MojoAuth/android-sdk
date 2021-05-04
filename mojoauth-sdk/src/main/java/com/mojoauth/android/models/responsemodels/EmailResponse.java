/* 
 * 
 * Created by MojoAuth Development Team
   Copyright 2020 MojoAuth Inc. All rights reserved.
   
 */

package com.mojoauth.android.models.responsemodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

// <summary>
//	Response containing Definition of Complete Profile data
// </summary>
public class EmailResponse {

	@SerializedName("guid")
	@Expose
	private String guid;
	@SerializedName("status")
	@Expose
	private Boolean status;
	@SerializedName("expiry")
	@Expose
	private String expiry;

	public String getGuid() {
	return guid;
	}

	public void setGuid(String guid) {
	this.guid = guid;
	}

	public Boolean getStatus() {
	return status;
	}

	public void setStatus(Boolean status) {
	this.status = status;
	}

	public String getExpiry() {
	return expiry;
	}

	public void setExpiry(String expiry) {
	this.expiry = expiry;
	}


}