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
public class UserResponse {

	@SerializedName("status")
	@Expose
	private Boolean status;
	@SerializedName("data")
	@Expose
	private Data data;

	public Boolean getStatus() {
	return status;
	}

	public void setStatus(Boolean status) {
	this.status = status;
	}

	public Data getData() {
	return data;
	}

	public void setData(Data data) {
	this.data = data;
	}

}