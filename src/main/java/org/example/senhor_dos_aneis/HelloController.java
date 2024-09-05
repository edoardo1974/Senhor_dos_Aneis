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
import java.util.ArrayList;
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
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] items = {"Elfo", "Humano", "Hobbit"};
        String[] items1 = {"Orco", "Troll"};
        comboBox.getItems().addAll(items);
        comboBox1.getItems().addAll(items1);

        comboBox.setValue("Elfo");
        comboBox1.setValue("Troll");

        buttonheroi.setText("Adicionar");
        buttonbestas.setText("Adicionar");

        buttonheroi.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, event -> {
            //System.out.println("Adicionado " + nomeheroi.getText() + " " + puntosVidaheroi.getText() + " " + resistênciaarmaduraheroi.getText());
            if (comboBox.getValue().equals("Elfo")) {
                Elfo hero = new Elfo(nomeheroi.getText(), Integer.parseInt(puntosVidaheroi.getText()), Integer.parseInt(resistênciaarmaduraheroi.getText()));
                heroi.add(hero);
                listViewheroi.getItems().add(hero);
                System.out.println("Heroi: "+heroi);



            }
            else if (comboBox.getValue().equals("Hobbit")) {
                Hobbit hobbit = (new Hobbit(nomeheroi.getText(), Integer.parseInt(puntosVidaheroi.getText()), Integer.parseInt(resistênciaarmaduraheroi.getText())));
                heroi.add(hobbit);
                listViewheroi.getItems().add(hobbit);
                System.out.println("Heroi: "+heroi);


            }
            else if (comboBox.getValue().equals("Humano")) {
                Homem homem = (new Homem(nomeheroi.getText(), Integer.parseInt(puntosVidaheroi.getText()), Integer.parseInt(resistênciaarmaduraheroi.getText())));
                heroi.add(homem);
                listViewheroi.getItems().add(homem);
                System.out.println("Heroi: "+heroi);



        }});

        buttonbestas.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, event -> {
            System.out.println("Adicionado " + nomebesta.getText() + " " + puntosVidabesta.getText() + " " + resistênciaarmadurabesta.getText());
            if (comboBox1.getValue().equals("Troll")) {
                Troll troll = (new Troll(nomebesta.getText(), Integer.parseInt(puntosVidabesta.getText()), Integer.parseInt(resistênciaarmadurabesta.getText())));
                bestas.add(troll);
                listViewbesta.getItems().add(troll);
                System.out.println("Bestas: "+bestas);




            }
            else if (comboBox1.getValue().equals("Orco")) {
                Orco orco = (new Orco(nomebesta.getText(), Integer.parseInt(puntosVidabesta.getText()), Integer.parseInt(resistênciaarmadurabesta.getText())));
                bestas.add(orco);
                listViewbesta.getItems().add(orco);
                System.out.println("Bestas: "+bestas);



            }

        });

        buttonluta.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, event -> {
            System.out.println("Início da batalha " );
            Battalha battaglia = new Battalha(heroi, bestas);


            String risultatoBattaglia = battaglia.inizia();
            listViewluta.getItems().add(risultatoBattaglia);


            });





        //Eventuale azione quando un elemento è selezionato
        comboBox.setOnAction(event -> {
            String selected = comboBox.getValue();
            System.out.println("Hai selezionato: " + selected);

        });

        comboBox1.setOnAction(event -> {
            String selected = comboBox.getValue();
            System.out.println("Hai selezionato: " + selected);});

        for (int i = 0; i < heroi.size(); i++) {
            listViewheroi.getItems().add(heroi.get(i).getNome());
        }

        listViewbesta.getItems().addAll(bestas);
    }

    @FXML
    private void handleComboBoxAction() {
        String selected = comboBox.getValue();
        System.out.println("Hai selezionato: " + selected);
    }



    }


