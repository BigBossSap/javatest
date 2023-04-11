package eac2_web;
import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class ServletFormulariEntrada extends HttpServlet {
public ServletFormulariEntrada() {
// TODO Auto-generated constructor stub
}
protected void doPost(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException {
//Obtenim els paràmetres del formulari
String nom=request.getParameter("nom");
String cognoms=request.getParameter("cognoms");
String DNI=request.getParameter("DNI");
String telefon=request.getParameter("telefon");
String dataNaixement=request.getParameter("dataNaixement");
//Preparem la sortida d'aquest mètode, que serà una plana HTML
response.setContentType("text/html");
PrintWriter out=response.getWriter();
//Generació de la resposta html
out.println("<html>");
out.println("<head><title>Dades introduïdes en el formulari</title></head>");
out.println("<body>");
out.println("<h2>Dades del formulari</h2>");
out.println("<table border=\"0\">");
out.println("<tr><td><b>Nom:</b></td><td><i>"+nom+"</i></td></tr>");
out.println("<tr><td><b>Cognoms:</b></td><td><i>"+
cognoms+"</i></td></tr>");
out.println("<tr><td><b>DNI:</b></td><td><i>"+DNI+"</i></td></tr>");
out.println("<tr><td><b>Telèfon:</b></td><td><i>"+
telefon+"</i></td></tr>");
out.println("<tr><td><b>Data de naixement:</b></td><td><i>"+
dataNaixement+"</i></td></tr>");
out.println("</table><p>");out.println("</body>"); out.println("</html>");
}
}