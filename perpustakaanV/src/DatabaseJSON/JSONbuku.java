package DatabaseJSON;

import Node.NodeBuku;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class JSONbuku {
    private FileWriter file;
    private JSONArray books;
    private String name = "JSONbuku.json";

    public JSONbuku(){
        books = new JSONArray();
        try {
            file = new FileWriter(name);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeJSON_buku(NodeBuku buku){
        JSONObject buku_detail = new JSONObject();
        buku_detail.put("Kode Buku", buku.kode_buku);
        buku_detail.put("Judul Buku", buku.judul_buku);
        buku_detail.put("Pengarang Buku", buku.pengarang);
        buku_detail.put("Tahun Terbit Buku", buku.tahun_terbit);
        buku_detail.put("Stok Buku", buku.getStok());
//        JSONArray arrBuku = new JSONArray();
//        arrBuku.add(buku_detail);
        books.add(buku_detail);
    }

    public void commitInsert(){
        try {
            file.write(books.toJSONString());
            file.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertBookList(ArrayList<NodeBuku> bukubuku){
        String jsontext = JSONValue.toJSONString(bukubuku);
        System.out.print(jsontext);
        try {
            file.write(jsontext);
            file.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readJSON_buku(){
        JSONParser parser = new JSONParser();
        try {
            Reader reader = new FileReader(name);
            JSONArray jsonArr = (JSONArray) parser.parse(reader);

            Iterator<JSONArray> iterator = jsonArr.iterator();
            System.out.println(iterator);
            for (int i=0;i<jsonArr.size();i++){
                System.out.println(jsonArr.get(i));
                JSONObject obj = (JSONObject) jsonArr.get(i);
                String Judul = obj.get("Judul Buku").toString();
                int Kode = Integer.parseInt(obj.get("Kode Buku").toString());
                int Tahun = Integer.parseInt(obj.get("Tahun Terbit Buku").toString());
                System.out.println("kode buku : "+Kode);
                System.out.println("judul buku : "+Judul);
                System.out.println("Tahun buku : "+Tahun);

//                System.out.println("tahun terbit : "+Tahun);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
