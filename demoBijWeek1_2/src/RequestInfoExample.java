/*
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements.  See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* The ASF licenses this file to You under the Apache License, Version 2.0
* (the "License"); you may not use this file except in compliance with
* the License.  You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
/* $Id: RequestInfoExample.java 102 2015-09-02 17:47:49Z mpro $
 *
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.HTMLFilter;

/**
 * Example servlet showing request information.
 *
 * @author James Duncan Davidson <duncan@eng.sun.com>
 */

@WebServlet("/ReqInfoExample")
public class RequestInfoExample extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final ResourceBundle RB = ResourceBundle.getBundle("LocalStrings");

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
    	System.out.format("[RequestInfoExample-doGet] - getProtocol : %s\n",  request.getProtocol());
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");

       String title = RB.getString("requestinfo.title");
       out.println("<title>" + title + "</title>");
        out.println("</head>");
        out.println("<body bgcolor=\"white\">");

        // img stuff not req'd for source code html showing
        // all links relative!

        // XXX
        // making these absolute till we work out the
        // addition of a PathInfo issue

        out.println("<a href=\"../reqinfo.html\">");
        out.println("<img src=\"../images/code.gif\" height=24 " +
                    "width=24 align=right border=0 alt=\"view code\"></a>");
        out.println("<a href=\"../index.html\">");
        out.println("<img src=\"../images/return.gif\" height=24 " +
                    "width=24 align=right border=0 alt=\"return\"></a>");

        out.println("<h3>" + title + "</h3>");
        out.println("<table border=0><tr><td>");
        
        /** Returns the name of the HTTP method with which this request was made, for example, GET, POST, or PUT. */ 
        out.println(RB.getString("requestinfo.label.method"));
        out.println("</td><td>");
        out.println(HTMLFilter.filter(request.getMethod()));
        out.println("</td></tr><tr><td>");
        
        /** Returns the part of this request's URL from the protocol name up to the query string in the first line of the HTTP request. */ 
        out.println(RB.getString("requestinfo.label.requesturi"));
        out.println("</td><td>");
        out.println(HTMLFilter.filter(request.getRequestURI()));
        out.println("</td></tr><tr><td>");
        
        /** Reconstructs the URL the client used to make the request. */
        out.println(RB.getString("requestinfo.label.requesturl"));
        out.println("</td><td>");
        StringBuffer sbURL = request.getRequestURL();
        out.println(HTMLFilter.filter(sbURL.toString()));
        out.println("</td></tr><tr><td>");
        
        /** Returns the name and version of the protocol the request uses in the form protocol/majorVersion.minorVersion, 
         *  for example, HTTP/1.1. For HTTP servlets, the value returned is the same as the value of the CGI variable SERVER_PROTOCOL.
        */
        out.println(RB.getString("requestinfo.label.protocol"));
        out.println("</td><td>");
        out.println(HTMLFilter.filter(request.getProtocol()));
        out.println("</td></tr><tr><td>");
        
        /** Returns any extra path information associated with the URL the client sent when it made this request. */
        out.println(RB.getString("requestinfo.label.pathinfo"));
        out.println("</td><td>");
        out.println(HTMLFilter.filter(request.getPathInfo()));
        
        /** Returns the Internet Protocol (IP) address of the client or last proxy that sent the request. 
         *  For HTTP servlets, same as the value of the CGI variable REMOTE_ADDR.
         */
        out.println("</td></tr><tr><td>");
        out.println(RB.getString("requestinfo.label.remoteaddr"));
        out.println("</td><td>");
        out.println(HTMLFilter.filter(request.getRemoteAddr()));
        out.println("</td></tr>");     
        
        /** Example Request Header for key word 'Host'. 
        out.println("<tr><td>");
        out.println(RB.getString("requestinfo.label.header") + " 4 'host'");
        out.println("</td><td>");
        out.println(HTMLFilter.filter(request.getHeader("host")));
        out.println("</td></tr>");
        
        /** Example Request getContentType. Returns the MIME type of the body of the request, or null if the type is not known. */  
        out.println("<tr><td>");
        out.println(RB.getString("requestinfo.label.contenttype"));
        out.println("</td><td>");
        out.println(HTMLFilter.filter(request.getContentType()));
        out.println("</td></tr>");
        
        
        

        String cipherSuite=
                (String)request.getAttribute("javax.servlet.request.cipher_suite");
        if(cipherSuite!=null){
            out.println("<tr><td>");
            out.println("SSLCipherSuite:");
            out.println("</td><td>");
            out.println(HTMLFilter.filter(cipherSuite));
            out.println("</td></tr>");
        }

        out.println("</table>");
    }

    @Override
    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
        doGet(request, response);
    }

}

