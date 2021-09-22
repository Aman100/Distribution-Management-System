package com.dms.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.dms.model.*;
import com.dms.repository.*;
import java.util.*;

@RestController()
public class DistributorController
{
@Autowired()
private DistributorRepository drepo;

@RequestMapping(value="/getAllDistributors",method=RequestMethod.GET)
public List<Distributor> getAllDistributors()
{
return drepo.findAll();
}

@RequestMapping(value="/getDistributorById/{d_id}",method=RequestMethod.GET)
public Distributor getDistributorById(@PathVariable("d_id") Integer d_id)
{
return drepo.findById(d_id).get();
}

@RequestMapping(value="/getDistributorByName/{d_name}",method=RequestMethod.GET)
public Distributor getDistributorByName(@PathVariable("d_name") String name)
{
return drepo.getDistributorByName(name);
}
}                                                 