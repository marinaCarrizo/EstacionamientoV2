/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expertos;

import java.util.List;

/**
 *
 * @author VICTOR
 */
public interface Experto {
    
    public static final String ADD = "add";
    public static final String EDIT = "edit";
    
    public List<Object> search(String param, int column);
    
    public List<Object> search(String param);
    
    public Object find(String param);
    
    public int persist(Object o, String operation);
    
    public int persist(Object entity);
    
    public int delete(Object entity);
    
}
