package in.premad.simrantasks.Utils;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "names")
public class Name {

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    @PrimaryKey
    @NonNull
    private String id;

    @NonNull
    @ColumnInfo(name = "name")
    private String mName;

    public Name(@NonNull String id, @NonNull String name) {
        this.id = id;
        mName= name;
    }

    @NonNull
    public String getName() {
        return mName;
    }
}
