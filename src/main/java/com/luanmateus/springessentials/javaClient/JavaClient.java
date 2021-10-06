package com.luanmateus.springessentials.javaClient;

import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JavaClient {
    public static void main(String[] args) {
        final String username = "Patrick";
        final String password = "root";

        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL("http://localhost:8080/api/v1/protected/students/1");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.addRequestProperty("Authorization", "Basic " + encodeUsernameAndPassword(username, password));

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuilder jsonSB = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                jsonSB.append(line);
            }

            System.out.println(jsonSB.toString());
        } catch (Exception e) {
            System.out.println(e);

        } finally {
            IOUtils.closeQuietly(reader);
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private static String encodeUsernameAndPassword(String username, String password) {
        String usernameAndPassword = username + ":" + password;

        return new String(Base64.encodeBase64(usernameAndPassword.getBytes()));
    }
}
