package com.dms.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.dms.model.*;
import com.dms.repository.*;
import java.util.*;

@RestController()
public class RetailerController
{
@Autowired()
private RetailerRepository rrepo;

@RequestMapping(value="/getAllRetailers",method=RequestMethod.GET)
public List<Retailer> getAllRetailers()
{
return rrepo.findAll();
}

@RequestMapping(value="/getRetailerById/{r_id}",method=RequestMethod.GET)
public Retailer getRetailerById(@PathVariable("r_id") Integer r_id)
{
return rrepo.findById(r_id).get();
}

@RequestMapping(value="/getRetailerByName/{d_name}",method=RequestMethod.GET)
public Retailer getRetailerByName(@PathVariable("d_name") String name)
{
return rrepo.getRetailerByName(name);
}

@RequestMapping(value="/mapRetailerToDistributor",method=RequestMethod.POST)
public void mapRetailerToDistributor(@RequestParam("r_id") Integer retailerId, @RequestParam("d_id") Integer distributorId)
{
rrepo.saveMapping(retailerId,distributorId);
}
}                                                                                                                                                                