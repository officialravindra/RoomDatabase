package in.premad.simrantasks.persistence;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import in.premad.simrantasks.Utils.Name;

@Dao
public interface NameDao {

    @Insert
    void insert(Name name);

    @Query("SELECT * FROM names")
    LiveData<List<Name>> getAllNames();
}