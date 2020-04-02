package com.github.mayconmoraesdm.main;

import com.github.mayconmoraesdm.entidades.Contato;
import com.github.mayconmoraesdm.entidades.Entidade;
import com.github.mayconmoraesdm.entidades.UserInterface;

import java.sql.SQLException;
import java.util.List;

public class Programa {
    public static void main(String[] args) {
            UserInterface userInterface = new UserInterface();
            userInterface.userInterface();
    }









    public static void exclui() {
        try {
            System.out.println("Excluindo contato");
            Contato contato = new Contato(2);
            contato.exclui();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
