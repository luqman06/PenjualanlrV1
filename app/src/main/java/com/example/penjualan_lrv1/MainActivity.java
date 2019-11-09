package com.example.penjualan_lrv1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editnamapel, editnamabar,editjumlahbar
            ,editharga,edituangbay;
    private Button btnproses;
    private Button btnhapus;
    private Button btnexit;
    private TextView tntnamapel;
    private TextView tntnamabar;
    private TextView tntjumlahbar;
    private TextView tntharga;
    private TextView tntuangbay;
    private TextView tntbonus;
    private TextView tnttotalbelanja;
    private TextView tntkembali;
    private TextView tntketerangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Toko Luqman");
        editnamapel = (EditText) findViewById(R.id.nama_pelanggan);
        editnamabar = (EditText) findViewById(R.id.nama_barang);
        editjumlahbar = (EditText) findViewById(R.id.jml_barang);
        editharga = (EditText) findViewById(R.id.harga_barang);
        edituangbay = (EditText) findViewById(R.id.jml_uang);

        btnproses = (Button) findViewById(R.id.proses);
        btnhapus = (Button) findViewById(R.id.reset);
        btnexit = (Button) findViewById(R.id.exit);

        tntnamapel = (TextView) findViewById(R.id.nama_pelanggan);
        tntnamabar = (TextView) findViewById(R.id.nama_barang);
        tntjumlahbar = (TextView) findViewById(R.id.jml_barang);
        tntharga = (TextView) findViewById(R.id.harga_barang);
        tntuangbay = (TextView) findViewById(R.id.jml_uang);
        tnttotalbelanja = findViewById(R.id.total);
        tntkembali = (TextView) findViewById(R.id.kembali);
        tntketerangan = (TextView) findViewById(R.id.keterangan);
        tntbonus = (TextView) findViewById(R.id.bonus);

        btnproses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namapelanggan = editnamapel.getText().toString().trim();
                String namabarang = editnamabar.getText().toString().trim();
                String jumlahbarang = editjumlahbar.getText().toString().trim();
                String hargabarang = editharga.getText().toString().trim();
                String uangbayar = edituangbay.getText().toString().trim();


                if (!TextUtils.isEmpty(jumlahbarang)||!TextUtils.isEmpty(hargabarang)||!TextUtils.isEmpty(uangbayar)) {

                    double jb = Double.parseDouble(jumlahbarang);
                    double h = Double.parseDouble(hargabarang);
                    double ub = Double.parseDouble(uangbayar);
                    double total = (jb*h);

                    tnttotalbelanja.setText("Total Belanja : "+total);



                    if (total >= 200000) {
                        tntbonus.setText("Bonus : 1 Box Mie Instan");
                    } else if (total >= 50000) {
                        tntbonus.setText("Bonus : 5 Bungkus Mie Instan");
                    } else if (total >= 40000) {
                        tntbonus.setText("Bonus : 3 Bungkus Mie Instan");
                    } else {
                        tntbonus.setText("Bonus : Tidak Ada Bonus");
                    }

                    double uangkembalian = (ub - total);
                    if (ub < total) {
                        tntketerangan.setText("Keterangan : Uang Bayar Kurang Rp." + (-uangkembalian));
                        tntkembali.setText("Uang Kembalian : Rp.0");
                    } else {
                        tntketerangan.setText("Keterangan : Tungu Kembalian");
                        tntkembali.setText("Uang Kembalian : Rp." + uangkembalian);
                    }

                }else {

                }

            }
        });

        btnhapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tntnamapel.setText("");
                tntnamabar.setText("");
                tntjumlahbar.setText("");
                tntharga.setText("");
                tntuangbay.setText("");
                tntkembali.setText("");
                tntkembali.setText("Uang Kembali : Rp. 0");
                tntketerangan.setText("-");
                tntbonus.setText("-");
                tnttotalbelanja.setText("Total Belanja : Rp.0");

                Toast.makeText(getApplicationContext(),"Data di hapus",Toast.LENGTH_LONG).show();

            }

        });

        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
            }
        });
    }
}
