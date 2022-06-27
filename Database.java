package CLASSWORK26;

import java.util.MissingFormatWidthException;

public class Database implements Connectable{
    private int key;
    private String value;

    public Database(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }



    @Override
    public  boolean openCon(boolean connection)throws MissingFormatWidthException {
        if(connection){
            throw new MissingFormatWidthException("Connection is already opened");
        }else {
            System.out.println("Connection is successfully opened");
            connection = true;

        }
        return connection;
    }

    @Override
    public boolean closeCon(boolean connection)throws MissingFormatWidthException {
        if(connection){
            System.out.println("Connection is successfully closed");
            connection = false;
        }else {
            throw new MissingFormatWidthException("Connection is already closed");
        }
        return connection;
    }

    @Override
    public void checkCon(boolean connection) {
        if(connection){
            System.out.println("Connection is open");
        }else{
            System.out.println("Connection is closed");
        }
    }

    @Override
    public void printLine(Database[] records, int index) throws AbsentException {
        if (index > records.length || index < 1) {
                throw new AbsentException("There is none record with this index");
        }else{
            for (int i = 1; i < records.length; i++) {
                if (index - 1 == i) {
                    System.out.println(records[i]);
                }
            }
        }
    }

    @Override
    public void printLineByKey(Database[] records,int key) throws AbsentException {
        for (Database d:
             records) {
            System.out.println(d);
            if(d.key == key){
                System.out.println(d);
            }else{
                throw new AbsentException("There is none record with this key");
            }
        }
//        for(int i = 0; i < records.length; i++){
//            System.out.println(records[i].getKey());
//            if(records[i].getKey() == key){
//                System.out.println(records[i]);
//            }else{
//                throw new AbsentException("There is none record with this key");
//            }
//        }
    }

    @Override
    public boolean checkLine(Database[] records, int index) throws AbsentException {
        boolean isExist = false;
        if (index > records.length || index < 1) {
            throw new AbsentException("There is none record with this index");
        }else{
            for (int i = 1; i < records.length; i++) {
                if (index - 1 == i) {
                    System.out.println("Record is " + records[i]);
                    isExist = true;
                }
            }
        }
        return isExist;
    }

    @Override
    public boolean checkLineByKey(Database[] records, int key) throws AbsentException {
        boolean isExist = false;
            for (int i = 1; i < records.length; i++) {
                if (key == records[i].key) {
                    System.out.println("Record is " + records[i]);
                    isExist = true;
                }else {
                    throw new AbsentException("There is none record with this key");
                }
            }
        return isExist;
    }

    @Override
    public void printLines(Database[] records, int firstRecord, int lastRecord) throws AbsentException {

    }

    @Override
    public void countOfRecords(Database[] records) {

    }

    @Override
    public Database recordLine(Database[] records) {
        return null;
    }

    @Override
    public Database[] replaceLine(Database[] records, int index) throws AbsentException {
        return new Database[0];
    }

    @Override
    public Database[] replaceLine(Database[] records, String key) throws AbsentException {
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
