package DatabaseJSON;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class JSONBookFile {
    private FileWriter file;
    private String name = "JSONbukuBaru.json";
    public JSONBookFile(){
        try {
            file = new FileWriter(name);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void init_commitInsert() {
        JSONObject buku_detail = new JSONObject();
        buku_detail.put("Kode Buku", 0);
        buku_detail.put("Judul Buku", 0);
        buku_detail.put("Pengarang Buku", 0);
        buku_detail.put("Tahun Terbit Buku", 0);
        buku_detail.put("Stok Buku", 0);
        JSONArray books = new JSONArray();
        books.add(buku_detail);
        try {
            file.write(books.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
