package com.careerdevs;

import com.careerdevs.ui.CLI;

import java.util.Random;

public class Main {
    public static int money = 1000;
    public static Random rand = new Random();
    public static void main(String[] args) {
	// write your code here
        mainMenu();
    }
    public static void mainMenu(){
      int selection =  CLI.readInt("1)Play\n2)Exit\n3)Cheats\nSelection",1,3);
      if(selection == 1){
          game();
          return;
      }else if(selection == 3){
          cheatsMenu();
          return;
      }else{

      }
    }

    public static void game(){
        int total = 0;
        int dealerTotal = 0;
        System.out.println("Money: "+money );
        int bet = CLI.readInt("Bet? ",1,money);
        while(total <= 21){
            System.out.println("Total: "+total);
            int selection = CLI.readInt("1)Hit\n2)Stand\nSelection",1,2);
            if(selection == 1){
                total += rand.nextInt(1,11);
            }else{
                if(total == 21){
                    System.out.println("You Win!");
                    money += bet;
                    System.out.println("Money: "+money );
                    mainMenu();
                    return;
                }
                dealerTotal += rand.nextInt(15,21);
                System.out.println("Dealer: "+dealerTotal);
                System.out.println("Total: "+total);
                if(dealerTotal > total){
                    System.out.println("You Lose!");
                    money -= bet;
                    System.out.println("Money: "+money );
                    mainMenu();
                    return;
                }else{
                    System.out.println("You Win!");
                    money += bet;
                    System.out.println("Money: "+money );
                    mainMenu();
                    return;
                }
            }


        }
        System.out.println("Total: "+total);
        System.out.println("You lose!");
        money -= bet;
        System.out.println("Money: "+money );
        mainMenu();
        return;
    }



    public static void cheatsMenu(){
        System.out.println("Cheats");
        String cheat = CLI.readString("Insert Cheat");
        if(cheat.equals("MoneyMan")){
            money += 1000;
        }else if(cheat.equals("exit")){
            mainMenu();
            return;
        }
        else{
            System.out.println("Cheat Invalid!");
        }

        cheatsMenu();
        return;

    }
}
