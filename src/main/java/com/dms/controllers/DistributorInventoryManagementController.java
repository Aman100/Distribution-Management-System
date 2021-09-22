package com.dms.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.dms.model.*;
import com.dms.repository.*;
import java.util.*;
@RestController()
public class DistributorInventoryManagementController
{
@Autowired()
private DistributorRepository drepo;

@RequestMapping(value="/getDistributorInventoryById/{d_id}",method=RequestMethod.GET)
public List<DistributorInventory> getDistributorInventoryById(@PathVariable(name="d_id") Integer d_id)
{
return drepo.getDistributorInventoryById(d_id);
}

@RequestMapping(value="/getDistributorsInventory",method=RequestMethod.GET)
public List<DistributorInventory> getDistributorsInventory()
{
return drepo.getDistributorsInventory();
}
}