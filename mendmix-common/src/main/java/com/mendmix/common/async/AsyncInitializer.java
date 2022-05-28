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
package com.mendmix.common.async;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 异步初始化接口
 * <br>
 * Class Name   : AsyncInitializer
 *
 * @author jiangwei
 * @version 1.0.0
 * @date 2020年8月27日
 */
public interface AsyncInitializer {

	static AtomicInteger count = new AtomicInteger(1);
	
	default void process(){
		new Thread(new Runnable() {
			@Override
			public void run() {
				doInitialize();
			}
		}, "AsyncInitializer-"+ count.getAndIncrement()).start();
	}
	
	void doInitialize();
}
