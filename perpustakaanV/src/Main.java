import Controller.ControllerBuku;
import Database.Database;
import Model.ModelBuku;
import Node.NodeBuku;
import View.ViewBook;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        ViewBook viewBook = new ViewBook();
//        ControllerBuku controllerBuku = new ControllerBuku(Database.dbBuku,viewBook);
//        Database.insertBukuStatis();
//        controllerBuku.controllerViewAll();
        ModelBuku obj_buku = new ModelBuku();
        obj_buku.insertBook("harry potter - 1","aan",2021);
        obj_buku.insertBook("harry potter - 2","kurniawan",2023);
        obj_buku.dbBuku.commitInsert();
        obj_buku.vieeAllbuku();
//
//        ArrayList<NodeBuku> bukubuku = new ArrayList<>();
//        bukubuku.add(new NodeBuku(1,"hp-1","kurniawan",2001));
//        bukubuku.add(new NodeBuku(1,"hp-1","kurniawan",2001));
//        obj_buku.dbBuku.insertBookList(bukubuku);
    }
}