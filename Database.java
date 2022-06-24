package CLASSWORK26;

import java.util.MissingFormatWidthException;
import java.util.Scanner;

public class Database implements Connectable{
    private String key;
    private String value;

    public Database(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean checkLine(Database[] records, int index)throws AbsentException {
        boolean isExist = false;
        for(int i = 0; i < records.length ;i++){
            if(i == index + 1){
                isExist = true;
            }else {
                throw new AbsentException("There is none exist record with this index");
            }
        }
        return isExist;
    }

    @Override
    public boolean openCon(boolean connection)throws MissingFormatWidthException {
        if(connection){
            throw new MissingFormatWidthException("Connection is already opened");
        }else {
            connection = true;
        }
        return connection;
    }

    @Override
    public boolean closeCon(boolean connection)throws MissingFormatWidthException {
        if(connection){
            connection = false;
        }else {
            throw new MissingFormatWidthException("Connection is already closed");
        }
        return connection;
    }

    @Override
    public boolean checkCon(boolean connection) {
        return false;
    }

    @Override
    public void printLine(Database[] records,int index)throws AbsentException {
        for(int i = 0; i < records.length;i++){
            if(index + 1 == i){
                System.out.println(records[i]);
            }else{
                throw new AbsentException("There is none exist record with this index");
            }
        }
    }



    @Override
    public void printLine(Database[] records,String key)throws AbsentException {
        for(int i = 0; i < records.length;i++){
            if(records[i].getKey().equals(key)){
                System.out.println(records[i]);
            }else{
                throw new AbsentException("There is none exist record with this key");
            }
        }
    }

    @Override
    public boolean checkLine(Database[] records, String key)throws AbsentException {
        boolean isExist = false;
        for(int i = 0; i < records.length ;i++){
            if(records[i].getKey().equals(key)){
                isExist = true;
            }else {
                throw new AbsentException("There is none exist record with this key");
            }
        }
        return isExist;
    }

    @Override
    public void printLines(Database[] records, int firstRecord, int lastRecord)throws AbsentException {
        if(firstRecord > records.length || lastRecord > records.length || firstRecord < 0 || lastRecord < 0){
            if(firstRecord > lastRecord){
                for(int i = firstRecord ;i > lastRecord; i-- ){
                    System.out.println(records[i]);
                }
            }else{
                for(int i = lastRecord; i <=firstRecord;i++){
                    System.out.println(records[i]);
                }
            }
        }else{
            throw new AbsentException("Choose correct numbers of records!!!");
        }

    }

    @Override
    public void countOfRecords(Database[] records) {
        System.out.println("Count of records is " + records.length);
    }

    @Override
    public Database recordLine(Database[] records) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("Enter the key of record:");
            String key = sc.nextLine();
            for (int i = 0; i < records.length; i++) {
                if (records[i].getKey().equals(key)){
                    System.out.println("You have to create another key, this one is already exist");
                    continue;
                }else{
                    System.out.print("Enter the value of record:");
                    String value = sc.nextLine();
                    Database record = new Database(key,value);
                    return record;
                }
            }
        }
    }

    @Override
    public Database[] replaceLine(Database[] records, int index) {
        return new Database[0];
    }

    @Override
    public Database[] replaceLine(Database[] records, String key) {
        return new Database[0];
    }

    @Override
    public String toString() {
        return "{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
