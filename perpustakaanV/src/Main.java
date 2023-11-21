import Controller.ControllerBuku;
import Database.Database;
import Model.ModelBuku;
import View.ViewBook;

public class Main {
    public static void main(String[] args) {
//        ViewBook viewBook = new ViewBook();
//        ControllerBuku controllerBuku = new ControllerBuku(Database.dbBuku,viewBook);
//        Database.insertBukuStatis();
//        controllerBuku.controllerViewAll();
        ModelBuku obj_buku = new ModelBuku();
        obj_buku.insertBook("harry potter - 1","kurniawan",2021);
        obj_buku.vieeAllbuku();
    }
}