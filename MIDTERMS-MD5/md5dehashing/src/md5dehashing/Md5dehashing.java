package md5dehashing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5dehashing {
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String TARGET_HASH = "2433f6a533fb465ef55f459b4a89c68a";
    private static final int MAX_STRING_LENGTH = 8;
    private static final int NUM_THREADS = 26;
    private static final int[] indexes = {0, -1, -1, -1, -1, -1, -1, -1, -1};
    private static int length = 1;
    private static final int charArrSize = CHARACTERS.length();

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[NUM_THREADS];

        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i] = new StringGeneratorThread();
            threads[i].start();
        }

        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i].join();
        }
    }

    private static class StringGeneratorThread extends Thread {
        @Override
        public void run() {
            try {
                String randomString;
                String randomHash;

                do {
                    randomString = generateString();
                    randomHash = calculateMD5(randomString);
                } while (!randomHash.equals(TARGET_HASH));

                if (randomHash.equals(TARGET_HASH)) {
                    System.out.println("The dehashed MD5: " + randomString);
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
    }

    private static String generateString() {
        StringBuilder stringBuilder = new StringBuilder(length);

        for (int i = 0; indexes[i] != -1; i++) {
            char charAtIndex = CHARACTERS.charAt(indexes[i] % charArrSize);
            stringBuilder.append(charAtIndex);
        }

        indexes[0]++;
        for (int i = 0; i < indexes.length - 1; i++) {
            if (indexes[i] >= charArrSize) {
                indexes[i] = 0;
                indexes[i + 1]++;
                if (length < i + 1) {
                    length++;
                }
            }
        }

        return stringBuilder.toString();
    }

    private static String calculateMD5(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(input.getBytes());
        byte[] hashBytes = md.digest();

        StringBuilder hash = new StringBuilder();
        for (byte hashByte : hashBytes) {
            hash.append(String.format("%02x", hashByte));
        }

        return hash.toString();
    }
}