package org.senolab.sscli.model;

import com.akamai.edgegrid.signer.exceptions.RequestSigningException;
import org.senolab.sscli.service.OpenAPICallService;
import org.senolab.sscli.utils.Instructions;

import java.io.IOException;
import java.text.ParseException;

public class SiteShield {
    private final String SITESHIELD_ENDPOINT_BASE = "/siteshield/v1/maps";
    private OpenAPICallService openAPICallService;

    public SiteShield(String edgerc, String action, String id) throws IOException, RequestSigningException, ParseException {
        String urlPath;
        if(action.equalsIgnoreCase("get-map")) {
            urlPath = SITESHIELD_ENDPOINT_BASE+"/"+id;
            openAPICallService = new OpenAPICallService(edgerc, "GET",urlPath);
        } else if(action.equalsIgnoreCase("ack-map")) {
            urlPath = SITESHIELD_ENDPOINT_BASE+"/"+id+"/acknowledge";
            openAPICallService = new OpenAPICallService(edgerc, "POST", urlPath);
        } else {
            Instructions.printErrorMessage("You specified incorrect command! Please see below instruction for the list of available command");
        }
    }

    public SiteShield(String edgerc, String action) throws IOException, RequestSigningException, ParseException {
        if(!action.equalsIgnoreCase("list-map")) {
            Instructions.printErrorMessage("You specified incorrect command! Please see below instruction for the list of available command");
        } else {
            openAPICallService = new OpenAPICallService(edgerc, "GET", SITESHIELD_ENDPOINT_BASE);
        }
    }

    public void execute() throws IOException, RequestSigningException {
        openAPICallService.execute();
    }


}
