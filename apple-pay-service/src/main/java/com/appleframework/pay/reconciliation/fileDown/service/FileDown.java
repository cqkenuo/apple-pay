/*
 * Copyright 2016-2102 Appleframework(http://www.appleframework.com) Group.
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
package com.appleframework.pay.reconciliation.fileDown.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * 对账文件下载
 * 
 * http://www.appleframework.com
 * 
 * @author  Cruise.Xu
 */
public interface FileDown {

	/**
	 * 对帐文件下载，获得文件输出
	 * 
	 * @param fileDate
	 *            账单日
	 * @param dir
	 *            账单文件存储地址
	 * @return
	 * @throws Exception
	 */
	File fileDown(Date fileDate, String dir) throws IOException, Exception;

}
