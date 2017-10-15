package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class Function {


    private int option;
    Stack<String> historyStack = new Stack<>();
    Stack<String> deletedStack = new Stack<>();


    public void menu() {
        //Show Menu unless Exit(5) is choosen, Repeats it while the 5 is not pressed
        //If user inputs unexpected it will ask hagain to the user
        System.out.println("\t\t\t\t\t\t\t.:MENU:.\n");

        do {

            if(historyStack.size() == 10){
                System.out.println("Your history is full. Thank you for using this document. Goodbye!");
                quitShow();
                break;
            }

            Scanner scanner = new Scanner(System.in);
            try {
                System.out.print("1. Input String,\t2. Copy,\t3. Delete,\t4. Undo,\t5. quit");

                System.out.println();
                System.out.print("Enter Option number : ");
                option = scanner.nextInt();
                if (historyStack.empty() && option != 1) {

                    if (deletedStack.empty()) {
                        System.out.println("Your history is empty. Please add a string: ");
                        inputString();
                        continue;
                    } else {
                        System.out.println("Empty enter string");
                        inputString();
                    }
                }


            } catch (InputMismatchException e) {
                System.out.println("Wrong input. Please enter a number.");
                continue;
            }


            System.out.println();

            //Switch statement that acts depending on number entered
            switch (option) {
                case 1:
                    //call method
                    inputString();
                    System.out.println();
                    break;
                case 2:
                    //call method
                    copyString();
                    System.out.println();
                    break;
                case 3:
                    //Call method
                    deleteString();
                    System.out.println();
                    break;
                case 4:
                    //Call method
                    undoString();
                    System.out.println();
                    break;
                case 5:
                    System.out.println("'5' was pressed the program will END ");
                    quitShow();
                    scanner.close();
                    break;
                default:
                    System.out.println("\t\t\t\tError, wrong menu option");
                    System.out.println();
            }

        } while (option != 5);
    }

    public void inputString() {

        System.out.print("Enter the string you wish to add to the stack: ");
        Scanner line = new Scanner(System.in);
        String input = line.nextLine();
        System.out.println(input);
        historyStack.push(input);
        System.out.println("We added " + historyStack.peek() + " to the Stack");
    }

    public void copyString() {
        String copiedStr = historyStack.peek();
        historyStack.push(copiedStr);
        System.out.println("We copied " + historyStack.peek() + " to the Stack");

    }

    public void deleteString() {
        System.out.println("You will delete the last entered String");
        String deletedStr = historyStack.peek();
        deletedStack.push(deletedStr);
        System.out.println("We deleted " + historyStack.peek() + " from the Stack");
        historyStack.pop();

    }

    public void undoString() {

        System.out.println("You will recover deleted String");
        String recoverStr = deletedStack.peek();
        historyStack.push(recoverStr);
        System.out.println();
        System.out.println("We recovered " + recoverStr + " to the Stack");

    }

    public void quitShow() {

        System.out.print("The last String in the Stack is : ");
        System.out.println(historyStack.peek());

    }
}
