
import org.dizitart.no2.Nitrite;

public class Create {

    void CreateDatabase(Pesanan pesanan){
        Nitrite db = Nitrite.builder()
                .compressed()
                .filePath("students.db")
                .openOrCreate("admin", "password123");
        var cust = db.getRepository(Pesanan.class);
        cust.insert(pesanan);
        db.close();
    }


}
