/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.List;
import model.Cliente;

/**
 *
 * @author alexandretorres
 */
public class ClienteService {
    private static List<Cliente> clientes;
    
    public static List<Cliente> obtemClientes(){
        if (clientes == null){
            clientes = new ArrayList<>();

            clientes.add( new Cliente( 1, "Frodo Baggins", "2345678909"));
            clientes.add( new Cliente( 2, "Bilbo Baggins", "48732682912"));
            clientes.add( new Cliente( 3, "Sauron Corintians", "38576139571"));
            clientes.add( new Cliente( 4, "Galadriel Diva", "57084290572"));
            clientes.add( new Cliente( 5, "Nazgul Flamenguista", "2849750284"));            
        }
        
        return clientes;
        
    }
    
    public static void ativaDesativa(int id){
        obtemClientes().stream()
                .filter( c -> c.getId() == id)
                .forEach(c -> c.setAtivo( !c.isAtivo()));
    }
    
}
