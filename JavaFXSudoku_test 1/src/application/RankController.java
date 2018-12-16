package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.*;
import java.util.*;
import java.net.URL;
import java.util.ResourceBundle;

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
            File file = new File("../data.txt");
            int i = 0;
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
            String temp = "";
            Double temp_value;

            HashMap<Double, String> map = new HashMap<Double, String>();

            if(isExists) {
                BufferedReader reader = new BufferedReader(new FileReader("../data.txt"));
                while (rank != 7) {
                    if((temp = reader.readLine()) != null) {
                        map.put(Double.parseDouble(temp.split(":")[0]), temp.split(":")[1]);
                    } else break;
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
                System.out.println("Ranking Data does not exist");
                return;
            }
            /*
            if(isExists) {
                BufferedReader reader = new BufferedReader(new FileReader("../data.txt"));
                while((temp = reader.readLine()) != null) {
                    System.out.println(temp);
                    moim[i].setText(temp.split(":")[1] + " - " + temp.split(":")[0]);
                    i++;
                }
            } */

        } catch(IOException e) {

        }
    }

}
