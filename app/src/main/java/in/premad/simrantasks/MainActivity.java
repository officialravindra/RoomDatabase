package in.premad.simrantasks;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.UUID;

import in.premad.simrantasks.Adapter.CustomAdapter;
import in.premad.simrantasks.Utils.CustomViewModel;
import in.premad.simrantasks.Utils.Name;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;
    private CustomViewModel mViewModel;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        customAdapter= new CustomAdapter(this);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton actionButton = findViewById(R.id.add_fab);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EnterNameActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        mViewModel= ViewModelProviders.of(this).get(CustomViewModel.class);

        mViewModel.getNames().observe(this, new Observer<List<Name>>() {
            @Override
            public void onChanged(List<Name> names) {
                customAdapter.setNames(names);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE &&resultCode == RESULT_OK){
            final String name_id = UUID.randomUUID().toString();
            Name name = new Name(name_id, data.getStringExtra(EnterNameActivity.NAME_ADDED));
            mViewModel.insert(name);

            Toast.makeText(this, "Name saved", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Name not saved", Toast.LENGTH_SHORT).show();
        }
    }
}