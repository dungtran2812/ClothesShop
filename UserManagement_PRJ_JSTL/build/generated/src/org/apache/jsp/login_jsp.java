package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!doctype html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("  <head>\n");
      out.write("    <!-- Required meta tags -->\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap\" rel=\"stylesheet\">\n");
      out.write("    \n");
      out.write("    <!-- Style -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("\n");
      out.write("    <title>Login #3</title>\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("  \n");
      out.write("\n");
      out.write("  <div class=\"half\">\n");
      out.write("    <div class=\"bg order-1 order-md-2\" style=\"background-image: url('images/bg_1.jpg');\"></div>\n");
      out.write("    <div class=\"contents order-2 order-md-1\">\n");
      out.write("\n");
      out.write("      <div class=\"container\">\n");
      out.write("        <div class=\"row align-items-center justify-content-center\">\n");
      out.write("          <div class=\"col-md-6\">\n");
      out.write("            <div class=\"form-block\">\n");
      out.write("              <div class=\"text-center mb-5\">\n");
      out.write("              <h3>Login to <strong>Colorlib</strong></h3>\n");
      out.write("              <!-- <p class=\"mb-4\">Lorem ipsum dolor sit amet elit. Sapiente sit aut eos consectetur adipisicing.</p> -->\n");
      out.write("              </div>\n");
      out.write("              <form action=\"MainController\" method=\"POST\">\n");
      out.write("                <div class=\"form-group first\">\n");
      out.write("                  <label for=\"username\">Username</label>\n");
      out.write("                  <input type=\"text\" class=\"form-control\" placeholder=\"your-email@gmail.com\" id=\"username\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group last mb-3\">\n");
      out.write("                  <label for=\"password\">Password</label>\n");
      out.write("                  <input type=\"password\" class=\"form-control\" placeholder=\"Your Password\" id=\"password\">\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <div class=\"d-sm-flex mb-5 align-items-center\">\n");
      out.write("                  <label class=\"control control--checkbox mb-3 mb-sm-0\"><span class=\"caption\">Remember me</span>\n");
      out.write("                    <input type=\"checkbox\" checked=\"checked\"/>\n");
      out.write("                    <div class=\"control__indicator\"></div>\n");
      out.write("                  </label>\n");
      out.write("                  <span class=\"ml-auto\"><a href=\"#\" class=\"forgot-pass\">Forgot Password</a></span> \n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <input type=\"submit\" value=\"Log In\" class=\"btn btn-block btn-primary\">\n");
      out.write("\n");
      out.write("              </form>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    \n");
      out.write("  </div>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("\n");
      out.write("    <script src=\"js/jquery-3.3.1.min.js\"></script>\n");
      out.write("    <script src=\"js/popper.min.js\"></script>\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("    <script src=\"js/main.js\"></script>\n");
      out.write("  </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
