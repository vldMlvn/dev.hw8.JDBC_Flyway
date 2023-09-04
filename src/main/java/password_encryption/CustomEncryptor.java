package password_encryption;

public class CustomEncryptor {
    private CustomEncryptor() {
    }

    public static String encrypt(String password) {
        StringBuilder st = new StringBuilder();
        int key = 5;
        st.append("0xE");

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            int encryptedChar = c + key;
            st.append(encryptedChar).append("00x");
        }

        st.append("Ww");
        return st.toString();
    }

    public static String decrypt(String encrypted) {
        StringBuilder decrypted = new StringBuilder();
        encrypted = encrypted.replace("0xE", "")
                .replace("00x", " ")
                .replace("Ww", " ");
        int key = 5;

        String[] encryptedValues = encrypted.trim().split(" ");

        for (int i = 0; i < encryptedValues.length; i++) {
            int encryptedValue = Integer.parseInt(encryptedValues[i]);
            char decryptedChar = (char) (encryptedValue - key);
            decrypted.append(decryptedChar);
        }

        return decrypted.toString();
    }
}