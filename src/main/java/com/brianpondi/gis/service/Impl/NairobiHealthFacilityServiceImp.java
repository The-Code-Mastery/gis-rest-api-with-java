package com.brianpondi.gis.service.Impl;

import com.brianpondi.gis.entity.NairobiHealthFacility;
import com.brianpondi.gis.repository.NairobiHealthFacilityRepository;
import com.brianpondi.gis.service.NairobiHealthFacilityService;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NairobiHealthFacilityServiceImp implements NairobiHealthFacilityService {

    @Autowired
    private NairobiHealthFacilityRepository nairobiHealthFacilityRepository;

    private static GeometryFactory geometryFactory = new GeometryFactory();
    private static WKTReader wktReader = new WKTReader(geometryFactory);



    private static Geometry fromWkt(String wkt) {
        try {
            return wktReader.read(wkt);
        } catch (ParseException e) {
            System.out.println("Converting from WKT to Geometry failure");
        }
        return null;
    }

    public List<NairobiHealthFacility> findAll() {
        return  nairobiHealthFacilityRepository.findAll();
    }

    public NairobiHealthFacility findById(int id) throws NotFoundException {
        return nairobiHealthFacilityRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Sub County not found with ID: " + id)
        );
    }


    public void deleteById(int id) {
        nairobiHealthFacilityRepository.deleteById(id);
    }

//    @Override
//    public NairobiHealthFacility findWithinSubCounty(String name) {
//        return null;
//    }

}
