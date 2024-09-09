package org.example.senhor_dos_aneis;

import com.tokio.model.*;
import com.tokio.service.Battalha;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;
import com.tokio.model.Personagem;
import java.util.List;

public class HelloController implements Initializable {

    @FXML
    private TextField nomeheroi;

    @FXML
    private TextField puntosVidaheroi;

    @FXML
    private TextField resistênciaarmaduraheroi;

    @FXML
    private TextField nomebesta;

    @FXML
    private TextField puntosVidabesta;

    @FXML
    private TextField resistênciaarmadurabesta;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private ComboBox<String> comboBox1;

    @FXML
    private Button buttonheroi;

    @FXML
    private Button buttonbestas;

    @FXML
    private Button buttonluta;

    @FXML
    private ListView listViewheroi;

    @FXML
    private ListView listViewbesta;

    @FXML
    private ListView listViewluta;


    private List<Personagem> heroi = new ArrayList<>();
    private List<Personagem> bestas = new ArrayList<>();

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {//Inicializa os vários eventos JavaFX
        String[] items = {"Elfo", "Humano", "Hobbit"};
        String[] items1 = {"Orco", "Troll"};
        comboBox.getItems().addAll(items);//Adiciona items à combobox
        comboBox1.getItems().addAll(items1);

        comboBox.setValue("Elfo");//Valor padrão
        comboBox1.setValue("Troll");

        buttonheroi.setText("Adicionar");//Nome do botão
        buttonbestas.setText("Adicionar");

        buttonheroi.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, event -> {//Evento de clique que gere a inclusão de heróis na lista.
            if (comboBox.getValue().equals("Elfo")) {
                Elfo hero = new Elfo(nomeheroi.getText(), Integer.parseInt(puntosVidaheroi.getText()), Integer.parseInt(resistênciaarmaduraheroi.getText()));
                heroi.add(hero);
                listViewheroi.getItems().add(hero);
            }
            else if (comboBox.getValue().equals("Hobbit")) {
                Hobbit hobbit = (new Hobbit(nomeheroi.getText(), Integer.parseInt(puntosVidaheroi.getText()), Integer.parseInt(resistênciaarmaduraheroi.getText())));
                heroi.add(hobbit);
                listViewheroi.getItems().add(hobbit);
            }
            else if (comboBox.getValue().equals("Humano")) {
                Homem homem = (new Homem(nomeheroi.getText(), Integer.parseInt(puntosVidaheroi.getText()), Integer.parseInt(resistênciaarmaduraheroi.getText())));
                heroi.add(homem);
                listViewheroi.getItems().add(homem);
        }});

        buttonbestas.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, event -> {//Evento de clique que gere a inclusão de bestas na lista.
            if (comboBox1.getValue().equals("Troll")) {
                Troll troll = (new Troll(nomebesta.getText(), Integer.parseInt(puntosVidabesta.getText()), Integer.parseInt(resistênciaarmadurabesta.getText())));
                bestas.add(troll);
                listViewbesta.getItems().add(troll);
            }
            else if (comboBox1.getValue().equals("Orco")) {
                Orco orco = (new Orco(nomebesta.getText(), Integer.parseInt(puntosVidabesta.getText()), Integer.parseInt(resistênciaarmadurabesta.getText())));
                bestas.add(orco);
                listViewbesta.getItems().add(orco);
            }
        });

        buttonluta.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, event -> {//Evento de clique que gere a batalha.
            Battalha battaglia = new Battalha(heroi, bestas);
            String resultouBatalha = battaglia.comecar();
            listViewluta.getItems().add(resultouBatalha);
            });
    }
}



