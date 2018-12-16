package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import static javafx.application.Platform.exit;

public class RankController implements Initializable {
    @FXML private Text r_e_1;
    @FXML private Text r_e_2;
    @FXML private Text r_e_3;
    @FXML private Text r_e_4;
    @FXML private Text r_e_5;
    @FXML private Text r_e_6;
    @FXML private Text r_h_1;
    @FXML private Text r_h_2;
    @FXML private Text r_h_3;
    @FXML private Text r_h_4;
    @FXML private Text r_h_5;
    @FXML private Text r_h_6;
    @FXML private Button exit_e_b;
    @FXML private Button exit_h_b;

    public void handle_exit_b_e(ActionEvent event) {
        exit();
    }
    public void handle_exit_b_h(ActionEvent event) {
        exit();
    }

    public void initialize(URL location, ResourceBundle resources) {
        try {
            File file = new File("datae.txt");
            File file_h = new File("datah.txt");
            int i = 0;
            int j = 6;
            int rank = 0;
            Text[] moim = new Text[12];
            moim[0] = r_e_1;
            moim[1] = r_e_2;
            moim[2] = r_e_3;
            moim[3] = r_e_4;
            moim[4] = r_e_5;
            moim[5] = r_e_6;
            moim[6] = r_h_1;
            moim[7] = r_h_2;
            moim[8] = r_h_3;
            moim[9] = r_h_4;
            moim[10] = r_h_5;
            moim[11] = r_h_6;


            boolean isExists = file.exists();
            boolean ishExists = file_h.exists();
            String temp = "";
            Double temp_value;
            String temp_h = "";
            Double temp_value_h;

            HashMap<Double, String> map = new HashMap<Double, String>();

            if(isExists) {
                BufferedReader reader = new BufferedReader(new FileReader("datae.txt"));
                while (rank != 7) {
                    if((temp = reader.readLine()) != null) {
                        map.put(Double.parseDouble(temp.split(":")[0]), temp.split(":")[1]);
                    } else break;
                    rank++;
                }
                rank = 0;
                TreeMap<Double, String> tm = new TreeMap<Double, String>(map);
                Set<Double> keyset = map.keySet();
                Iterator<Double> keyiterator = tm.keySet().iterator();

                Double k;
                String v;
                while (keyiterator.hasNext()) {
                    k = (Double) keyiterator.next();
                    v = (String) tm.get(k);
                    moim[i].setText(v + " - " + k);
                    i++;
                }

            } else {
                System.out.println("Hard Ranking Data does not exist");
                return;
            }
            HashMap<Double, String> map_h = new HashMap<Double, String>();
            if(ishExists) {
                BufferedReader reader_h = new BufferedReader(new FileReader("datah.txt"));
                while (rank != 7) {
                    if((temp_h = reader_h.readLine()) != null) {
                        map_h.put(Double.parseDouble(temp_h.split(":")[0]), temp_h.split(":")[1]);
                    } else break;
                    rank++;
                }
                rank = 0;
                TreeMap<Double, String> tm_h = new TreeMap<Double, String>(map_h);
                Set<Double> keyset = map.keySet();
                Iterator<Double> keyiterator_h = tm_h.keySet().iterator();

                Double k_h;
                String v_h;
                while (keyiterator_h.hasNext()) {
                    k_h = (Double) keyiterator_h.next();
                    v_h = (String) tm_h.get(k_h);
                    moim[j].setText(v_h + " - " + k_h);
                    j++;
                    System.out.println(j);
                }

            } else {
                System.out.println("Ranking Data does not exist");
                return;
            }
        } catch(IOException e) {

        }
    }

}
