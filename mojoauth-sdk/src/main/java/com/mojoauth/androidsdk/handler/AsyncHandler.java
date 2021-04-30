package com.mojoauth.androidsdk.handler;


import com.mojoauth.androidsdk.helper.ErrorResponse;

import java.io.Serializable;

public interface AsyncHandler<T> extends Serializable{
	void onFailure(ErrorResponse error);
	void onSuccess(T data);

}
