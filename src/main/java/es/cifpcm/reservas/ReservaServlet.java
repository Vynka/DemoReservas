package es.cifpcm.reservas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 2dawb
 */
@WebServlet(urlPatterns = {"/reserva"})
public class ReservaServlet extends HttpServlet {
    
    private final DatabaseConfig dbCfg = new DatabaseConfig();

    @Override
    public void init() throws ServletException {
        try {
            super.init(); //To change body of generated methods, choose Tools | Templates.
            ResourceBundle rb = ResourceBundle.getBundle("reserva");
            dbCfg.setDriverClassName(rb.getString("database.driver"));
            dbCfg.setDatabaseUrl(rb.getString("database.url"));
            dbCfg.setDatabaseUser(rb.getString("database.user"));
            dbCfg.setDatabasePassword(rb.getString("database.password"));

            Class.forName(dbCfg.getDriverClassName());
        } catch (ClassNotFoundException ex) {
            
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int code = parseInt(request.getParameter("codeHotel"));
        int nights = 0;
        if (!request.getParameter("nights").equals("")){
            nights = parseInt(request.getParameter("nights"));
        }
        else{
            String error="Número de noches no válido.";
            getServletContext().getRequestDispatcher("/error.jsp?error="+error).forward(request, response);
        }
        Reserva reserva = new Reserva(code,nights);
        
        try {
            if(getPrice(reserva,code,nights)){
                getServletContext().getRequestDispatcher("/success.jsp?precio="+reserva.getTotal()).forward(request, response);
            }
            else{
                String error="No se ha podido conectar con la base de datos.";
                getServletContext().getRequestDispatcher("/error.jsp?error="+error).forward(request, response);
            }
        } catch (SQLException ex) {
            getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
            Logger.getLogger(ReservaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private boolean getPrice(Reserva reserva, int code, int noches) throws SQLException{
        final String query = "select precio from precios_habitacion where cod_hotel='hotel"+code+"';";
        
        try (Connection conn = DriverManager.getConnection(dbCfg.getDatabaseUrl(), dbCfg.getDatabaseUser(), dbCfg.getDatabasePassword());
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.executeQuery();
            ResultSet res = pstmt.getResultSet();
            res.first();
            int precio = res.getInt(1);
            reserva.setTotal(precio*noches);
            return true;
        } catch(Exception ex){
            return false;
        }
    }
}