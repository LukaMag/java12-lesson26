package CLASSWORK26;

import java.util.MissingFormatWidthException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        run();
    }
    static void run(){
        Database[] records = FileServise.readFile();
        action(records);

    }

    static void action(Database[] records)  {
        boolean connection = false;
        Scanner sc = new Scanner(System.in);
        Database someRecord = new Database(789,"kkk-vvv");
        int command = 0;
        while(true){
            try {
                printMenu();
                String com = sc.nextLine();
                command = parseToInt(com);
                isCapableCommand(command);
                break;
            }catch (NumberFormatException | IndexOutOfBoundsException e){
                System.out.println(e.getMessage());
            }
        }
        switch (command){
            case 1 :
                while(true){
                    try{
                        connection = records[0].openCon(connection);
                        break;
                    }catch (MissingFormatWidthException e){
                        System.out.println(e.getMessage());
                        action(records);
                    }
                }
                break;
            case 2 :
                while(true){
                    try{
                        connection = someRecord.closeCon(connection);
                        break;
                    }catch (MissingFormatWidthException e){
                        System.out.println(e.getMessage());
                        action(records);
                    }
                }
                break;
            case 3:
                someRecord.checkCon(connection);
                break;
            case 4:
                while(true){
                    String i = "";
                    int index = 0;
                    try{
                        System.out.print("Enter index of record:");
                        i = sc.nextLine();
                        index = parseToInt(i);
                        records[0].printLine(records,index);
                        break;
                    }catch (AbsentException e){
                        System.out.println(e.getMessage());
                        action(records);
                    }
                }
                break;
            case 5:
                while(true){
                    String key = "";
                    int key1 = 0;
                    try{
//                        connection = isOpenedConnection(connection);
                        System.out.print("Enter key of record:");
                        key = sc.nextLine();
                        key1 = parseToInt(key);
                        records[0].checkLine(records,key1);
                        break;
                    }catch (AbsentException  e){
                        System.out.println(e.getMessage());
                    }
                }
                break;
            case 6:
                while(true){
                    int index = 0;
                    try{
                        index = enterIndex();
                        records[0].printLine(records,index);
                        break;
                    }catch (AbsentException e){
                        System.out.println(e.getMessage());
                        action(records);
                    }
                }
                break;
            case 7:
                while(true){
                    String key = "";
                    int key1 = 0;
                    try{
                        System.out.print("Enter key of record:");
                        key = sc.nextLine();
                        key1 = parseToInt(key);
                        someRecord.printLineByKey(records,key1);
                        break;
                    }catch (AbsentException e){
                        System.out.println(e.getMessage());
                        action(records);
                    }
                }
                break;
            case 8:
                while(true){
                    int firstIndex = 0;
                    int secondIndex = 0;
                    try{
//                        connection = isOpenedConnection(connection);
                        System.out.print("First ");
                        firstIndex = enterIndex();
                        System.out.print("Second ");
                        secondIndex = enterIndex();
                        someRecord.printLines(records,firstIndex,secondIndex);
                        break;
                    }catch (AbsentException e){
                        System.out.println(e.getMessage());
                    }
                }
                break;
            case 9:
                someRecord.countOfRecords(records);
                break;
            case 10:
                someRecord.recordLine(records);
                break;
            case 11:
                while(true){
                    int index = 0;
                    try{
//                        connection = isOpenedConnection(connection);
                        index = enterIndex();
                        someRecord.replaceLine(records,index);
                        break;
                    }catch (AbsentException e){
                        System.out.println(e.getMessage());
                    }
                }
                break;
            case 12:
                while(true){
                    String key = "";
                    try{
//                        connection = isOpenedConnection(connection);
                        System.out.print("Enter key of record:");
                        key = sc.nextLine();
                        someRecord.replaceLine(records,key);
                        break;
                    }catch (AbsentException e){
                        System.out.println(e.getMessage());
                    }
                }
                break;
        }
        System.out.println(connection);
    }


    static boolean isOpenedConnection(boolean connection)throws NoneExistConnectionException {
        if(connection){
            return connection;
        }else{
            throw new NoneExistConnectionException("You can not do anything without opened connection(((");
        }
    }

    static void printMenu(){
        System.out.println("Some commands to manipulate with database");
        System.out.println("+----------------------------------------+");
        System.out.println("1  - to open connection");
        System.out.println("2  - to close connection");
        System.out.println("3  - to check state of connection");
        System.out.println("4  - to show a record by index of it");
        System.out.println("5  - to check existence of record by key of it");
        System.out.println("6  - to show a record by key of it");
        System.out.println("7  - to show some records by gap (from .. to ..)");
        System.out.println("8  - to show count of records");
        System.out.println("9  - to add new record");
        System.out.println("10 - to update a value of record by index of it");
        System.out.println("11 - to update a value of record by key of it");
    }

    static int parseToInt(String num) throws NumberFormatException{
        try{
            int number = Integer.parseInt(num);
            return number;
        }catch (NumberFormatException e){
            throw new NumberFormatException("Format hve to be Integer");
        }
    }
    static int isCapableCommand(int command)throws IndexOutOfBoundsException{
        if(command < 1 || command > 12){
            throw new IndexOutOfBoundsException("Choose correct number of command");
        }else{
            return command;
        }
    }

    static int enterIndex(){
        Scanner sc = new Scanner(System.in);
        int index = 0;
        while(true) {
            try {
                System.out.print("Enter index of record:");
                String ind = sc.nextLine();
                index = parseToInt(ind);
                return index;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }

    }
}
