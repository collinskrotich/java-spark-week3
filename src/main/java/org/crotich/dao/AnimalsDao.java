package org.crotich.dao;

import org.crotich.config.DatabaseConfig;
import org.crotich.models.Animals;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class AnimalsDao {
    private static final Sql2o sql2o = DatabaseConfig.getDatabaseProduction();

    private static Connection connection = sql2o.open();
    public static boolean  createAnimal(Animals animals) {
        try {
            String query = "INSERT INTO animals ( type ,name, health, age) VALUES (:type,:name, :health, :age);";
            connection.createQuery(query)
                    .addParameter("type", animals.getType())
                    .addParameter("name", animals.getName())
                    .addParameter("health",animals.getHealth())
                    .addParameter("age",animals.getAge())
                    .executeUpdate();
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }


    public static Animals findAnimalById(int animalId) {
        try {
            String queryAnimals= "SELECT * FROM animals WHERE NOT deleted AND id = :id;";
            Animals animals = connection.createQuery(queryAnimals)
                    .addParameter("id", animalId)
                    .executeAndFetchFirst(Animals.class);
//
            return animals;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return  null;
        }
    }


    //update
}
