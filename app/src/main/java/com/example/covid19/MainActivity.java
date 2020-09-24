package com.example.covid19;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView pertanyaan ;
    RadioGroup rg;
    RadioButton PilihanA , PilihanB ;
    int nomor = 0;
    public static int hasil , benar , salah;
    public static String status;





    String[] pertanyaan_covid = new String[]{
            "1.Saya Pergi Keluar Rumah ?",
            "2.Saya Menggunakan Transportasi Umum,seperti ANGKOT dll ?",
            "3.Saya TidaK Memakai Masker Saat Berkumpul Dengan Orang Lain ?",
            "4.Saya Berjabat Tangan Dengan Orang Lain ?",
            "5.Saya Tidak Membersihkan Tangan Dengan Handsanitizer / Tissue Basah Sebelum Pegang Kemudi Mobil / Motor ?",
            "6.Saya Menyentuh Benda Yang Juga Disentuh Orang Lain ?",
            "7.Saya Tidak Berajaga Jarak Dengan Orang Lain Ketika Sedang Diluar Rumah ?",
            "8.Saya Makan DiLuar Rumah ?",
            "9.Saya Tidak Minum Hangat & Cuci Tangan Dengan Sabun Setelah Tiba diTujuan ?",
            "10.Saya Berada di Wilayah Kelurahan Tempat Pasien Tertular ?",
            "11.Saya Tidak Pasang HandSaniTizer Di Depan Pintu Masuk Untuk Bersihkan Tangan ?",
            "12.Saya Tidak Mencuci Tangan Dengan Sabun Setelah TIba Dirumah ?",
            "13.Saya Tidak Menyediakan Tissue Basah dll Untuk Keluarga DiRumah ?",
            "14.Saya Tidak Segera Merendam Pakaian Bekas Pakai diLuar Rumah ?",
            "15.Saya Tidak Segera Mandi Setelah Tiba DIRumah ?",
            "16.Saya Tidak Mensosialisasikan Check List Penilaian Resiko Pribadi ini Kepada Keluarga diRumah ?",
            "17.Saya Dalam Sehari Tidak Kena Cahaya Matahari ?",
            "18.Saya Tidak Berolahraga Minimal 30Menit ?",
            "19.Saya Jarang Minum Vitamin C & E,dan Kurang Tidur ? ",
            "20.Usia Saya DiAtas 60 Tahun ?",
            "21.Saya Mempunyai Penyakit : Jantung,Diabetes,Gangguan Pernapasan Kronik ?",
    };
    //pilihan jawaban
    String[] pilihan_jawaban = new String[]{
            "iya","tidak",
            "iya","tidak",
            "iya","tidak",
            "iya","tidak",
            "iya","tidak",
            "iya","tidak",
            "iya","tidak",
            "iya","tidak",
            "iya","tidak",
            "iya","tidak",
            "iya","tidak",
            "iya","tidak",
            "iya","tidak",
            "iya","tidak",
            "iya","tidak",
            "iya","tidak",
            "iya","tidak",
            "iya","tidak",
            "iya","tidak",
            "iya","tidak",
            "iya","tidak",
    };
    //jawaban yang benar
    String[] jawaban_benar = new String[]{
            "iya",
            "iya",
            "iya",
            "iya",
            "iya",
            "iya",
            "iya",
            "iya",
            "iya",
            "iya",
            "iya",
            "iya",
            "iya",
            "iya",
            "iya",
            "iya",
            "iya",
            "iya",
            "iya",
            "iya",
            "iya",

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pertanyaan = (TextView)findViewById(R.id.pertanyaan);
        rg = (RadioGroup)findViewById(R.id.radio_group);
        PilihanA = (RadioButton) findViewById(R.id.pilihanA);
        PilihanB = (RadioButton) findViewById(R.id.pilihanB);

        pertanyaan.setText(pertanyaan_covid[nomor]);
        PilihanA.setText(pilihan_jawaban[0]);
        PilihanB.setText(pilihan_jawaban[1]);



        rg.check(0 );
        benar = 0;
        salah = 0;





    }

    public void next(View view){
        if(PilihanA.isChecked()||PilihanB.isChecked()) {

            RadioButton jawaban_user = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            rg.check(0);
            if (ambil_jawaban_user.equalsIgnoreCase(jawaban_benar[nomor])) benar++;
            else salah++;
            nomor++;
            if (nomor < pertanyaan_covid.length) {
                pertanyaan.setText(pertanyaan_covid[nomor]);
                PilihanA.setText(pilihan_jawaban[nomor * 1 + 0]);
                PilihanB.setText(pilihan_jawaban[nomor * 1 + 1]);


            } else {
                hasil = benar * 1;
                Intent selesai = new Intent(getApplicationContext(), HasilCovid.class);
                startActivity(selesai);
            }

            //RUMUS STATUS
            if (hasil<=7){
                status=("Rendah");
            }
            else if (hasil<=14){
                status=("Sedang");
            }
            else if (hasil<=21){
                status=("Tinggi");
            }
            else{
                status=("-");
            }


        }
        else{
            Toast.makeText(this,"Pilih Jawaban DULLU",Toast.LENGTH_SHORT).show();

        }
    }
}
