/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import business.dao.BookingDAO;
import business.data.Booking;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kingw
 */
@WebServlet(name = "AddBookingServlet", urlPatterns = {"/AddBookingServlet"})
public class AddBookingServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            long uid = Long.parseLong(request.getParameter("uid"));
            long sid = Long.parseLong(request.getParameter("sid"));
            String remark = request.getParameter("remark");
            String status = request.getParameter("status");
            double price = Double.parseDouble(request.getParameter("price"));
            String start = request.getParameter("start");
            String end = request.getParameter("end");
            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy,HH");
            Date bstart = formatter.parse(start);
            Date bend = formatter.parse(end);
            
            Booking booking = new Booking(uid, sid, price, bstart, bend, remark, status);
            BookingDAO bookingDAO = new BookingDAO();
            bookingDAO.newBooking(booking);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddBookingServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Complete!</h1>");
            out.println("</body>");
            out.println("</html>");
        } catch (ParseException ex) {
            Logger.getLogger(AddBookingServlet.class.getName()).log(Level.SEVERE, null, ex);
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
