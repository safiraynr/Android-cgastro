package com.example.projectbarudeh;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterPakarRecyclerView extends RecyclerView.Adapter<AdapterPakarRecyclerView.ViewHolder>{

    private ArrayList<profil> daftarBarang;
    Menu_Pakar listener;
    private Context context;

    public AdapterPakarRecyclerView(ArrayList<profil> profilz, Context ctx){

        daftarBarang = profilz;
        context = ctx;
        listener = (Menu_Pakar)ctx;

    }
    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvnamapkr, tvusiapkr, tvjenispkr, tvdehidrasipkr, tvrekomenpkr;
        ViewHolder(View v) {
            super(v);
            tvnamapkr = (TextView) v.findViewById(R.id.tvnamapakar);
            tvusiapkr = (TextView) v.findViewById(R.id.tvusiapakar);
            tvjenispkr = (TextView) v.findViewById(R.id.tvjenispakar);
            tvdehidrasipkr = (TextView) v.findViewById(R.id.tvdehidrasipakar);
            tvrekomenpkr = (TextView) v.findViewById(R.id.tvrekomendasipakar);
        }

    }
    @Override

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_pakar, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;

    }
    @Override

    public void onBindViewHolder(AdapterPakarRecyclerView.ViewHolder holder, final int position){
        holder.tvnamapkr.setOnLongClickListener(new View.OnLongClickListener() {

            @Override

            public boolean onLongClick(View view) {

                final Dialog dialog = new Dialog(context);

                dialog.setContentView(R.layout.activity_dialog_view2);

                dialog.setTitle("Pilih Aksi");

                dialog.show();
                //Button editButton = (Button) dialog.findViewById(R.id.bt_editpakar);
                Button delButton = (Button) dialog.findViewById(R.id.bt_deletepakar);

//                editButton.setOnClickListener(
//
//                        new View.OnClickListener() {
//
//                            @Override
//
//                            public void onClick(View view) {
//
//                                dialog.dismiss();
//
//                                context.startActivity(Read_Pakar.getActIntent((Activity) context).putExtra("data", daftarBarang.get(position)));
//                            }
//
//                        }
//
//                );

                delButton.setOnClickListener(

                        new View.OnClickListener() {

                            @Override

                            public void onClick(View view) {
                                dialog.dismiss();

                                listener.onDeleteData(daftarBarang.get(position), position);
                            }

                        }
                );

                return true;
            }

        });
        holder.tvusiapkr.setOnLongClickListener(new View.OnLongClickListener() {

            @Override

            public boolean onLongClick(View view) {

                final Dialog dialog = new Dialog(context);

                dialog.setContentView(R.layout.activity_dialog_view2);

                dialog.setTitle("Pilih Aksi");

                dialog.show();
                //Button editButton = (Button) dialog.findViewById(R.id.bt_editpakar);
                Button delButton = (Button) dialog.findViewById(R.id.bt_deletepakar);

//                editButton.setOnClickListener(
//
//                        new View.OnClickListener() {
//
//                            @Override
//
//                            public void onClick(View view) {
//
//                                dialog.dismiss();
//
//                                context.startActivity(Read_Pakar.getActIntent((Activity) context).putExtra("data", daftarBarang.get(position)));
//                            }
//
//                        }
//
//                );

                delButton.setOnClickListener(

                        new View.OnClickListener() {

                            @Override

                            public void onClick(View view) {
                                dialog.dismiss();

                                listener.onDeleteData(daftarBarang.get(position), position);
                            }

                        }
                );

                return true;
            }

        });
        holder.tvjenispkr.setOnLongClickListener(new View.OnLongClickListener() {

            @Override

            public boolean onLongClick(View view) {

                final Dialog dialog = new Dialog(context);

                dialog.setContentView(R.layout.activity_dialog_view2);

                dialog.setTitle("Pilih Aksi");

                dialog.show();
                //Button editButton = (Button) dialog.findViewById(R.id.bt_editpakar);
                Button delButton = (Button) dialog.findViewById(R.id.bt_deletepakar);

//                editButton.setOnClickListener(
//
//                        new View.OnClickListener() {
//
//                            @Override
//
//                            public void onClick(View view) {
//
//                                dialog.dismiss();
//
//                                context.startActivity(Read_Pakar.getActIntent((Activity) context).putExtra("data", daftarBarang.get(position)));
//                            }
//
//                        }
//                );
                delButton.setOnClickListener(
                        new View.OnClickListener() {

                            @Override

                            public void onClick(View view) {
                                dialog.dismiss();

                                listener.onDeleteData(daftarBarang.get(position), position);
                            }

                        }
                );

                return true;
            }

        });
        holder.tvdehidrasipkr.setOnLongClickListener(new View.OnLongClickListener() {

            @Override

            public boolean onLongClick(View view) {

                final Dialog dialog = new Dialog(context);

                dialog.setContentView(R.layout.activity_dialog_view2);

                dialog.setTitle("Pilih Aksi");

                dialog.show();
                //Button editButton = (Button) dialog.findViewById(R.id.bt_editpakar);
                Button delButton = (Button) dialog.findViewById(R.id.bt_deletepakar);

//                editButton.setOnClickListener(
//
//                        new View.OnClickListener() {
//
//                            @Override
//
//                            public void onClick(View view) {
//
//                                dialog.dismiss();
//
//                                context.startActivity(Read_Pakar.getActIntent((Activity) context).putExtra("data", daftarBarang.get(position)));
//                            }
//
//                        }
//                );
                delButton.setOnClickListener(
                        new View.OnClickListener() {

                            @Override

                            public void onClick(View view) {
                                dialog.dismiss();

                                listener.onDeleteData(daftarBarang.get(position), position);
                            }

                        }
                );

                return true;
            }

        });
        holder.tvrekomenpkr.setOnLongClickListener(new View.OnLongClickListener() {

            @Override

            public boolean onLongClick(View view) {

                final Dialog dialog = new Dialog(context);

                dialog.setContentView(R.layout.activity_dialog_view2);

                dialog.setTitle("Pilih Aksi");

                dialog.show();
              //  Button editButton = (Button) dialog.findViewById(R.id.bt_editpakar);
                Button delButton = (Button) dialog.findViewById(R.id.bt_deletepakar);

//                editButton.setOnClickListener(
//
//                        new View.OnClickListener() {
//
//                            @Override
//
//                            public void onClick(View view) {
//
//                                dialog.dismiss();
//
//                                context.startActivity(Read_Pakar.getActIntent((Activity) context).putExtra("data", daftarBarang.get(position)));
//                            }
//
//                        }
//                );
                delButton.setOnClickListener(
                        new View.OnClickListener() {

                            @Override

                            public void onClick(View view) {
                                dialog.dismiss();

                                listener.onDeleteData(daftarBarang.get(position), position);
                            }

                        }
                );

                return true;
            }

        });

        holder.tvnamapkr.setText(daftarBarang.get(position).getNamaorg());
        holder.tvusiapkr.setText(daftarBarang.get(position).getUsia());
        holder.tvjenispkr.setText(daftarBarang.get(position).getJenis_diare());
        holder.tvdehidrasipkr.setText(daftarBarang.get(position).getTipe_dehidrasi());
        holder.tvrekomenpkr.setText(daftarBarang.get(position).getRekomen_obat());
    }
    @Override

    public int getItemCount() {
        return daftarBarang.size();

    }
    public interface FirebaseDataListener{

        void onDeleteData(profil profil, int position);

    }
}
