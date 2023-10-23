package hashReversal;

import java.security.MessageDigest;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class ReverseHash {

    private static final String CHAR_OPTIONS = "abcdefghijklmnopqrstuvwxyz";
    private static final String DESIRED_HASH_VALUE = "851ba7daae26beafc7a96a09112e7282";
    private static AtomicBoolean IS_HASH_RESOLVED = new AtomicBoolean(false);
    private static final int PARALLEL_DEPTH_THRESHOLD = 5;  // Use multithreading from this depth onwards
    private static ExecutorService threadPool = Executors.newFixedThreadPool(8); // Increased thread pool size for better parallel processing

    public static void main(String[] args) {
        for (int len = 1; len <= CHAR_OPTIONS.length() && !IS_HASH_RESOLVED.get(); len++) {
            char[] possiblePassword = new char[len];
            searchCombinations(possiblePassword, 0, len);
        }

        threadPool.shutdown();
        try {
            threadPool.awaitTermination(1, TimeUnit.HOURS); // Wait for a maximum of 1 hour
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (!IS_HASH_RESOLVED.get()) {
            System.out.println("Unable to find the original string for the given MD5.");
        }
    }

    public static String computeMd5Hash(String str) {
        try {
            MessageDigest digestEngine = MessageDigest.getInstance("MD5");
            byte[] digestResult = digestEngine.digest(str.getBytes());
            StringBuilder hexValue = new StringBuilder();
            for (byte b : digestResult) {
                hexValue.append(String.format("%02x", b & 0xff));
            }
            return hexValue.toString();
        } catch (Exception e) {
            throw new RuntimeException("Failed to compute MD5 hash.", e);
        }
    }

    private static void searchCombinations(char[] possiblePassword, int idx, int len) {
        if (IS_HASH_RESOLVED.get()) {
            return;
        }

        if (idx == len) {
            threadPool.execute(() -> {
                String attempt = new String(possiblePassword);
                String calculatedHash = computeMd5Hash(attempt);
                if (calculatedHash.equals(DESIRED_HASH_VALUE)) {
                    IS_HASH_RESOLVED.set(true);
                    System.out.println("Found original string: " + attempt);
                }
            });
            return;
        }

        for (int i = 0; i < CHAR_OPTIONS.length(); i++) {
            char[] newPassword = possiblePassword.clone();  // Clone to prevent overlap in parallel executions
            newPassword[idx] = CHAR_OPTIONS.charAt(i);
            if (len >= PARALLEL_DEPTH_THRESHOLD) {
                threadPool.execute(() -> searchCombinations(newPassword, idx + 1, len));
            } else {
                searchCombinations(newPassword, idx + 1, len);
            }
        }
    }
}