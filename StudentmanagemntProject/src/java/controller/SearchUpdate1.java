package controller;

import Model.Student;
import dao.Studentdao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class SearchUpdate1 extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SearchUpdate1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchUpdate1 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        int rno;
        PrintWriter out =response.getWriter();
        rno=Integer.parseInt(request.getParameter("txtrno"));
        Studentdao sd=new Studentdao();
        Student s;
        s=sd.searchByRno(rno);
            
        if(s==null)
           // out.println("Record not found..");
            response.sendRedirect("RecordNotFoundMsg.html");
        
        else
        
//          {  out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet SearchUpdate1</title>");            
//            out.println("</head>");
//            out.println("<body>");
//             out.println("<form action=finalupdate method=post>");
//                out.println("<table border=1>");
//                        out.println("<tr>");
//                            out.println("<th>Roll number</th><th>Name</th><th>Physics</th><th>Chemistry</th><th>Maths</th>");
//                        out.println("</tr>");
//                        out.println("<tr>");
//                             out.println("<td>"+s.getRno()+"</td>");
//                             out.println("<td><input type=text name=txtname value="+s.getName()+"></td>");
//                             out.println("<td><input type=text name=txtphy value="+s.getPhy()+"></td>");
//                             out.println("<td><input type=text name=txtchem value="+s.getChem()+"></td>");
//                             out.println("<td><input type=text name=txtmaths value="+s.getMaths()+"></td>");
//                               out.println("<td><input type=submit  value=Updatedata></td> ");    
//                         out.println("</tr>");           
//                 out.println("</table>");       
//            out.println("</form>");
//            out.println("</body>");
//        out.println("</html>");}
        {out.println("<html>"+
         "<head><title>Student Data</title><style>"+
         "body {font-family: Arial, sans-serif;margin: 0;padding: 20px;background-color: #f4f4f4; }"+
        "table{width: 60%;border-collapse: collapse;margin-bottom: 20px;}"+
" table, th, td {border: 1px solid #ccc;}"+
" th, td {padding: 8px;text-align: left;}"+
" th {background-color: #4CAF50;color: white;}"+
"tr:nth-child(even){background-color: #f2f2f2; }"+
".delete-button {padding: 5px 10px;border: none;border-radius: 3px;cursor: pointer;background-color: #4CAF50;color: white;}"+
".delete-button:hover{background-color: #45a049;}"+
"input[type=submit]{padding: 5px 15px;margin-right: 10px;border: none;border-radius: 3px;cursor: pointer;background-color: #4CAF50;color: white;}"+
"input[type=submit]:hover{background-color: #45a049;}"+
"</style></head><body>"+
"<style>header {background-color: #4CAF50;color: white;padding: 10px 0;text-align: center;margin-bottom: 20px;}"+
"nav{background: linear-gradient(to right, #4CAF50, #8BC34A);color: white;text-align: center;padding: 10px 0;border-radius: 5px;margin-bottom: 20px;}"+
"nav a{color: white;text-decoration: none;padding: 5px 15px;transition: background-color 0.3s;}"+
"nav a:hover {background-color: #388E3C;}"+
".container {max-width: 800px;margin: 0 auto;padding: 0 20px;}"+
"h2 {margin-top: 40px;}"+
"</style><header><h1>Student Application</h1></header>"+
"<nav><A href=header.html>Home</A><A href=Insert.html>Insert Student</A><A href=Delete.html>Delete Student</A><A href=Search.html>Search Student</A><A href=SearchAll>Search All</A><A href=Update.html>Update Student</A><A href>About Us</A></nav>"+
"<center><h2>Student Data</h2><form action=finalupdate method=post><table>"+
        "<thead>"+
            "<tr><th>Roll No</th><th>Name</th><th>Physics</th><th>Chemistry</th><th>Maths</th><th>Action</th></tr>"+
        "</thead><tbody><tr>"+
         "<td>"+s.getRno()+"</td>"+
         "<td><input type=text name=txtname value="+s.getName()+"></td>"+
          "<td><input type=text name=txtphy value="+s.getPhy()+"></td>"+
           "<td><input type=text name=txtchem value="+s.getChem()+"></td>"+
           "<td><input type=text name=txtmaths value="+s.getMaths()+"></td>"+
          "<td><input type=submit  value=Updatedata></td> "+   

        
            "</tr></tbody></table></form></center></body></html>");
        HttpSession session=request.getSession();
         session.setAttribute("rollno",s.getRno());
        }
         
        }      
        
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
