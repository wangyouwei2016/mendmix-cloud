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
package com.mendmix.mybatis.plugin.cache;

import org.apache.ibatis.mapping.SqlCommandType;

/**
 * 按主键更新（add,update,delete）的缓存方法元信息
 * <br>
 * Class Name   : UpdateByPkMethodCache
 *
 * @author jiangwei
 * @version 1.0.0
 * @date Dec 23, 2020
 */
public class UpdateByPkCacheMethodMetadata {
	public String keyPattern;
	
	public UpdateByPkCacheMethodMetadata(Class<?> entityClass,String methodName, String keyPattern, SqlCommandType sqlCommandType) {
		this.keyPattern = keyPattern;
	}
}
