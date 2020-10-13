/**
 * @Author: Kishore Karanam <itsknk>
 * @Date: 2020-05-03T10:35:16+05:30
 * @Project: Diffie–Hellman key exchange Algorithm Implementation
 * @Last modified by: itsknk
 * @Last modified time: 2020-05-03T10:36:26+05:30
 */
 import java.util.*;
 import java.math.*;
 public class DHalg {
     public static void main(String[] args) {
          int n = 0;
         Random rand = new Random(); // generate a random number
         n = rand.nextInt(1000) + 1;

         while (!isPrime(n)) {
             n = rand.nextInt(1000) + 1;

         }
         System.out.println("The value of P generated is: "+n);
         System.out.println("The value of g which is the primitive root of P is: "+findPrimitive(n));
         Scanner sc=new Scanner(System.in);
         System.out.println("Choose 1st Private key of user A");
         int a=sc.nextInt();
         System.out.println("Choose 2nd Private key of user B");
         int b=sc.nextInt();
         int pka = (int)Math.pow(findPrimitive(n),a)%n;
         System.out.println("The public key of A is: "+pka);
         int pkb = (int)Math.pow(findPrimitive(n),b)%n;
         System.out.println("The public key of B is: "+pkb);
         int ska = (int)Math.pow(pkb,a)%n;
         System.out.println("The required secret key of A is: "+ska);
         int skb = (int)Math.pow(pka,b)%n;
         System.out.println("The required secret key of B is: "+skb);
         if(ska == skb)
             System.out.println("Secret keys matched, A and B can communicate");
         else
             System.out.println("Secret keys won't match, A and B can't communicate");

     }

     //fucntion to check prime
     private static boolean isPrime(int inputNum){
         if (inputNum <= 3 || inputNum % 2 == 0)
             return inputNum == 2 || inputNum == 3; //this returns false if number is <=1 & true if number = 2 or 3
         int divisor = 3;
         while ((divisor <= Math.sqrt(inputNum)) && (inputNum % divisor != 0))
             divisor += 2; //iterates through all possible divisors
         return inputNum % divisor != 0; //returns true/false
     }
     static int gcd(int e, int z)
     {
       if(e==0)
        return z;
       else
        return gcd(z%e,e);
     }
      static int power(int x, int y, int p)
     {
         int res = 1;     // Initialize result

         x = x % p; // Update x if it is more than or
         // equal to p

         while (y > 0)
         {
             // If y is odd, multiply x with result
             if (y % 2 == 1)
             {
                 res = (res * x) % p;
             }

             // y must be even now
             y = y >> 1; // y = y/2
             x = (x * x) % p;
         }
         return res;
     }

     // Utility function to store prime factors of a number
     static void findPrimefactors(HashSet<Integer> s, int n)
     {
         // Print the number of 2s that divide n
         while (n % 2 == 0)
         {
             s.add(2);
             n = n / 2;
         }

         // n must be odd at this point. So we can skip
         // one element (Note i = i +2)
         for (int i = 3; i <= Math.sqrt(n); i = i + 2)
         {
             // While i divides n, print i and divide n
             while (n % i == 0)
             {
                 s.add(i);
                 n = n / i;
             }
         }

         // This condition is to handle the case when
         // n is a prime number greater than 2
         if (n > 2)
         {
             s.add(n);
         }
     }

     // Function to find smallest primitive root of n
     static int findPrimitive(int n)
     {
         HashSet<Integer> s = new HashSet<Integer>();

         // Check if n is prime or not

         // Find value of Euler Totient function of n
         // Since n is a prime number, the value of Euler
         // Totient function is n-1 as there are n-1
         // relatively prime numbers.
         int phi = n - 1;

         // Find prime factors of phi and store in a set
         findPrimefactors(s, phi);

         // Check for every number from 2 to phi
         for (int r = 2; r <= phi; r++)
         {
             // Iterate through all prime factors of phi.
             // and check if we found a power with value 1
             boolean flag = false;
             for (Integer a : s)
             {

                 // Check if r^((phi)/primefactors) mod n
                 // is 1 or not
                 if (power(r, phi / (a), n) == 1)
                 {
                     flag = true;
                     break;
                 }
             }

             // If there was no power with value 1.
             if (flag == false)
             {
                 return r;
             }
         }

         // If no primitive root found
         return -1;
     }

 }
