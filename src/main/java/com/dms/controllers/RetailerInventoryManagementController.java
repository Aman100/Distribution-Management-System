package com.dms.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.dms.model.*;
import com.dms.repository.*;
import java.util.*;
@RestController()
public class RetailerInventoryManagementController
{
@Autowired()
private RetailerRepository drepo;

@RequestMapping(value="/getRetailerInventoryById/{d_id}",method=RequestMethod.GET)
public List<RetailerInventory> getRetailerInventoryById(@PathVariable(name="d_id") Integer d_id)
{
return drepo.getRetailerInventoryById(d_id);
}

@RequestMapping(value="/getRetailersInventory",method=RequestMethod.GET)
public List<RetailerInventory> getRetailersInventory()
{
return drepo.getRetailersInventory();
}
}