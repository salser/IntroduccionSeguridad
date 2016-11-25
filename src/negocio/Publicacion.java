/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
public class Publicacion implements Serializable {

    private String titulo;
    private byte[] textoCifrado;
    private Calendar fechaCreacion;
    private Persona admin;
    private byte[] hash;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() throws Exception {

        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec key = new SecretKeySpec(new String("CualquierCosaCua").getBytes(), "AES");
        IvParameterSpec iv = new IvParameterSpec(new String("VacioVacioVacioV").getBytes());
        c.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] descifrado = c.doFinal(this.textoCifrado);
        String texto = new String(descifrado);
        System.out.println(texto);
        return texto;

    }

    public void setTexto(byte[] texto) {
        this.textoCifrado = texto;
    }

    public Calendar getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Calendar fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Persona getAdmin() {
        return admin;
    }

    public void setAdmin(Persona admin) {
        this.admin = admin;
    }

    public Publicacion(String titulo, String texto, Persona admin) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] input = texto.getBytes();
        md.update(input);
        byte[] hash = md.digest();
        this.hash = hash;
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec key = new SecretKeySpec(new String("CualquierCosaCua").getBytes(), "AES");
        IvParameterSpec iv = new IvParameterSpec(new String("VacioVacioVacioV").getBytes());
        c.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] encriptado = c.doFinal(input);

        this.textoCifrado = encriptado;
        this.admin = admin;
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
        this.fechaCreacion = calendar;
        this.titulo = titulo;

    }

    public boolean comparar(byte[] p) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(p);
        byte[] hash = md.digest();
        return Arrays.equals(hash, this.hash);

    }


}
