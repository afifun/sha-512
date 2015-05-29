/*
 * To change this license header, choose "icense Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sha512;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 *
 * @author moh.afifun
 */
public class SHA512 {

    /**
     * @param args the command line arguments
     */
    
    public static String[] H = new String[]{"6A09E667F3BCC908", 
                                     "BB67AE8584CAA73B", 
                                     "3C6EF372FE94F82B", 
                                     "A54FF53A5F1D36F1", 
                                     "510E527FADE682D1", 
                                     "9B05688C2B3E6C1F", 
                                     "1F83D9ABFB41BD6B", 
                                     "5BE0CD19137E2179"};
    
    public static final String[] k = new String[]{
                  "428a2f98d728ae22", "7137449123ef65cd", "b5c0fbcfec4d3b2f", 
                  "e9b5dba58189dbbc", "3956c25bf348b538", "59f111f1b605d019",
                  "923f82a4af194f9b", "ab1c5ed5da6d8118", "d807aa98a3030242",
                  "12835b0145706fbe", "243185be4ee4b28c", "550c7dc3d5ffb4e2",
                  "72be5d74f27b896f", "80deb1fe3b1696b1", "9bdc06a725c71235",
                  "c19bf174cf692694", "e49b69c19ef14ad2", "efbe4786384f25e3",
                  "0fc19dc68b8cd5b5", "240ca1cc77ac9c65", "2de92c6f592b0275",
                  "4a7484aa6ea6e483", "5cb0a9dcbd41fbd4", "76f988da831153b5",
                  "983e5152ee66dfab", "a831c66d2db43210", "b00327c898fb213f",
                  "bf597fc7beef0ee4", "c6e00bf33da88fc2", "d5a79147930aa725",
                  "06ca6351e003826f", "142929670a0e6e70", "27b70a8546d22ffc",
                  "2e1b21385c26c926", "4d2c6dfc5ac42aed", "53380d139d95b3df",
                  "650a73548baf63de", "766a0abb3c77b2a8", "81c2c92e47edaee6",
                  "92722c851482353b", "a2bfe8a14cf10364", "a81a664bbc423001",
                  "c24b8b70d0f89791", "c76c51a30654be30", "d192e819d6ef5218",
                  "d69906245565a910", "f40e35855771202a", "106aa07032bbd1b8",
                  "19a4c116b8d2d0c8", "1e376c085141ab53", "2748774cdf8eeb99",
                  "34b0bcb5e19b48a8", "391c0cb3c5c95a63", "4ed8aa4ae3418acb",
                  "5b9cca4f7763e373", "682e6ff3d6b2b8a3", "748f82ee5defb2fc",
                  "78a5636f43172f60", "84c87814a1f0ab72", "8cc702081a6439ec",
                  "90befffa23631e28", "a4506cebde82bde9", "bef9a3f7b2c67915",
                  "c67178f2e372532b", "ca273eceea26619c", "d186b8c721c0c207",
                  "eada7dd6cde0eb1e", "f57d4f7fee6ed178", "06f067aa72176fba",
                  "0a637dc5a2c898a6", "113f9804bef90dae", "1b710b35131c471b",
                  "28db77f523047d84", "32caab7b40c72493", "3c9ebe0a15c9bebc",
                  "431d67c49c100d4c", "4cc5d4becb3e42b6", "597f299cfc657e2a",
                  "5fcb6fab3ad6faec", "6c44198c4a475817"
                   };
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        // TODO code application logic here
       String msg = "abc";
//       File msg = new File("C:\\Users\\moh.afifun\\ownCloud\\ownCloudUserManual.pdf");
//       Path pathFileD = Paths.get(msg.getAbsolutePath());
//       byte[] bytesFileD = Files.readAllBytes(pathFileD);
       String a =  convertBytestoHexa(msg.getBytes());
       int[] bits = generateBits(a);
       
       int[][] d = digest(bits);
//       System.out.println(Arrays.toString(bits));
       int[][] temp4  = generateW(d[0]);
//        String output = "";
      
        System.out.println("_____________________________________");
    
       
       int[][] iv = new int[8][64];
       
       for (int i = 0; i < H.length; i++) {
            iv[i] = generateK(H[i]);
       }
       
        for (int i = 0; i < d.length; i++) {
            int[][] temp2  = generateW(d[i]);
            int[][] hasil = proses(temp2, iv);
            for (int j = 0; j < hasil.length; j++) {
//                System.out.println(Arrays.deepToString(iv));
//                System.out.println(Arrays.deepToString(hasil));
//                System.out.println(hasil == iv);
                iv[i] = sum(hasil[i], iv[i]);  
//                System.out.println(Arrays.deepToString(iv));
            }
        }
        
