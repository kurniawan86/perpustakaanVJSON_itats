package DatabaseJSON;

import Node.NodeBuku;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class JSONbuku {
    private FileWriter file;
    private JSONObject books;
    private String name = "JSONbuku.json";

    public JSONbuku(){
        books = new JSONObject();
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
        books.put("buku",buku_detail);
        try {
            file.write(books.toJSONString());
            file.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readJSON_buku(){
        JSONParser parser = new JSONParser();
        try {
            Reader reader = new FileReader(name);
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
//            System.out.println(jsonObject);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
