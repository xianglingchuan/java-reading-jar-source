

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

import java.util.Enumeration;
import javax.servlet.ServletContext;

/**
 *
 * Provides a way to identify a user across more than one page
 * request or visit to a Web site and to store information about that user.
 *
 * <p>The servlet container uses this interface to create a session
 * between an HTTP client and an HTTP server. The session persists
 * for a specified time period, across more than one connection or
 * page request from the user. A session usually corresponds to one 
 * user, who may visit a site many times. The server can maintain a 
 * session in many ways such as using cookies or rewriting URLs.
 *
 * <p>This interface allows servlets to 
 * <ul>
 * <li>View and manipulate information about a session, such as
 *     the session identifier, creation time, and last accessed time
 * <li>Bind objects to sessions, allowing user information to persist 
 *     across multiple user connections
 * </ul>
 *
 * <p>When an application stores an object in or removes an object from a
 * session, the session checks whether the object implements
 * {@link HttpSessionBindingListener}. If it does, 
 * the servlet notifies the object that it has been bound to or unbound 
 * from the session. Notifications are sent after the binding methods complete. 
 * For session that are invalidated or expire, notifications are sent after
 * the session has been invalidated or expired.
 *
 * <p> When container migrates a session between VMs in a distributed container
 * setting, all session attributes implementing the {@link HttpSessionActivationListener}
 * interface are notified.
 * 
 * <p>A servlet should be able to handle cases in which
 * the client does not choose to join a session, such as when cookies are
 * intentionally turned off. Until the client joins the session,
 * <code>isNew</code> returns <code>true</code>.  If the client chooses 
 * not to join
 * the session, <code>getSession</code> will return a different session
 * on each request, and <code>isNew</code> will always return
 * <code>true</code>.
 *
 * <p>Session information is scoped only to the current web application
 * (<code>ServletContext</code>), so information stored in one context
 * will not be directly visible in another.
 *
 * @author	Various
 *
 * @see 	HttpSessionBindingListener
 * @see 	HttpSessionContext
 *
 */
//提供一种跨多个页面识别用户的方法
//请求或访问Web站点并存储关于该用户的信息。
//*
public interface HttpSession {




    /**
     *
     * Returns the time when this session was created, measured
     * in milliseconds since midnight January 1, 1970 GMT.
     *
     * @return				a <code>long</code> specifying
     * 					when this session was created,
     *					expressed in 
     *					milliseconds since 1/1/1970 GMT
     *
     * @exception IllegalStateException	if this method is called on an
     *					invalidated session
     *
     */
//	返回这个会话创建时的时间
//	从1970年1月1日午夜开始，以毫秒为单位。
    public long getCreationTime();
    
    
    
    
    /**
     *
     * Returns a string containing the unique identifier assigned 
     * to this session. The identifier is assigned 
     * by the servlet container and is implementation dependent.
     * 
     * @return				a string specifying the identifier
     *					assigned to this session
     */
//    返回一个包含惟一标识符的字符串
//    *这个会话。标识符分配
//    由servlet容器和实现依赖。
    public String getId();
    
    
    

    /**
     *
     * Returns the last time the client sent a request associated with
     * this session, as the number of milliseconds since midnight
     * January 1, 1970 GMT, and marked by the time the container received the request. 
     *
     * <p>Actions that your application takes, such as getting or setting
     * a value associated with the session, do not affect the access
     * time.
     *
     * @return				a <code>long</code>
     *					representing the last time 
     *					the client sent a request associated
     *					with this session, expressed in 
     *					milliseconds since 1/1/1970 GMT
     *
     * @exception IllegalStateException	if this method is called on an
     *					invalidated session
     *
     */
//    最后一次客户端发送一个与之相关的请求
//    这个session，就像午夜之后的毫秒数
//    在格林尼治时间1970年1月1日，并在容器收到请求的时候标记。
    public long getLastAccessedTime();
    
    
    /**
    * Returns the ServletContext to which this session belongs.
    *    
    * @return The ServletContext object for the web application
    * @since 2.3
    */
    //返回这个会话所属的ServletContext。
    public ServletContext getServletContext();


    /**
     *
     * Specifies the time, in seconds, between client requests before the 
     * servlet container will invalidate this session.  A negative time
     * indicates the session should never timeout.
     *
     * @param interval		An integer specifying the number
     * 				of seconds 
     *
     */
//    指定时间，以秒为间隔，在客户端请求之前
//    servlet容器将使此会话无效。消极的时候
//    表示会话不应该超时。
    public void setMaxInactiveInterval(int interval);




   /**
    * Returns the maximum time interval, in seconds, that 
    * the servlet container will keep this session open between 
    * client accesses. After this interval, the servlet container
    * will invalidate the session.  The maximum time interval can be set
    * with the <code>setMaxInactiveInterval</code> method.
    * A negative time indicates the session should never timeout.
    *  
    *
    * @return		an integer specifying the number of
    *			seconds this session remains open
    *			between client requests
    *
    * @see		#setMaxInactiveInterval
    *
    *
    */
//    返回最大的时间间隔，以秒为间隔
//    servlet容器将保持会话之间的开放
//    *客户端访问。在这个时间间隔之后，servlet容器
//    将使会话无效。可以设置最大的时间间隔
//    使用了setMaxInactiveInterval的方法。
//    负时间表示会话不应该超时。
    public int getMaxInactiveInterval();
    
    


   /**
    *
    * @deprecated 	As of Version 2.1, this method is
    *			deprecated and has no replacement.
    *			It will be removed in a future
    *			version of the Java Servlet API.
    *
    */

