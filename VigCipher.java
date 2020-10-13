/**
 * @Author: Kishore Karanam <itsknk>
 * @Date: 2020-10-13 09:20
 * @Project: Vigenere Cipher Implementation
 * @Last modified by: itsknk
 * @Last modified time: 2020-10-13 09:50
 */
import java.util.*;
public class VigCipher
{
    public static String encrypt(String message, String keyword)
    {
        char msg[] = message.toCharArray();
        char key[] = keyword.toCharArray();
        int msgLength = msg.length;
        char newKey[] = new char[msgLength];
        char encryptedMessage[] = new char[msgLength];
        //generates a new key in cyclic manner equal to length of plain text.
        for(int i=0, j=0; i<msgLength; i++, j++) 
        {
            if(j == key.length)
                j=0;
            newKey[i] = key[j];
        }
        //encryption
        for(int i=0; i<msgLength; i++)
        {
            encryptedMessage[i] = (char) (((msg[i] + newKey[i]) % 26) + 'A');
        }
        return String.valueOf(encryptedMessage);
    }
    public static String decrypt(String message, String keyword)
    {
        char msg[] = message.toCharArray();
        char key[] = keyword.toCharArray();
        int msgLength = msg.length;
        char newKey[] = new char[msgLength];
        char decryptedMessage[] = new char[msgLength];
        //generates a new key in cyclic manner equal to length of plain text.
        for(int i=0, j=0; i<msgLength; i++, j++) 
        {
            if(j == key.length)
                j=0;
            newKey[i] = key[j];
        }
        //decryption
        for(int i=0; i<msgLength; i++)
        {
            decryptedMessage[i] = (char) ((((msg[i] - newKey[i]) + 26) % 26) + 'A');
        }
        return String.valueOf(decryptedMessage);
    }
    public static void main(String args[])
    {
        String plainText, keyword, cipherText;
        Scanner sc = new Scanner(System.in);
        plainText = sc.nextLine();
        keyword = sc.nextLine();
        System.out.println("Plain Text: " + plainText);
        cipherText = encrypt(plainText, keyword);
        System.out.println("Encrypted Text: " + cipherText);
        System.out.println("Decrypted Text: " + decrypt(cipherText, keyword));
    }
}
