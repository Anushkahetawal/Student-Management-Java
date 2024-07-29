/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author HP
 */
public class Searchdelete extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Searchdelete</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Searchdelete at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out =response.getWriter();
        int rno;
        rno=Integer.parseInt(request.getParameter("txtrno"));
        Studentdao sd=new Studentdao();
        Student s;
        s=sd.searchByRno(rno);
        if(s==null)
            //out.println("Record not found");
            response.sendRedirect("RecordNotFoundMsg.html");
        else //agr record present hoto record apnko table ke format me chahiye
//        {   out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Searchdelete</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            
//            out.println("<table border=2>");
//                out.println("<tr>");
//                        out.println("<th>Roll no</th><th>Name</th><th>Physics</th><th>Chemistry</th><th>Maths</th></tr>");
//                         out.println("</tr>");
//                         out.println("<tr>");
//                         out.println("<td>"+s.getRno()+"</td><td>"+s.getName()+"</td><td>"+s.getPhy()+"</td><td>"+s.getChem()+"</td><td>"+s.getMaths()+"</td>");
//                         //out.println("</tr>");
//                         out.println("<form action=deletedata method=post>");
//                           out.println("<td><input type=submit value=deletedata></td>");
//                         out.println("</form>");
//                         out.println("</tr>");
//            out.println("</table>");
//            out.println("</body>");
//            out.println("</html>");
//            HttpSession session=request.getSession(true);
//            session.setAttribute("rollno",s.getRno());
//            
//        }  
            
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
"<center><h2>Student Data</h2><table>"+
        "<thead>"+
            "<tr><th>Roll No</th><th>Name</th><th>Physics</th><th>Chemistry</th><th>Maths</th><th>Action</th></tr>"+
        "</thead>"+
        "<tbody><tr><td>"+s.getRno()+"</td><td>"+s.getName()+"</td><td>"+s.getPhy()+"</td><td>"+s.getChem()+"</td><td>"+s.getMaths()+"</td>"+
        "<form action=deletedata method=post>"+
        "<td><input type=submit value=Delete></td>"+
        "</form>"+
            "</tr></tbody></table></center></body></html>");
         HttpSession session=request.getSession(true);
         session.setAttribute("rollno",s.getRno());
        }    

    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
