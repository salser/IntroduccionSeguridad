/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author paulamoreno
 */
public class Archivo implements Serializable{

    private String titulo;
    private Calendar fecha;
    private int tipo;
    private byte[] dato;
    private byte[] hash;
    private Persona admin;
    private List<Persona> autorizados;

    public Archivo(String titulo, String path, Persona admin, int tipo) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        String[] ids = TimeZone.getAvailableIDs(-8 * 60 * 60 * 1000);
        if (ids.length == 0) {
            System.exit(0);
        }
        System.out.println("Current Time");
        SimpleTimeZone pdt = new SimpleTimeZone(-8 * 60 * 60 * 1000, ids[0]);
        pdt.setStartRule(Calendar.APRIL, 1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);
        pdt.setEndRule(Calendar.OCTOBER, -1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);
        Calendar calendar = new GregorianCalendar(pdt);
        Date trialTime = new Date();
        calendar.setTime(trialTime);
        this.titulo = titulo;
        this.fecha = calendar;
        FileInputStream fileInputStream = null;
        File f = new File(path);
        byte[] bFile = new byte[(int) f.length()];
        try {
            fileInputStream = new FileInputStream(f);
            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");

        SecretKeySpec key = new SecretKeySpec(new String("CualquierCosaCua").getBytes(), "AES");
        IvParameterSpec iv = new IvParameterSpec(new String("VacioVacioVacioV").getBytes());

        c.init(Cipher.ENCRYPT_MODE, key, iv);

        this.dato = c.doFinal(bFile);

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(this.dato);
        this.hash = md.digest();
        this.admin = admin;
        this.tipo = tipo;
        this.autorizados = new ArrayList<Persona>();
    }

    public boolean esIntegro() throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(this.dato);
        byte[] hash = md.digest();
        return Arrays.equals(hash, this.hash);
    }

    public void guardarArchivo() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, FileNotFoundException, IOException {
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");

        SecretKeySpec key = new SecretKeySpec(new String("CualquierCosaCua").getBytes(), "AES");
        IvParameterSpec iv = new IvParameterSpec(new String("VacioVacioVacioV").getBytes());

        c.init(Cipher.DECRYPT_MODE, key, iv);

        byte[] archivo = c.doFinal(this.dato);
        FileOutputStream fileOuputStream = null;
        try {
            fileOuputStream = new FileOutputStream(this.titulo);
            fileOuputStream.write(archivo);
        } finally {
            fileOuputStream.close();
        }

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitutlo(String titulo) {
        this.titulo = titulo;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    public byte[] getDato() {
        return dato;
    }

    public void setDato(byte[] dato) {
        this.dato = dato;
    }

    public byte[] getHash() {
        return hash;
    }

    public void setHash(byte[] hash) {
        this.hash = hash;
    }

    public Persona getAdmin() {
        return admin;
    }

    public void setAdmin(Persona admin) {
        this.admin = admin;
    }

    public List<Persona> getAutorizados() {
        return autorizados;
    }

    public void setAutorizados(List<Persona> autorizados) {
        this.autorizados = autorizados;
    }

    
    
    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

}
