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
public class StudentView extends HttpServlet {

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
            String roll_no=request.getParameter("Roll_No");
            Student s=StudentDAO.getStudent(roll_no);
            out.print("<!DOCTYPE html>" +
"<html>" +
"<head>" +
"<title>Student View</title>" +
"  <style type='text/css'>" +
"  body{" +
"      background-image: url(bg.jpg);" +
"       }" +
"       #button {" +
"    width: 100px;" +
"    background-color: #4CAF50;" +
"    color: white;" +
"    padding: 14px 20px;" +
"    margin: 8px 0;" +
"    border: none;" +
"    border-radius: 4px;" +
"    cursor: pointer;" +
"    position: relative;" +
"    left: -4px;" +
"    top: -270px;" +
"" +
"}" +
"" +
"  td{" +
"  font-size: 20px;" +
"  width: 20%;" +
"    background-color: #4CAF50;" +
"    color: white;" +
"    padding: 14px 20px;" +
"    margin: 8px 0;" +
"    border: none;" +
"    border-radius: 4px;" +
"    cursor: pointer;" +
"    position: relative;" +
"    left: 140px;" +
"    top: 15px;" +
"          }" +
"#table" +
"{" +
"  position: relative;" +
"  left: 30px;" +
"  top: 30px;" +
"}" +
" #head" +
"{" +
"  " +
"        position: relative;" +
"        left:1px;" +
"         width: 250px;" +
"         top: -15px;" +
"" +
"}" +
"#header{" +
"    width: 120%;" +
"}" +
"#back{" +
"       width: 100%;" +
"       height: 45px;" +
"" +
"       background-color: red;" +
"     }" +
"" +
"    " +
"" +
"  </style>" +
"  " +
"</head>" +
"<body>" +
"  <div id='back'>" +
"    <marquee >" +
" <div id='head'>" +
"  <h1 id='header'>Welcome "+s.getName()+"</h1>" +
"    </div>" +
"  </marquee>" +
"  </div>" +
"  " +
"    <table id='table'>" +
"      <tr>" +
"        <td>Name</td>" +
" <td>"+s.getName()+"</td> " +
"      </tr>" +
"      <tr>" +
"        <td>Roll No</td>" +
"        <td>"+s.getRoll_No()+"</td>  " +
"      </tr>" +
"      <tr>" +
"        <td>Email</td>" +
"        <td>"+s.getEmail()+"</td>  " +
"      </tr>" +
"      <tr>" +
"        <td>Class</td>" +
"        <td>"+s.getClass()+"</td>  " +
"      </tr>"
        + "<tr>" +
"        <td>Address</td>" +
"        <td>"+s.getAddress()+"</td>  " +
"      </tr>" +
"      <tr>" +
"        <td>Country</td>" +
"        <td>"+s.getCountry()+"</td>  " +
"      </tr>" +

"    </table>" +

        " <script type=\"text/javascript\">" +
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
" " +
"" +
"" +
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
