

/*
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the "License").  You may not use this file except
 * in compliance with the License.
 *
 * You can obtain a copy of the license at
 * glassfish/bootstrap/legal/CDDLv1.0.txt or
 * https://glassfish.dev.java.net/public/CDDLv1.0.html.
 * See the License for the specific language governing
 * permissions and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL
 * HEADER in each file and include the License file at
 * glassfish/bootstrap/legal/CDDLv1.0.txt.  If applicable,
 * add the following below this CDDL HEADER, with the
 * fields enclosed by brackets "[]" replaced with your
 * own identifying information: Portions Copyright [yyyy]
 * [name of copyright owner]
 *
 * Copyright 2005 Sun Microsystems, Inc. All rights reserved.
 *
 * Portions Copyright Apache Software Foundation.
 */

package javax.servlet.http;

import java.util.EventListener;

    /** Objects that are bound to a session may listen to container
    ** events notifying them that sessions will be passivated and that
    ** session will be activated. A container that migrates session between VMs
    ** or persists sessions is required to notify all attributes bound to sessions
    ** implementing HttpSessionActivationListener.
    **
    * @since 2.3
    */
//绑定到会话的对象可以侦听容器
//事件通知他们会话将被钝化，并且
//会话将被激活。一个在vm间迁移会话的容器
//或者持久化会话需要通知所有绑定到会话的属性
//实现HttpSessionActivationListener * *。
public interface HttpSessionActivationListener extends EventListener { 

    /** Notification that the session is about to be passivated.*/
    public void sessionWillPassivate(HttpSessionEvent se); 
    /** Notification that the session has just been activated.*/
    public void sessionDidActivate(HttpSessionEvent se);
} 

