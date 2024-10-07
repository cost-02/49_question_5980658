package com.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashHelper {

    public static String sha1(String stringToHash) {
        try {
            // Crea un oggetto MessageDigest per SHA-1
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            // Converte la stringa in un array di byte usando UTF-8
            byte[] bytes = stringToHash.getBytes("UTF-8");
            // Aggiorna il digest con l'input
            digest.update(bytes, 0, bytes.length);
            // Completa il calcolo dell'hash
            bytes = digest.digest();
            // Converti l'hash in esadecimale
            return bytesToHex(bytes);
        } catch (NoSuchAlgorithmException | java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Metodo per convertire un array di byte in una stringa esadecimale
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String stringToHash = "Hello World";
        String hashedString = sha1(stringToHash);
        System.out.println("SHA-1 Hash: " + hashedString);
    }
}
