package in.premad.simrantasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EnterNameActivity extends AppCompatActivity {

    public static final String NAME_ADDED = "new_name";
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_name);

        mEditText= findViewById(R.id.enter_name);

        Button button = findViewById(R.id.btn_add);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();

                if(TextUtils.isEmpty(mEditText.getText())){
                    setResult(RESULT_CANCELED, intent);
                }
                else{
                    String name = mEditText.getText().toString();
                    intent.putExtra(NAME_ADDED, name);
                    setResult(RESULT_OK, intent);
                }
                finish();
            }
        });

    }
}
