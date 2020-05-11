package bakery.hashing;

import java.security.*;

public class HashPassword {


    private final char[] hexArray = "0123456789ABCDEF".toCharArray();

    public HashPassword() {}

    public String generateHash(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.reset();
            String salt = bytesToStringHex(createSalt());
            password = salt+password+"pepper";
            byte[] hash = digest.digest(password.getBytes());
            return salt+bytesToStringHex(hash);
        } catch (NoSuchAlgorithmException e) {
            System.err.println(e);
        }
        return "password";
    }

    private String bytesToStringHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length*2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j*2] = hexArray[v >>> 4];
            hexChars[j*2+1] = hexArray[v & 0x0f];
        }
        return new String(hexChars);
    }

    private byte[] createSalt() {
        byte[] bytes = new byte[20];
        SecureRandom random = new SecureRandom();
        random.nextBytes(bytes);
        return bytes;
    }

    private String getSalt(String hash) {
        return hash.substring(0, 40);
    }

    public boolean checkPassword(String password, String hash) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.reset();
            String salt = getSalt(hash);
            password = salt+password+"pepper";
            byte[] newHash = digest.digest(password.getBytes());
            return (salt+bytesToStringHex(newHash)).equals(hash);
        } catch (NoSuchAlgorithmException e) {
            System.err.println(e);
        }
        return false;
    }
}
