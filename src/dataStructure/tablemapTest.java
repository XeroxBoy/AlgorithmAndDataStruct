package dataStructure;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;

public class tablemapTest {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date tab1 = new Date();
        System.out.println("Hasetable测试开始时间" + format.format(tab1));
        addHashtable();
        Date tab2 = new Date();
        System.out.println("Hasetable测试结束时间" + format.format(tab2));
        System.out.println("用时" + (tab2.getTime() - tab1.getTime()));


        Date map1 = new Date();
        System.out.println("HashMap测试开始时间" + format.format(map1));
        addHashMap();
        Date map2 = new Date();
        System.out.println("HashMap测试结束时间" + format.format(map2));
        System.out.println("用时" + (map2.getTime() - map1.getTime()));
    }

    public static void addHashtable() {
        Hashtable<String, String> table = new Hashtable<String, String>();
        for (int i = 0; i < 5000000; i++) {
            table.put(i + "key", i + "value");
        }
    }

    public static void addHashMap() {
        HashMap<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < 5000000; i++) {
            map.put(i + "key", i + "value");
        }
    }
}
 