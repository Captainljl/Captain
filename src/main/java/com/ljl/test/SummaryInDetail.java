package com.ljl.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * this class will summary download type more detail, auto download and hand download,
 *
 * @author liujialei
 */
public class SummaryInDetail {


    private static final long SECOND_OF_DAY = 24 * 60 * 60;
    private static final long DOMAIN_OF_TIME = 30 * 60;
    private static final long START_OF_TIME = 1601481600 + 4 * SECOND_OF_DAY;
    private static final long END_OF_TIME = START_OF_TIME + SECOND_OF_DAY;

    public static void main(String[] args) throws IOException {

        //BufferedReader是可以按行读取文件
        FileInputStream inputStream = new FileInputStream("/Users/liujialei/Downloads/stdout");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        //我们现在是要获取一天10月一号一天的，
        String str = null;
        String s = bufferedReader.readLine();
        System.out.println(s);
        int[] handSummary = new int[(int) ((END_OF_TIME - START_OF_TIME) / DOMAIN_OF_TIME)];
        int[] autoSummary = new int[(int) ((END_OF_TIME - START_OF_TIME) / DOMAIN_OF_TIME)];
        long startTime;
        boolean isHandDownLoad;
        long lineNum = 0;
        while((str = bufferedReader.readLine()) != null)
        {
            lineNum ++;
            if (lineNum % 10000 == 0) {
                System.out.println(lineNum);
            }
            try {
                startTime = getDownloadStartTime(str);
                isHandDownLoad = isHandDownload(str);
            } catch (Exception e) {
                continue;
            }
            if (startTime >= START_OF_TIME && startTime < END_OF_TIME) {
                int distinct = witchDistinct(startTime);
                if (isHandDownLoad) {
                    handSummary[distinct] = handSummary[distinct] + 1;
                } else {
                    autoSummary[distinct] = autoSummary[distinct] + 1;
                }
            } else {
                //break;
            }

        }

        for (int i : handSummary) {
            System.out.println(i);
        }
        System.out.println();
        for (int i : autoSummary) {
            System.out.println(i);
        }
        System.out.println("lineNum : " + lineNum);
        //close
        inputStream.close();
        bufferedReader.close();

    }


    private static boolean isHandDownload(String source) {
        String[] split = source.split("\t");
        return Integer.parseInt(split[17]) < 1000;
    }

    private static int witchDistinct(long startTime) {
        return (int) ((startTime - START_OF_TIME) / DOMAIN_OF_TIME);
    }

    private static String witchDay(String source) {
        String[] s = source.split("\t");
        return s[0];
    }

    private static long getDownloadStartTime(String source) {
        String[] s = source.split("\t");
        String s1 = s[s.length - 4];
        return Long.parseLong(s1);
    }

}
