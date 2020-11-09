package com.ljl.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * this class will summary download type more detail, auto download and hand download,
 *
 * @author liujialei
 */
public class Mada {

    public static void main(String[] args) throws IOException {

        //BufferedReader是可以按行读取文件
        FileInputStream inputStream = new FileInputStream("/Users/liujialei/Downloads/remove");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        //我们现在是要获取一天10月一号一天的，
        String str = null;
        Set<String> imeiSet = new HashSet<>();
        String s = bufferedReader.readLine();
        System.out.println(s);
        int line = 0;
        while((str = bufferedReader.readLine()) != null)
        {
            line ++;
            String imei = getImei(str);
            if (imei != null && !"".equals(imei)) {
                imeiSet.add(imei);
            }
        }
        System.out.println(line);
        System.out.println(imeiSet.size());

        //close
        inputStream.close();
        bufferedReader.close();

        FileInputStream nightInputStream = new FileInputStream("/Users/liujialei/Downloads/nightNum");
        BufferedReader nightBufferedReader = new BufferedReader(new InputStreamReader(nightInputStream));
        BufferedWriter nightRemoved = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/liujialei/Downloads/nightRemoved", true)));
        BufferedWriter nightInValid = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/liujialei/Downloads/nightInValid", true)));
        BufferedWriter nightTarget = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/liujialei/Downloads/nightTarget", true)));
        Set<String> nightSumSet = new HashSet<>();
        Set<String> nightTargetSumSet = new HashSet<>();
        nightBufferedReader.readLine();
        String nightStr;
        int nightSum = 0, nightRemovedSum = 0, nightInValidSum = 0, nightTargetNum = 0;
        while ((nightStr = nightBufferedReader.readLine()) != null) {
            String nightImei = getImei(nightStr);
            nightSumSet.add(nightImei);
            nightSum ++;
            if (nightImei != null && !"".equals(nightImei)) {
                if (imeiSet.contains(nightImei)) {
                    nightRemovedSum ++;
                    //nightRemoved.write(nightStr);
                } else {
                    nightTargetNum ++;
                    //nightTarget.write(nightStr);
                    nightTargetSumSet.add(nightImei);
                }
            } else {
                nightInValidSum ++;
                //nightInValid.write(nightStr);
            }
        }

        nightInputStream.close();
        nightBufferedReader.close();
        nightRemoved.close();
        nightInValid.close();
        nightTarget.close();

        System.out.println("nightSum = " + nightSum + " nightRemovedSum = " + nightRemovedSum + " nightInValidSum = " + nightInValidSum + " nightTargetNum = " + nightTargetNum);
        System.out.println("nightSumImei = " + nightSumSet.size() + " nightTargetSumSet = " + nightTargetSumSet.size());

        FileInputStream tenInputStream = new FileInputStream("/Users/liujialei/Downloads/tenNum");
        BufferedReader tenBufferedReader = new BufferedReader(new InputStreamReader(tenInputStream));
        BufferedWriter tenRemoved = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/liujialei/Downloads/tenRemoved", true)));
        BufferedWriter tenInValid = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/liujialei/Downloads/tenInValid", true)));
        BufferedWriter tenTarget = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/liujialei/Downloads/tenTarget", true)));
        Set<String> tenSumSet = new HashSet<>();
        Set<String> tenTargetSumSet = new HashSet<>();

        tenBufferedReader.readLine();
        String tenStr;
        int tenSum = 0, tenRemovedSum = 0, tenInValidSum = 0, tenTargetNum = 0;
        while ((tenStr = tenBufferedReader.readLine()) != null) {
            String tenImei = getImei(tenStr);
            tenSum ++;
            tenSumSet.add(tenImei);
            if (tenImei != null && !"".equals(tenImei)) {
                if (imeiSet.contains(tenImei)) {
                    tenRemovedSum ++;
                    //tenRemoved.write(tenStr);
                } else {
                    tenTargetNum ++;
                    //tenTarget.write(tenStr);
                    tenTargetSumSet.add(tenImei);
                }
            } else {
                tenInValidSum ++;
                //tenInValid.write(tenStr);
            }
        }

        System.out.println("tenSum = " + tenSum + " tenRemovedSum = " + tenRemovedSum + " tenInValidSum = " + tenInValidSum + " tenTargetNum = " + tenTargetNum);
        System.out.println("tenSumImei = " + tenSumSet.size() + " tenTargetSumSet = " + tenTargetSumSet.size());

        tenInputStream.close();
        tenBufferedReader.close();
        tenRemoved.close();
        tenInValid.close();
        tenTarget.close();







    }


    //2020-09-23	18:02:25	c4-miui-ota-fe04.bj	/updates/v1/stat.php	1	raphael	2	20.9.3	raphael	0x0a02b334	95e738a586dbb66cd893e2a81b7cbbb0	zh_CN	CN	-	2	20.9.17	https://hugeota.d.miui.com/20.9.17/miui-blockota-raphael-20.9.3-20.9.17-ab772bd270-10.0.zip	1	0	91801	-	-	0	-	-	-	1600855345423	12	636430342	12	be8e605096fa5e50b0d52dd714407155eac967b9c48483781bab92cf5d3b0172	-	-	-	1600763543	NULL	NULL	NULL
    //	NULL	NULL	20200923	NULL	NULL	NULL	NULL	NULL	NULL	NULL	NULL	NULL	NULL	NULL	NULL	NULL	NULL	NULL	NULL	NULL	NULL	NULL	NULL	NULL	NULL	NULL	NULL	NULL	NULL	NULL	NULL	NULL	NULL	NULL	NULL	NULL	NULL


    private static String getImei(String source) {
        return source.split("\t")[10];
    }


}
