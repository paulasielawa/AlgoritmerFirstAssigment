# Obligatorisk oppgave 1 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende student:
* Paula Sielawa, S364585, s364584@oslomet.no

# Arbeidsfordeling

I oppgaven har jeg hatt følgende arbeidsfordeling:
* Paula (jeg) har hatt hovedansvar for all oppgaver 1, 2, 3, 4, 5 og 7.

# Oppgavebeskrivelse

I oppgave 1 så gikk jeg frem ved å implementere forløkke for å gå gjennom hver element for å finne største
tall. I den oppgaven måtte vi bruke en annen teknikk for å finne det største tallet og det er sammenligning
mellom tall som står ved siden av hverandre.
I ombytting metoden telles hvor mange ganger den ombyttingen skjer. Eneste som må tilsettes er å sette opp 
variable counter for å telle opp hver gang if statement er sann. 

Når blir det flest ombyttinger?
Det blir flest av hvis tabellen er sortert synkende og det største tallet ligger foran, det må utføres n-1 sammenligninger
for å bytte plass til å komme seg til slutten av array. Det største tallet må ligge bakerst når prosessen er ferdig.
Hvert tall foran den er mindre og derfor den sammenligningen utføres hvert omløp.

Når blir det færrest?
Det blir færrest når tabellen er sortert stigende (det største tallet ligger bakerst). Det best tilfellet er lik 0.

Hvor mange blir det i gjennomsnitt?
I gjennomsnitt blir det n-1/2 fordi det summeres best tilfelle og verst tilfelle og deles med antall tilfeller
(her er det 2).

Kan du på grunnlag av dette si om metoden maks er bedre (eller dårligere) enn de maks-metodene vi har sett på tidligere?

