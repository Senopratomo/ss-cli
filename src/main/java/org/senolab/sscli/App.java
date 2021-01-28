package org.senolab.sscli;

import com.akamai.edgegrid.signer.exceptions.RequestSigningException;
import com.google.api.client.http.HttpResponseException;
import org.senolab.sscli.model.SiteShield;
import org.senolab.sscli.utils.Instructions;

import java.io.IOException;
import java.text.ParseException;

public class App {

    public static void main(String[] args) {
        try {
            if (args.length == 2) {
                SiteShield siteShield = new SiteShield(args[0], args[1]);
                siteShield.execute();
            } else if(args.length == 3) {
                SiteShield siteShield = new SiteShield(args[0], args[1], args[2]);
                siteShield.execute();
            } else {
                Instructions.printInstructions();
            }
        } catch (ParseException e) {
            System.out.println("Something wrong when parsing JSON body to the request. Details: \n");
            e.printStackTrace();
        } catch (HttpResponseException e) {
            System.out.println("Response code: "+e.getStatusCode());
            System.out.println("Response headers: \n"+e.getHeaders());
            System.out.println("Response body: \n"+e.getContent());
        } catch (IOException e) {
            System.out.println("Something wrong during I/O process. Details:");
            e.printStackTrace();
        } catch (RequestSigningException e) {
            System.out.println("Something wrong during authentication process. Details:");
            e.printStackTrace();
        }
    }



}
