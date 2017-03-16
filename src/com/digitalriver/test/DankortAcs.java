package com.digitalriver.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DankortAcs
 */
@WebServlet("/DankortAcs")
public class DankortAcs extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DankortAcs() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setBufferSize(8192);
        PrintWriter out = response.getWriter();

        // then write the data of the response
        out.println("<html lang=\"en\">"
                + "<head><title>PaymentPageOne</title></head>");

        // then write the data of the response
        out.println("<body  bgcolor=\"#ffffff\">"
                + "<form name=\"AuthenticationRequest\" action=\"https://dankort-acs.test.modirum.com/nets-dankort/req\" method=\"post\" target=\"_top\">"
                + "<h2>DankortAcs</h2>"
                + "<input name=\"MerchantContinueURL\" value=\"https://127.0.0.1:8443/ServletTestProject/DankortContinue\">"
                + "<p></p>"
                + "<input name=\"MerchantDeclineURL\" value=\"https://127.0.0.1:8443/ServletTestProject/DankortDecline\">"
                + "<p></p>"
                + "<input name=\"MerchantTitle\"  value=\"CoffeeHouse\">"
                + "<p></p>"
                + "<input name=\"OrderNo\"  value=\"ABC-123\">"
                + "<p></p>"
                + "<input name=\"MerchantAccount\"  value=\"1978551\">"
                + "<p></p>"
                + "<input name=\"AmountTrn\"  value=\"000000123456\">"
                + "<p></p>"
                + "<input name=\"CurrencyTrn\"  value=\"DKK\">"
                + "<p></p>"
                + "<input name=\"MerchantCountry\"  value=\"208\">"
                + "<p></p>"
                + "<input name=\"MerchantGmtoffset\"  value=\"+1\">"
                + "<p></p>"
                + "<input name=\"MerchantUrl\"  value=\"https://127.0.0.1:8443/ServletTestProject/Merchant\">"
                + "<p></p>"
                + "PAN: <input name=\"PAN\" value=\"k1rn49836mv8m5khqudmt78gjc\">"
                + "<p></p>"
                + "<input name=\"BIN\"  value=\"457104\">"
                + "<p></p>"
                + "<input name=\"Last4\"  value=\"9238\">"
                + "<p></p>"
                + "<input name=\"PurchaseDate\"  value=\"160502 09:13:45\">"
                + "<p></p>"
                + "<input name=\"PurchaseAmount\"  value=\"1234.56 DKK\">"
                + "<p></p>"
                + "<input name=\"PurchaseExponent\"  value=\"2\">"
                + "<p></p>"
                + "<input name=\"PurchaseDescription\"  value=\"Coffee\">"
                + "<p></p>"
                + "<input name=\"ExtID\" value=\"MTIzNDU2Nzg5MEFCQ0RFRkdIaUo=\">"
                + "<p></p>"
                + "<input type=\"submit\" value=\"Authorize\">"
                + "</form>");

        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

}
