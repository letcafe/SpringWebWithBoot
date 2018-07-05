package com.spring.source.study;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        String[] strArray = new String[count];
        for (int i = 0; i < count; i++) {
            strArray[i] = scanner.next();
        }
        String[] telDictionary = new String[]{"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};
        for (int i = 0; i < strArray.length; i++) {
            List<Character> eachLineCharList = new LinkedList<>();
            for(char element : strArray[i].toCharArray()) {
                eachLineCharList.add(element);
            }
            int[] telCount = new int[telDictionary.length];
            for (int j = 0; j < eachLineCharList.size(); j ++) {
                switch (eachLineCharList.get(j)) {
                    case 'Z':
                        eachLineCharList.remove(new Character('Z'));
                        eachLineCharList.remove(new Character('E'));
                        eachLineCharList.remove(new Character('R'));
                        eachLineCharList.remove(new Character('O'));
                        j = 0;
                        telCount[0] ++;break;
                    case 'W':
                        eachLineCharList.remove(new Character('T'));
                        eachLineCharList.remove(new Character('W'));
                        eachLineCharList.remove(new Character('O'));
                        j = 0;
                        telCount[2] ++;break;
                    case 'U':
                        eachLineCharList.remove(new Character('F'));
                        eachLineCharList.remove(new Character('O'));
                        eachLineCharList.remove(new Character('U'));
                        eachLineCharList.remove(new Character('R'));
                        j = 0;
                        telCount[4] ++;break;
                    case 'X':
                        eachLineCharList.remove(new Character('S'));
                        eachLineCharList.remove(new Character('I'));
                        eachLineCharList.remove(new Character('X'));
                        j = 0;
                        telCount[6] ++;break;
                    case 'G':
                        eachLineCharList.remove(new Character('E'));
                        eachLineCharList.remove(new Character('I'));
                        eachLineCharList.remove(new Character('G'));
                        eachLineCharList.remove(new Character('H'));
                        eachLineCharList.remove(new Character('T'));
                        telCount[8] ++;break;
                }
            }
            for (int j = 0; j < eachLineCharList.size(); j ++) {
                switch (eachLineCharList.get(j)) {
                    case 'O':
                        eachLineCharList.remove(new Character('O'));
                        eachLineCharList.remove(new Character('N'));
                        eachLineCharList.remove(new Character('E'));
                        j = 0;
                        telCount[1] ++;break;
                    case 'T':
                        eachLineCharList.remove(new Character('T'));
                        eachLineCharList.remove(new Character('H'));
                        eachLineCharList.remove(new Character('R'));
                        eachLineCharList.remove(new Character('E'));
                        eachLineCharList.remove(new Character('E'));
                        j = 0;
                        telCount[3] ++;break;
                    case 'F':
                        eachLineCharList.remove(new Character('F'));
                        eachLineCharList.remove(new Character('I'));
                        eachLineCharList.remove(new Character('V'));
                        eachLineCharList.remove(new Character('E'));
                        j = 0;
                        telCount[5] ++;break;
                    case 'S':
                        eachLineCharList.remove(new Character('S'));
                        eachLineCharList.remove(new Character('E'));
                        eachLineCharList.remove(new Character('V'));
                        eachLineCharList.remove(new Character('E'));
                        eachLineCharList.remove(new Character('N'));
                        j = 0;
                        telCount[7] ++;break;
                }
            }
            for (int j = 0; j < eachLineCharList.size(); j ++) {
                if(eachLineCharList.get(j) == 'I') {
                    eachLineCharList.remove(new Character('N'));
                    eachLineCharList.remove(new Character('I'));
                    eachLineCharList.remove(new Character('N'));
                    eachLineCharList.remove(new Character('E'));
                    j = 0;
                    telCount[9] ++;
                }
            }
            for (int k = 0; k < telCount.length; k ++) {
                System.out.println(k + "=>" + telCount[k]);
//                if(telCount[k] != 0) {
//                    for(int n = 0; n < telCount[k]; n ++) {
////                        System.out.println(k + "=>" + );
//                        if (k <= 7) {
//                            System.out.print(k + 2);
//                        } else {
//                            System.out.print(k - 8);
//                        }
//                    }
//                }
            }
            System.out.println("++++++");
        }
    }
}
