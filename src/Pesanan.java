import java.io.Serializable;

public class Pesanan implements Serializable{
    private String nama,kotaAsal, kotaTujuan, kendaraan, kodePromo, jamBooking, harga;

    public Pesanan() {}

    public Pesanan(String nama, String kotaAsal, String kotaTujuan, String kendaraan, String kodePromo, String jamBooking, String harga) {
        this.nama = nama;
        this.kotaAsal = kotaAsal;
        this.kotaTujuan = kotaTujuan;
        this.kendaraan = kendaraan;
        this.kodePromo = kodePromo;
        this.jamBooking = jamBooking;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public String getKotaAsal() {
        return kotaAsal;
    }

    public String getKotaTujuan() {
        return kotaTujuan;
    }

    public String getKendaraan() {
        return kendaraan;
    }

    public String getKodePromo() {
        return kodePromo;
    }

    public String getJamBooking() {
        return jamBooking;
    }

    public String getHarga() {
        return harga;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setKotaAsal(String kotaAsal) {
        this.kotaAsal = kotaAsal;
    }

    public void setKotaTujuan(String kotaTujuan) {
        this.kotaTujuan = kotaTujuan;
    }

    public void setKendaraan(String kendaraan) {
        this.kendaraan = kendaraan;
    }

    public void setKodePromo(String kodePromo) {
        this.kodePromo = kodePromo;
    }

    public void setJamBooking(String jamBooking) {
        this.jamBooking = jamBooking;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    @Override
    public String toString() {
        return "Pesanan{" +
                "nama='" + nama + '\'' +
                ", kotaAsal='" + kotaAsal + '\'' +
                ", kotaTujuan='" + kotaTujuan + '\'' +
                ", kendaraan='" + kendaraan + '\'' +
                ", kodePromo='" + kodePromo + '\'' +
                ", jamBooking='" + jamBooking + '\'' +
                ", harga='" + harga + '\'' +
                '}';
    }

}
