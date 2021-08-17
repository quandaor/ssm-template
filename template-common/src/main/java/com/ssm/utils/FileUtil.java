package com.ssm.utils;


import cn.hutool.core.net.Ipv4Util;
import cn.hutool.system.HostInfo;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @author quandaoran
 * @date 2021/7/30 9:00 上午
 * @describe FileUtil
 **/
@Slf4j
public class FileUtil {

    private FileUtil() {
    }

    private static List<String> loadFile(String fileName) throws IOException {
        String content;
        List<String> contentLists = new ArrayList<>();
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader br = new BufferedReader(fileReader)) {
            while ((content = br.readLine()) != null) {
                contentLists.add(content);
            }
        }
        return contentLists;
    }

    private static void writeFile(List<String> writeData, String fileName) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileName);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (String writeDatum : writeData) {
                bufferedWriter.write(writeDatum);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        }
    }

    public static String getInternetIp() {
        String INTRANET_IP = null;
        try {
            Enumeration<NetworkInterface> networks = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            Enumeration<InetAddress> addrs;
            while (networks.hasMoreElements()) {
                addrs = networks.nextElement().getInetAddresses();
                while (addrs.hasMoreElements()) {
                    ip = addrs.nextElement();
                    if (ip != null && ip instanceof Inet4Address && ip.isSiteLocalAddress() &&
                            !ip.getHostAddress().equals(INTRANET_IP)) {
                        return ip.getHostAddress();
                    }
                }
            }
            // 如果没有网卡IP，就返回/etc/hosts IP
            return INTRANET_IP;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
