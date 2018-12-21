package com.grape.basic8051;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by kbhargav on 2/26/2016.
 */
public class InstructionDescriptionActivity extends AppCompatActivity
{
    TextView textView;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction_description);

        textView = (TextView)findViewById(R.id.textViewDescription);

        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/Slabo27px-Regular.ttf");
        textView.setTypeface(tf);

        intent = getIntent();

        intentCheck("desp_acall");
        

        
        intentCheck("desp_add");
        

        
        intentCheck("desp_addc");
        

        
        intentCheck("desp_ajmp");
        

        
        intentCheck("desp_anl");
        

        
        intentCheck("desp_cjne");
        

        
        intentCheck("desp_clr");
        

        
        intentCheck("desp_cpl");
        

        
        intentCheck("desp_da");
        
        
        intentCheck("desp_dec");
        
        
        intentCheck("desp_div");
        
        
        intentCheck("desp_djnz");
        
        
        intentCheck("desp_inc");
        
        
        intentCheck("desp_jb");
        
        
        intentCheck("desp_jbc");
        
        
        intentCheck("desp_jc");
        
        
        intentCheck("desp_jmp");
        
        
        intentCheck("desp_jnb");
        
        
        intentCheck("desp_jnc");
        
        
        intentCheck("desp_jnz");
        
        
        intentCheck("desp_jz");
        
        
        intentCheck("desp_lcall");
        
        
        intentCheck("desp_ljmp");
        
        
        intentCheck("desp_mov");
        
        
        intentCheck("desp_movc");
        
        
        intentCheck("desp_movx");
        
        
        intentCheck("desp_mul");
        
        
        intentCheck("desp_nop");
        
        
        intentCheck("desp_orl");
        
        
        intentCheck("desp_pop");
        
        
        intentCheck("desp_push");
        
        
        intentCheck("desp_ret");
        
        
        intentCheck("desp_reti");
        
        
        intentCheck("desp_rl");
        
        
        intentCheck("desp_rlc");
        
        
        intentCheck("desp_rr");
        
        
        intentCheck("desp_rrc");
        
        
        intentCheck("desp_setb");
        
        
        intentCheck("desp_sjmp");
        
        
        intentCheck("desp_subb");
        
        
        intentCheck("desp_swap");
        
        
        intentCheck("desp_xch");
        
        
        intentCheck("desp_xchd");
        
        
        intentCheck("desp_xrl");

        intentCheck("details");

    }

    public void intentCheck(String code)
    {
        if(intent.hasExtra(code))
        {
            textView.setText(intent.getStringExtra(code));
        }
    }
}
