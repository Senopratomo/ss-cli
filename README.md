<h3>SiteShield CLI</h3>
<hr>
<p>
This is a simple CLI wrapper to manage Akamai SiteShield.
The purpose is for to show sample implementation on how to use edgegrid JAVA to make call to Siteshield OPEN API - 
https://developers.akamai.com/api/cloud_security/site_shield/v1.html
</p>

<h5>Prerequisite</h5>
<ul>
    <li>Java installed in the local machine (JAVA 8 and above. note: I use JAVA 11 in this sample, but if you have different JAVA version locally, change the "properties" tag in pom.xml and rebuild using "mvn clean install"</li>
    <li>Maven installed in local (Optional - if you want to build from source)</li>
</ul>
<br>
<h5>Build from source</h5>
<ul>
    <li>Clone this project</li>
    <li>Go to that root dir of the project</li>
    <li>Run: mvn clean install</li>
    <li>It will produce file siteshield.jar inside "target" folder</li>
</ul>
<br>
<h5>Download the pre-built JAR</h5>
<ul>
    <li>Go to "Release" section of this Github repo<</li>
    <li>Download the latest version</li>
</ul>
<br>
<h5>How to use the CLI</h5>
<p>Siteshield CLI takes 2 - 3 arguments separated by single space. These arguments are:</p>
<ul>
   <li>
    args[0] is location of .edgerc file.<br>
    This file contain Akamai API client credentials (client token,
    access token, secret, host, and max body size) which necessary for EdgeGrid lib to authenticate<br>
    Content of this .edgerc file is in this format:<br>
    host = akab-xxxxx.luna.akamaiapis.net<br>
    client_token = akab-xxxxx <br>
    client_secret = xxxxx<br>
    access_token = xxxx
   </li>
   <li>args[1] is action which you like to perform - options are: 'list-map', 'get-map', and 'ack-map'</li>
   <li>args[2] is site shield map id (required only for 'get-map' and 'ack-map' action)</li>
</ul>
<br>
<h5>Sample Usage</h5>
<ol>
    <li>java -jar siteshield.jar ~/.edgerc list-map</li>
    <li>java -jar siteshield.jar ~/.edgerc get-map 9999</li>
    <li>java -jar siteshield.jar ~/.edgerc ack-map 9999</li>   
</ol>
