package org.crotich.dao;

import org.crotich.config.DatabaseConfig;
import org.crotich.models.Sightings;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class SightingsDao {

    private static final Sql2o sql2o = DatabaseConfig.getDatabaseProduction();
    private static Connection connection = sql2o.open();

    public static boolean  createSighting(Sightings sightings) {
        try {
            String query = "INSERT INTO sightings ( animal_id ,location, ranger_name) VALUES (:animalId,:location, :rangerName);";
            connection.createQuery(query)
                    .addParameter("animalId", sightings.getAnimal_id())
                    .addParameter("location", sightings.getLocation())
                    .addParameter("rangerName",sightings.getRangerName())
                    .executeUpdate();
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }


}