    public HttpSessionContext getSessionContext();
    
    
    
    
    /**
     *
     * Returns the object bound with the specified name in this session, or
     * <code>null</code> if no object is bound under the name.
     *
     * @param name		a string specifying the name of the object
     *
     * @return			the object with the specified name
     *
     * @exception IllegalStateException	if this method is called on an
     *					invalidated session
     *
     */
//    在这个会话中返回与指定名称绑定的对象
//    如果没有对象被绑定到这个名称中。
    public Object getAttribute(String name);
    
    
    
    
    /**
     *
     * @deprecated 	As of Version 2.2, this method is
     * 			replaced by {@link #getAttribute}.
     *
     * @param name		a string specifying the name of the object
     *
     * @return			the object with the specified name
     *
     * @exception IllegalStateException	if this method is called on an
     *					invalidated session
     *
     */
  
    public Object getValue(String name);
    
    
    

    /**
     *
     * Returns an <code>Enumeration</code> of <code>String</code> objects
     * containing the names of all the objects bound to this session. 
     *
     * @return			an <code>Enumeration</code> of 
     *				<code>String</code> objects specifying the
     *				names of all the objects bound to
     *				this session
     *
     * @exception IllegalStateException	if this method is called on an
     *					invalidated session
     *
     */
//    返回的是字符串的字符串/代码，对象是字符串。
//    包含绑定到这个会话的所有对象的名称。
    public Enumeration getAttributeNames();
    
    
    

    /**
     *
     * @deprecated 	As of Version 2.2, this method is
     * 			replaced by {@link #getAttributeNames}
     *
     * @return				an array of <code>String</code>
     *					objects specifying the
     *					names of all the objects bound to
     *					this session
     *
     * @exception IllegalStateException	if this method is called on an
     *					invalidated session
     *
     */
    
    public String[] getValueNames();
    
    
    

    /**
     * Binds an object to this session, using the name specified.
     * If an object of the same name is already bound to the session,
     * the object is replaced.
     *
     * <p>After this method executes, and if the new object
     * implements <code>HttpSessionBindingListener</code>,
     * the container calls 
     * <code>HttpSessionBindingListener.valueBound</code>. The container then   
     * notifies any <code>HttpSessionAttributeListener</code>s in the web 
     * application.
     
     * <p>If an object was already bound to this session of this name
     * that implements <code>HttpSessionBindingListener</code>, its 
     * <code>HttpSessionBindingListener.valueUnbound</code> method is called.
     *
     * <p>If the value passed in is null, this has the same effect as calling 
     * <code>removeAttribute()<code>.
     *
     *
     * @param name			the name to which the object is bound;
     *					cannot be null
     *
     * @param value			the object to be bound
     *
     * @exception IllegalStateException	if this method is called on an
     *					invalidated session
     *
     */
//    使用指定的名称将一个对象绑定到这个会话。
//    如果一个同名的对象已经被绑定到会话，
//    对象被替换了。
    public void setAttribute(String name, Object value);
    



    
    /**
     *
     * @deprecated 	As of Version 2.2, this method is
     * 			replaced by {@link #setAttribute}
     *
     * @param name			the name to which the object is bound;
     *					cannot be null
     *
     * @param value			the object to be bound; cannot be null
     *
     * @exception IllegalStateException	if this method is called on an
     *					invalidated session
     *
     */
 
    public void putValue(String name, Object value);





    /**
     *
     * Removes the object bound with the specified name from
     * this session. If the session does not have an object
     * bound with the specified name, this method does nothing.
     *
     * <p>After this method executes, and if the object
     * implements <code>HttpSessionBindingListener</code>,
     * the container calls 
     * <code>HttpSessionBindingListener.valueUnbound</code>. The container
     * then notifies any <code>HttpSessionAttributeListener</code>s in the web 
     * application.
     * 
     * 
     *
     * @param name				the name of the object to
     *						remove from this session
     *
     * @exception IllegalStateException	if this method is called on an
     *					invalidated session
     */
//    删除与指定名称绑定的对象
//    *这个会话。如果会话中没有对象
//    用指定的名称绑定，这个方法什么也不做。
    public void removeAttribute(String name);





    /**
     *
     * @deprecated 	As of Version 2.2, this method is
     * 			replaced by {@link #removeAttribute}
     *
     * @param name				the name of the object to
     *						remove from this session
     *
     * @exception IllegalStateException	if this method is called on an
     *					invalidated session
     */

    public void removeValue(String name);




    /**
     *
     * Invalidates this session then unbinds any objects bound
     * to it. 
     *
     * @exception IllegalStateException	if this method is called on an
     *					already invalidated session
     *
     *使这个会话失效，然后解除绑定任何对象的绑定
     */

    public void invalidate();
    
    
    
    
    /**
     *
     * Returns <code>true</code> if the client does not yet know about the
     * session or if the client chooses not to join the session.  For 
     * example, if the server used only cookie-based sessions, and
     * the client had disabled the use of cookies, then a session would
     * be new on each request.
     *
     * @return 				<code>true</code> if the 
     *					server has created a session, 
     *					but the client has not yet joined
     *
     * @exception IllegalStateException	if this method is called on an
     *					already invalidated session
     *
     */
//    如果客户端还不知道该如何做，则返回true/code
//    会话或客户端选择不加入会话。为
//    例如，如果服务器仅使用基于cookie的会话，并且
//    客户端禁用了cookie，然后是会话
//    对每个请求都是新的。
    
    public boolean isNew();



}

