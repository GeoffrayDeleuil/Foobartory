# ProductionLine

## Enoncé

Le but est de coder une chaîne de production automatique de foobar .


On dispose au départ de 2 robots, mais on souhaite accélérer la production pour prendre le contrôle du marché des foobar . Pour ce faire on va devoir acheter davantage de robots, le programme s'arrête quand on a 30 robots.

Les robots sont chacun capables d'effectuer les activités suivantes :

Miner du foo : occupe le robot pendant 1 seconde.

Miner du bar : occupe le robot pendant un temps aléatoire compris entre 0.5 et 2 secondes.

Assembler un foobar à partir d'un foo et d'un bar : occupe le robot pendant 2 secondes. L'opération a 60% de chances de succès ; en cas d'échec le bar peut être réutilisé, le foo est perdu.

Vendre des foobar : 10s pour vendre de 1 à 5 foobar, on gagne 1€ par foobar vendu

Acheter un nouveau robot pour 3€ et 6 foo , 0s

A chaque changement de type d'activité, le robot doit se déplacer à un nouveau poste de travail, cela l'occupe pendant 5s.

**Notes:**

1 seconde du jeu n'a pas besoin d'être une seconde réelle.

Le choix des activités n'a pas besoin d'être optimal (pas besoin de faire des maths), seulement fonctionnel.


## Analyse de l'énoncé:

**BUT:** avoir 30 robot.

**COMMENT:** acheter de nouveaux robot.

  + chaque robot coute 3e et 6 foo
 
  - vendre un foobar = 1e : temps fixe de vente 10s pour 1 - 5 foobar
 		Je decide d'optimiser et de vendre par 5 (voir si on optimise pour le dernier lot)
    
  - assembler un foobar (necessite 1 foo et 1 bar) (possibilité d'echec)
 	
  - miner du bar
 	
  - miner du foo

**Plusieurs solution:**
- Prevoir d'avance les taches, en faire une file et distribuer les jetons aux robots. -> Problème avec l'assemblage de foobar qui peut échouer.

- Chaque robot arrive et demande une tache, on calcul les tache a la volée. -> Problème, le temps que le robot finisse la tache, elle peut avoir été redemandée à un autre robot: pas optimal


**Solution choisie:** Solution 2, plus simple à mettre en oeuvre, et l'énoncé ne demnde pas un choix optimal.

## Implémentation:

Choix d'implémenter un administrateur pour donner une tache au robot (synchronisé)

L'administrateur a accés aux ressources, et seulement lui.

Le robot demande une tache, l'administrateur lui donne une tache ainsi que les ressources associées et se libére.

Quand le robot a fini la tache il revient donner ses nouvelles resources à l'administrateur qui les prend en compte et refait ses calculs de taches en fonction, à l'arrivée d'un nouveau robot.

Pour une question de praticité, 1s est représenté par 10ms dans le code.

## Evolutions possibles:
Garder en memoire les actions demandées, pour optimiser.

Optimiser le dernier lot pour ne pas attendre les 5 foobars.

Eventuellement faire en sorte que les robots finissent leur taches avant d'interompre le programme (utilité?)

Output plus friendly


## Temps passé: 
Difficile à dire, temps passé en fractionné.

Environ 2h pour une première solution qui fonctionne, et 1h de plus pour fignoler, refaire des petites améliorations.


## Execution: 
There is an executable jar file into: foobars/out/artifacts/foobars_jar

You can execute it in command line : java -jar foobars.jar

If you want the log for all the execution, you can put the result into a file like: java -jar foobars.jar > outputFile.txt 2>&1


