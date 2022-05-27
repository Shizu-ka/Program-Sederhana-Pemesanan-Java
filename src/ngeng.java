import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ngeng {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField tfKotaAsal;
    private JTextField tfKotaTujuan;
    private JTextField tfKendaraan;
    private JTextField tfKodePromo;
    private JTextField tfJam;
    private JTextField tfHarga;
    private JButton btnBook;
    private JButton btnCekHarga;
    private JTable tbPesanan;
    private JLabel tfNama;
    private JRadioButton motorRadioButton;
    private JRadioButton mobilRadioButton;
    private JRadioButton kotaMalangRadioButton;
    private JRadioButton kotaBatuRadioButton;
    private JRadioButton bromoRadioButton;
    private JRadioButton kotaMalangRadioButton1;
    private JRadioButton kotaBatuRadioButton1;
    private JRadioButton bromoRadioButton1;
    String jenisKendaraan="Motor";
    String kotaAsal;
    String kotaTujuan;



    public ngeng() {

        tfJam.setText(String.valueOf(LocalDateTime.now().getHour()));

        kotaMalangRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            kotaAsal = "Malang";
            }
        });

        kotaBatuRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            kotaAsal = "Batu";
            }
        });

        bromoRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            kotaAsal = "Bromo";
            }
        });


        motorRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jenisKendaraan = "Motor";
                System.out.println(jenisKendaraan);
            }
        });
        mobilRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jenisKendaraan = "Mobil";
                System.out.println(jenisKendaraan);
            }
        });

        kotaMalangRadioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kotaTujuan = "Malang";
            }
        });

        kotaBatuRadioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kotaTujuan = "Batu";
            }
        });

        bromoRadioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kotaTujuan = "Bromo";
            }
        });

        btnCekHarga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int asal = 0, tujuan = 0, biaya = 0, promo = 0;
                int malang = 0;
                int batu = 200;
                int bromo = batu + 300;
                String kode = tfKodePromo.getText();


                switch (kotaAsal.toLowerCase()) {
                    case "malang":
                        asal = malang;
                        break;
                    case "batu":
                        asal = batu;
                        break;
                    case "bromo":
                        asal = bromo;
                        break;
                    default:
                        break;
                }
                switch (kotaTujuan.toLowerCase()) {
                    case "malang":
                        tujuan = malang;
                        break;
                    case "batu":
                        tujuan = batu;
                        break;
                    case "bromo":
                        tujuan = bromo;
                        break;
                    default:
                        break;
                }

                switch (kode) {
                    case "JalanAsik":
                        promo = 10000;
                        break;
                    case "kitaHebat":
                        promo = 20000;
                        break;
                    case "KerenBanget":
                        promo = 25000;
                        break;
                    default:promo = 0;
                }
                switch(jenisKendaraan){
                    case "Mobil":
                        if (LocalDateTime.now().getHour() < 12) {
                            biaya = 500;
                        } else if (LocalDateTime.now().getHour() < 19) {
                            biaya = 1000;
                        } else {
                            biaya = 1500;
                        }
                        break;
                    case "Motor":
                        if (LocalDateTime.now().getHour() < 12) {
                            biaya = 300;
                        } else if (LocalDateTime.now().getHour() < 19) {
                            biaya = 800;
                        } else {
                            biaya = 1200;
                        }
                        break;

                }
                int temp = Math.abs(tujuan - asal);
                if (temp == 0) tujuan+=70;
                int total = (Math.abs(tujuan - asal) * biaya) - promo;
                tfHarga.setText(String.valueOf(total));
            }
        });



        btnBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Create database = new Create();
                database.CreateDatabase(new Pesanan(textField1.getText(),kotaAsal,kotaTujuan,jenisKendaraan,tfKodePromo.getText(),String.valueOf(LocalDateTime.now().getHour()),tfHarga.getText()));
                textField1.setText("");
                tfJam.setText(String.valueOf(LocalDateTime.now().getHour()));
                tfKodePromo.setText("");
                tfHarga.setText("");
                Read order = new Read();


                List<Pesanan> pesanans = new ArrayList<>();
                pesanans = order.Read();

                System.out.println(pesanans.toString());

                PesananModelTable pesananModelTable = new PesananModelTable(pesanans);
                tbPesanan.setModel(pesananModelTable);
                tbPesanan.setAutoCreateRowSorter(true);
            }
        });


    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("ngeng");
        frame.setContentPane(new ngeng().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

/*jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
*/
    //LocalDateTime.now().getHour()



    private static class PesananModelTable extends AbstractTableModel {

        private final String[] COLUMNS = {"NAMA","ASAL", "TUJUAN","KENDARAAN","WAKTU","HARGA"};
        private List<Pesanan> pesanans;

        public PesananModelTable(List<Pesanan> pesanans) {
            this.pesanans = pesanans;
        }

        @Override
        public int getRowCount() {
            return pesanans.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMNS.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return switch (columnIndex) {
                case 0 -> pesanans.get(rowIndex).getNama();
                case 1 -> pesanans.get(rowIndex).getKotaAsal();
                case 2 -> pesanans.get(rowIndex).getKotaTujuan();
                case 3 -> pesanans.get(rowIndex).getKendaraan();
                case 4 -> pesanans.get(rowIndex).getJamBooking();
                case 5 -> pesanans.get(rowIndex).getHarga();
                default -> "-";
            };
        }

        @Override
        public String getColumnName(int column) {
            return COLUMNS[column];
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (getValueAt(0,columnIndex) != null) {
                return getValueAt(0,columnIndex).getClass();
            } else
                return Object.class;
        }
    }
}
