package com.example.aryam.test.model;

import android.content.Context;
import android.database.Cursor;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by arya.m on 11/15/2016.
 */
public class QuzSQliteDbWrapper  {
    static final String TABLE_QUESTION= "Questiontbl" ;
    QuzSQliteDb qdb;

    public boolean openLocalDb(Context ctx){
        boolean dbcreated=true;
        qdb= new QuzSQliteDb(ctx);
        try {
            qdb.createDataBase();
            qdb.openDataBase();
        }
        catch (IOException e ){
            dbcreated= false;
        }
        catch (SQLException sqle){
            dbcreated=false;
        }
        return dbcreated;
    }
    public void closeLocalDb(){
        if(qdb!=null){
            qdb.close();
        }
    }


    public Cursor readAllData(){
        return qdb.readAllRecords(TABLE_QUESTION, null);
    }

}

