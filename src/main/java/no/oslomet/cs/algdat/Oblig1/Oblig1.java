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
        int counter = 0; // variabel counter er lik 0
        for(int i = 0; i < a.length-1; i++) {
            if(a[i] > a[i+1]) {
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
                counter++; //telles opp
            }
        }
        return counter; // returner antall ombyttinger
    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        int counter = 0; //setter opp variabel lik 0

        if(a.length == 0) {
            return 0; //dersom arrayet er tom så det er 0 ulike tall
        } else {
            counter++; //om det er ikke tom så det er alltid minst et tall
        }
        for(int i = a.length -1; i > 0; i--) { // går vi nedover i forløkke
            if(a[i] >= a[i-1]) { //samenligning tall ved siden av hverandre
                if(a[i] != a[i-1]){ //tall er ikke det samme
                    counter++;
                }
            } else {
                throw new IllegalStateException("Arrayet er ikke sortert stigende"); //array må være sortert stigende
            }
        }
        return counter;
    }

    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        int counter = 0; // setter opp variable 0

        if(a.length == 0) {
            return counter; //om det er tomt tabell så det må returnere 0
        } else {
            counter++; // om det er noe element så det begynner med 1
        }
        for(int i = 1; i < a.length; i++) { //i utgangspunktet tar vi første element i arrayet
            int j = 0;
            for(j=0; j < i; j++) { // her sammenligner vi et tall så går til så lenge til indeksen i
                if(a[i] == a[j]){ //finner vi samme tall slutter det programmet
                    break;
                }
            }
            if(j==i){ // det telles opp samme tall kun en gang
                counter++;
            }
        }
        return counter; // returner antall ulike tall
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void bytt (int[]a,int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static int partering(int [] a) {
        int v = 0;
        int h = a.length -1;
        while(true) {
            while(v <= h && a[v]% 2 != 0) {
                v++;
            }
            while(v <= h && a[h]% 2 == 0) {
                h--;
            }
            if( v < h) {
                bytt(a, v++, h--);
            }
            else {
                return v;
            }
        }
    }
    public static void sortering(int[]a, int fra, int til) {
        for(int i = fra ; i < til -1; i++) {
            int m = i;
            int minverdi = a[i];

            for (int j = i +1; j < til; j++) {
                if(a[j] < minverdi) {
                    minverdi = a[j];
                    m=j;
                }
            }
            int temp = a[i];
            a[i] = a[m];
            a[m] = temp;
        }
    }
    public static void delsortering(int[] a) {
            partering(a);
            int midten = (a.length -1)/2;
            sortering(a,0,midten+1);
            sortering(a,midten + 1, a.length);
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
