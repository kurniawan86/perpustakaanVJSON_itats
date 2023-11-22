package DatabaseJSON;

import Node.NodeBuku;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.text.html.parser.Parser;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;

public class JSONbuku {
    private FileWriter file;
    private JSONArray books;
    private String name = "JSONbukuBaru.json";

    public JSONbuku(){
        books = new JSONArray();
        try {
            file = new FileWriter(name);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        cekEmptyJSON();
//        System.out.println(cekEmptyJSON());
//        if (cekEmptyJSON()== null){
//            init_commitInsert();
//        }
//        readJSON_buku();
//        init_commitInsert();
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

    public void commitInsert() {
        JSONParser parser = new JSONParser();
        try {
            JSONArray a = (JSONArray) parser.parse(new FileReader(name));
            FileWriter newfile = new FileWriter(name);
            for (int i = 1;i<books.size();i++){
                JSONObject temp = (JSONObject) books.get(i);
                a.add(temp);
            }
            newfile.write(a.toJSONString());
            newfile.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void init_commitInsert(){
        JSONObject buku_detail = new JSONObject();
        buku_detail.put("Kode Buku", 0);
        buku_detail.put("Judul Buku", 0);
        buku_detail.put("Pengarang Buku", 0);
        buku_detail.put("Tahun Terbit Buku", 0);
        buku_detail.put("Stok Buku", 0);
        books.add(buku_detail);
        try {
            file.write(books.toJSONString());
            file.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        commitInsert();
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

    public void cekEmptyJSON(){
//        JSONParser parser = new JSONParser();
//        FileReader reader = null;
//        try {
//            reader = new FileReader(name);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        JSONArray arr = null;
//        try {
//            arr = (JSONArray) parser.parse(reader);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(arr.size());
//        Reader reader = null;
//        try {
//            reader = new FileReader(name);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        int readSize = 0;
//        try {
//            readSize = reader.read();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(readSize);
//        return readSize;
        File file = new File(name);
        if(file.length()==0){
            System.out.println("empty");
        }else{
            System.out.println(1);
        }
//        String cek = "not null";
//        BufferedReader fis = null;
//        try {
//            fis = new BufferedReader(new FileReader(name));
//            System.out.println(fis.readLine());
//            cek = fis.readLine();
//            System.out.println("cek : "+cek);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return cek;
//        JSONParser parser = new JSONParser();
//        JSONArray jsonArr = null;
//        Reader reader = null;
//        int cek = 10;
//        try {
//            reader = new FileReader(name);
//            cek = reader.read();
//            System.out.println(cek);
//            try {
////                jsonArr = (JSONArray) parser.parse(reader);
//                System.out.println(parser.parse(reader));
//            } catch (ParseException e) {
//
//                throw new RuntimeException(e);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return cek;
    }

    public void readJSON_buku(){
        JSONParser parser = new JSONParser();
        JSONArray jsonArr = null;
        try {
            FileReader reader = new FileReader(name);
            jsonArr = (JSONArray) parser.parse(reader);
            for (int i=1;i<jsonArr.size();i++){
                JSONObject obj = (JSONObject) jsonArr.get(i);
                String Judul = obj.get("Judul Buku").toString();
                int Kode = Integer.parseInt(obj.get("Kode Buku").toString());
                int Tahun = Integer.parseInt(obj.get("Tahun Terbit Buku").toString());
                System.out.println("kode buku : "+Kode);
                System.out.println("judul buku : "+Judul);
                System.out.println("Tahun buku : "+Tahun);
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
