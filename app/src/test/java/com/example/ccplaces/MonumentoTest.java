package com.example.ccplaces;

import com.example.ccplaces.Model.Monumento;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MonumentoTest {

    private Monumento m=new Monumento();

    @Before
    public void setUp() throws Exception {
        try{
            m.setNombre("San Jorge");
            m.setDesc("Esta estatua es muy bonita");
            m.setImgId(4);
            m.setTipo("Estatua");
            m.setFavorito(false);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void getTipo() {
        assertEquals("Estatua",m.getTipo());
    }

    @Test
    public void setTipo() {
        m.setTipo("Iglesia");
        assertEquals("Iglesia",m.getTipo());
    }

    @Test
    public void getNombre() {
        assertEquals("San Jorge",m.getNombre());
    }

    @Test
    public void setNombre() {
        m.setNombre("Plaza Mayor");
        assertEquals("Plaza Mayor",m.getNombre());
    }

    @Test
    public void getFavorito() {
        assertTrue(m.getFavorito()==false);
    }

    @Test
    public void setFavorito() {
        m.setFavorito(true);
        assertTrue(m.getFavorito()==true);
    }

    @Test
    public void getDesc() {
        assertEquals("Esta estatua es muy bonita",m.getDesc());
    }

    @Test
    public void setDesc() {
        m.setDesc("Restaurado en 1966");
        assertEquals("Restaurado en 1966",m.getDesc());
    }

    @Test
    public void getImgId() {
        assertEquals(new Integer(4),m.getImgId());
    }

    @Test
    public void setImgId() {
        m.setImgId(59);
        assertEquals(new Integer(59),m.getImgId());
    }

    @After
    public void tearDown() throws Exception {
        try{
            m.setNombre("");
            m.setTipo("");
            m.setImgId(null);
            m.setFavorito(false);
            m.setDesc("");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}