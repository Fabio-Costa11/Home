package com.example.asus.home;

/**
 * Created by Asus on 06/02/2017.
 */

public class Divisao {
    private String ID;
    private String Descricao;

    public Divisao(String ID, String Descricao)
    {
        this.ID = ID;
        this.Descricao = Descricao;
    }
    public String getID()
    {
        return ID;
    }

    public void setID(String id)
    {
        this.ID = id;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }
}
