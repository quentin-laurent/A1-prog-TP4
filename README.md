# ISEP A1
## Algo-Prog TP4

This repository contains the implentation of the `Mini RPG Lite 3000` available [here](https://moodle.isep.fr/moodle/pluginfile.php/50118/mod_resource/content/3/tp4.pdf).

The game is organized as follows:
- The game is made of a number of stages (chosen by the player at the beginning of the game)
- Each stage opposes a team of enemies (controlled automatically) to a team of heroes (controlled by the player)
- Each stage is made of multiple rounds, in which the play order is determined randomly
- During a round:
  - If all heroes die, the game is lost
  - If all enemies die, the game proceeds to the next stage
  - If there are still enemies and heroes alive, a next round occurs
- If all the enemies of the last stage (a.k.a the boss) die, the game is won

The game obeys to the following rules:
- On its turn, each `Hero` has the possibility to choose one of 4 actions:
  - `attack`, which allows the `Hero` to attack an `Enemy` using its `Weapon`
  - `spell`, which allows a `SpellCaster` (a specific type of `Hero`) to use its spell (the effect of the spell varies depending on the class implementation)
  - `defend`, which allows the `Hero` to reduce the damage of the following attack from `20%` to `50%`
  - `consume`, which allows the `Hero` to use an `Consumable` (a specific type of `Item`) from its inventory
- On its turn, each `Enemy` attacks a random `Hero`
- A `SpellCaster` regenerates 15 mana on each stage
- A `Hero` can only target an `Enemy` when choosing the `attack` action
- A `SpellCaster` can target any `Combatant` when choosing the `spell` action
- A `Hunter` needs to have at least one `Arrow` (a specific type of `Item`) in its inventory in order to `attack`
- `Food` (a specific type of `Consumable`) can be used by a `Hero` to regenerate HP
- A `Potion` (a specific type of `Consumable`) can be used by a `SpellCaster` to regenerate Mana
