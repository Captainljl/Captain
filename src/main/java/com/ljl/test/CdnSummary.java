package com.ljl.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liujialei
 */
public class CdnSummary {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws IOException, ParseException {
        //BufferedReader是可以按行读取文件
        FileInputStream inputStream = new FileInputStream("/Users/liujialei/Downloads/1849.log");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        //2020:18:21:02 => 1602496750
        //2020:18:49:11 => 1602499751
        int startTime = 1602496750;
        int endTime = 1602499751 + 1;
        int[] power_checker_nums = new int[endTime - startTime];
        int[] app_predict_nums = new int[endTime - startTime];
        int[] common_nums = new int[endTime - startTime];
        int[] rules_ctrl_nums = new int[endTime - startTime];
        int[] power_applist_nums = new int[endTime - startTime];
        int[] Joyose_nums = new int[endTime - startTime];
        int[] power_update_nums = new int[endTime - startTime];
        int[] thermal_config_path_nums = new int[endTime - startTime];
        int[] perf_engine_nums = new int[endTime - startTime];
        int[] osai_setting_nums = new int[endTime - startTime];
        int[] power_detection_nums = new int[endTime - startTime];
        int[] feature_ctrl_nums = new int[endTime - startTime];

        Set<String> set = new HashSet<>();
        //我们现在是要获取一天10月一号一天的，
        String str = null;
        long failCount = 0;
        try {
            while((str = bufferedReader.readLine()) != null)
            {
                String[] s1 = str.split(" ");
                if (s1[0].equals("解析失败")) {
                    failCount ++;
                    System.out.println(failCount);
                } else {
                    int second = getSecond(s1[0]);
                    set.add(s1[2]);
                    switch (s1[2]) {
                        case "power_checker" : power_checker_nums[second - startTime] ++; break;
                        case "app_predict" : app_predict_nums[second - startTime] ++; break;
                        case "common" : common_nums[second - startTime] ++; break;
                        case "rules_ctrl" : rules_ctrl_nums[second - startTime] ++; break;
                        case "power_applist" : power_applist_nums[second - startTime] ++; break;
                        case "Joyose" : Joyose_nums[second - startTime] ++; break;
                        case "power_update" : power_update_nums[second - startTime] ++; break;
                        case "thermal_config_path" : thermal_config_path_nums[second - startTime] ++; break;
                        case "perf_engine" : perf_engine_nums[second - startTime] ++; break;
                        case "osai_setting" : osai_setting_nums[second - startTime] ++; break;
                        case "power_detection" : power_detection_nums[second - startTime] ++; break;
                        case "feature_ctrl" : feature_ctrl_nums[second - startTime] ++; break;
                        default: System.out.println("other case "); break;
                    }
                }
            /*if () {

            }*/

            }
        } catch (Exception e) {
            System.out.println(str);
        }
        System.out.println("failCount = " + failCount);

        System.out.println("power_checker : ");
        for (int power_checker_num : power_checker_nums) {
            System.out.println(power_checker_num);
        }
        System.out.println("app_predict : ");
        for (int app_predict_num : app_predict_nums) {
            System.out.println(app_predict_num);
        }

        System.out.println("common : ");
        for (int common_num : common_nums) {
            System.out.println(common_num);
        }

        System.out.println("rules_ctrl : ");
        for (int rules_ctrl_num : rules_ctrl_nums) {
            System.out.println(rules_ctrl_num);
        }

        System.out.println("power_applist : ");
        for (int power_applist_num : power_applist_nums) {
            System.out.println(power_applist_num);
        }

        System.out.println("joyse : ");
        for (int joyose_num : Joyose_nums) {
            System.out.println(joyose_num);
        }

        System.out.println("power_update : ");
        for (int power_update_num : power_update_nums) {
            System.out.println(power_update_num);
        }

        System.out.println("thermal_config_path : ");
        for (int thermal_config_path_num : thermal_config_path_nums) {
            System.out.println(thermal_config_path_num);
        }

        System.out.println("perf_engine_num : ");
        for (int perf_engine_num : perf_engine_nums) {
            System.out.println(perf_engine_num);
        }

        System.out.println("osai_setting_num : ");
        for (int osai_setting_num : osai_setting_nums) {
            System.out.println(osai_setting_num);
        }

        System.out.println("power_detection : ");
        for (int power_detection_num : power_detection_nums) {
            System.out.println(power_detection_num);
        }

        System.out.println("feature_ctrl_num : ");
        for (int feature_ctrl_num : feature_ctrl_nums) {
            System.out.println(feature_ctrl_num);
        }

        System.out.println("set : " );
        for (String s : set) {
            System.out.println(s);
        }
    }


    private static int getSecond(String timeStr) throws ParseException {
        timeStr = "2020-10-12 " + timeStr.substring(5);
        Date parse = sdf.parse(timeStr);
        return (int) (parse.getTime()/1000);
    }

}
