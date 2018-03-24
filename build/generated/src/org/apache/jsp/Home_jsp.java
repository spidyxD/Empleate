package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("      <title>Empleate</title>\n");
      out.write("      <!--Import Google Icon Font-->\n");
      out.write("      <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\n");
      out.write("      <!--Import materialize.css-->\n");
      out.write("      <link type=\"text/css\" rel=\"stylesheet\" href=\"css/materialize.css\"  media=\"screen,projection\"/>\n");
      out.write("      <!--Let browser know website is optimized for mobile-->\n");
      out.write("      <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("    <div class=\"header\">\n");
      out.write("      <div class=\"titulo\">\n");
      out.write("        <h1>Empleate</h1>\n");
      out.write("        <h2>Busque su lugar!</h2>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"test\">\n");
      out.write("        <nav>\n");
      out.write("          <div class=\"nav-wrapper\">\n");
      out.write("            <ul class=\"right hide-on-med-and-down\">\n");
      out.write("              <li><input id=\"icon_prefix\" type=\"text\" class=\"validate\"></li>\n");
      out.write("              <li><a href=\"#\"><i class=\"material-icons right\">search</i></a></li>\n");
      out.write("              <li><a href=\"#\"class=\"waves-effect waves-light btn\">Registrarse</a></li>\n");
      out.write("              <li><a href=\"#\"class=\"waves-effect waves-light btn\">Entrar</a></li>\n");
      out.write("            </ul>\n");
      out.write("          </div>\n");
      out.write("        </nav>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"cuerpo\">\n");
      out.write("      <section class=\"section\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("          <div class=\"carousel carousel-slider center\">\n");
      out.write("            <div class=\"carousel-fixed-item center\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"carousel-item red white-text\" href=\"#one!\">\n");
      out.write("              <h2>Job1</h2>\n");
      out.write("              <p class=\"white-text\">job1 descrip</p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"carousel-item amber white-text\" href=\"#two!\">\n");
      out.write("              <h2>Job2</h2>\n");
      out.write("              <p class=\"white-text\">job2 descrip</p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"carousel-item green white-text\" href=\"#three!\">\n");
      out.write("              <h2>Job3</h2>\n");
      out.write("              <p class=\"white-text\">job3 descrip</p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"carousel-item blue white-text\" href=\"#four!\">\n");
      out.write("              <h2>Job4</h2>\n");
      out.write("              <p class=\"white-text\">job4 descrip</p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"carousel-item black white-text\" href=\"#five!\">\n");
      out.write("              <h2>Job5</h2>\n");
      out.write("              <p class=\"white-text\">job5 descrip</p>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </section>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"cuerpo2\">\n");
      out.write("        <div class=\"parallax-container\">\n");
      out.write("          <div class=\"parallax\"><img src=\"images/5.jpg\"></div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"footer contenedor\">\n");
      out.write("      <a href=\"tel:+50661688613\"><strong>Telefono </strong><span>61688613</span></a>\n");
      out.write("      <a href=\"mailto:andres.gutierrez.arcia@gmail.com\"><strong>E-mail </strong><span>andres.gutierrez.arcia@gmail.com</span></a>\n");
      out.write("    </div>\n");
      out.write("    <!--JavaScript at end of body for optimized loading-->\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery.js\"></script> <!--necesario para los carruseles-->\n");
      out.write("    <script type=\"text/javascript\" src=\"js/materialize.min.js\"></script><!--js de materialize-->\n");
      out.write("    <script type=\"text/javascript\" src=\"js/myScript.js\"></script><!--codigo js para inicializar js-->\n");
      out.write("  </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
