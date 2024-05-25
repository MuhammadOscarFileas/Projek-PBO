/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.List;
import DAODataAdmin.DataAdminDAO;
import DAOImplement.DataAdminInterface;
import javax.swing.JOptionPane;
import model.*;
import perpustakaan.MainView;
/**
 *
 * @author HP
 */
public class DataAdminController {
    MainView frame;
    DataAdminInterface ImplDataAdmin;
    List<DataAdmin> da;

    public DataAdminController(MainView frame) {
        this.frame = frame;
        ImplDataAdmin = new DataAdminDAO();
    }
    
    public void cekLogin() {
        DataAdmin ds = new DataAdmin();
        ds.setUsername(frame.getTxtusername().getText());  
        ds.setPassword(frame.getTxtpassword().getText());
        ImplDataAdmin.cekLogin(ds);
    }
}
