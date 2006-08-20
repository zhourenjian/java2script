/* Copyright 2006 The Apache Software Foundation or its licensors, as applicable
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package java.util;

import java.io.Serializable;

/**
 * The unchecked exception will be thrown out if the formatter has been closed.
 * 
 */
public class FormatterClosedException extends IllegalStateException implements
		Serializable {
	private static final long serialVersionUID = 18111216L;

	/**
	 * Constucts an instance of FormatterClosedException.
	 * 
	 */
	public FormatterClosedException() {
	}
}