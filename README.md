inventory control system
===

[![Build Status for pnathan's fork](https://travis-ci.org/pnathan/InventoryControlSystem.svg?branch=master)](https://travis-ci.org/pnathan/InventoryControlSystem)

Setup for development:
---

- Install postgres and create:
    - inventory_control_system database
    - inventory_control_system user
    - dev-password password
- Install the Java 7 or Java 8 JDKs.
- clone this repository, `cd` to it, and execute `./activator run`
    - get `$beverage`
    - After a while, open `http://localhost:9000` in your browser
- Do development!

Future Setup (not done yet):
---

- Install Vagrant & Virtualbox
- clone repo, `cd` to it, and `vagrant up`
- `vagrant ssh` && /vagrant/activator run
- After a (long) while, open `http://localhost:9000` in your browser


IDE
---

- after having loaded the project successfully, run `activator
 (eclipse|idea|ensime)` to generate the appropriate IDE file.


Remarks
---

The ICS uses this tech stack:

- JVM
- Scala
- Play framework (a MVC framework)
- Slick DB framework

This stac will (should) provide type safety for development.
