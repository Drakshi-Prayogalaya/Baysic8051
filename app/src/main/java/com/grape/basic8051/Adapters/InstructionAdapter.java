package com.grape.basic8051.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.grape.basic8051.InstructionValues;
import com.grape.basic8051.R;

import java.util.ArrayList;

/**
 * Created by kbhargav on 2/26/2016.
 */
public class InstructionAdapter extends BaseAdapter
{
    ArrayList<InstructionValues> instructionsArray = new ArrayList<>();

    public InstructionAdapter(Context context)
    {
        createInstructionList(context);
    }

    @Override
    public int getCount() {
        return instructionsArray.size();
    }

    @Override
    public Object getItem(int position) {
        return getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if(convertView == null)
        {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.list_item_instruction, parent, false);
        }

        InstructionValues instructionValues = instructionsArray.get(position);
        TextView textView = (TextView)convertView.findViewById(R.id.textViewInstruction);
        textView.setText(instructionValues.getInstructionName());

        return convertView;
    }

    public ArrayList<InstructionValues> getInstructionsArray()
    {
        return instructionsArray;
    }

    public void setInstructionsArray(ArrayList<InstructionValues> instructionsArray)
    {
        this.instructionsArray = instructionsArray;
    }

    public void createInstructionList(Context context)
    {
        String[] strings = context.getResources().getStringArray(R.array.inst_array);

        instructionsArray.clear();

        for(int i = 0; i<strings.length; i++)
        {
            instructionsArray.add(new InstructionValues(strings[i]));
        }
    }
}
