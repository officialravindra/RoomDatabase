package in.premad.simrantasks.Utils;


import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.room.Insert;

import java.util.List;

import in.premad.simrantasks.persistence.NameDao;
import in.premad.simrantasks.persistence.NameDatabase;

public class CustomViewModel extends AndroidViewModel {

    private NameDao nameDao;
    private NameDatabase nameDB;
    private LiveData<List<Name>> mNames;

    public CustomViewModel(@NonNull Application application) {
        super(application);

        nameDB= NameDatabase.getInstance(application);
        nameDao= nameDB.nameDao();
        mNames= nameDao.getAllNames();
    }

    public LiveData<List<Name>>getNames() {
        return mNames;
    }

    public void insert(Name name){
        new InsertNameTask(nameDao).execute(name);
    }

    private class InsertNameTask extends AsyncTask<Name, Void, Void> {

        NameDao mNameDao;

        public InsertNameTask(NameDao nameDao) {
            mNameDao= nameDao;
        }

        @Override
        protected Void doInBackground(Name... names) {
            nameDao.insert(names[0]);
            return null;
        }
    }
}