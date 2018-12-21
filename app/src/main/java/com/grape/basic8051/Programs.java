package com.grape.basic8051;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.purplebrain.adbuddiz.sdk.AdBuddiz;
import com.purplebrain.adbuddiz.sdk.AdBuddizLogLevel;

/**
 * Created by rarodi on 12/15/2015.
 */
public class Programs extends Activity
{
    Button b1;
    TextView tv,tva;

    String program;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.programs);

        final Activity activity = this;
        AdBuddiz.setLogLevel(AdBuddizLogLevel.Info);    // log level
        AdBuddiz.setPublisherKey("48e15c7c-fd9f-488b-8a68-4346d8d3d34c"); // replace with your app publisher key
        AdBuddiz.cacheAds(activity);

        //TextView tv,tva;

        tv = (TextView)findViewById(R.id.textView3);
        tva = (TextView)findViewById(R.id.textView1);

        String fontpath = "fonts/Slabo27px-Regular.ttf";
        Typeface tf = Typeface.createFromAsset(getAssets(), fontpath);

        tv.setTypeface(tf);
        tva.setTypeface(tf);

        b1 = (Button)findViewById(R.id.button1);
        final Intent i = getIntent();

        if(i.hasExtra("c1"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            program = i.getStringExtra("c1");
            tv.setText(program);
            tva.setText("PROGRAM 1");
            AdBuddiz.cacheAds(this);
        }

        if(i.hasExtra("c2"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            program = i.getStringExtra("c2");
            tv.setText(program);
            tva.setText("PROGRAM 2");
            AdBuddiz.cacheAds(this);
        }

        if(i.hasExtra("c3"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            program = i.getStringExtra("c3");
            tv.setText(program);
            tva.setText("PROGRAM 3");
            AdBuddiz.cacheAds(this);
        }

        if(i.hasExtra("c4"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            program = i.getStringExtra("c4");
            tv.setText(program);
            tva.setText("PROGRAM 4");
            AdBuddiz.cacheAds(this);
        }

        if(i.hasExtra("c5"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            program = i.getStringExtra("c5");
            tv.setText(program);
            tva.setText("PROGRAM 5");
            AdBuddiz.cacheAds(this);
        }

        if(i.hasExtra("c6"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            program = i.getStringExtra("c6");
            tv.setText(program);
            tva.setText("PROGRAM 6");
            AdBuddiz.cacheAds(this);
        }

        if(i.hasExtra("c7"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            program = i.getStringExtra("c7");
            tv.setText(program);
            tva.setText("PROGRAM 7");
            AdBuddiz.cacheAds(this);
        }

        if(i.hasExtra("c8"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            program = i.getStringExtra("c8");
            tv.setText(program);
            tva.setText("PROGRAM 8");
            AdBuddiz.cacheAds(this);
        }

        if(i.hasExtra("c9"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            program = i.getStringExtra("c9");
            tv.setText(program);
            tva.setText("PROGRAM 9");
            AdBuddiz.cacheAds(this);
        }

        if(i.hasExtra("c10"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            program = i.getStringExtra("c10");
            tv.setText(program);
            tva.setText("PROGRAM 10");
            AdBuddiz.cacheAds(this);
        }

        if(i.hasExtra("c11"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            program = i.getStringExtra("c11");
            tv.setText(program);
            tva.setText("PROGRAM 11");
            AdBuddiz.cacheAds(this);
        }

        if(i.hasExtra("c12"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            program = i.getStringExtra("c12");
            tv.setText(program);
            tva.setText("PROGRAM 12");
            AdBuddiz.cacheAds(this);
        }

        if(i.hasExtra("c13"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            program = i.getStringExtra("c13");
            tv.setText(program);
            tva.setText("PROGRAM 13");
            AdBuddiz.cacheAds(this);
        }

        if(i.hasExtra("c14"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            program = i.getStringExtra("c14");
            tv.setText(program);
            tva.setText("PROGRAM 14");
            AdBuddiz.cacheAds(this);
        }

        if(i.hasExtra("c15"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            program = i.getStringExtra("c15");
            tv.setText(program);
            tva.setText("PROGRAM 15");
            AdBuddiz.cacheAds(this);
        }

        if(i.hasExtra("c16"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            program = i.getStringExtra("c16");
            tv.setText(program);
            tva.setText("PROGRAM 16");
            AdBuddiz.cacheAds(this);
        }

        if(i.hasExtra("c17"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            program = i.getStringExtra("c17");
            tv.setText(program);
            tva.setText("PROGRAM 17");
            AdBuddiz.cacheAds(this);
        }

        if(i.hasExtra("c18"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            program = i.getStringExtra("c18");
            tv.setText(program);
            tva.setText("PROGRAM 18");
            AdBuddiz.cacheAds(this);
        }

        if(i.hasExtra("c19"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            program = i.getStringExtra("c19");
            tv.setText(program);
            tva.setText("PROGRAM 19");
            AdBuddiz.cacheAds(this);
        }

        if(i.hasExtra("c20"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            program = i.getStringExtra("c20");
            tv.setText(program);
            tva.setText("PROGRAM 20");
            AdBuddiz.cacheAds(this);
        }

        if(i.hasExtra("c21"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            program = i.getStringExtra("c21");
            tv.setText(program);
            tva.setText("PROGRAM 21");
            AdBuddiz.cacheAds(this);
        }

        if(i.hasExtra("c22"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            program = i.getStringExtra("c22");
            tv.setText(program);
            tva.setText("PROGRAM 22");
            AdBuddiz.cacheAds(this);
        }

        if(i.hasExtra("c23"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            program = i.getStringExtra("c23");
            tv.setText(program);
            tva.setText("PROGRAM 23");
            AdBuddiz.cacheAds(this);
        }

        if(i.hasExtra("c24"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            program = i.getStringExtra("c24");
            tv.setText(program);
            tva.setText("PROGRAM 24");
            AdBuddiz.cacheAds(this);
        }

        if(i.hasExtra("c25"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            program = i.getStringExtra("c25");
            tv.setText(program);
            tva.setText("PROGRAM 25");
            AdBuddiz.cacheAds(this);
        }

        if(i.hasExtra("c26"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            program = i.getStringExtra("c26");
            tv.setText(program);
            tva.setText("PROGRAM 26");
            AdBuddiz.cacheAds(this);
        }

        if(i.hasExtra("c27"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            program = i.getStringExtra("c27");
            tv.setText(program);
            tva.setText("PROGRAM 27");
            AdBuddiz.cacheAds(this);
        }

        if(i.hasExtra("c28"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            program = i.getStringExtra("c28");
            tv.setText(program);
            tva.setText("PROGRAM 28");
            AdBuddiz.cacheAds(this);
        }

        if(i.hasExtra("c29"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            program = i.getStringExtra("c29");
            tv.setText(program);
            tva.setText("PROGRAM 29");
            AdBuddiz.cacheAds(this);
        }

        if(i.hasExtra("c30"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            program = i.getStringExtra("c30");
            tv.setText(program);
            tva.setText("PROGRAM 30");
            AdBuddiz.cacheAds(this);
        }

        if(i.hasExtra("c31"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            program = i.getStringExtra("c31");
            tv.setText(program);
            tva.setText("PROGRAM 31");
            AdBuddiz.cacheAds(this);
        }

        if(i.hasExtra("c32"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            program = i.getStringExtra("c32");
            tv.setText(program);
            tva.setText("PROGRAM 32");
            AdBuddiz.cacheAds(this);
        }

        if(i.hasExtra("c33"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            program = i.getStringExtra("c33");
            tv.setText(program);
            tva.setText("PROGRAM 33");
            AdBuddiz.cacheAds(this);
        }

        if(i.hasExtra("c34"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            program = i.getStringExtra("c34");
            tv.setText(program);
            tva.setText("PROGRAM 34");
            AdBuddiz.cacheAds(this);
        }

        if(i.hasExtra("c35"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            program = i.getStringExtra("c35");
            tv.setText(program);
            tva.setText("PROGRAM 35");
            AdBuddiz.cacheAds(this);
        }


        AdBuddiz.showAd(this);

        String array[] = this.getResources().getStringArray(R.array.inst_array);

        SpannableString ss = new SpannableString(program);

        for (int a = array.length - 1; a >= 0; a--)
        {
            int temp = a;
            //ss.setSpan(new URLSpan(temp))
            if (search(array[a], program) >= 0){
                ss.setSpan(new CustomSpan(temp), search(array[a], program), search(array[a], program) + array[a].length(), 0);

                //ss.setSpan(new ForegroundColorSpan(Color.rgb(27, 94, 32)),search(array[a], program),
                        //search(array[a], program) + array[a].length(), 0);
            }
            tv.setText(ss);
            tv.setMovementMethod(LinkMovementMethod.getInstance());
        }

        // newly added code to highlight the comments
        int semiCounter = 0;
        int slashCounter = 0;
        int temp;

        for(int z=0; z<program.length(); z++)
        {
            if(program.charAt(z) == ';')
            {
                semiCounter = semiCounter + 1;
                Log.e("Semicolon", String.valueOf(semiCounter));
                temp = program.indexOf("\n", z);
                slashCounter = slashCounter + 1;
                Log.e("Slash", String.valueOf(temp));

                ss.setSpan(new ForegroundColorSpan(Color.rgb(0, 200, 83)), z, temp, Spanned.SPAN_INTERMEDIATE);

            }
        }

        tv.setText(ss);
        tv.setMovementMethod(LinkMovementMethod.getInstance());

    }

    public int search(String pat, String txt)
    {
        return txt.indexOf(pat, 0);
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        AdBuddiz.showAd(this);
    }

    public class CustomSpan extends ClickableSpan
    {
        int i;
        public CustomSpan(int i) {
            super();
            this.i = i;
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            ds.setUnderlineText(false);
        }

        @Override
        public void onClick(View widget)
        {
            int id = widget.getId();
            Intent intent = new Intent(Programs.this, InstructionDescriptionActivity.class);
            Log.e("You Clicked", String.valueOf(i));
            putIntent(intent, i);
            startActivity(intent);

            Log.e("ID of the spannable", String.valueOf(id));
        }

        public void putIntent(Intent intent, int value)
        {
            switch(value)
            {
                case 0:
                    intent.putExtra("details", getResources().getString(R.string.desp_acall));
                    break;

                case 1:
                    intent.putExtra("details", getResources().getString(R.string.desp_add));
                    break;

                case 2:
                    intent.putExtra("details", getResources().getString(R.string.desp_addc));
                    break;

                case 3:
                    intent.putExtra("details", getResources().getString(R.string.desp_ajmp));
                    break;

                case 4:
                    intent.putExtra("details", getResources().getString(R.string.desp_anl));
                    break;

                case 5:
                    intent.putExtra("details", getResources().getString(R.string.desp_cjne));
                    break;

                case 6:
                    intent.putExtra("details", getResources().getString(R.string.desp_clr));
                    break;

                case 7:
                    intent.putExtra("details", getResources().getString(R.string.desp_cpl));
                    break;

                case 8:
                    intent.putExtra("details", getResources().getString(R.string.desp_da));
                    break;

                case 9:
                    intent.putExtra("details", getResources().getString(R.string.desp_dec));
                    break;

                case 10:
                    intent.putExtra("details", getResources().getString(R.string.desp_div));
                    break;

                case 11:
                    intent.putExtra("details", getResources().getString(R.string.desp_jnz));
                    break;

                case 12:
                    intent.putExtra("details", getResources().getString(R.string.desp_inc));
                    break;

                case 13:
                    intent.putExtra("details", getResources().getString(R.string.desp_jb));
                    break;

                case 14:
                    intent.putExtra("details", getResources().getString(R.string.desp_jbc));
                    break;

                case 15:
                    intent.putExtra("details", getResources().getString(R.string.desp_jc));
                    break;

                case 16:
                    intent.putExtra("details", getResources().getString(R.string.desp_jmp));
                    break;

                case 17:
                    intent.putExtra("details", getResources().getString(R.string.desp_jnb));
                    break;

                case 18:
                    intent.putExtra("details", getResources().getString(R.string.desp_jnc));
                    break;

                case 19:
                    intent.putExtra("details", getResources().getString(R.string.desp_djnz));
                    break;

                case 20:
                    intent.putExtra("details", getResources().getString(R.string.desp_jz));
                    break;

                case 21:
                    intent.putExtra("details", getResources().getString(R.string.desp_lcall));
                    break;

                case 22:
                    intent.putExtra("details", getResources().getString(R.string.desp_ljmp));
                    break;

                case 23:
                    intent.putExtra("details", getResources().getString(R.string.desp_mov));
                    break;

                case 24:
                    intent.putExtra("details", getResources().getString(R.string.desp_movc));
                    break;

                case 25:
                    intent.putExtra("details", getResources().getString(R.string.desp_movx));
                    break;

                case 26:
                    intent.putExtra("details", getResources().getString(R.string.desp_mul));
                    break;

                case 27:
                    intent.putExtra("details", getResources().getString(R.string.desp_nop));
                    break;

                case 28:
                    intent.putExtra("details", getResources().getString(R.string.desp_orl));
                    break;

                case 29:
                    intent.putExtra("details", getResources().getString(R.string.desp_pop));
                    break;

                case 30:
                    intent.putExtra("details", getResources().getString(R.string.desp_push));
                    break;

                case 31:
                    intent.putExtra("details", getResources().getString(R.string.desp_ret));
                    break;

                case 32:
                    intent.putExtra("details", getResources().getString(R.string.desp_reti));
                    break;

                case 33:
                    intent.putExtra("details", getResources().getString(R.string.desp_rl));
                    break;

                case 34:
                    intent.putExtra("details", getResources().getString(R.string.desp_rlc));
                    break;

                case 35:
                    intent.putExtra("details", getResources().getString(R.string.desp_rr));
                    break;

                case 36:
                    intent.putExtra("details", getResources().getString(R.string.desp_rrc));
                    break;

                case 37:
                    intent.putExtra("details", getResources().getString(R.string.desp_setb));
                    break;

                case 38:
                    intent.putExtra("details", getResources().getString(R.string.desp_sjmp));
                    break;

                case 39:
                    intent.putExtra("details", getResources().getString(R.string.desp_subb));
                    break;

                case 40:
                    intent.putExtra("details", getResources().getString(R.string.desp_swap));
                    break;

                case 41:
                    intent.putExtra("details", getResources().getString(R.string.desp_xch));
                    break;

                case 42:
                    intent.putExtra("details", getResources().getString(R.string.desp_xchd));
                    break;

                case 43:
                    intent.putExtra("details", getResources().getString(R.string.desp_xrl));
                    break;

                default:
                    break;
            }
        }
    }
}
