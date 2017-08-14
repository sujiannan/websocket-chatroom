/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-08-14 10:59:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class client_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>多人聊天室</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<h1>欢迎来到本聊天室 - enjoy</h1> <br/>\n");
      out.write("昵称：<input type=\"text\" id=\"nick\"> <br>\n");
      out.write("你说：<input type=\"text\" id=\"context\">\n");
      out.write("<input id=\"send\" type=\"button\" value=\"发送\" >\n");
      out.write("<input id=\"disconn\" type=\"button\" value=\"断开连接\" onclick=\"disconn()\" >\n");
      out.write("<hr/>\n");
      out.write("<div id=\"msg\" ></div>\n");
      out.write("</body>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\tvar ws = new WebSocket(\"ws://localhost:8080/wserver\");\n");
      out.write("\tws.onopen = function(e) {\n");
      out.write("\t\tshowToDiv(\"连接服务器成功...\");\n");
      out.write("\t} \n");
      out.write("\t\n");
      out.write("\t//接收到消息的回调方法  \n");
      out.write("    ws.onmessage = function (event) {  \n");
      out.write("    \tshowToDiv(event.data);  \n");
      out.write("    }  \n");
      out.write("\t\n");
      out.write("    //连接关闭的回调方法  \n");
      out.write("    ws.onclose = function () {  \n");
      out.write("    \tshowToDiv(\"WebSocket连接关闭\");  \n");
      out.write("    }  \n");
      out.write("    //连接发生错误的回调方法  \n");
      out.write("    ws.onerror = function () {  \n");
      out.write("        setMessageInnerHTML(\"WebSocket连接发生错误\");  \n");
      out.write("    };  \n");
      out.write("  \n");
      out.write("\tfunction showToDiv(str) {\n");
      out.write("\t\tvar inn = document.createElement(\"p\");\n");
      out.write("\t\tinn.innerHTML = str;\n");
      out.write("\t\tmsgDiv = document.getElementById(\"msg\");\n");
      out.write("\t\tmsgDiv.appendChild(inn);\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\tdocument.getElementById(\"send\").onclick = function() {\n");
      out.write("\t\tvar nickname = document.getElementById(\"nick\").value;\n");
      out.write("\t\tvar txt = document.getElementById(\"context\").value ;\n");
      out.write("\t\tshowToDiv(\"我说：\" + txt);\n");
      out.write("\t\tws.send(nickname + \":\" + txt);  // 发送给ws服务器\n");
      out.write("\t\tdocument.getElementById(\"context\").value = \"\";\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\tfunction disconn() {\n");
      out.write("\t\tws.close();\n");
      out.write("\t}\n");
      out.write("</script>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
