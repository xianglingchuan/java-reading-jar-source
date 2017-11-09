

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

import java.io.IOException;

    /**
    * A FilterChain is an object provided by the servlet container to the developer
    * giving a view into the invocation chain of a filtered request for a resource. Filters
    * use the FilterChain to invoke the next filter in the chain, or if the calling filter
    * is the last filter in the chain, to invoke the resource at the end of the chain.
    *
    * @see Filter
    * @since Servlet 2.3
    **/
//FilterChain是由servlet容器提供给开发人员的对象
//对资源的过滤请求的调用链给出一个视图。过滤器
//使用FilterChain来调用链中的下一个过滤器，或者调用过滤器
//是链中的最后一个过滤器，用于调用链末端的资源。
public interface FilterChain {
	
	/**
	* Causes the next filter in the chain to be invoked, or if the calling filter is the last filter
	* in the chain, causes the resource at the end of the chain to be invoked.
	*
	* @param request the request to pass along the chain.
	* @param response the response to pass along the chain.
	*
	* @since 2.3
	*/
	
    public void doFilter ( ServletRequest request, ServletResponse response ) throws IOException, ServletException;

}

