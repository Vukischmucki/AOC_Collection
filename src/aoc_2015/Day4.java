package aoc_2015;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class Day4 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String key = "bgvyzdsv";
        for (int i = 1; ; i++) {
            String input = key + i;
            byte[] bytesOfMessage = input.getBytes(StandardCharsets.UTF_8);
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] thedigest = md.digest(bytesOfMessage);
            BigInteger bigInt = new BigInteger(1, thedigest); //Signum 1 steht für das Die Zahl Positiv ist
            String hashtext = bigInt.toString(16);
            while(hashtext.length() < 32 ){
                hashtext = "0"+hashtext;
            }
            if (hashtext.substring(0, 5).equals("00000")) {
                System.out.println("The lowest positive number is: " + i);
                break;
            }
        }
    }

}