        String output = "";
        for (int i = 0; i < iv.length; i++) {
            output = output + Arrays.toString(iv[i]).replaceAll("[\\[\\] ,]", "");
        }
        System.out.println(output);
        convertBitsToHex(iv);
        String hex = "";
        for (int i = 0; i < output.length(); i+=4) {
            String bin = output.substring(i, i + 4);
//            System.out.println(bin);
            int decimal = Integer.parseInt(bin, 2);
//            System.out.println(decimal);
            hex += Integer.toHexString(decimal);
        }
        System.out.println(hex);
        System.out.println(hex.length());
//        byte[] eb = hexStringToByteArray(hex);
//        FileOutputStream fileOuputStream = new FileOutputStream("E:\\testing2.txt"); 
//	fileOuputStream.write(eb);
//	fileOuputStream.close();
// 
	System.out.println("Done");
        
        int[] e = new int[]{1,0,1,1};
        int[] f = new int[]{0,1,0,1};
        int[] g = new int[]{1,0,1,0};
        int[] result = sum(sum(e,f),g);
        System.out.println(Arrays.toString(result) + "");
        System.out.println(0 | 7);
     
    }
    
    public static int getSum(int p, int q)
{
    int result = p ^ q; // + without carry 0+0=0, 0+1=1+0=1, 1+1=0
    int carry = (p & q) << 1; // 1+1=2
    if (carry != 0) {
        return getSum(result, carry);
    }
    return result;
}
    
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }
    
    private static int[][] proses(int[][] w, int[][] h){
        String output = "";
        int[][] temp = h;
        convertBitsToHex(temp);
        System.out.println(">>>>>>>>>>>>>>>>>>>>");
        convertBitsToHex(w);
        for (int i = 0; i < 80; i++) {
//            System.out.println(Arrays.deepToString(temp));
            
            System.out.println("Round " + i + "_______________________");
            
            temp = singleRound(w[i], temp, i);
            convertBitsToHex(temp);
        }
        return temp;
    }
    
    public static void convertBitsToHex(int[][] input) {
        
        for (int i = 0; i < input.length; i++) {
            String output = Arrays.toString(input[i]).replaceAll("[\\[\\] ,]", "");
             String hex = "";
            for (int j = 0; j < output.length(); j += 4) {
                String bin = output.substring(j, j + 4);
                //            System.out.println(bin);
                int decimal = Integer.parseInt(bin, 2);
                //            System.out.println(decimal);
                hex += Integer.toHexString(decimal);
            }
            System.out.println(i + " ; " + hex);

        }
    }
    
    
    private static int[][] singleRound(int[] w,int[][] inputH, int round){
//        System.out.println(Arrays.deepToString(H));
        int[][] output = new int[8][64];
        
        int[] a = inputH[0];
        int[] b = inputH[1];
        int[] c = inputH[2];
        int[] d = inputH[3];
        int[] e = inputH[4];
        int[] f = inputH[5];
        int[] g = inputH[6];
        int[] h = inputH[7];
        
        int[] sumA = sum512a(a);
        int[] sumE = sum512e(e);
        int[] wt = w;
        int[] kt = generateK(k[round]);
        int[] t1 = sum(sum(sum(sum(ch(e,f,g),h),sumE),wt),kt);
        int[] t2 = sum(sumA, maj(a, b, c));
        output[7] = g;
        output[6] = f;
        output[5] = e;
        output[4] = sum(d, t1);
        output[3] = c;
        output[2] = b;
        output[1] = a;
        output[0] = sum(t1, t2);
//        System.out.println(Arrays.deepToString(H));
        return output;
    }
    
    private static int[] ch(int[] e,int[] f ,int[] g){
        int[] output = new int[e.length];
        output = xor(and(e,f),and(not(e), g));
        return output;
    }
    
    private static int[] maj(int[] a,int[] b ,int[] c){
        int[] output = new int[a.length];
        output = xor(and(a,b),and(a, c));
        output = xor(output, and(b,c));
        return output;
    }
    
    private static int[] sum512a(int[] a){
        int[] output = new int[a.length];
        output = xor(rotrN(a,28),rotrN(a, 34));
        System.out.println("output : " + Arrays.toString(output));
        output = xor(output, rotrN(a,39));
        System.out.println("output2 : " + Arrays.toString(output));
        return output;
    }
    
    private static int[][] generateW(int[] input){
        
          int index = 0;
          int indexM = 0;
          int[][] output = new int[80][64];
          while (index < input.length){
                int[] temp = new int[64];
                System.arraycopy(input, index, temp, 0, 64);
                output[indexM] = temp;
                indexM++;
                index = index + 64;
          }
          
          for (int i = 16; i < output.length; i++) {
            int[] temp1 = sum(sum512x1(output[i-2]),output[i-7]);
            int[] temp2 = sum(sum512x(output[i-15]),output[i-16]);
            output[i] = sum(temp1, temp2);
          }
        return output;
    }
    
    private static int[] sum512x1(int[] x){
        int[] output = new int[x.length];
        output = xor(rotrN(x,19),rotrN(x, 61));
        output = xor(output, shrN(x,6));
        return output;
    }
    
    private static int[] sum512x(int[] x){
        int[] output = new int[x.length];
        output = xor(rotrN(x,1),rotrN(x, 8));
        output = xor(output, shrN(x,7));
        return output;
    }
    
    
    private static int[] sum512e(int[] e){
        int[] output = new int[e.length];
        output = xor(rotrN(e,14),rotrN(e, 18));
        output = xor(output, rotrN(e,41));
        return output;
    }
    
    private static int[] rotrN(int[] bits, int n) {
        
        int[] output = new int[bits.length];
        System.arraycopy(bits, 0, output, 0, bits.length);
        for (int i = 0; i < n; i++) {
            int temp = output[bits.length - 1];
            for (int j = bits.length - 1; j >0 ; j--) {
                output[j] = output[j-1];
            }
            output[0] = temp;
        }
        return output;
    }
    
    private static int[] shrN(int[] bits, int n) {
        
         int[] output = new int[bits.length];
        System.arraycopy(bits, 0, output, 0, bits.length);
        for (int i = 0; i < n; i++) {
            int temp = output[bits.length - 1];
            for (int j = bits.length - 1; j >0 ; j--) {
                output[j] = output[j-1];
            }
            output[0] = 0;
        }
        return output;
    }
    
    public static int[][] digest(int[] msg){
        int[][] m = new int[msg.length / 1024][1024];
        int index = 0;
        int indexM = 0;
        while (index < msg.length){
            int[] temp = new int[1024];
            System.arraycopy(msg, index, temp, 0, 1024);
            m[indexM] = temp;
            indexM++;
            index = index + 1024;
        }
        return m;
    }
    
    private static int[] xor(int[] a, int[] b) {
        int answer[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            answer[i] = a[i] ^ b[i];
        }
        return answer;
    }
    
    private static int[] not(int[] a) {
        int answer[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1){
                answer[i] = 0;
            }
            else{
                answer[i] = 1;
            }
        }
        return answer;
    }
    
    
    private static int[] and(int[] a, int[] b) {
        int answer[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            answer[i] = a[i] & b[i];
        }
        return answer;
    }
    
    private static int[] or(int[] a, int[] b) {
        int answer[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            answer[i] = a[i] | b[i];
        }
        return answer;
    }
    
    private static int[] sum(int[] a, int[] b) {
        int answer[] = new int[a.length];
        int temp = 0;
        for (int i = a.length - 1; i >=0 ; i--) {
            if((a[i] + b[i] + temp) == 2){
                answer[i] = 0;
                temp = 1;
            }
            else if ((a[i] + b[i] + temp) == 3){
                answer[i] = 1;
                temp = 1;
            }
            else if((a[i] + b[i] + temp) == 1){
                answer[i] = 1;
                temp = 0;
            }
            else {
                answer[i] = 0;
                temp = 0;
            }
            
        }
        return answer;
    }
    
    public static void singleRound(){
        
    }
    
    public static int[] generateK(String hexKey){
        //method ini mengambil 16 Hexa pertama dari key
        int keyBits[] = new int[64];
            for (int i = 0; i < 16; i++) {
                String s = Integer.toBinaryString(Integer.parseInt(hexKey.charAt(i) + "", 16));
                while (s.length() < 4) {
                    s = "0" + s;
                }
                for (int j = 0; j < 4; j++) {
                    keyBits[(4 * i) + j] = Integer.parseInt(s.charAt(j) + "");
                }
            }
        return keyBits;
    }
    
    public static int[] generateBits(String hexKey){
        //method ini mengambil 16 Hexa pertama dari key
        int msglength = hexKey.length() * 4;
        int padding = 1024 - (msglength % 1024);
        StringBuilder str = new StringBuilder(msglength);
        int keyBits[] = new int[msglength + padding];
            for (int i = 0; i <hexKey.length() ; i++) {
                String s = Integer.toBinaryString(Integer.parseInt(hexKey.charAt(i) + "", 16));
                while (s.length() < 4) {
                    s = "0" + s;
                }
                for (int j = 0; j < 4; j++) {
                    keyBits[(4 * i) + j] = Integer.parseInt(s.charAt(j) + "");
                }
            }
            String lengthBits = Integer.toBinaryString(Integer.parseInt(Integer.toHexString(msglength), 16));
            int index = lengthBits.length() - 1;
            int indexK = keyBits.length - 1;
            while(index >= 0){
                keyBits[indexK] = Integer.parseInt(lengthBits.charAt(index) + "");
                indexK--;
                index--;
            }
            
            keyBits[msglength] = 1;
//            keyBits[keyBits.length - 128] = 1;
            
            for (int i = 0; i < keyBits.length; i+=4) {
            
            }
        return keyBits;
    }
    
    public static String convertBytestoHexa(byte[] input){
        StringBuilder sb = new StringBuilder();
        for (byte b : input) {
                sb.append(String.format("%02X", b));
            }
        return sb.toString();
    }
    
}
