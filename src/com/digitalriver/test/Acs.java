package com.digitalriver.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Acs
 */
@WebServlet("/Acs")
public class Acs extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Acs() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        System.out.println("ACS");
        String returnUrl = "";
        String pan = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            System.out.println("Cookies are not empty in ACS");
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName());
                if (cookie.getName().equals("pan")) {
                    System.out.println("Acs doGet pan: " + cookie.getValue());
                    pan = cookie.getValue();
                }
                if (cookie.getName().equals("return_url")) {
                    System.out.println("Acs doGet return_url: " + cookie.getValue());
                    returnUrl = cookie.getValue();
                }
            }
        } else {
            System.out.println("Cookies are empty in ACS");
        }
        response.getWriter().append("Served at: ").append(request.getContextPath());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        response.sendRedirect("http://localhost:8080/ServletTestProject/" + returnUrl);
    }
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    // @Override
    // protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
    // IOException {
    // HttpSession session = request.getSession();
    // System.out.println("Acs doGet " + session.getAttribute("pan"));
    // System.out.println("Acs return url " + session.getAttribute("return_url"));
    // response.getWriter().append("Served at: ").append(request.getContextPath());
    // try {
    // Thread.sleep(2000);
    // } catch (InterruptedException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // response.sendRedirect(request.getContextPath() + session.getAttribute("return_url"));
    // }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    // @Override
    // protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
    // IOException {
    // // TODO Auto-generated method stub
    // doGet(request, response);
    // }

}
