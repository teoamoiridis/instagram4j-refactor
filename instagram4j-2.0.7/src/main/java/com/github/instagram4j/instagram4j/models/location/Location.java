package com.github.instagram4j.instagram4j.models.location;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.github.instagram4j.instagram4j.models.IGBaseModel;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class Location extends IGBaseModel {
    private Long pk;
    private String external_id;
    private String name;
    private String external_source;
    private Double lat;
    private Double lng;
    private String address;
    private Integer minimum_age;
    
    public Location copyLocation() {
    	Location payloadLoc = new Location();
    	
        payloadLoc.setExternal_id(this.external_id);
        payloadLoc.setName(this.name);
        payloadLoc.setAddress(this.address);
        payloadLoc.setLat(this.lat);
        payloadLoc.setLng(this.lng);
        payloadLoc.setExternal_source(this.external_source);
        payloadLoc.put(payloadLoc.getExternal_source() + "_id", payloadLoc.getExternal_id());
        return payloadLoc;
    }

    @Data
    public static class Venue extends Location {
        @JsonAlias("external_id_source")
        private String external_source;
    }
    
}
