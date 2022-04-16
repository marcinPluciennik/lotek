package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Lotek implements Game{

    private final int LIMIT_OF_NUMBERS = 6;
    private final int START_NUMBER = 1;
    private final int END_NUMBER = 99;
    List<Integer> userNumbers = new ArrayList<>();
    List<Integer> computerNumbers = new ArrayList<>();

    @Override
    public void play() {
        giveUserNumbers();
        showUserNumbers();
        showComputerNumbers();
        showResult();
    }

    public void giveUserNumbers(){
        int userNumber;
        System.out.println("LET'S PLAY -> LOTEK");
        for (int i = 1; i <= LIMIT_OF_NUMBERS; i++) {
            boolean isNumberNotOK = true;
            do {
                System.out.print("GIVE YOUR " + i + " NUMBER (1-99): ");
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNextInt()) {
                    userNumber = scanner.nextInt();
                    if (userNumber >= START_NUMBER && userNumber <= END_NUMBER && !userNumbers.contains(userNumber)) {
                        userNumbers.add(userNumber);
                        isNumberNotOK = false;
                    } else {
                        System.out.println("IT'S NOT A NUMBER (1-99) OR IT EXISTS ON YOUR LIST ALREADY -> TRY AGAIN:");
                    }
                } else {
                    System.out.println("ARE YOU BLIND? IT'S NOT A NUMBER! -> TRY AGAIN:");
                }
            } while (isNumberNotOK);
        }
    }

    public void showUserNumbers(){
        System.out.println("========================================");
        System.out.println("YOUR NUMBERS :" + userNumbers);
    }

    public void randomComputerNumbers(){
        for (int i = 1; i <= LIMIT_OF_NUMBERS; i++ ){
            boolean isNumberNotOK = true;
            do{
                int number = ThreadLocalRandom.current().nextInt(START_NUMBER,END_NUMBER + 1);
                if (!computerNumbers.contains(number)){
                    computerNumbers.add(number);
                    isNumberNotOK = false;
                }
            } while (isNumberNotOK);
        }
    }

    public void showComputerNumbers(){
        randomComputerNumbers();
        System.out.println("LUCKY NUMBERS :" + computerNumbers);
        System.out.println("========================================");
    }

    public void showResult(){
        List<Integer> resultNumbers = new ArrayList<>();
        for (int i = 0; i < LIMIT_OF_NUMBERS; i++ ){
         if (userNumbers.contains(computerNumbers.get(i))){
             resultNumbers.add(computerNumbers.get(i));
         }
        }
        System.out.println("MATCHING NUMBERS :" + resultNumbers);
        switch (resultNumbers.size()) {
            case 3:
                System.out.println("NOT BAD, YOU WON 100$");
            case 4:
                System.out.println("YES, YOU WON 1000$");
            case 5:
                System.out.println("YOU ARE LUCKY GUY, YOU WON 10000$");
            case 6:
                System.out.println("CONGRATULATION!, YOU WON 1000000$");
            default:
                System.out.println("SORRY, MAYBE NEXT TIME :(");
        }
        System.out.println("========================================");
    }
}
