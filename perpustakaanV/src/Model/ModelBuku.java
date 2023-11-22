package Model;
import DatabaseJSON.JSONbuku;
import Node.NodeBuku;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;

public class ModelBuku {
    private JSONArray books;
    private String fname = "buku.json";
    public ModelBuku(){
        books = new JSONArray();
        createJSON();
        loadJson();
    }

    public void insertBook(String judul_buku, String pengarang, int tahun_terbit){
        JSONObject buku_detail = new JSONObject();
        JSONObject temp = (JSONObject) books.get(books.size()-1);
        int lastKode = Integer.parseInt(temp.get("Kode Buku").toString());

        buku_detail.put("Kode Buku", lastKode+1);
        buku_detail.put("Judul Buku", judul_buku);
        buku_detail.put("Pengarang Buku", pengarang);
        buku_detail.put("Tahun Terbit Buku", tahun_terbit);
        buku_detail.put("Stok Buku", 0);

        loadJson();
        books.add(buku_detail);
        saveToFileJson();
    }

    private void saveToFileJson(){
        FileWriter newfile = null;
        try {
            newfile = new FileWriter(fname);
            newfile.write(books.toJSONString());
            newfile.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void loadJson(){
        JSONParser parser = new JSONParser();
        try {
            FileReader reader = new FileReader(fname);
            books = (JSONArray) parser.parse(reader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    private void createJSON(){
        File file = new File(fname);
        if (!file.exists()){
            JSONObject buku_detail = new JSONObject();
            buku_detail.put("Kode Buku", 0);
            buku_detail.put("Judul Buku", 0);
            buku_detail.put("Pengarang Buku", 0);
            buku_detail.put("Tahun Terbit Buku", 0);
            buku_detail.put("Stok Buku", 0);
            JSONArray temp = new JSONArray();
            temp.add(buku_detail);
            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter(fname);
                fileWriter.write(temp.toJSONString());
                fileWriter.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
