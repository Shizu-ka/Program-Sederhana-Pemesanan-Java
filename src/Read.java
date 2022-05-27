
import org.dizitart.no2.Nitrite;

import java.util.ArrayList;
import java.util.List;

public class Read {
    List Read(){
        var db = Nitrite.builder()
                .compressed()
                .filePath("students.db")
                .openOrCreate("admin", "password123");

        var custo = db.getRepository(Pesanan.class);

        List<Pesanan> pesanans = new ArrayList<>();
        for (var order : custo.find()) {
            pesanans.add(order);
        }
        db.close();
        return pesanans;
    }


}
