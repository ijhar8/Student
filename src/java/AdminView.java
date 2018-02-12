/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ijhar-A
 */
public class AdminView extends HttpServlet {

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
            List<Student> list=StudentDAO.getAllStudents(); 
            out.println("<!DOCTYPE html>" +
"<html>" +
"<head>" +
"      <title>Student managment</title>" +
"    <style type='text/css'>" +
"            #head" +
"{" +
"    " +
"    position: relative;" +
"        left:700px;" +
"         width: 250px;" +
"" +
"}" +
"#header{" +
"    width: 160px;" +
"}" +
"" +
"" +
"       #body{ " +
"             background-image:url(bg.jpg);"
                    + "}" +

"#form{" +
"    border-color: red;" +
"    border: solid 5px;" +
"    padding: 35px;" +
"        position: relative;" +
"    width: 100%;" +

"        top:-70px;" +
"        left: 20px;" +
"        background: #99f533;" +
"" +
"}" +
"td{" +
"   " +
"    padding: 12px 20px;"
                    + "width: 150px;\n" +
"    overflow: hidden;\n" +
"    text-overflow: ellipsis;" +
"    margin: 8px 0;" +
"    display: inline-block;" +
"    border: 2px solid red;" +
"    border-radius: 4px;" +
"    box-sizing: border-box;" +
"    font-size: 20px;" +
"    color: red;" +
"}" +
"#table" +
"{" +
"    position: relative;"
                    + " table-layout:fixed;" +
"    left: 30px;" +
"    top:30px;" +
"}" +
"</style>" +
"</head>" +
"<body id='body'>" +
"    <div id='head'>" +
"    <h1 id='header'> IJHAR.org</h1>" +
"    </div>" +
"    <div id='form'>" +
"   " +
"            <table id='table'>" +
"                <tr >" +
"                    <td bgcolor='blue'>Name</td>" +
"                    " +
"                    " +
"                    <td bgcolor='blue'>Roll Number</td>" +
"                    " +
"                   " +
"                    <td bgcolor='blue'>Email</td>" +
"                " +
"                   " +
"                    <td bgcolor='blue'>Class</td>" +
"                " +
"                   " +
"                    <td bgcolor='blue'>Country</td>" +
"                " +
"                    " +
"                " +
"                    <td bgcolor='blue'>Address</td>" +
"                " +
"                    <td bgcolor='blue'>Password</td>" +
"                " +
"                    " +
"             </tr>");
            list.forEach((e)->{
            out.print("<tr>"
                    + "<td>"+e.getName()+"</td>"
                    + "<td>"+e.getRoll_No()+"</td>"
                    + "<td>"+e.getEmail()+"</td>"
                    + "<td>"+e.getClasss()+"</td>"
                     + "<td>"+e.getCountry()+"</td>" 
                     + "<td>"+e.getAddress()+"</td>"
                     + "<td>"+e.getPassword()+"</td>"
                    + "</tr>");
                    });

            out.print("</table>" +


"    </div>" +

"    <script type='text/javascript'>" +
"var arrColor = ['#45c1bf', '#f0593e', '#aeacd4', '#bdd630', '#4479bd', '#f5b11e'];" +
"var header = document.getElementById('header');" +
"//helper function - get dark or lighter color" +
"function LightenDarkenColor(col, amt) {" +
"    var usePound = false;" +
"    if (col[0] == '#') {" +
"      col = col.slice(1);" +
"      usePound = true;" +
"    }" +
"    var num = parseInt(col, 16);" +
"    var r = (num >> 16) + amt;" +
"    if (r > 255) r = 255;" +
"    else if (r < 0) r = 0;" +
"    var b = ((num >> 8) & 0x00FF) + amt;" +
"    if (b > 255) b = 255;" +
"    else if (b < 0) b = 0;" +
"    var g = (num & 0x0000FF) + amt;" +
"    if (g > 255) g = 255;" +
"    else if (g < 0) g = 0;" +
"    return (usePound ? '#' : '') + (g | (b << 8) | (r << 16)).toString(16);" +
"  }" +
"  //random new color" +
" function GetNewColor() {" +
"    var index = Math.floor((Math.random() * 5) + 1);" +
"    return arrColor[index];" +
"  }" +
"  // set new color" +
" function SetNewColor(color) {" +
"    var NewColor = LightenDarkenColor(color, -20);" +
"    header.style.backgroundColor = NewColor;" +
"    //footer.style.opacity = 1.2;" +
"  }" +
"  // on document load function start" +
"  (function() {" +
"    var colorSelected = GetNewColor();" +
"    SetNewColor(colorSelected);" +
"  })();" +
"//change color timer" +
" window.setInterval(function() {" +
" var colorSelected = GetNewColor();" +
" SetNewColor(colorSelected);" +
"}, 200);" +
"</script>" +
"" +
"" +
"</body>" +
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
