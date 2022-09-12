package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 ////////////////////////

import java.lang.UnsupportedOperationException;
import java.util.NoSuchElementException;

public class Oblig1 {
    private Oblig1() {}

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {
        if(a.length == 0) {
            throw new NoSuchElementException("Tabell a er tom"); //kastes feil når tabell er tom
        }

        for(int i = 0; i < a.length-1; i++) { //forløkke for å gå gjennom hver element i arrayet
            if(a[i] > a[i+1]) { //sammenligning 2 tall som står ved siden av hverandre
                int temp = a[i]; //lagres tall
                a[i] = a[i+1]; // byttes plass
                a[i+1] = temp; //beholdes den gamle verdien
            }
        }
        return a[a.length-1]; //returnes det største tallet som samtidig ligger bakerst
    }

    public static int ombyttinger(int[] a) {

    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        throw new UnsupportedOperationException();
    }

    /// 7b)
    public static String flett(String... s) {
        throw new UnsupportedOperationException();
    }


}  // Oblig1
