package net.lermex.up.level3;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class InfoServlet extends HttpServlet {
    volatile int count; // int counter; не синхронизированная переменная
    List<String> usersList  = new ArrayList<String> ();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.process(request , response);
    }

    @Override
    protected void doHead(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.process(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.process(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.process(request, response);
    }

    private  void process (HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        String result = null;
        String requestURI = request.getRequestURI();
        StringTokenizer st = new StringTokenizer (requestURI, "/");
        ArrayList<String> array = new ArrayList<String>();

        while(st.hasMoreTokens()){
            array.add(st.nextToken());
        }

       switch (array.size()){
            case 1:
                if (array.get(0).equalsIgnoreCase("name")) {
                    printPersonsList (response);
                }
                break;
            case 2:
                result = array.get(1);
                if (array.get(0).equalsIgnoreCase("name")) {
                    usersList.add(result);
                    result = "<br><br><h2>Hi, "+result+"!</h2>";
                    response.getWriter().println(result);
                }
                if (array.get(0).equalsIgnoreCase("math")) {
                    try {
                        int num = Integer.parseInt(result);
                        result = "<br><br> math result: " + num*num;
                        response.getWriter().println(result);
                    }catch (NumberFormatException e){
                        response.getWriter().println("Number Format Exception");
                    }
                }
                break;
            default:
                printCurrentDate (response);
                break;
        }
    }

    private void printCurrentDate (HttpServletResponse response) throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String result =  "<h1>Current date: ".concat( dateFormat.format( new Date()).concat("</h1>"));
        response.getWriter().println(result);
    }

    private void printPersonsList (HttpServletResponse response) throws IOException {
        response.getWriter().println("<h1>List of visitors".concat((this.usersList.isEmpty() ? " is empty" : ":")).concat("</h1>"));
        for (int i = 0; i <this.usersList.size(); i++){
            response.getWriter().println(i+1 +". "+  this.usersList.get(i)+ "<br>" );
        }
    }

}
