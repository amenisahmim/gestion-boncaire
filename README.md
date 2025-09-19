# 🏦 Système de Gestion Bancaire en Java

## 📌 Description
Ce projet est un système de gestion bancaire développé en **Java** avec une base de données **MySQL**, conçu à l’aide de l’**UML**.  
Il permet de gérer les clients, les comptes et d’effectuer des opérations bancaires.

## ✨ Fonctionnalités
- **Administrateur** : ajouter, modifier et supprimer des clients et des comptes.  
- **Banquier** : transférer de l’argent entre comptes, effectuer des transactions (créditer/débiter), rechercher un compte ou un client.  
- **Client** : consulter ses coordonnées et ses comptes.  

## ⚙️ Technologies
- Java (Swing)  
- MySQL + JDBC  
- UML pour la conception  

## 🚀 Exécution
1. Créer la base MySQL (script SQL fourni).  
2. Configurer la connexion dans les classes DAO.  
3. Lancer l’application avec `login.java`.  

---
## ⚙️ Architecture en couches :  
  - `interface_gestionbancaire` (couche présentation)  
  - `DAO` (accès aux données)  
  - `metier` (couche métier / logique applicative)
