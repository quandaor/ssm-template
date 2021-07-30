package com.ssm.utils;


import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.ArrayList;
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
}
