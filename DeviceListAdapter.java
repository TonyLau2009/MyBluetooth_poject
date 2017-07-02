package com.joce.mybluetooth_app;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.LayoutInflaterCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jocelyn on 20/4/2017.
 */

public class DeviceListAdapter extends ArrayAdapter<BluetoothDevice> {

    private LayoutInflater mLayoutInflater;
    private int tvResourceId;
    private ArrayList<BluetoothDevice> mBTdevices;

    public DeviceListAdapter(Context context, int tvResourceId, ArrayList<BluetoothDevice> devices) {
        super(context, tvResourceId, devices);

        this.tvResourceId = tvResourceId;
        this.mBTdevices = devices;

        mLayoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mBTdevices.size();
    }

    @Override
    public BluetoothDevice getItem(int position) {
        return mBTdevices.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {

        convertView = mLayoutInflater.inflate(tvResourceId, parent, false);

        BluetoothDevice device = mBTdevices.get(position);

        if(device != null){
            TextView deviceName = (TextView) convertView.findViewById(R.id.tvName);
            TextView deviceAdress = (TextView) convertView.findViewById(R.id.tvAddress);

            if (deviceName != null) {
                deviceName.setText(device.getName());
            }
            if (deviceAdress != null) {
                deviceAdress.setText(device.getAddress());
            }
        }

        return convertView;
    }
}
