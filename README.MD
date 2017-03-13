#Úkol 1. - Úvod do problematiky

Tento úkol je těžce inspirován tutoriálem od Oracle.

Vytvořte projekt, který bude obsahovat následující třídy:

* Bicycle - reprezentuje jízdní kolo s následujícími atributy a metodami:
..* private int cadence;
..* private int gear;
..* private int speed;
..* public void printDescription(){}, která vypíše informace o kolu ve tvaru: 
```
Bike is in gear 1 with a cadence of 20 and travelling at a speed of 10. 
```
* TestBikes - obsahuje pouze public static void main(), kde budeme naše výtvory zkoušet.
Slovníková definice polymorfismu odkazuje na zásady v biologii, v níž organismus nebo druh může mít mnoho různých forem nebo fáze. Tento princip lze také použít k objektově orientovanému programování a jazyků, tedy i v jazyku Java. Podtřídy třídy mohou definovat své vlastní jedinečné chování a přesto sdílejí některé stejné funkčnosti nadřazené třídy.

Polymorfismus může být demonstrován na třídě Bicycle. Ta obsahuje metodu printDescription(), která vypíše informace o všech datech dané instance.

*Napište třídy MountainBike a RoadBike, které budou reprezentovat horské a silniční kolo, a které budou dědit od třídy Bicycle.
..* MountainBike bude mít navíc atribut String suspension označující, jakým druhem odpružení kolo disponuje (“Front” pro přední, “Dual” pro přední i zadní).
..* RoadBike bude mít navíc atribut int tireWidth označující šířku pneumatiky v milimetrech (protože siniční kola mívají pneumatiky úzké).
Nyní bychom chtěli, aby printDescription() vypisovalo všechny informace o daném kolu:
```
Bicycle bike01, bike02, bike03;
 
bike01 = new Bicycle(20, 10, 1);
bike02 = new MountainBike(20, 10, 5, "Dual");
bike03 = new RoadBike(40, 20, 8, 23);
 
bike01.printDescription();
bike02.printDescription();
bike03.printDescription();
```
Jenže výstup je následující:
```
Bike is in gear 1 with a cadence of 20 and travelling at a speed of 10. 

Bike is in gear 5 with a cadence of 20 and travelling at a speed of 10. 

Bike is in gear 8 with a cadence of 40 and travelling at a speed of 20.
```
Informace o odpružení (u druhého kola) a o šířce pneumatik (u třetího kola) chybí. Návrhy jak to vyřešit?

* Přepište metodu printDescription() u potomků třídy Bicycle tak, aby vždy zahrnovala data specifická pro dané kolo.
Tedy, existují tři třídy: Bicycle, MountainBike a RoadBike. Dvě podtřídy přepisují metodu printDescription() a tisknou jedinečné informace. Jak to, že se volá správná metoda, ačkoliv všechny proměnné jsou typu Bike?

Java Virtual Machine (JVM) volá příslušnou metodu pro objekt, na který se odkazuje každá z proměnných. Není to volání metody určené podle typu proměnné. Toto chování se označuje jako volání virtuální metody a ukazuje určitý aspekt důležitých polymorfních rysů v jazyce Java.

#Úkol 2. - Servis kol

Navrhněte servis kol. Servis příjmá různá kola a může mít různé specializace na opravy. Například může být servis, který se specializuje jen na RoadBike ale zvládne i údržbu běžného kola. Zkusme navrhnout následující 3 servisy:

* BasicService s metodou void accept(Bicycle) - vypíše “fixing Bicycle”
* MountainBikeService extends BasicService s metodami void accept (Bicycle) a void accept (MountainBike) - druhá z metod přijme jen MountainBike a vypíše “fixing MountainBike”
* RoadBikeService extends BasicService s metodami void accept (Bicycle) a void accept (RoadBike) - druhá z metod přijme jen RoadBike a vypíše “fixing RoadBike”
Nyní zkusme zakomponovat do metody main tyto servisy a předejme jim kola.

PZN: Výsledek našeho testu je nasledujicí, v úkolu č.3 řešíme jak to vyřešít
![poznamka k ukolu čislo 2](https://github.com/KORabdi/cvicka_4/blob/master/ukol2pzn.png?raw=true)

#Úkol 3. - Život není snadný, ale nevzdávejme se

Servis nám příjmá kola jako Bicycle. Co stím? Nápady?

* Detekce a přetypování
* Atribut typ pro každou třídu kola a dle něj přetypujeme
* Nějaký magický trik
Zkusme tedy použít kouzlo, jistě ho oceníte. Nejprve, ale řekněme co je zde za problém. Pokud uděláme toto Bicycle bike = new MountainBike(20, 10, 5, “Dual”); a zavoláme bike.printDescription(); tak se správně zavolá virtuální metoda z MountainBike. Pokud ale zavoláme na mountainBikeService.accept(bike), tak si compiler myslí, že má Bicycle.

Jak na to? Znovu pro pořádek:

1. zavoláme bike.printDescription(); a správně se zavolá virtuální metoda z MountainBike
2. zavoláme na mountainBikeService.accept(bike) a compiler si myslí, že má Bicycle.

Co tedy s tím? Spojme to a udělejme double dispatch. Přidejme metodu visit(BasicService bs) do každého typu kola! Každý typ kola pak zavolá v metodě visit bs.accept(this);. Zopakujme si to:

1. Zavoláme bike.visit(mountainBikeService) - to zavolá virtuální metodu visit na MountainBike - nic nového.
2. V těle visit se do mountainBikeService předá this, jenže co je nyní this? this je nyní MountainBike a ne Bicycle. Proč? Protože jsme zavolali virtuální metodu nad MountainBike.
Tento trik, je opět “best practice” a nazývá se visitor.

Je třeba aby každý servis implementoval metody accept pro všechny typy kol.
Každé kolo pak musí mít vlastní metody visit, i když vypadají stejně.