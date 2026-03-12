package com.example.migrationpoc.config;

/* To determine active and target schema*/
public class SchemaResolver {
    public static String getTargetSchema(String activeSchema) {
        if("addressmig_blue".equalsIgnoreCase(activeSchema)){
            return "addressmig_green";
        } else {
            return "addressmig_blue";
        }
    }
}
