package org.senolab.sscli.utils;

public class Instructions {
    public static void printInstructions() {
        System.out.println("Siteshield CLI takes 2 - 3 arguments separated by single space. These arguments are: \n" +
                "args[0] is location of .edgerc file. " +
                "This file contain Akamai API client credentials (client token, \n" +
                "access token, secret, host, and max body size) which necessary for EdgeGrid lib \n" +
                "sample: \n" +
                "host = akab-xxxxx.luna.akamaiapis.net \n" +
                "client_token = akab-xxxxx \n" +
                "client_secret = xxxxx \n" +
                "access_token = xxxx \n" +
                "\n" +
                "args[1] is action which you like to perform - options are: 'list-map', 'get-map', and 'ack-map'\n" +
                "args[2] is site shield map id (required only for 'get-map' and 'ack-map' action) \n" +
                "\n" +
                "Example:\n" +
                "1) java -jar siteshield.jar ~/.edgerc list-map\n" +
                "2) java -jar siteshield.jar ~/.edgerc get-map 1500\n" +
                "3) java -jar siteshield.jar ~/.edgerc ack-map 1500\n");
    }

    public static void printErrorMessage(String msg) {
        System.out.println(msg+"\n");
        printInstructions();
        System.exit(0);
    }
}
