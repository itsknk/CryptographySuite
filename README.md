## Cryptography Suite
A collection of Cryptography Algorithms implemented in Java.

## Usage
1. Clone the repository
2. cd `CryptographySuite`
3. `javac filename.java`
4. `java filename`

## RSA Algorithm
1. First it generates two huge prime numbers(p,q) and calculates N and ϕN respectively, where N = p*q and ϕN = (p-1)(q-1).
2. Now it generates e which will be relative prime to ϕN and will be  1<e<ϕ, so that gcd(e,ϕ)=1.
3. After getting e it calculates d as d will be = e*dmod(ϕN)=1.
4. Then it converts the entered plain text into bytes and encrypts it into a cipher text by the formula msg^e*mod(N).
5. Final step involves decrypting the cipher text by formula msg^d*mod(N) and it converts the bytes to string to reveal the original plain text.

## Diffie–Hellman key exchange Algorithm
1. First it generates a prime number p and a primitive root of p i.e, g
2. Next step involves taking the user input which will be the private keys of A and B.
3. After getting the private keys of both A and B it calculates the public keys of both i.e, for A it'll be g^pka mod p and for B it's g^pkb mod p where pka and pkb are the private keys of A and B.
4. Now based on the public keys generated it calculates the secret key for both A and B via the formula pkb^pka mod p for A and pka^pkb mod p for B.
5. The final step involves checking whether the secret keys generated match or not, if they match then communication can be allowed or else it can't be.

## Vigenere Cipher
1. First step involves taking the user input for the plain text and the keyword.
2. The user input will be in string format but is converted to charArray to make the implementation easy.
3. Inside the encrypt funtion it creates a new key from the existing key by repeating it until it's equal to the plain text length and then using the formula (plaintext+key) mod 26 it encrypts the plain text and returns it.
4. Inside the decrypt function it takes the encrypted text and then using the formula ((encryptedtext-key)+26) mod 26 it decrypts the encrypted text and returns it.
5. The final step involves the main program calling those methods and printing the required data returned by those.

## License
[MIT](https://github.com/itsknk/CryptographySuite/blob/master/LICENSE)
