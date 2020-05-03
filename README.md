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

## License
[MIT]() 
