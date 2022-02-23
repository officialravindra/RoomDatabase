package in.premad.simrantasks.persistence;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import in.premad.simrantasks.Utils.Name;

@Database(entities = Name.class, version = 1)
public abstract class NameDatabase extends RoomDatabase {

    public abstract NameDao nameDao();

    private static volatile NameDatabase nameDatabaseInstance;

    public static NameDatabase getInstance(final Context context){
        if(nameDatabaseInstance== null){
            synchronized(NameDatabase.class){
                if(nameDatabaseInstance== null){
                    nameDatabaseInstance= Room.databaseBuilder(context.getApplicationContext(),
                            NameDatabase.class, "name_database")
                            .build();
                }
            }
        }
        return nameDatabaseInstance;
    }
}