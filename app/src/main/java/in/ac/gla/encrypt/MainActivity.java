package in.ac.gla.encrypt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{

    private EditText etInput, etOutput;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = findViewById(R.id.et_input);

        etOutput = findViewById(R.id.et_output);

        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String output = "";
                char key = 13;
                String message = etInput.getText().toString().trim();
                for (int i = 0; i < message.length(); i++)
                {
                    char input = message.charAt(i);
                    if (input >= 'a' && input <= 'z')
                    {
                        input += key;
                        if (input > 'z')
                        {
                            input -= 26;
                        }
                        if (input < 'a')
                        {
                            input += 26;
                        }
                        output = output.concat(Character.toString(input));
                        etOutput.setText(output);
                    }
                }
            }
        });
    }
}
