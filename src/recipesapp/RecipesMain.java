package recipesapp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RecipesMain extends JFrame {
    private String[] yemekler = {"Kebap", "Pizza", "Salata", "Makarna", "Balık", "Köfte"};
    private String[] yemekResimleri = {"images/kebap.jpeg", "images/pizza.jpeg", "images/salata1.jpeg", "images/makarna1.jpeg", "images/fish.jpeg", "images/kofte.jpeg"};

    public RecipesMain() {
        // Pencereyi başlat
        super("Yemek Tarifleri");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Ana panel oluştur
        JPanel anaPanel = new JPanel(new GridBagLayout());

        // GridBagConstraint oluştur
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10); // Boşluk eklendi

        // Her yemek için bir resim ve isim oluştur, panellere ekle
        for (int i = 0; i < yemekler.length; i++) {
            // Yemeği aşağıya yerleştirmek için
            if (i >= 3) {
                c.gridx = i - 3;
                c.gridy = 1;
            } else {
                c.gridx = i;
                c.gridy = 0;
            }

            ImageIcon icon = new ImageIcon(yemekResimleri[i]);
            Image image = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            JLabel resimLabel = new JLabel(new ImageIcon(image));
            String yemekIsmi = yemekler[i]; // final veya effectively final yapmak için
            resimLabel.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    yemekDetaylariniGoster(yemekIsmi);
                }
            });
            JLabel isimLabel = new JLabel(yemekler[i], JLabel.CENTER);

            // Panel oluştur ve resmi ve ismi içine ekle
            JPanel yemekPaneli = new JPanel(new BorderLayout());
            yemekPaneli.add(resimLabel, BorderLayout.CENTER);
            yemekPaneli.add(isimLabel, BorderLayout.SOUTH);

            // Ana panele yemek panelini ekle
            anaPanel.add(yemekPaneli, c);
        }

        // Ana paneli pencereye ekle
        add(anaPanel);

        setVisible(true);
    }

    // Yemek ismine tıklandığında çağrılacak metod
    private void yemekDetaylariniGoster(String yemekIsmi) {
        String tarif = "";
        switch (yemekIsmi) {
            case "Kebap":
                tarif = "1. Tavuk etini marine edin.\n" +
                        "2. Izgara tavada pişirin.\n" +
                        "3. Yanında pilav ve salata ile servis yapın.";
                break;
            case "Pizza":
                tarif = "1. Pizza tabanını hazırlayın.\n" +
                        "2. Üzerine sos, peynir ve istediğiniz malzemeleri ekleyin.\n" +
                        "3. Fırında pişirin.";
                break;
            case "Salata":
                tarif = "1. İstenilen yeşillikleri doğrayın.\n" +
                        "2. Domates ve salatalığı ekleyin.\n" +
                        "3. Zeytinyağı ve limon suyu ile soslayın.";
                break;
            case "Makarna":
                tarif = "1. Makarnayı haşlayın.\n" +
                        "2. Sos hazırlayın.\n" +
                        "3. Makarnayı sosla karıştırın.";
                break;
            case "Balık":
                tarif = "1. Balığı temizleyin ve marine edin.\n" +
                        "2. Fırında veya tavada pişirin.\n" +
                        "3. Limon ve yeşilliklerle servis yapın.";
                break;
            case "Köfte":
                tarif = "1. Kıymayı yoğurun ve şekil verin.\n" +
                        "2. Izgara veya tavada pişirin.\n" +
                        "3. Yanında pilav ve cacık ile servis yapın.";
                break;
            default:
                tarif = "Geçersiz seçim.";
                break;
        }
        JOptionPane.showMessageDialog(null, "Seçilen Yemek: " + yemekIsmi + "\n\nTarif:\n" + tarif, "Yemek Tarifi", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new RecipesMain();
    }
}
