package md5cracker;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Cracker {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String targetHash = "afbb8c417355b2cc9841860abf2fdeef"; // Replace with the target MD5 hash
        int wordLength = 5; // Length of the word to find

        MD5Cracker cracker = new MD5Cracker(targetHash, wordLength);
        cracker.crack();
    }

    private final String targetHash;
    private final int wordLength;

    public MD5Cracker(String targetHash, int wordLength) {
        this.targetHash = targetHash;
        this.wordLength = wordLength;
    }

    public void crack() {
        Thread[] threads = new Thread[26]; // 26 threads for the alphabet
        for (int i = 0; i < 26; i++) {
            char firstChar = (char) ('a' + i);
            threads[i] = new Thread(new BruteForceWorker(firstChar));
            threads[i].start();
        }
    }

    class BruteForceWorker implements Runnable {
        private final char firstChar;

        BruteForceWorker(char firstChar) {
            this.firstChar = firstChar;
        }

        @Override
        public void run() {
            char[] word = new char[wordLength];
            word[0] = firstChar;

            // Brute-force loop
            while (true) {
                String currentWord = new String(word);
                String currentHash = calculateMD5(currentWord);

                if (currentHash.equals(targetHash)) {
                    System.out.println("Found the word: " + currentWord);
                    return;
                }

                // Increment to the next word
                if (!incrementWord(word)) {
                    return; // No more words to try
                }
            }
        }
    }

    private String calculateMD5(String word) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(word.getBytes());
            StringBuilder hash = new StringBuilder();

            for (byte hashByte : hashBytes) {
                hash.append(String.format("%02x", hashByte));
            }

            return hash.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    private boolean incrementWord(char[] word) {
        for (int i = word.length - 1; i >= 0; i--) {
            if (word[i] != 'z') {
                word[i]++;
                return true;
            } else {
                word[i] = 'a';
            }
        }
        return false; // All combinations exhausted
    }
}