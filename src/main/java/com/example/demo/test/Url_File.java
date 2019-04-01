package com.example.demo.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Url_File {

    public static void main(String[] args) {

        try {
            URL url = new URL("http://pic.58pic.com/58pic/15/68/59/71X58PICNjx_1024.jpg");
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);

            File file = new File("D:/target.jpg");
            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            byte[] b = new byte[1024];
            while (bis.read(b) != -1) {
                bos.write(b);
            }
            bos.close();
            fos.close();
            bis.close();
            is.close();

        } catch (MalformedURLException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
