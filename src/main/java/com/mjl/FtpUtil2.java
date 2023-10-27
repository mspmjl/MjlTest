package com.mjl;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author MJL
 * @date 2021/10/8.
 */
public class FtpUtil2 {
    private static String path = "/envcloud/springboot";
    private static String pathServer = "/mnt/vortex/springboot";

    public static void main(String[] args) throws IOException {
        File txt = new File("C:\\Users\\DELL\\Desktop\\ftp\\FtpWebDownload2.sh");
        File txt2 = new File("C:\\Users\\DELL\\Desktop\\ftp\\FtpXxlDownload2.sh");
        File txt3 = new File("C:\\Users\\DELL\\Desktop\\ftp\\FtpCommonDownload2.sh");
        if (!txt.exists()) {
            txt.createNewFile();
        }
        FileWriter writer = new FileWriter(txt);
        BufferedWriter webBufferedWriter = new BufferedWriter(writer);
        FileWriter writer2 = new FileWriter(txt2);
        BufferedWriter xxlBufferedWriter = new BufferedWriter(writer2);
        FileWriter writer3 = new FileWriter(txt3);
        BufferedWriter commonBufferedWriter = new BufferedWriter(writer3);
        FTPClient ftpClient = new FTPClient();
        ftpClient.connect("222.92.212.125", 21);
        ftpClient.login("vortex", "ftp12#$");
        ftpClient.enterLocalActiveMode();
        ftpClient.changeWorkingDirectory(path);
        FTPFile[] ftpFiles = ftpClient.listFiles();
        for (FTPFile ftpFile : ftpFiles) {
            String dirName = ftpFile.getName();
            if (dirName.contains("xxl")) {
                writeLine(dirName, ftpClient, xxlBufferedWriter);
            } else if ("vortex-analysis".equals(dirName) || "vortex-app".equals(dirName) || "vortex-cache".equals(dirName) || "vortex-cas".equals(dirName)
                    || "vortex-eureka".equals(dirName) || "vortex-file".equals(dirName) || "vortex-gateway".equals(dirName) || "vortex-ums-backboot".equals(dirName)
                    || "vortex-ums-webboot".equals(dirName) || "vortex-xxljob-admin".equals(dirName) || "vortex-ums-backboot-yuanqu".equals(dirName) || "vortex-ums-webboot-yuanqu".equals(dirName)) {
                writeLine(dirName, ftpClient, commonBufferedWriter);
            } else {
                writeLine(dirName, ftpClient, webBufferedWriter);
            }
        }
        webBufferedWriter.flush();
        xxlBufferedWriter.flush();
        commonBufferedWriter.flush();
        ftpClient.disconnect();
    }

    // wget ftp://vortex@222.92.212.125/mjl/hw-cloud-zyry-web-api-2.0.0.jar --ftp-user=vortex --ftp-password=ftp12#$
    private static void writeLine(String dirName, FTPClient ftpClient, BufferedWriter bufferedWriter) throws IOException {
        bufferedWriter.write("#" + " " + dirName);
        bufferedWriter.newLine();
        System.out.println("mkdir " + pathServer + "/" + dirName + ";");
        bufferedWriter.write("mkdir " + pathServer + "/" + dirName + ";");
        bufferedWriter.newLine();
        ftpClient.changeWorkingDirectory(path + "/" + (dirName));
        FTPFile[] ftpFiles2 = ftpClient.listFiles();
        for (FTPFile file : ftpFiles2) {
            if ("config".equals(file.getName())) {
                bufferedWriter.write("mkdir " + pathServer + "/" + dirName + "/config;");
                bufferedWriter.newLine();
                ftpClient.changeWorkingDirectory(path + "/" + dirName + "/config");
                for (FTPFile config : ftpClient.listFiles()) {
                    bufferedWriter.write("wget ftp://vortex@222.92.212.125" + path + "/" + dirName + "/config/" + config.getName() + " --ftp-user=vortex --ftp-password=ftp12#$;");
                    bufferedWriter.newLine();
                }
            } else {
                bufferedWriter.write( "wget ftp://vortex@222.92.212.125" + path + "/" + dirName + "/" + file.getName() + " --ftp-user=vortex --ftp-password=ftp12#$;");
                bufferedWriter.newLine();
            }
        }
        bufferedWriter.newLine();
    }

}
