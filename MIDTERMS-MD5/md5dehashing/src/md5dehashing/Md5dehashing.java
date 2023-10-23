package md5dehashing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class Md5dehashing {
    private static final String CHARSET = "abcdefghijklmnopqrstuvwxyz";
    private static final String TARGET_HASH = "5d41402abc4b2a76b9719d911017c592";
    private static AtomicBoolean MATCH_FOUND = new AtomicBoolean(false);

    public static void main(String[] args) throws NoSuchAlgorithmException {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (int length = 1; length <= CHARSET.length(); length++) {
            char[] password = new char[length];
            if (bruteForce(password, 0, length, executor)) {
                break;
            }
        }

        executor.shutdown();

        if (!MATCH_FOUND.get()) {
            System.out.println("The MD5 cannot be dehashed.");
        }
    }

    public static String getMd5(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(input.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : messageDigest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }

    private static boolean bruteForce(char[] password, int position, int length, ExecutorService executor) {
        if (MATCH_FOUND.get()) {
            return true;
        }

        if (position == length) {
            String candidate = new String(password);
            try {
                String hash = getMd5(candidate);
                if (hash.equals(TARGET_HASH)) {
                    MATCH_FOUND.set(true);
                    System.out.println("The dehashed MD5: " + candidate);
                    return true;
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            return false;
        }

        for (int i = 0; i < CHARSET.length(); i++) {
            password[position] = CHARSET.charAt(i);
            if (bruteForce(password, position + 1, length, executor)) {
                return true;
            }
        }

        return false;
    }
}