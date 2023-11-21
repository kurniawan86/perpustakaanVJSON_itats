package Node;

public class NodeBuku {
    public int kode_buku;
    public String judul_buku;
    public String pengarang;
    public int tahun_terbit;
    private int stok;

    public NodeBuku(int kode_buku, String judul_buku, String pengarang, int tahun_terbit) {
        this.kode_buku = kode_buku;
        this.judul_buku = judul_buku;
        this.pengarang = pengarang;
        this.tahun_terbit = tahun_terbit;
        this.stok = 0;
    }
    public void updateStok(int newStok){
        this.stok = this.stok + newStok;
    }
    public int getStok(){
        return stok;
    }
}
