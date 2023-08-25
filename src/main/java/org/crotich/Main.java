package org.crotich;

import org.crotich.dao.AnimalsDao;
import org.crotich.dao.SightingsDao;
import org.crotich.models.Animals;
import org.crotich.models.Sightings;
import org.crotich.utils.SharedUtils;

import java.util.HashMap;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        staticFileLocation("/public");
        get("/", (req, res)->{
            return SharedUtils.render(new HashMap<>(), "index.hbs");
        });
        get("/wildlife/add", (req, res)->{
            return SharedUtils.render(new HashMap<>(), "wildlife-details.hbs");
        });
        get("/animal/add", (req, res)->{
            return SharedUtils.render(new HashMap<>(), "animal-details.hbs");
        });

        post("/create-sighting", (req, res)->{
            String id = req.queryParams("id");
            String location =req.queryParams("location");
            String rangerName =req.queryParams("rangername");

            try{
                if( id ==null  || id.length()==0
                        || location==null || location.length()==0 || rangerName==null || rangerName.length()==0 ){
                    throw new IllegalArgumentException("invalid input all fields have to be provided");
                }
                int latestId= Integer.valueOf(id);
                Animals animal=AnimalsDao.findAnimalById(latestId);
                Sightings sightings= new Sightings(animal.getId(), location, rangerName);

                //save sighting
                SightingsDao.createSighting(sightings);

            }catch (Exception e){

                System.out.print(e.getMessage());
            }

            res.redirect("/");
            return null;
        });

        post("/create-animal", (req, res)->{
            String category = req.queryParams("category");
            String name = req.queryParams("name");
            String health= req.queryParams("health");
            String age=req.queryParams("age");

            try{
                if(category==null || category.length()==0 || name==null|| name.length()==0|| health==null ||health.length()==0 || age ==null || age.length()==0){
                    System.out.print(category);
                    System.out.print(name);
                    System.out.print(health);
                    System.out.print(age);
                    throw new IllegalArgumentException("invalid input all fields have to be provided");
                }

                Animals animals= new Animals(category,name,health,age);
                AnimalsDao.createAnimal(animals);

            }catch (Exception e){

                System.out.print(e.getMessage());
            }

            res.redirect("/");
            return null;
        });
    }
}