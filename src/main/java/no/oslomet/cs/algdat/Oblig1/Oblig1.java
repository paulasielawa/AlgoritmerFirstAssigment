package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 ////////////////////////

import java.lang.UnsupportedOperationException;
import java.util.Arrays;
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
        int counter = 0; // setter opp variable 0 som teller opp antall ulike tall

        if(a.length == 0) {
            return counter; //om det er tomt tabell så det må returnere 0
        } else {
            counter++; // om det er noe element så det begynner med 1
        }
        for(int i = 1; i < a.length; i++) { //i utgangspunktet tar vi første element i arrayet
            int j = 0;
            for(j=0; j < i; j++) {       // her sammenligner vi et tall så går til så lenge til indeksen i
                                        //finner samme tall og derfor slutter det programmet
                if(a[i] == a[j]){       //sjekker om det er samme verdi
                    break;
                }
            }
            if(j==i){ // det telles opp samme tall kun en gang som er på samme plass
                counter++;
            }
        }
        return counter; // returner antall ulike tall
    }

    ///// Oppgave 4 //////////////////////////////////////
    //metode fra kompendie
    public static void bytt (int[]a,int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    //metode fra kompendie
    private static int parter0(int[]a, int v, int h, int skilleverdi){
        while(true) {
            while(v <= h && a[v]< skilleverdi) {
                v++;
            }
            while(v <= h && a[h] >= skilleverdi) {
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
    //metode fra kompendie
    private static int sParter0(int[] a, int v, int h, int indeks)
    {
        bytt(a, indeks, h);           // skilleverdi a[indeks] flyttes bakerst
        int pos = parter0(a, v, h - 1, a[h]);  // partisjonerer a[v:h - 1]
        bytt(a, pos, h);              // bytter for å få skilleverdien på rett plass
        return pos;                   // returnerer posisjonen til skilleverdien
    }
    //metode fra kompendie
    private static void kvikksortering0(int[] a, int v, int h)  // en privat metode
    {
        if (v >= h) return;  // a[v:h] er tomt eller har maks ett element
        int k = sParter0(a, v, h, (v + h)/2);  // bruker midtverdien
        kvikksortering0(a, v, k - 1);     // sorterer intervallet a[v:k-1]
        kvikksortering0(a, k + 1, h);     // sorterer intervallet a[k+1:h]
    }
    //metode fra kompendie
    public static void kvikksortering(int[] a, int fra, int til) // a[fra:til>
    {
        kvikksortering0(a, fra, til - 1);  // v = fra, h = til - 1
    }
    //metode fra kompendie
    public static void kvikksortering(int[] a)   // sorterer hele tabellen
    {
        kvikksortering0(a, 0, a.length - 1);
    }

    public static void delsortering(int[] a) {
        kvikksortering(a); //først må sortere alle elementene i arrayet
        int counter = 0; //trenger variable som begynner fra null så kan påpeke seinere indeksene foran for å bytte plass
        for(int i = 0; i <a.length; i++){
            if(a[i]%2 != 0) {           //sjekk om tall er odetall (modulo)
                int temp = a[counter]; //kunne bruke også metoden bytt her for å spare litt mer plass
                a[counter] = a[i];
                a[i] = temp;
                counter++; //når oddetall er opptatt så vi tar neste tall
            }
        }
        kvikksortering(a,counter,a.length); // sorterer vi kun partall
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        int n = a.length;    // arrayets lengde
        if(n<2) {           //dersom array er tom eller har et element
            return;
        }
        char[]b = Arrays.copyOfRange(a,n-1,n);      //lagrer vi array som består av
                                                        // et element som er kopi av siste element i arrayet A
        for(int i = n-1; i >= 1; i-- ){                //går vi nedover til første element
            a[i] = a[i-1];                             //skyves verdier på en plass til høyre
        }
        System.arraycopy(b,0,a,0,1); //byttes første element med array b første element
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        int slengde = s.length();   //String s lengde
        int tlengde = t.length();   //String t lengde
        String ut = "";             //definerer arrayet for å returnere den på slutten
        int i = 0;
        int j = 0;

        while(i < slengde && j < tlengde) { //fletter char mellom 2 arrayet så lenge til i og j er større en lengde
            ut += s.charAt(i);          //legger til bokstaver
            ut += t.charAt(j);
            i++;                        //øker counter
            j++;
        }
        while (i < slengde) {           //dersom arrayer har ulike lengder så må tas resten
            ut += s.charAt(i);
            i++;
        }
        while (j < tlengde) {           //dersom arrayer har ulike lengder så må tas resten
            ut += t.charAt(j);
            j++;
        }
        return ut;
    }
    /// 7b)
    public static String flett(String... s) {
        int lengde = s.length;          //hvor mange string har vi i arrayet
        int m= 0;
        int maksAntallBokstaver = 0;    //for å definere antall bokstaver av String med mest antall bokstaver

        while(m < lengde) {             //for å finne hvor mange bokstaver
            if(s[m].length() >= maksAntallBokstaver) {
                maksAntallBokstaver = s[m].length();
            }
            m++;
        }
        String resultat = "";

        int i = 0;
        while(i<maksAntallBokstaver) {
            for(int j = 0; j < lengde; j++) {
                if(s[j].length() > i) {         //dersom String lengde er mindre enn posisjon til bokstav så det ikke legges til char
                    resultat += s[j].charAt(i);
                }
            }
            i++;
        }
        return resultat;
    }
}  // Oblig1
