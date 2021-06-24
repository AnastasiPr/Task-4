package com.company;
import java.util.*;

import static java.lang.Math.abs;
//4 задачи
public class Main {

    public static String SevenBoom (int[] a){
        String str = "";
        for (int i = 0; i < a.length-1; i++){
           str += a[i];
        }
        if (str.contains("7")) return "Boom";
        else return "There is no 7 in the array";
    }

    public static boolean Cons(ArrayList<Integer> a){
        for (int t:a) {
            if (a.indexOf(t)!=a.lastIndexOf(t)) return false;
        }
        a.sort(null);
        for (int i=0; i<a.size()-1; i++){
            if (a.get(i+1)-a.get(i) != 1) return false;
        }
        return true;
    }

    public static String Unmix(String str) {
        char[] mychar = str.toCharArray();
        char t;
        for (int i = 0; i < mychar.length - 1; i += 2) {
            if (i + 1 != mychar.length) {
                t = mychar[i];
                mychar[i] = mychar[i + 1];
                mychar[i + 1] = t;
            }
        }
        return String.valueOf(mychar);
    }

    public static String NoYelling(String str) {
        int endIndex = str.length();
        if (str.charAt(str.length() - 1) == '!' || str.charAt(str.length() - 1) == '?') {
            char yell = str.charAt(str.length() - 1); //charAt - метод извлечения символа из строки

            for (int i = str.length() - 1; str.charAt(i - 1) == yell; i = i - 1) //до какого элемента есть ?/!
                endIndex = i;
        }
        return str.substring(0, endIndex); //возвращает новую строку, которая является подстрокой данной строки. Подстрока начинается с символа, заданного индексом, и продолжается до конца данной строки
    }

    public static String xPronounce(String str1){
        String[] arr = str1.split(" ");
        String str2 = "";
        for (int i =0;i< arr.length;i++){
            if (arr[i].equals("x")) arr[i]="ecks";
            else {
                if (arr[i].charAt(0) == 'x') arr[i] = arr[i].replaceFirst("x", "z");
                arr[i]=arr[i].replaceAll("x","cks");
            }
            str2+=arr[i]+" ";
        }
        return  str2;
    }

    public static int LargestGap(List<Integer> lst){

        Collections.sort(lst);
        int maxGap=0;
        for (int i=0; i<lst.size()-1;i++){
            if (Math.abs(lst.get(i)-lst.get(i+1))>maxGap) maxGap=Math.abs(lst.get(i)-lst.get(i+1));
        }
        return maxGap;
    }

    public static int Alg(int oldNum){
        ArrayList<Integer> myNums = new ArrayList<Integer>();
        int iterations=-1, newNum=0;
        int memory = oldNum;
        while (oldNum>0){
            myNums.add(oldNum % 10);
            oldNum = Math.floorDiv(oldNum,10); // oldNum/10; возвращает наибольшее (самое близкое к положительной бесконечности) int значение, которое меньше или равно алгебраическому коэффициенту.
            iterations++;
        }
        Collections.sort(myNums);
        for (int temp:myNums) {
            newNum += temp*(Math.pow(10,iterations)); // 10^iterations
            iterations--;
        }
        return memory-newNum;
    }

    public static Character CommonLastVowel(String inpStr){
        Map<Character, Integer> vowels = new HashMap<Character,Integer>();
        vowels.put('a', 0);
        vowels.put('e', 0);
        vowels.put('o', 0);
        vowels.put('u', 0);
        vowels.put('y', 0);
        vowels.put('i', 0);

        int maximum=0;
        Character answer='n';
        inpStr= inpStr.toLowerCase(Locale.ROOT);
        String[] words = inpStr.split(" ");

        for (String word:words) {
            Character lastLetter = word.charAt(word.length()-1);
            if (vowels.containsKey(lastLetter)){
                int newVal = (Integer)vowels.get(lastLetter)+1;
                vowels.put(Character.valueOf(lastLetter), (Integer)newVal);
            }
        }
        for (Map.Entry dic :vowels.entrySet()) {
            if ((int)dic.getValue()>maximum){
                maximum = (int)dic.getValue();
                answer = (Character)dic.getKey();
            }
        }
        return answer;
    }

    public static int HelpMeme(int razr, int howMuch){
        while (howMuch>0){
            razr=razr*10;
            howMuch=Math.floorDiv(howMuch,10);
        }
        return razr;
    }
    public static int MemeSum(int a, int b){
        int sum=0;
        while (a!=0 || b!=0){
            int t = a % 10 +b % 10;
            sum += HelpMeme(t,sum); //прибавляем добавляя разряды
            a = Math.floorDiv(a,10);
            b = Math.floorDiv(b,10);
        }
        return sum;
    }

    public static String UnRepeated(String str) {
        char[] arr = str.toCharArray();
        String newStr = "";
        for (Character t:arr){
            if (!newStr.contains(String.valueOf(t))){
                newStr = newStr + String.valueOf(t);
            }
        }
        return newStr;
    }

        public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //1

        System.out.println(SevenBoom(new int[] {7, 5, 6, 9, 0}));
        System.out.println(SevenBoom(new int[] {4, 5, 6, 9, 0}));

        //2


        System.out.println(Cons(new ArrayList<Integer >() {{
            add(5);
            add(1);
            add(4);
            add(3);
            add(2);
            add(8);
        }}));

        //3

       System.out.println(Unmix(scan.nextLine()));

       //4

       System.out.println(NoYelling(scan.nextLine()));

       //5

        System.out.println(xPronounce(scan.nextLine()));

        //6

        System.out.println(LargestGap(new ArrayList<Integer >() {{
            add(9);
            add(4);
            add(26);
            add(26);
            add(0);
            add(0);
            add(5);
            add(20);
            add(6);
            add(25);
            add(5);
        }}));

        //7

        System.out.println(Alg(scan.nextInt()));

        //8

        System.out.println(CommonLastVowel(scan.nextLine()));

        //9

        System.out.println(MemeSum(scan.nextInt(), scan.nextInt()));


        }
}
