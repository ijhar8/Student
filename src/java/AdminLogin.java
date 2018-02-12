/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ijhar-A
 */
public class AdminLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           out.println("<!DOCTYPE html>\n" +
"<html>\n" +
"<head>\n" +
"	<title>ADMIN LOGIN</title>\n" +
"	<style type=\"text/css\">\n" +
"	body{\n" +
"		background-image: url(\"bg.jpg\");\n" +
"	}\n" +
"	#login{\n" +
"		border: solid red 4px;\n" +
"		background-color: green;\n" +
"		padding:15px;\n" +
"		width: 40%;\n" +
"		position: relative;\n" +
"		top:200px;\n" +
"		left: 470px;\n" +
"	}\n" +
"	input[type=text]\n" +
"	{\n" +
"    width: 80%;\n" +
"    padding: 12px 20px;\n" +
"    margin: 8px 0;\n" +
"    display: inline-block;\n" +
"    border: 1px solid #ccc;\n" +
"    border-radius: 4px;\n" +
"    box-sizing: border-box;\n" +
"	}\n" +
"	input[type=password] {\n" +
"    width: 80%;\n" +
"    padding: 12px 20px;\n" +
"    margin: 8px 0;\n" +
"    display: inline-block;\n" +
"    border: 1px solid #ccc;\n" +
"    border-radius: 4px;\n" +
"    box-sizing: border-box;\n" +
"    }\n" +
"     #btn{\n" +
"    width: 20%;\n" +
"    background-color: #4CAF50;\n" +
"    color: white;\n" +
"    padding: 14px 20px;\n" +
"    margin: 8px 0;\n" +
"    border: none;\n" +
"    border-radius: 4px;\n" +
"    cursor: pointer;\n" +
"    position: relative;\n" +
"    left: 170px;\n" +
"    top: -30px;\n" +
"}\n" +
"#btn:hover{\n" +
"	background-color: #45a049;\n" +
"}\n" +
"p{\n" +
"	font-size: 20px;\n" +
"	position: relative;\n" +
"	top:40px;\n" +
"	left: 16px;\n" +
"}\n" +
"#pass\n" +
"{ \n" +
"position: relative;\n" +
"top:-50px;\n" +
" }\n" +
" #content\n" +
" {\n" +
"position: relative;\n" +
"left: 60px;\n" +
"top: 10px;\n" +
"}\n" +
"		\n" +
"	</style>\n" +
" \n" +
"	\n" +
"	\n" +
"</head>\n" +
"<body>\n" +
"	<div id=\"login\">\n" +
"		<form action=\"AdminView\">\n" +
"			<div id=\"content\">\n" +
"				<p>ID:</p><br>\n" +
"				<input type=\"text\" name=\"Id\">\n" +
"				<br>\n" +
"				<div id=\"pass\">\n" +
"				<p>PASSWORD</p>\n" +
"				<br>\n" +
"				<input type=\"password\" name=\"password\">\n" +
"			   </div>\n" +
"			</div>\n" +
"			\n" +
"			<input type=\"submit\" id=\"btn\" name=\"LOGIN\">\n" +
"		    \n" +
"		</form>\n" +
"\n" +
"\n" +
"	</div>\n" +
"\n" +
"\n" +
"</body>\n" +
"</html>");
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
        processRequest(request, response);
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
