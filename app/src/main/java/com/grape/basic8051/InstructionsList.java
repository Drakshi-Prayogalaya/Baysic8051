package com.grape.basic8051;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.grape.basic8051.Adapters.InstructionAdapter;

/**
 * Created by kbhargav on 2/26/2016.
 */
public class InstructionsList extends AppCompatActivity
{
    ListView listView;
    static String sarray[];
    InstructionAdapter instructionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_instructions);

        listView = (ListView) findViewById(R.id.listViewInstructions);

        instructionAdapter = new InstructionAdapter(this);
        listView.setAdapter(instructionAdapter);

        sarray = this.getResources().getStringArray(R.array.inst_array);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        intentCaller("desp_acall", R.string.desp_acall);
                        break;

                    case 1:
                        intentCaller("desp_add", R.string.desp_add);
                        break;

                    case 2:
                        intentCaller("desp_addc", R.string.desp_addc);
                        break;

                    case 3:
                        intentCaller("desp_ajmp", R.string.desp_ajmp);
                        break;

                    case 4:
                        intentCaller("desp_anl", R.string.desp_anl);
                        break;

                    case 5:
                        intentCaller("desp_cjne", R.string.desp_cjne);
                        break;

                    case 6:
                        intentCaller("desp_clr", R.string.desp_clr);
                        break;

                    case 7:
                        intentCaller("desp_cpl", R.string.desp_cpl);
                        break;

                    case 8:
                        intentCaller("desp_da", R.string.desp_da);
                        break;
                    case 9:
                        intentCaller("desp_dec", R.string.desp_dec);
                        break;
                    case 10:
                        intentCaller("desp_div", R.string.desp_div);
                        break;
                    case 11:
                        intentCaller("desp_djnz", R.string.desp_djnz);
                        break;
                    case 12:
                        intentCaller("desp_inc", R.string.desp_inc);
                        break;
                    case 13:
                        intentCaller("desp_jb", R.string.desp_jb);
                        break;
                    case 14:
                        intentCaller("desp_jbc", R.string.desp_jbc);
                        break;
                    case 15:
                        intentCaller("desp_jc", R.string.desp_jc);
                        break;
                    case 16:
                        intentCaller("desp_jmp", R.string.desp_jmp);
                        break;
                    case 17:
                        intentCaller("desp_jnb", R.string.desp_jnb);
                        break;
                    case 18:
                        intentCaller("desp_jnc", R.string.desp_jnc);
                        break;
                    case 19:
                        intentCaller("desp_jnz", R.string.desp_jnz);
                        break;
                    case 20:
                        intentCaller("desp_jz", R.string.desp_jz);
                        break;
                    case 21:
                        intentCaller("desp_lcall", R.string.desp_lcall);
                        break;
                    case 22:
                        intentCaller("desp_ljmp", R.string.desp_ljmp);
                        break;
                    case 23:
                        intentCaller("desp_mov", R.string.desp_mov);
                        break;
                    case 24:
                        intentCaller("desp_movc", R.string.desp_movc);
                        break;
                    case 25:
                        intentCaller("desp_movx", R.string.desp_movx);
                        break;
                    case 26:
                        intentCaller("desp_mul", R.string.desp_mul);
                        break;
                    case 27:
                        intentCaller("desp_nop", R.string.desp_nop);
                        break;
                    case 28:
                        intentCaller("desp_orl", R.string.desp_orl);
                        break;
                    case 29:
                        intentCaller("desp_pop", R.string.desp_pop);
                        break;
                    case 30:
                        intentCaller("desp_push", R.string.desp_push);
                        break;
                    case 31:
                        intentCaller("desp_ret", R.string.desp_ret);
                        break;
                    case 32:
                        intentCaller("desp_reti", R.string.desp_reti);
                        break;
                    case 33:
                        intentCaller("desp_rl", R.string.desp_rl);
                        break;
                    case 34:
                        intentCaller("desp_rlc", R.string.desp_rlc);
                        break;
                    case 35:
                        intentCaller("desp_rr", R.string.desp_rr);
                        break;
                    case 36:
                        intentCaller("desp_rrc", R.string.desp_rrc);
                        break;
                    case 37:
                        intentCaller("desp_setb", R.string.desp_setb);
                        break;
                    case 38:
                        intentCaller("desp_sjmp", R.string.desp_sjmp);
                        break;
                    case 39:
                        intentCaller("desp_subb", R.string.desp_subb);
                        break;
                    case 40:
                        intentCaller("desp_swap", R.string.desp_swap);
                        break;
                    case 41:
                        intentCaller("desp_xch", R.string.desp_xch);
                        break;
                    case 42:
                        intentCaller("desp_xchd", R.string.desp_xchd);
                        break;
                    case 43:
                        intentCaller("desp_xrl", R.string.desp_xrl);
                        break;
                    default:

                }
            }
        });


    }

    public void intentCaller(String code, int id)
    {
        Intent intent = new Intent(InstructionsList.this, InstructionDescriptionActivity.class);
        intent.putExtra(code, getResources().getString(id));
        startActivity(intent);
    }

    //public void searchText(String string)
    //{
    //    ArrayList<InstructionValues> instructionValuesArrayList =  instructionAdapter.getInstructionsArray();
    //    ArrayList<InstructionValues> tempArray = new ArrayList<>();
    //    Iterator<InstructionValues> iterator = instructionValuesArrayList.iterator();
//
    //    while(iterator.hasNext())
    //    {
    //        InstructionValues value = iterator.next();
    //        if(value.getInstructionName().contains(string))
    //        {
    //            tempArray.add(value);
    //        }
    //    }
//
    //    if(tempArray.size() == 0)
    //    {
    //        //Toast.makeText(this, "No instruction containing " + "\'" + string +"\'" + " found",Toast.LENGTH_LONG).show();
    //    }
//
    //    instructionAdapter.setInstructionsArray(tempArray);
//
    //    instructionAdapter.notifyDataSetChanged();
//
    //}
}
