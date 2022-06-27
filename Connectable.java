package CLASSWORK26;

import java.util.MissingFormatWidthException;

public interface Connectable {
     boolean openCon(boolean connection)throws MissingFormatWidthException;
     boolean closeCon(boolean connection)throws MissingFormatWidthException;
     void checkCon(boolean connection);
    void printLine(Database[] records,int index)throws AbsentException;
    void printLineByKey(Database[] records,int key)throws AbsentException;
    boolean checkLine(Database[] records, int index)throws AbsentException;
    boolean checkLineByKey(Database[] records, int key)throws AbsentException;
    void printLines(Database[] records,int firstRecord, int lastRecord)throws AbsentException;
    void countOfRecords(Database[] records);
    Database recordLine(Database[] records);
    Database[] replaceLine(Database[] records,int index)throws AbsentException;
    Database[] replaceLine(Database[] records,String key)throws AbsentException;

}
