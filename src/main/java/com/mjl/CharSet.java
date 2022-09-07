package com.mjl;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * @author MJL
 * @date 2022/6/30.
 */
public class CharSet {
    public static void main(String[] args) throws CharacterCodingException {
        Charset charset = Charset.forName("utf-8");

        //获取编码器
        CharsetEncoder charsetEncoder = charset.newEncoder();
        //获取解码器
        CharsetDecoder charsetDecoder = charset.newDecoder();


        CharBuffer charBuffer = CharBuffer.allocate(1024);
        charBuffer.put("{");
        charBuffer.flip();

        //编码
        ByteBuffer bBuf = charsetEncoder.encode(charBuffer);

        System.out.println("编码------------");
        for(int i=0;i <30;i++){
            System.out.println(bBuf.get());
        }

        System.out.println("解码-------------");
        //解码
        bBuf.flip();
        CharBuffer cBuf = charsetDecoder.decode(bBuf);
        System.out.println(cBuf.toString());
    }
}
