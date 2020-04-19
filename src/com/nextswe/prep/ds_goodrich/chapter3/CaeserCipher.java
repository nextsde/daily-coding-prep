package com.nextswe.prep.ds_goodrich.chapter3;

public class CaeserCipher {
    protected char[] encoder = new char[26];
    protected char[] decoder = new char[26];

    public CaeserCipher(int rotation){
        for(int k=0;k<26;k++){
            encoder[k] = (char)('A'+ (k+rotation) % 26);
            decoder[k] = (char)('A'+ (k-rotation+26) % 26);
        }
    }

    public String encrypt(String message){
        return transform(message,encoder);
    }

    public String decrypt(String message){
        return transform(message,decoder);
    }

    private String transform(String original, char[] code){
        char[] msg = original.toCharArray();
        for(int k=0;k<msg.length;k++){
            if(Character.isUpperCase(msg[k])){
                int j = msg[k] - 'A';
                msg[k] = code[j];
            }
        }
        return new String(msg);
    }

    public static void main(String[] args){
        CaeserCipher csc = new CaeserCipher(3);
        System.out.println("Encryption code = "+new String(csc.encoder));
        System.out.println("Decryption code = "+new String(csc.decoder));
        String message = "THE EAGLE IS IN PLAY; MEET ME AT JOE'S";
        String coded = csc.encrypt(message);
        System.out.println("Secret: "+coded);
        String answer = csc.decrypt(coded);
        System.out.println("Message: "+answer);
    }
}
