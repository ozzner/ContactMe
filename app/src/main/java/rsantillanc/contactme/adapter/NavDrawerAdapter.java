package rsantillanc.contactme.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import rsantillanc.contactme.R;
import rsantillanc.contactme.model.NavItemModel;

/**
 * Created by RenzoD on 22/05/2015.
 */
public class NavDrawerAdapter extends RecyclerView.Adapter<NavDrawerAdapter.CustomViewHolder> {

    private LayoutInflater layInf;
    private Context _context;
    private ArrayList<NavItemModel> items;


    public NavDrawerAdapter(LayoutInflater layInf, Context _context) {
        this.layInf = layInf;
        this._context = _context;
    }

    public NavDrawerAdapter(Context _context, ArrayList<NavItemModel> items) {
        this._context = _context;
        this.items = items;
        this.layInf = LayoutInflater.from(_context);
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View row = null;

        row = layInf.inflate(R.layout.nav_drawer_row,viewGroup,false);
        CustomViewHolder holder = new CustomViewHolder(row);

        return holder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        NavItemModel currentItem = items.get(i);
        customViewHolder.label.setText(currentItem.getLabel());
        customViewHolder.icon.setImageResource(currentItem.getIcon());
    }


    @Override
    public int getItemCount() {
        return items.size();
    }


    /* ViewHolder */
    class CustomViewHolder extends RecyclerView.ViewHolder{
        public TextView label;
        public ImageView icon;

        public CustomViewHolder(View itemView) {
            super(itemView);
            label = (TextView)itemView.findViewById(R.id.tv_title);
            icon = (ImageView)itemView.findViewById(R.id.iv_icons_nav);
        }
    }

}
