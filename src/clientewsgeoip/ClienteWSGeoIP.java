/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientewsgeoip;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;


/**
 *
 * @author entrar
 */
public class ClienteWSGeoIP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException, Exception  {
        // TODO code application logic here
        String s="http://www.webservicex.net/geoipservice.asmx/GetGeoIPContext";
        URL url=new URL(s);
        Scanner scan=new Scanner(url.openStream());
        String source=new String();
        while(scan.hasNext()){
            source+=scan.nextLine();
        }
        System.out.println(source);
        Serializer serializer = new Persister();
        GetGeoIPContextResult elements = new GetGeoIPContextResult();
        serializer.read(elements, source);
        
        System.out.println(elements.getIP());
        System.out.println(elements.getReturnCode());
        System.out.println(elements.getReturnCodeDetails());
        System.out.println(elements.getCountryName());
        System.out.println(elements.getCountryCode());
        
        
    }


    
}
