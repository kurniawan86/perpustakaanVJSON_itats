package Model;
import DatabaseJSON.JSONbuku;
import Node.NodeBuku;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.util.ArrayList;

public class ModelBuku {
    public JSONbuku dbBuku;
    int inc_kode = 1;

    public ModelBuku(){
        dbBuku = new JSONbuku();
    }

    public void insertBook(String judul, String pengarang, int tahun){
        int index = this.inc_kode;
        NodeBuku obj = new NodeBuku(index,judul,pengarang,tahun);
        this.dbBuku.writeJSON_buku(obj);
        this.inc_kode ++;
    }



    public void vieeAllbuku(){
        dbBuku.readJSON_buku();
    }
//    public ArrayList<NodeBuku> viewBooks(){
//        return books;
//    }
//    public void updateBook(String nama,int jumlah){
//        for (int i=0;i<books.size();i++){
//            if (nama.equals(books.get(i).judul_buku)){
//                books.get(i).updateStok(jumlah);
//            }
//        }
//    }
//
//    public void deleteBook(String judul){
//        for (int i=0;i<books.size();i++){
//            if (judul.equals(books.get(i).judul_buku)){
//                books.remove(i);
//            }
//        }
//    }
//
//    private int searchBook(String judul){
//        int index = -1;
//        for (int i=0;i<books.size();i++){
//            if (judul.equals(books.get(i).getJudul_buku())){
//                index = i;
//            }
//        }
//        return index;
//    }
//
//    public NodeBuku viewBook(String judul){
//        NodeBuku buku = null;
//        int index = searchBook(judul);
//        if (index != -1){
//            buku = books.get(index);
//        }
//        return buku;
//    }
}
