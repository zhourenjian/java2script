/*******************************************************************************
 * Copyright (c) 2007 java2script.org and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Zhou Renjian - initial API and implementation
 *******************************************************************************/

package org.java2script.demo.gtalk;


/**
 * @author zhou renjian
 *
 * 2007-3-11
 */
public class CloseChattingRunnable extends GTalkRunnable {
	public String user;
	public String hash;
	public String friend;
	public boolean status;

	/* (non-Javadoc)
	 * @see net.sf.j2s.ajax.SimpleRPCRunnable#ajaxRun()
	 */
	public void ajaxRun() {
		status = JabberPool.closeChat(user, hash, friend);
	}
}
