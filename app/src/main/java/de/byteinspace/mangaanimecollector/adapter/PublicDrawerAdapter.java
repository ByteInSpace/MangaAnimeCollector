package de.byteinspace.mangaanimecollector.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.List;
import java.util.ArrayList;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import de.byteinspace.mangaanimecollector.R;
import de.byteinspace.mangaanimecollector.datamodel.MenuItem;

public class PublicDrawerAdapter extends BaseAdapter {
    List<MenuItem> menuItems = new ArrayList<MenuItem>();
    private final LayoutInflater inflator;

    public PublicDrawerAdapter(Context context) {
        inflator = LayoutInflater.from(context);
        menuItems.add(new MenuItem("News", R.drawable.newspaper_big));
        menuItems.add(new MenuItem("Press Releases", R.drawable.press_big));
        menuItems.add(new MenuItem("Forms", R.drawable.forms_big));
        menuItems.add(new MenuItem("Rules & Regulations", R.drawable.rules_middle));

    }

    @Override
    public int getCount() {
        return menuItems.size();
    }

    @Override
    public Object getItem(int position) {
        return menuItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflator.inflate(R.layout.drawer_public_list_view, parent, false);
            holder = new ViewHolder();
            holder.caption = (TextView) convertView.findViewById(R.id.caption);
            holder.menuicon = (ImageView) convertView.findViewById(R.id.menuicon);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Context context = parent.getContext();
        MenuItem menuItem = (MenuItem) getItem(position);
        holder.caption.setText(menuItem.getCaption());
        holder.menuicon.setImageResource(menuItem.getMenuicon());

        convertView.setFocusable(false);

        return convertView;


    }

    static class ViewHolder {
        TextView caption;
        ImageView menuicon;

    }




}