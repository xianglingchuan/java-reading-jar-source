

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

package javax.servlet;

import java.util.Enumeration;



/**
 * 
 * A servlet configuration object used by a servlet container
 * to pass information to a servlet during initialization. 
 *
 */
/***
 * 
 * Servlet配置接口类
 * servlet容器使用的servlet配置对象在初始化期间将信息传递给servlet
 * */
public interface ServletConfig {
    

    /**
     * Returns the name of this servlet instance.
     * The name may be provided via server administration, assigned in the 
     * web application deployment descriptor, or for an unregistered (and thus
     * unnamed) servlet instance it will be the servlet's class name.
     *
     * @return		the name of the servlet instance
     *
     *
     *
     */

	/***
	 * 
	 * 返回这个servlet实例的名称。这个名称可以通过服务器管理来提供，
	 * web应用程序部署描述符或未注册的(因此未命名的)servlet实例它将是servlet的类名。
	 * 
	 * @return servlet实例的名称
	 * 
	 */
    public String getServletName();

    /**
     * Returns a reference to the {@link ServletContext} in which the caller
     * is executing.
     *
     *
     * @return		a {@link ServletContext} object, used
     *			by the caller to interact with its servlet 
     *                  container
     * 
     * @see		ServletContext
     *
     */

    /**
     * 
     * @return 调用者使用的@link ServletContext对象与它的servlet容器进行交互
     * */
    public ServletContext getServletContext();
    
    
    /**
     * Returns a <code>String</code> containing the value of the 
     * named initialization parameter, or <code>null</code> if 
     * the parameter does not exist.
     *
     * @param name	a <code>String</code> specifying the name
     *			of the initialization parameter
     *
     * @return		a <code>String</code> containing the value 
     *			of the initialization parameter
     *
     */

    public String getInitParameter(String name);


    /**
     * Returns the names of the servlet's initialization parameters
     * as an <code>Enumeration</code> of <code>String</code> objects, 
     * or an empty <code>Enumeration</code> if the servlet has
     * no initialization parameters.
     *
     * @return		an <code>Enumeration</code> of <code>String</code> 
     *			objects containing the names of the servlet's 
     *			initialization parameters
     *
     *
     *
     */
    /**
     * 返回Servlet初始化的参数信息，返回类型为Enumeration
     * 
     * */
    public Enumeration getInitParameterNames();


}
