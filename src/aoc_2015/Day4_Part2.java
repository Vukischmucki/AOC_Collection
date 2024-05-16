package aoc_2015;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day4_Part2 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String key = "bgvyzdsv";
        for (int i = 1; ; i++) {
            String input = key + i;
            byte[] bytesOfMessage = input.getBytes(StandardCharsets.UTF_8);
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] thedigest = md.digest(bytesOfMessage);
            BigInteger bigInt = new BigInteger(1, thedigest);
            String hashtext = bigInt.toString(16);
            while(hashtext.length() < 32 ){
                hashtext = "0"+hashtext;
            }
            if (hashtext.substring(0, 6).equals("000000")) {
                System.out.println("The lowest positive number is: " + i);
                break;
            }
        }
    }
}

