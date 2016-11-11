/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alumno
 */
public class AreaServlet extends HttpServlet {

    @EJB
    private service.CalculadoraServiceLocal calculadoraService; // "Insert Code > Call Enterprise Bean"

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
        String tipoOperacion = request.getParameter("area");

        try {
            //Esto no hace falta ya que tenemos el @EJB
            //InitialContext jndi = new InitialContext();
            //calculadoraService = (CalculadoraServiceLocal) jndi.lookup("java:global/Calculadora-EA-ear/Calculadora-EA-ejb-1.0-SNAPSHOT/CalculadoraService!service.CalculadoraServiceLocal");
            double area = 0;
            
            switch (tipoOperacion) {
                case "circulo":
                    double radio = Double.parseDouble(request.getParameter("radio"));
                    area = calculadoraService.calculaAreaCirculo(radio);
                    break;
                case "cuadrado":
                    double lado = Double.parseDouble(request.getParameter("lado"));
                    area = calculadoraService.calcularAreaCuadrado(lado);
                    break;
                case "triangulo":
                    double altura = Double.parseDouble(request.getParameter("altura"));
                    double base = Double.parseDouble(request.getParameter("base"));
                    area = calculadoraService.calculaAreaTriangulo(base, altura);
                    break;
                case "trapecio":
                    double base1 = Double.parseDouble(request.getParameter("base1"));
                    double base2 = Double.parseDouble(request.getParameter("base2"));
                    double alturaT = Double.parseDouble(request.getParameter("altura"));
                    area = calculadoraService.calculaAreaTrapecio(alturaT, base1, base2);
                    break;
            }
            
            //¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡EL RUN SE HACE EN EL EAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            
            //Cookie _myCookie = new Cookie("area", String.valueOf(area));
            //_myCookie.setMaxAge(1*60*60);
            //response.addCookie(_myCookie);
            
            request.setAttribute("area", area);
            request.setAttribute("formula", tipoOperacion);
            RequestDispatcher rd = request.getRequestDispatcher("respuesta.jsp");
            rd.forward(request, response);
        } catch (NumberFormatException | ServletException | IOException ex) {
            Logger.getLogger(AreaServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("EL RUN SE HACE EN EL EAR!!!!!!!");
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
