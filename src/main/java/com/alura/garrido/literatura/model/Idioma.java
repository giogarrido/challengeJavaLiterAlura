package com.alura.garrido.literatura.model;

import java.util.List;
import java.util.ArrayList;

public enum Idioma{
    ESPAÑOL("es","Español"),
    INGLES("en","Ingles"),
    FRANCES("fr","Frances"),
    PORTUGUES("pt","Portugues"),
    ITALIANO("it","Italiano"),
    NO_IDENTIFICADO(" "," ");

    private String idiomaEspaniol;
    private String idiomaGutendex;

    Idioma (String idiomaGutendex,String idiomaEspaniol){
        this.idiomaEspaniol=idiomaEspaniol;
        this.idiomaGutendex=idiomaGutendex;
    }

    public static Idioma fromString(String text){
        for (Idioma idioma: Idioma.values()){
            if(idioma.idiomaGutendex.equalsIgnoreCase(text)){
                return idioma;
            }
        }
        return NO_IDENTIFICADO;
    }



    public static Idioma fromEspaniol(String text){
        for (Idioma idioma: Idioma.values()){
            if(idioma.idiomaEspaniol.equalsIgnoreCase(text)){
                return idioma;
            }
        }
        return NO_IDENTIFICADO;
    }

    public String getIdiomaEspaniol(){
        return idiomaEspaniol;
    }

}
