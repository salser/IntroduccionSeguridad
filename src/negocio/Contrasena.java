/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.GregorianCalendar;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Henry Salazar Serrano
 */
public class Contrasena implements Serializable {
    private GregorianCalendar fechaRegistro;
    private GregorianCalendar fechaInicioContraseña;

    public Contrasena(String contraseniaAlpha,String usuario) throws NoSuchAlgorithmException, FileNotFoundException, IOException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        this.fechaRegistro = new GregorianCalendar();
        this.fechaInicioContraseña = new GregorianCalendar();
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte [] input=contraseniaAlpha.getBytes();
        md.update(input);
        byte [] hash=md.digest();
        String contraHash = new String (hash);
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec key = new SecretKeySpec(new String("CualquierCosaCua").getBytes(),"AES");
        IvParameterSpec iv = new IvParameterSpec(new String ("VacioVacioVacioV").getBytes());
        c.init(Cipher.ENCRYPT_MODE, key , iv);
        byte [] encriptado = c.doFinal(hash);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < encriptado.length; i++) {
          sb.append(Integer.toString((encriptado[i] & 0xff) + 0x100, 16).substring(1));
        }
        String texto =usuario.trim()+" "+sb.toString();
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("contrasenias.txt",true)));
            out.append(texto+"\r\n");
            out.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    
    public static boolean verificar(String usuario,String contraseniaAlpha) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException
    {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte [] input=contraseniaAlpha.getBytes();
        md.update(input);
        byte [] hash=md.digest();
        String contraHash = new String (hash);
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec key = new SecretKeySpec(new String("CualquierCosaCua").getBytes(),"AES");
        IvParameterSpec iv = new IvParameterSpec(new String ("VacioVacioVacioV").getBytes());
        c.init(Cipher.ENCRYPT_MODE, key , iv);
        byte [] encriptado = c.doFinal(hash);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < encriptado.length; i++) {
          sb.append(Integer.toString((encriptado[i] & 0xff) + 0x100, 16).substring(1));
        }
        String texto =usuario.trim()+" "+sb.toString();
        try {
            InputStream fis = new FileInputStream("contrasenias.txt");
            InputStreamReader isr = new InputStreamReader(fis,Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);
            String s;
            while ((s=br.readLine())!=null)
            {
                if (s.equalsIgnoreCase(texto))
                    return true;
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }
    
    public GregorianCalendar getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(GregorianCalendar fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public GregorianCalendar getFechaInicioContraseña() {
        return fechaInicioContraseña;
    }

    public void setFechaInicioContraseña(GregorianCalendar fechaInicioContraseña) {
        this.fechaInicioContraseña = fechaInicioContraseña;
    }
    
    
}
