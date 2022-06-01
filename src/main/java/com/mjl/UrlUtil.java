package com.mjl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @author MJL
 * @date 2022/2/16.
 */
public class UrlUtil {
    public static void main(String[] args) throws Exception {
        UrlUtil util = new UrlUtil();
        Set<String> newUrls = new HashSet<>();
        Set<String> formerUrls = new HashSet<>();
        util.getFile("E:\\zhj-ums-new\\hw-cloud-ums-deprecated\\src\\main\\java\\com\\vortex\\cloud\\ums\\deprecated\\controller", newUrls);
        util.getFile("E:\\zhj-ums\\hw-cloud-ums-webboot\\src\\main\\java\\com\\vortex\\cloud\\ums\\web", formerUrls);
        for (String formerUrl : formerUrls) {
            if (!newUrls.contains(formerUrl)) {
                System.out.println(formerUrl);
            }
        }
    }


    private void getFile(String path, Set<String> urls) throws Exception {
        // get file list where the path has
        File file = new File(path);
        // get the folder list
        File[] array = file.listFiles();

        for (int i = 0; i < array.length; i++) {
            if (array[i].isFile()) {
                File controller = array[i];
                getUrl(controller, urls);
            } else if (array[i].isDirectory()) {
                getFile(array[i].getPath(), urls);
            }
        }
    }

    private void getUrl(File file, Set<String> urls) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String s;
        String base = null;
        boolean first = true;
        while ((s = reader.readLine()) != null) {
            s = s.trim();
            if (s.startsWith("@RequestMapping")) {
                if (first) {
                    base = s.split("\"")[1];
                } else {
                    urls.add(base + "/" + s.split("\"")[1]);
                }
                first = false;
            }
        }
        reader.close();
    }

}
