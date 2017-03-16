package com.digitalriver.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PaymentPageTwo
 */
@WebServlet("/PaymentPageTwo")
public class PaymentPageTwo extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentPageTwo() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        // response.getWriter().append("PaymentPageTwo: ").append(request.getSession().getAttribute("pan") + " is
        // authorized");
        String pan = "";
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("pan")) {
                System.out.println("PaymentPage2 doGet pan: " + cookie.getValue());
                pan = cookie.getValue();
            }
        }

        response.getWriter().append("PaymentPageTwo: ").append(pan + " is authorized");
        response.flushBuffer();
    }

    // /**
    // * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    // */
    // protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
    // IOException {
    // // TODO Auto-generated method stub
    // doGet(request, response);
    // }

}
