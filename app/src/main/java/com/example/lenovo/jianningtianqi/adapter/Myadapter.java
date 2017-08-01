package com.example.lenovo.jianningtianqi.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.jianningtianqi.R;
import com.example.lenovo.jianningtianqi.entity.Msg;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static org.litepal.LitePalApplication.getContext;

/**
 * Created by lenovo on 2017/7/13.
 */

public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder>{
    private List<Msg> listmsg;
    static class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout leftLayout;
        LinearLayout rightLayout;
        TextView leftMsg;
        TextView rightMsg;
        public ViewHolder(View view){
            super(view);
            leftLayout=(LinearLayout)view.findViewById(R.id.ll_left);
            rightLayout=(LinearLayout)view.findViewById(R.id.ll_right);
            leftMsg=(TextView)view.findViewById(R.id.left_message);
            rightMsg=(TextView)view.findViewById(R.id.right_message);
        }

    }
    public Myadapter(List<Msg> msgList){
        listmsg=msgList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Msg msg=listmsg.get(position);
        if(msg.getType()==Msg.TYPE_RECEIVER){
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            holder.leftMsg.setText(msg.getContent());
        }else if(msg.getType()==Msg.TYPE_SEND){
            holder.leftLayout.setVisibility(View.GONE);
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.rightMsg.setText(msg.getContent());

        }

    }

    @Override
    public int getItemCount() {
        return listmsg.size();
    }
}
