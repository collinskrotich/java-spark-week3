package org.crotich.utils;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Map;

public class SharedUtils {

    public static String render(Map<Integer, Object> model, String templateName) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templateName));
    }

}
