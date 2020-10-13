/**
 * @Author: Kishore Karanam <itsknk>
 * @Date: 2020-05-03T07:38:10+05:30
 * @Project: RSA(Rivest–Shamir–Adleman) Algorithm Implementation
 * @Last modified by: itsknk
 * @Last modified time: 2020-10-13 10:00
 */
import java.util.*;
import java.math.*;
import java.io.*;

public class RSAalg{
	BigInteger p;
	BigInteger q;
	BigInteger n;
	BigInteger z;
	BigInteger e;
	BigInteger d;
	int bitlength = 1024;
	Random r;
	public RSAalg(){
		r = new Random();
		//generates a big ass prime number within the specified length
		p = BigInteger.probablePrime(bitlength, r);
		q = BigInteger.probablePrime(bitlength, r);
		System.out.println("The Value of p: "+p);
		System.out.println("The Value of q: "+q);
		//Calculating N i.e, N=p*q
		n = p.multiply(q);
		//Calculating ϕN i.e, ϕN=(p-1)(q-1)
		z = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
		System.out.println("The Value of N is: " +n);
		System.out.println("The Value of ϕN is: "+z);
		//generates e which will be a relative prime to ϕN
		e = BigInteger.probablePrime(bitlength/2, r);
		//to check if  1<e<ϕ, such that gcd(e,ϕ)=1
 		while (z.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(z) < 0 ) {

			e.add(BigInteger.ONE);

		}
 		//calculating d i.e, d should be = e*dmod(ϕN)=1
		d = e.modInverse(z);
		//Public Key = (e,N)
		System.out.println("Public Key generated: (" +e+","+n+")");
		//Private Key = (d,N)
		System.out.println("Private Key generated: (" +d+","+n+")");
	}
	public RSAalg(BigInteger e, BigInteger d, BigInteger n) {

		this.e = e;

		this.d = d;

		this.n = n;

	}
	public static void main(String [] args) throws IOException {
		RSAalg rsa = new RSAalg();

		DataInputStream in=new DataInputStream(System.in);

		String question ;

		System.out.println("Enter the plain text:");

		question=in.readLine();

		System.out.println("Encrypting String: " + question);

 		//converting the string to Bytes
		System.out.println("String in Bytes: " + bytesToString(question.getBytes()));

		// encrypt

		byte[] encrypted = rsa.encrypt(question.getBytes());

		System.out.println("Encrypted String in Bytes: " + bytesToString(encrypted));

		// decrypt

		byte[] decrypted = rsa.decrypt(encrypted);

		System.out.println("Decrypted String in Bytes: " +  bytesToString(decrypted));

		System.out.println("Decrypted String: " + new String(decrypted));

	}
	public static String bytesToString(byte[] encrypted) {

		String something = "";

		for (byte b : encrypted) {

			something += Byte.toString(b);

		}

		return something;

	}
	//Encryption
	public byte[] encrypt(byte[] msg){
		return (new BigInteger(msg).modPow(e,n).toByteArray()); //to encrypt, msg^e*mod(N)
	}
	//Decryption
	public byte[] decrypt(byte[] msg){
		return (new BigInteger(msg).modPow(d,n).toByteArray()); //to decrypt, msg^d*mod(N)
	}

}
