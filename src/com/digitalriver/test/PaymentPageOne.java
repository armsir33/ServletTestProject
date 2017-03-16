package com.digitalriver.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PaymentPageOne
 */
@WebServlet("/PaymentPageOne")
public class PaymentPageOne extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentPageOne() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setBufferSize(8192);
        PrintWriter out = response.getWriter();

        // then write the data of the response
        out.println("<html lang=\"en\">"
                + "<head><title>PaymentPageOne</title></head>");

        // then write the data of the response
        out.println("<body  bgcolor=\"#ffffff\">"
                + "<form method=\"post\">"
                + "<h2>PaymentPageOne</h2>"
                + "PAN: <input type=\"text\" name=\"pan\" size=\"15\">"
                + "<p></p>"
                + "<input type=\"submit\" value=\"Authorize\">"
                + "</form>");

        // String username = request.getParameter("pan");
        // if (username != null && username.length() > 0) {
        // RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/response");
        //
        // if (dispatcher != null) {
        // dispatcher.include(request, response);
        // }
        // }
        out.println("</body></html>");
        out.close();
    }

    // @Override
    // protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
    // IOException {
    // String pan = request.getParameter("pan");
    // System.out.println("PaymentPageOne doPost pan " + pan);
    // HttpSession session = request.getSession();
    // session.setAttribute("pan", pan);
    // session.setAttribute("return_url", "/PaymentPageTwo");
    // response.sendRedirect(request.getContextPath() + "/Acs");
    // }

    // @Override
    // protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
    // IOException {
    // String pan = request.getParameter("pan");
    // System.out.println("PaymentPageOne doPost pan " + pan);
    // HttpSession session = request.getSession();
    // session.setAttribute("pan", pan);
    // session.setAttribute("return_url", "/PaymentPageTwo");
    // response.sendRedirect("http://127.0.0.1:8080/ServletTestAcs/Acs2");
    // }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        String pan = request.getParameter("pan");
        System.out.println("PaymentPageOne doPost pan " + pan);
        Cookie panCookie = new Cookie("pan", request.getParameter("pan"));
        panCookie.setMaxAge(30);
        panCookie.setPath("/ServletTestAcs");
        response.addCookie(panCookie);

        Cookie returnUrlCookie = new Cookie("return_url", "/PaymentPageTwo");
        returnUrlCookie.setMaxAge(30);
        returnUrlCookie.setPath("/ServletTestAcs");
        response.addCookie(returnUrlCookie);
        response.sendRedirect("http://127.0.0.1:8080/ServletTestAcs/Acs2");
        // response.sendRedirect("http://127.0.0.1:8080/ServletTestProject/Acs");
        response.flushBuffer();
    }

}
