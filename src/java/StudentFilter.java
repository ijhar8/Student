
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author Ijhar-A
 */
public class StudentFilter implements Filter {
@Override
public void init(FilterConfig arg0) throws ServletException {}  
      
@Override
public void doFilter(ServletRequest req, ServletResponse resp,  
        FilterChain chain) throws IOException, ServletException {  
      resp.setContentType("text/html;charset=UTF-8");     
    PrintWriter out=resp.getWriter(); 
     out.print("<style>h1{\n" +
"	font-size: 20px;\n"
             + "background-color:red;"
             + "width:40%"
              +
"	position: relative;\n" +
"	top:40px;\n" +
"	left: 16px;\n" +
"}</style>");
    LoginService l=new LoginService();
    String password=req.getParameter("password");
    String rollno=req.getParameter("Roll_No");
    boolean b=l.loginCheck(rollno, password);
    
    
    if(b){  
    chain.doFilter(req, resp);//sends request to next resource  
    }  
    else{  
    out.print("<h1>username or password error!</h1>"+b);  
    RequestDispatcher rd=req.getRequestDispatcher("StudentLogin");  
    rd.include(req, resp);  
    }  
          
}  
@Override
    public void destroy() {}  
}
