package com.github.mayconmoraesdm.entidades;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    boolean x = true;
    int selectedValue, selectForId;
    static String name,cel,phone,cel2,phone2,email;
    Scanner scanner = new Scanner(System.in);

    public void  userInterface(){

        while(x == true) {
            System.out.println("O que você deseja fazer ?");
            System.out.println("1 - Listar todos os usuários");
            System.out.println("2 - Listar um único registro por ID");
            System.out.println("3 - Listar um único registro por nome");
            System.out.println("4 - Inserir novo registro");
            System.out.println("5 - Alterar registro existente");
            System.out.println("6 - Excluir registro existente");
            System.out.println("7 - Fechar aplicação");
            selectedValue = scanner.nextInt();

            switch (selectedValue) {
                case 1:
                    try {
                        listaTodos();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Insira um Id");
                        selectForId = scanner.nextInt();
                        listaId(selectForId);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Insira um Id");
                        name = scanner.next();
                        listaName(name);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    try {
                        insere();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    System.out.println("Insira um Id");
                    selectForId = scanner.nextInt();
                    altera(selectForId);
                    break;
                case 6:
                    System.out.println("Insira um Id");
                    selectForId = scanner.nextInt();
                    exclui(selectForId);
                    break;
                case 7:
                    System.out.println("Sistema Finalizado");
                    System.exit(0);
                    break;
            }

        }

    }

    public static void listaTodos() throws SQLException {
        System.out.println("Lista Todos");
        Contato contato = new Contato();
        List<Contato> contatos = contato.busca();
        if (contatos.size() == 0) {
            System.out.printf("Nenhum contato na agenda!");
        } else {
            contatos.forEach((c) -> {
                System.out.println(String.format("Id: %d\nNome: %s\nTelefone: %s\nCelular: %s\nE-mail: %s\n", c.getId(), c.getNome(), c.getTelefone(), c.getCelular(), c.getEmail()));
            });
        }
        new UserInterface().userInterface();
    }

    public static void listaId(Integer id) throws SQLException {
        System.out.println("Lista um contato");
        Contato c = new Contato(id);
        if (Contato.verifica == 1) {
            System.out.println("Lista por nome");
            System.out.println(String.format("Id: %d\nNome: %s\nTelefone: %s\nTelefone2: %s\nCelular: %s\nCelular2: %s \nE-mail: %s\n",
                    c.getId(), c.getNome(), c.getTelefone(), c.getTelefone2(), c.getCelular(), c.getCelular2(), c.getEmail()));
        }else {
            System.out.println("Registro não encontrado");
        }
    }

    public static void listaName(String name) throws SQLException {
        System.out.println("Lista um contato");
        Contato c = new Contato(name);
        if (Contato.verifica == 1) {
            System.out.println("Lista por nome");
            System.out.println(String.format("Id: %d\nNome: %s\nTelefone: %s\nTelefone2: %s\nCelular: %s\nCelular2: %s \nE-mail: %s\n",
                    c.getId(), c.getNome(), c.getTelefone(), c.getTelefone2(), c.getCelular(), c.getCelular2(), c.getEmail()));
        }else {
            System.out.println("Registro não encontrado");
        }
    }

    public static void insere() throws SQLException {
        System.out.println("Inserindo contato");
        try {
            Contato contato = new Contato();
            System.out.println("Insira o nome");
            name = new UserInterface().scanner.nextLine();
            contato.setNome(name);
            System.out.println("Insira o Telefone");
            phone = new UserInterface().scanner.nextLine();
            contato.setTelefone(phone);
            System.out.println("Insira o Celular");
            cel = new UserInterface().scanner.nextLine();
            contato.setCelular(cel);

            System.out.println("Insira o Telefone 2");
            phone2 = new UserInterface().scanner.nextLine();
            contato.setTelefone2(phone);
            System.out.println("Insira o Celular 2");
            cel2 = new UserInterface().scanner.nextLine();
            contato.setCelular2(cel);

            System.out.println("Insira um Email");
            email = new UserInterface().scanner.nextLine();
            contato.setEmail(email);
            contato.insere();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        new UserInterface().userInterface();
    }


    public static void altera(int id) {
        try {
            System.out.println("Alterando contato");
            Contato contato = new Contato(id);
            contato.setEmail("maycon@emailteste.com");
            contato.altera();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        new UserInterface().userInterface();
    }

    public static void exclui(Integer id) {
        try {
            System.out.println("Excluindo contato");
            Contato contato = new Contato(id);
            contato.exclui();
        } catch (SQLException var1) {
            var1.printStackTrace();
        }
        new UserInterface().userInterface();
    }
}
