package com.one;

import com.sun.deploy.net.cookie.CookieUnavailableException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.junit.Test;

import javax.crypto.spec.PSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.security.KeyStore;
import java.sql.Connection;
import java.util.*;

class Student implements Comparator<Student> {
    int age;
    String name;

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Student() {
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.age > o2.age) {
            return 1;
        } else if (o1.age < o2.age) {
            return -1;
        }else {
            return 0;
        }
    }
}

class goods implements Comparable{
    String name;
    int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public goods(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public goods() {
    }

    @Override
    public String toString() {
        return "goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof goods) {
            goods god5 = (goods)o;
            if (this.price > god5.price) {
                return 1;
            } else if (this.price < god5.price) {
                return -1;
            } else {
//                return 0;
                return /*-this.*/name.compareTo(god5.name);
            }
        }
        throw new RuntimeException("?????????????????????????????????");
    }
}
public class Study05 {

    double price = 55;
    int aa;
    Study04 o1 = new Study04();
    public void setAa(int aa) {
        this.aa = aa;
        System.out.println(aa);
    }

    @Test
    public void is31() {
        Student s1 = new Student(31, "???is");
        Student s2 = new Student(41, "???is");
        Student s3 = new Student(72, "???is");
        Student s4 = new Student(7, "???is");

        List<Student> stus = new ArrayList<Student>();
        stus.add(s1);
        stus.add(s2);
        stus.add(s3);
        stus.add(s4);
        Collections.sort(stus,new Student());
        for (Student stuu :
                stus) {
            System.out.println(stuu.toString());
        }
        Student themax = Collections.max(stus, new Student());
        System.out.println(themax);
        System.out.println(Collections.frequency(stus,s1));
    }
    @Test//TreeMap?????????????????????
    public void is30() {
        Map<Integer, String> map = new TreeMap<Integer, String>();
        map.put(4,"a");
        map.put(2,"a");
        map.put(3,"a");
        map.put(1,"a");
        System.out.println(map);
        Map<String, String> map1 = new TreeMap<String, String>();
        map1.put("b", "b");
        map1.put("c", "c");
        map1.put("d", "d");
        map1.put("a", "a");
        map1.put("ab", "ab");
        System.out.println(map1);
    }
    @Test//Map??????
    public void is29() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("b", 1);
        map.put("c", 2);
        map.put("d", 2);
        map.put("e", 4);
        System.out.println(map);
        System.out.println(map.get("b"));//??????key??????
//        map.remove("c");//??????key???????????????
//        map.clear();//????????????
        System.out.println(map.size());//????????????
        System.out.println(map.containsKey("b"));//?????????????????????key
        System.out.println(map.containsValue(2));//?????????????????????value
        //??????Map??????
        Set<String> keys = map.keySet();
        for (String s :
                keys) {
            System.out.println(s + ":" + map.get(s));
        }
        //???????????????Map??????
        Set<Map.Entry<String, Integer>> entrys = map.entrySet();
        for (Map.Entry<String, Integer> en : entrys){
            System.out.println(en.getKey()+":"+en.getValue());
        }
    }
    @Test//List??????
    public void is28() {
        List<String> list = new ArrayList<String>();
        list.add("ss");
        list.add("sssf");
        list.add("sssfds");
        List<String> list1 = new ArrayList<String>();
        list1.add("????????????1");
        list1.add("????????????2");
        list.addAll(1, list1);//?????????????????????????????????,?????????????????????????????????????????????
        System.out.println(list.get(2));//????????????????????????????????????????????????
        System.out.println(list.indexOf("sssf"));//?????????????????????????????????????????????????????????
        System.out.println(list.lastIndexOf("sssf"));//????????????????????????????????????????????????????????????
//        list.remove(2);//???????????????????????????????????????
        list.set(1, "???????????????");//????????????????????????????????????
        System.out.println(list);
        List<String> sublist = list.subList(1, 3);//???????????????????????????????????????1?????????2???????????????????????????????????????
        System.out.println(sublist);
        System.out.println(list.size());//???????????????
    }
    @Test
    public void is26() {
        int q = 5;
        goods[] s1 = new goods[q];
        s1[0] = new goods("sds", 566);
        s1[1] = new goods("gfd",5527 );
        s1[2] = new goods("dfgdr",775 );
        s1[3] = new goods("xbxxx", 5257);
        s1[4] = new goods("aax", 5257);
        Arrays.sort(s1);
//        System.out.println(Arrays.toString(s1));
        for (Object j :  //?????????????????????Arrays???????????????,???????????????
                s1) {
            System.out.println(j);
        }
    }
    @Test//??????????????????--->???????????????
    public void is25() {
        String[] arr = new String[]{"AA", "CC", "DD", "YY", "JJ", "KK", "SS", "EE", "RR", "TT"};
        /*Arrays.sort(arr);      //String????????????compareTo()?????????,?????????????????????
        System.out.println(Arrays.toString(arr));*/
        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }
                throw new RuntimeException("?????????????????????????????????");
            }
        });
        for (Object j :  //?????????????????????Arrays???????????????,???????????????
                arr) {
            System.out.println(j);
        }
    }
    @Test//???????????????????????????????????????????????????
    public void is27() {
        int q = 5;
        goods[] g1 = new goods[q];
        g1[0] = new goods("sds", 566);
        g1[1] = new goods("gfd",5527 );
        g1[2] = new goods("dfgdr",775 );
        g1[3] = new goods("xbxxx", 5257);
        g1[4] = new goods("aax", 5257);
        Arrays.sort(g1, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof goods && o2 instanceof goods) {
                    goods s1 = (goods) o1;
                    goods s2 = (goods) o2;
                    if (s1.getName().equals(s2.getName())) {
                        return Double.compare(s1.getPrice(), s2.getPrice());
                    }
                    else{
                        return s1.getName().compareTo(s2.getName());
                    }
                }
                throw new RuntimeException("?????????????????????????????????");
            }

        });
        for (Object j :  //?????????????????????Arrays???????????????,???????????????
                g1) {
            System.out.println(j);
        }
    }
    @Test//Set??????
    public void is24() {
        Set set = new HashSet();
        set.add(5);
        set.add("fsf");
        set.add("s");
        set.add("ef");
        set.add("fdg");
        System.out.println(set);
        //?????????????????????
//        set.remove("fsf");
        //?????????????????????
//        set.clear();
        //?????????????????????
        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        //??????foreach????????????
        for (Object obj :
                set) {
            System.out.println(obj);
        }
        //??????set?????????????????????
        System.out.println(set.size());
        //????????????
        Set<String> set2 = new HashSet<String>();
        set2.add("ss");

    }
    @Test
    public void is23() {
        String c = "55";
        int a = 34;
        float w = (short)2;
        System.out.println();
    }
    @Test
    public void is2() {
//        Integer[] a = new Integer[5];
//        a = {2, 6, 9, 55, 3};
//        int[] a = new int[5];
        Integer[] a ={2, 6, 9, 55, 3};
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    @Test
    public void is() {
        char ij = 65;
        int a = 65;
//        String b = new String("65");
        String b = "65";
        System.out.println(a == ij);
        System.out.println(b.equals(a));

    }
@Test
    public void ii() throws IOException {
        int[] a = {8,2,6,8,2,3,6};
        byte[] b = new byte[4];
        FileInputStream sis = new FileInputStream("E:/??????/eded.txt");
        int read1 = sis.read(b);
        System.out.println(read1);
        System.out.println(new String(b));
    if (read1 == -1) {
        sis.close();
    }
    }

    @Test
    public void momo(){
        String io = "j";
        System.out.println(io.length());
    }

    public String add(int aa, int d3) {
        aa = this.aa;
        System.out.println(aa + d3);
        return "o";
    }

    @Override
    public String toString() {
        String b = super.toString();
        return super.toString() + "\nssss:0";
    }

    @Test
    public void sa2() {
        List a3 = new ArrayList();
        a3.add(8);
        a3.add(8);
        a3.add(8);
        List a6 = new ArrayList();
        a6.add(a3);
        Object[] a= {5,5,'s','f','s',"jfdd",6,4};
        a6.add(a);
        a6.add(6535);
        String a4 = "da";
        System.out.println(a6.toString());
//        System.out.println(ArrayList.toString(a3));
    }

    @Test
    public void sa4() {

        System.out.println(5+"=====================================");
    }
    @Test
    public void sa1() {
        int[] a = {3, 95, 96, 6, 5, 3, 544, 54, 5, 4, 98};
        System.out.println(Arrays.toString(a));
    }
}
class son1 extends Study05{
    public son1() {
        System.out.println("son1???????????????");
    }
    void add2(){

    System.out.println("????????????");
    }
}
@Component
class  dd{
    public static void main(String[] args) throws ClassNotFoundException {
        Study05 d = new Study05();
        d.setAa(45);
        d.add(5, 6);
        System.out.println(d.toString());
        Study04 i = new Study04();
        System.out.println(i.toString());
        Date ij = new Date();
        System.out.println(ij.toString());
        List<String>list = new ArrayList<String>();
        list.add("????????????");  //????????????????????????
        list.add("????????????");  //????????????????????????
        list.add("????????????");  //????????????????????????
        List list2 = new ArrayList();
        list2.add(9);
        list2.add("dad");
        System.out.println(list2);
        System.out.println(list);
        String[] in = {"55", "55", "5"};
        System.out.println(in[0]);
        Class c1 = Study04.class;
        System.out.println(c1);
        Class c2 = c1.getClass();
        System.out.println(c2);
        Class c3 = Class.forName("com.one.Study05");
        System.out.println(c3);
        System.out.println("=========1");
        son1 po = new son1();
        Class c4 = po.getClass();
        Class c5 = c4.getSuperclass();
        System.out.println(c5);
        String c6 = c4.getSimpleName();
        System.out.println(c6);
        System.out.println("=========2");
        /*Method c7 = c4.getMethod("add2");
        System.out.println(c7);*//*destroy*/
    }
    }





