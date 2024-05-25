/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAODataAdmin;

import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOImplement.DataAdminInterface;
import perpustakaan.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class DataAdminDAO implements DataAdminInterface {

    Connection connection;

    final String cek = "SELECT * FROM admin WHERE USERNAME=? AND PASSWORD=?";

    public DataAdminDAO() {
        connection = connector.connection();
    }

    @Override
    public void cekLogin(DataAdmin a) {
        String isAuthenticated = "false";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(cek);
            statement.setString(1, a.getUsername());
            statement.setString(2, a.getPassword());
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                isAuthenticated = "true";
                String adminId = rs.getString("ID_ADMIN");
                System.out.println(adminId);
                Halamanutama v = new Halamanutama(adminId);
                v.setVisible(true);
                v.setLocationRelativeTo(null);
               
                throw new SQLException("Berhasil Login");
            } else {
                throw new SQLException("Gagal Login");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return;
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
