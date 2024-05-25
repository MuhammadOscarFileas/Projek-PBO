/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.List;
import DAOdatabuku.databukuDAO;
import DAOImplement.databukuimplement;
import model.*;
import perpustakaan.Halamanutama;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author Lenovo
 */
public class databukucontroller {
    Halamanutama frame;
    databukuimplement impldatabuku;
    List<databuku> db;
    
    public databukucontroller(Halamanutama frame){
        this.frame = frame;
        impldatabuku = new databukuDAO();
        db = impldatabuku.getAll();
    }
    
    public void isitabel(){
        db = impldatabuku.getAll();
        modeltabeldatabuku mb = new modeltabeldatabuku(db);
        frame.getTabletampilbuku().setModel(mb);
        
    }
    
    public void insert(){ //disini
        databuku db = new databuku();
        try {
            db.setId_buku(frame.getJtxtidbuku().getText());
            db.setTitle(frame.getJtxttitle().getText());
            db.setAuthor(frame.getJtxtauthor().getText());
            db.setPublisher(frame.getJtxtpublisher().getText());
            db.setYear(frame.getJtxtyear().getText());
            db.setQty(Integer.parseInt(frame.getJtxtqty().getText()));
            db.setKeluar(0);
            impldatabuku.insert(db);
        } catch(Exception error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        
    }
    
    public void update(){
        databuku db = new databuku();
        try {
            db.setId_buku(frame.getJtxtidbuku().getText());
            db.setTitle(frame.getJtxttitle().getText());
            db.setAuthor(frame.getJtxtauthor().getText());
            db.setPublisher(frame.getJtxtpublisher().getText());
            db.setYear(frame.getJtxtyear().getText());
            db.setQty(Integer.parseInt(frame.getJtxtqty().getText()));
            //db.setKeluar(0);
            impldatabuku.update(db);
            throw new Exception("Data berhasil diupdate");
        } catch(Exception error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }
    
    public void delete(){
        try{
            String id_buku = frame.getJtxtidbuku().getText();
            impldatabuku.delete(id_buku);
            throw new Exception("Data berhasil dihapus");
        }catch(Exception error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        //throw new Exception("Data berhasil dihapus");
    }
    
}
