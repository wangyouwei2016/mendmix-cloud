/*
 * Copyright 2016-2022 www.mendmix.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mendmix.gateway.model;

import java.util.List;

/**
 * @description <br>
 * @author <a href="mailto:vakinge@gmail.com">vakinge</a>
 * @date Jun 12, 2022
 */
public class OpenApiConfig {

	private String clientId;
	private String clientSecret;
	private List<String> grantedApis;
	
	public OpenApiConfig() {}
	
	public OpenApiConfig(String clientId, String clientSecret) {
		super();
		this.clientId = clientId;
		this.clientSecret = clientSecret;
	}

	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientSecret() {
		return clientSecret;
	}
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	public List<String> getGrantedApis() {
		return grantedApis;
	}
	public void setGrantedApis(List<String> grantedApis) {
		this.grantedApis = grantedApis;
	}
	
	
}
